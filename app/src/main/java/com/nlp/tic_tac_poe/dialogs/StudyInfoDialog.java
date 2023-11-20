package com.nlp.tic_tac_poe.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.nlp.tic_tac_poe.Study;
import com.nlp.tic_tac_poe.adapters.StudyAdapter;
import com.nlp.tic_tac_poe.databinding.DialogStudyInfoBinding;
import com.nlp.tic_tac_poe.Study;
import com.nlp.tic_tac_poe.fragments.StudyListFragments;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class StudyInfoDialog extends DialogFragment {
    private Study study;
    public static String STUDY_KEY;
    DialogStudyInfoBinding binding;
    private StudyAdapter adapter;

    public StudyInfoDialog(StudyAdapter adapter) {
        this.adapter = adapter;
    }

    public static StudyInfoDialog getInstance(Study study, StudyAdapter adapter) {
        Bundle args = new Bundle();
        args.putSerializable(STUDY_KEY, study);
        StudyInfoDialog studyInfoDialog = new StudyInfoDialog(adapter);
        studyInfoDialog.setArguments(args);
        return studyInfoDialog;

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /*Получаем переданного пользователя через входные аргументы*/
        if(getArguments()!=null && getArguments().containsKey(STUDY_KEY)){
            this.study = (Study)getArguments().getSerializable(STUDY_KEY);
        }
        /*Инициализация binding*/
        binding = DialogStudyInfoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ArrayAdapter<String> studyClassAdapter =
                new ArrayAdapter<>(
                        getContext(),
                        android.R.layout.simple_list_item_1,
                        study.studyClassroomNumbers);
        binding.studyClass.setAdapter(studyClassAdapter);
        binding.studyName.setText(study.Name);
        deleteBtn();
    }
    private void deleteBtn() {
        binding.Del.setOnClickListener((v) -> {
            adapter.remove(study);
            dismiss();
//            getActivity().getSupportFragmentManager().popBackStack();
        });
    }
}
