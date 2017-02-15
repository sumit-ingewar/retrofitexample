package com.pankanis.retrofit.viewmodel;

import android.databinding.BaseObservable;
import android.support.annotation.Nullable;
import android.databinding.BaseObservable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
/**
 * Created by sumit.ingewar on 2/15/2017.
 */

public abstract class ViewModel extends BaseObservable {


    public static class State implements Parcelable {

        public State(ViewModel viewModel) {
        }

        public State(Parcel in) {
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @CallSuper
        @Override
        public void writeToParcel(Parcel dest, int flags) {

        }

        public static Creator<State> CREATOR = new Creator<State>() {
            @Override
            public State createFromParcel(Parcel source) {
                return null;
            }

            @Override
            public State[] newArray(int size) {
                return new State[0];
            }
        };
    }

    protected ViewModel(@Nullable State savedInstanceState) {

    }

    @CallSuper
    public void onStart(){

    }

    @CallSuper
    public void onStop(){

    }

    public State getInstanceState(){
        return new State(this);
    }




}
