package com.nlp.tic_tac_poe;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nlp.tic_tac_poe.adapters.StudyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyViewModel extends ViewModel {

    public StudyAdapter studyAdapter;
    private MyViewModel binding;

    private MutableLiveData<List<Study>> text = new MutableLiveData(
            new ArrayList<Study>()
    );
    public void setText(List<Study> input){
        text.setValue(input);
    }
    public void postList(List<Study> list) {
        text.postValue(list);
    }
    public LiveData<List<Study>> getText(){
        return text;
    }
    public List<Study> studyList = new ArrayList<>();
    public MyViewModel(){
        setStudyList(studyList);
    }

    public void setStudyList(List<Study> list) {
        studyList = list;
    }
}



