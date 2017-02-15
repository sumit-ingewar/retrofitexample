package com.pankanis.retrofit.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.pankanis.retrofit.R;
import com.pankanis.retrofit.viewmodel.ViewModel;
import com.pankanis.retrofit.viewmodel.ViewModelActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by sumit.ingewar on 2/15/2017.
 */

public class StartActivity extends ViewModelActivity {

    private MainViewModel mainViewModel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp_main);
        ButterKnife.bind(this);

    }

    @Nullable
    @Override
    protected ViewModel createViewModel(@Nullable ViewModel.State savedViewModel) {
        return null;
    }


    @OnClick(R.id.btnClick)
    void onClickButtonClick(){
        mainViewModel.onCliclButtonClicks(this);
    }

    @OnClick(R.id.btnRecyclerView)
    void onCliclButtonRecyclerView(){
        mainViewModel.onClickHiSumit(this);
    }
}
