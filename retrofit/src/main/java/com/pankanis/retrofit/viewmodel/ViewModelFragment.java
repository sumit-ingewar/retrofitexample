package com.pankanis.retrofit.viewmodel;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by sumit.ingewar on 2/15/2017.
 */

public abstract class ViewModelFragment extends Fragment {

    public static final String EXTRA_VIEW_MODEL_STATE = "viewModelState";

    private ViewModel viewModel;

    public abstract ViewModel createViewModel(@Nullable ViewModel.State savedViewModelState);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewModel.State savedViewModelState = null;
        if(savedInstanceState != null){
            savedViewModelState = savedInstanceState.getParcelable(EXTRA_VIEW_MODEL_STATE);
        }

        viewModel = createViewModel(savedViewModelState);
    }


    @Override
    public void onStart() {
        super.onStart();
        if(viewModel != null)
            viewModel.onStart();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(viewModel != null){
            outState.putParcelable(EXTRA_VIEW_MODEL_STATE,viewModel.getInstanceState());
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if(viewModel != null)
            viewModel.onStop();
    }


}
