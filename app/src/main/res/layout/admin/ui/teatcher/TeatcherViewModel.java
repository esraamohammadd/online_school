package com.example.school.admin.ui.teatcher;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TeatcherViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public TeatcherViewModel() {
        mText = new MutableLiveData<> ();
        mText.setValue ( "This is dashboard fragment" );
    }

    public LiveData<String> getText() {
        return mText;
    }
}