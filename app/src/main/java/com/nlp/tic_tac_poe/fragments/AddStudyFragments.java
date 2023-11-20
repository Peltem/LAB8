package com.nlp.tic_tac_poe.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.nlp.tic_tac_poe.R;
import com.nlp.tic_tac_poe.adapters.StudyAdapter;
import com.nlp.tic_tac_poe.Study;
import com.nlp.tic_tac_poe.databinding.FragmentAddStudyBinding;

import java.util.Random;

public class AddStudyFragments extends Fragment {
    FragmentAddStudyBinding binding;
    public AddStudyFragments(){

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAddStudyBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initCommitBtn();
    }

    private void initCommitBtn(){
        binding.commitBtn.setOnClickListener((v)->{
            Random random = new Random();
            String login = binding.studyName.getText().toString();
            int hour = Integer.valueOf(binding.studyHours.getText().toString());
            if(hour == 0 || login.equals("") ) return;
            Study study = new Study(login, hour);
            Study.generateStudyClass(
                    study, random.nextInt(Study.ClassroomNumbers.length));

            StudyListFragments.studyList.add(study);


            getActivity().getSupportFragmentManager().popBackStack();
        });
    }

}
