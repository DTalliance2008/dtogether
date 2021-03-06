package com.dtalliance.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.dtalliance.R;
import com.dtalliance.util.ConstantUtil;
import com.dtalliance.util.DBUtil;
import com.dtalliance.util.SPUtil;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        getWindow().setFormat(PixelFormat.RGBA_8888);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DITHER);

        //Display the current version number
        PackageManager pm = getPackageManager();
        try {
            PackageInfo pi = pm.getPackageInfo("org.wordpress.android", 0);
//            TextView versionNumber = (TextView) findViewById(R.id.versionNumber);
//            versionNumber.setText("Version " + pi.versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        new Handler().postDelayed(new Runnable() {
            public void run() {
                /* Create an Intent that will start the Main WordPress Activity. */
                String isExistDB = SPUtil.getString(getApplicationContext(), ConstantUtil.IMPORT_DB_SP, "isExist");
                if(isExistDB == null || isExistDB.isEmpty()){
                    DBUtil.getDataBasePath(getApplicationContext());
                    SPUtil.setString(getApplicationContext(), ConstantUtil.IMPORT_DB_SP, "isExist", "data");
                }
                goLogin();
            }
        }, 2900); //2900 for release

    }

    public void goLogin(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
