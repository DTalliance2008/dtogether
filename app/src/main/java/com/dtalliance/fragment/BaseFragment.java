package com.dtalliance.fragment;

import android.support.v4.app.Fragment;

/**
 * Created by zhf on 2016/4/16.
 */
public abstract class BaseFragment extends Fragment {
    private boolean isVisible;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if(getUserVisibleHint()){
            isVisible = true;
            onVisible();
        }else{
            isVisible = false;
            onInVisible();
        }

    }

    protected void onVisible(){
        lazyLoad();
    }

    protected void onInVisible(){

    }

    protected abstract void lazyLoad();
}
