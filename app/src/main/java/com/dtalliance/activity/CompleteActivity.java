package com.dtalliance.activity;

import android.app.Activity;
import android.view.Menu;

import com.dtalliance.R;

public class CompleteActivity extends Activity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.complete, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
