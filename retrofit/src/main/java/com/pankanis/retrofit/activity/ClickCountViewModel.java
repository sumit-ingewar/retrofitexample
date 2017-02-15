package com.pankanis.retrofit.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.Bindable;
import android.os.Parcel;
import android.support.annotation.Nullable;

import com.pankanis.retrofit.BR;
import com.pankanis.retrofit.R;
import com.pankanis.retrofit.viewmodel.ViewModel;

import java.net.URISyntaxException;

/**
 * Created by sumit.ingewar on 2/15/2017.
 */

public class ClickCountViewModel extends ViewModel {

    private Context appContext = null;
    int clicks;

    protected ClickCountViewModel(Context context, @Nullable State savedInstanceState) {
        super(savedInstanceState);
        appContext = context.getApplicationContext();
        if (savedInstanceState instanceof ClickCountState) {
            clicks = ((ClickCountState) savedInstanceState).clicks;
        }
    }

    @Override
    public State getInstanceState() {
        return new ClickCountState(this);
    }

    @Bindable
    public String getClickCountText() {
        return null;//String.format(appContext.getString(R.string.click_count), clicks);
        //return String.format(appContext.getString(R.string.button_click), clicks);
    }


    public void onClickButton() {
        clicks++;
        notifyPropertyChanged(BR.clickCountText);
    }

    public void onClickHiSumit(Activity activity) {
        try {
            Intent intent = Intent.parseUri(activity.getString(R.string.apikey), 0);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private static class ClickCountState extends State {

        private final int clicks;

        public ClickCountState(ClickCountViewModel  viewModel) {
            super(viewModel);
            clicks = viewModel.clicks;
        }

        public ClickCountState(Parcel in) {
            super(in);
            clicks = in.readInt();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(clicks);
        }

        public static Creator<ClickCountState> CREATOR = new Creator<ClickCountState>() {
            @Override
            public ClickCountState createFromParcel(Parcel source) {
                return new ClickCountState(source);
            }

            @Override
            public ClickCountState[] newArray(int size) {
                return new ClickCountState[size];
            }
        };
    }
}
