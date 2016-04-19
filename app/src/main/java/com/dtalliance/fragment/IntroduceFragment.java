package com.dtalliance.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.dtalliance.R;
import com.dtalliance.activity.DreamTreeActivity;
import com.dtalliance.activity.DreamVersusActivity;
import com.dtalliance.activity.LaunchVsActivity;
import com.dtalliance.activity.TeamCreateActivity;
import com.dtalliance.activity.TeamDreamActivity;
import com.dtalliance.activity.TeamTaskActivity;
import com.dtalliance.util.ConstantUtil;
import com.dtalliance.util.SPUtil;

/**
 * Created by zhf on 2016/4/16.
 */
public class IntroduceFragment extends BaseFragment {

    private TextView teamNameTv;
    private TextView teamDreamTv;

    private String teamName = "";

    @Override
    protected void lazyLoad() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_introduce, container, false);

        TextView myBt = (TextView) view.findViewById(R.id.tv_homepage_dream);
        Button battleBt = (Button) view.findViewById(R.id.bt_homepage_mybattle);
        Button editTeamDream = (Button) view.findViewById(R.id.bt_homepage_myteamedit);
        TextView taskTv = (TextView) view.findViewById(R.id.tv_homepage_mytask);


        teamNameTv = (TextView) view.findViewById(R.id.tv_homepage_myteamname);
        teamDreamTv = (TextView) view.findViewById(R.id.tv_homepage_myteamdream);

        ImageButton teamIb = (ImageButton) view.findViewById(R.id.ib_homepage_myteam);

        teamIb.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                goTeamDream();
            }
        });

        battleBt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                goDreamVersus();
            }
        });

        myBt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                goDreamTree();
            }
        });

        editTeamDream.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                goTeamCreate();
            }
        });

        taskTv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                goTeamTask();
            }
        });

        myBt.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View arg0) {
                goLaunch();
                return false;
            }
        });

        return view;
    }

    private void setPageDetail() {
        teamName = SPUtil.getString(getActivity(), ConstantUtil.TEAM_FIRST_LEVEL, ConstantUtil.TEAM_NAME);
        teamNameTv.setText(teamName);
        teamDreamTv.setText(SPUtil.getString(getActivity(), ConstantUtil.TEAM_TERMINAL_LEVEL, "title"));
    }
    public void goLaunch(){
        Intent intent = new Intent(getActivity(), LaunchVsActivity.class);
        startActivity(intent);
    }

    public void goDreamVersus(){
        Intent intent = new Intent(getActivity(), DreamVersusActivity.class);
        startActivity(intent);
    }

    public void goDreamTree(){
        Intent intent = new Intent(getActivity(), DreamTreeActivity.class);
        startActivity(intent);
    }

    public void goTeamDream(){
        Intent intent = new Intent(getActivity(), TeamDreamActivity.class);
        startActivity(intent);
    }

    public void goTeamCreate(){
        Intent intent = new Intent(getActivity(), TeamCreateActivity.class);
        intent.putExtra(ConstantUtil.TEAM_DREAM, teamName);
        startActivity(intent);
    }

    public void goTeamTask(){
        Intent intent = new Intent(getActivity(), TeamTaskActivity.class);
        intent.putExtra(ConstantUtil.DREAM_LEVEL, ConstantUtil.DREAM_LEVEL);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        setPageDetail();
    }
}
