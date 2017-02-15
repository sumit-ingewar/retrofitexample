package com.pankanis.retrofit.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.pankanis.retrofit.R;
import com.pankanis.retrofit.viewmodel.ViewModel;

import java.net.URISyntaxException;

/**
 * Created by sumit.ingewar on 2/15/2017.
 */

public class MainViewModel extends ViewModel {

    protected MainViewModel(@Nullable State savedInstanceState) {
        super(savedInstanceState);
    }

    public void onCliclButtonClicks(Activity activity) {
        activity.startActivity(new Intent(activity, MainActivity.class));
    }

    public void onClickHiSumit(Activity activity) {
        try {
            Intent intent = Intent.parseUri(activity.getString(R.string.apikey), 0);
            activity.startActivity(intent);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
