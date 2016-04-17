package com.dtalliance.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by zhf on 2016/4/16.
 */
public class MyPagerAdapter  extends FragmentPagerAdapter {
    private List<DTab> dtList;

    @Override
    public Fragment getItem(int position) {
        try {
            return (Fragment) dtList.get(position).getFragment().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getCount() {
        return dtList.size();
    }

    public MyPagerAdapter(FragmentManager fm, List<DTab> dtList) {
        super(fm);
        this.dtList = dtList;
    }

}
