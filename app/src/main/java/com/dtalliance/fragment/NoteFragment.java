package com.dtalliance.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.dtalliance.R;
import com.dtalliance.activity.AsyncTaskWithProgressDialog;
import com.dtalliance.util.ConstantUtil;
import com.dtalliance.util.TimeUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zhf on 2016/4/16.
 */
public class NoteFragment extends BaseFragment {
    @Override
    protected void lazyLoad() {

    }

    private File[] fileList;
    private File filePath;
    private int count;
    private ListView noteContentLV;
    private TextView noContentTv;
    private SimpleAdapter adapterNote = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note, container, false);
        noteContentLV = (ListView) view.findViewById(R.id.lv_note_content);
        noContentTv = (TextView) view.findViewById(R.id.tv_note_no_content);
        refreshItemView();
        return view;
    }

    public void refreshItemView() {
        new NoteBackground(getActivity()).execute();
    }

    //background thread is used to read system files
    private class NoteBackground extends AsyncTaskWithProgressDialog {

        public NoteBackground(Context progressDialogContext) {
            super(progressDialogContext);
        }

        @Override
        protected void onPostExecute2(String result) {
            if (result.equals("success")) {
                Log.d("success", result);
                noteContentLV.setAdapter(adapterNote);
            } else {
                Toast.makeText(getActivity(), "打开文件失败", Toast.LENGTH_SHORT).show();
            }
        }

        @SuppressLint("CommitPrefEdits")
        @Override
        protected String doInBackground2(String... params) {
            filePath = new File(Environment.getExternalStorageDirectory() + "/files");
            fileList = filePath.listFiles();

            List<HashMap<String, Object>> listItemNoteNew = new ArrayList<HashMap<String, Object>>();

            List<String> list = new ArrayList<String>();
            if (fileList != null && fileList.length != 0) {
                for (int i = 0; i < fileList.length; i++) {
                    list.add(fileList[i].getName());
                    String[] array = TimeUtil.getFileName(fileList[i].getName());
                    HashMap<String, Object> map = new HashMap<String, Object>();

                    if (array != null) {
                        if (array.length > 1) {
                            map.put("itemText1", array[1]);
                        }
                        map.put("itemTitle", array[0]);
                    }
                    listItemNoteNew.add(map);

                }
            }else{
                noContentTv.setVisibility(View.VISIBLE);
            }

            adapterNote = new SimpleAdapter(getActivity(), (List<HashMap<String, Object>>) listItemNoteNew,
                    R.layout.notelist, new String[]{"itemText1", "itemTitle"}, new int[]{R.id.tv_notelist_note1, R.id.tv_notelist_title1});
            return ConstantUtil.SUCCESS;
        }
    }
}