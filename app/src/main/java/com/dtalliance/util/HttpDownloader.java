package com.dtalliance.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import android.os.Environment;
import android.util.Log;

import com.dtalliance.file.StoreFileToSD;

public class HttpDownloader {
	public static String DownloadString(String httpUrl, String uploadString) {
		String downString = "";
		try {
			URL url = new URL(httpUrl);
			byte[] upBytes = uploadString.getBytes();
			byte[] downBytes = DownloadBytes(url, upBytes);
			downString = new String(downBytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return downString;
	}

	public static byte[] DownloadBytes(URL httpUrl, byte[] upBytes) {
		int TimeOut = 250;
		HttpURLConnection urlConnection = null;
		try {
			urlConnection = (HttpURLConnection) httpUrl.openConnection();
			urlConnection.setRequestMethod("POST");
			urlConnection.setDoInput(true);
			urlConnection.setDoOutput(true);
			urlConnection.setUseCaches(false);
			urlConnection.setConnectTimeout(TimeOut * 10 * 10);
			urlConnection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			urlConnection.setRequestProperty("Content-Length",
					String.valueOf(upBytes.length));

			BufferedOutputStream out = new BufferedOutputStream(
					urlConnection.getOutputStream());
			out.write(upBytes);
			out.flush();
			out.close();

			InputStream in = new BufferedInputStream(
					urlConnection.getInputStream());
			int Size = 1024;
			int len = 0;
			byte[] downBytes;

			if (in instanceof ByteArrayInputStream) {
				Size = in.available();
				downBytes = new byte[Size];
				len = in.read(downBytes, 0, Size);
			} else {
				ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
				downBytes = new byte[Size];
				while ((len = in.read(downBytes, 0, Size)) != -1) {
					byteOut.write(downBytes, 0, len);
				}
				downBytes = byteOut.toByteArray();
			}

			in.close();
			return downBytes;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			urlConnection.disconnect();
		}

		return null;
	}

	public static String downloadFile(String urlStr, String fileName) {
		String line = "";
		StringBuffer sb = new StringBuffer();

		try {
			URL url = new URL(urlStr);

			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setUseCaches(false);
			connection.setConnectTimeout(250 * 10 * 10);
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");

			InputStream inputStream = connection.getInputStream();


			if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
				StoreFileToSD fileToSD = new StoreFileToSD();
//				fileToSD.writeSD("txt/", fileName, inputStream);

				File fileNameNew = Environment.getExternalStorageDirectory();
				int length;
				int size = 1024;
				byte[] buffer = new byte[size];

				File writeFileNew = new File(fileNameNew, "1.txt");
				FileOutputStream outputStream = new FileOutputStream(writeFileNew);

				while((length = inputStream.read(buffer, 0, size)) != -1){
					outputStream.write(buffer, 0, size);
				}
				outputStream.flush();
				outputStream.close();
				inputStream.close();
				line = "success";
			} else {
				StoreFileToSD fileToSD = new StoreFileToSD();
				fileToSD.writeSD("", fileName, inputStream);
				line = "error";
			}

		} catch (Exception e) {
			e.printStackTrace();
			sb.append("error");
		} finally {
		}
		return line;
	}
}
