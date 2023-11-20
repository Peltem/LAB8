package com.nlp.tic_tac_poe.fragments;

import static android.os.Build.VERSION_CODES.O;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.nlp.tic_tac_poe.MyViewModel;
import com.nlp.tic_tac_poe.R;
import com.nlp.tic_tac_poe.adapters.StudyAdapter;
import com.nlp.tic_tac_poe.Study;
import com.nlp.tic_tac_poe.databinding.FragmentStudyListBinding;
import com.nlp.tic_tac_poe.dialogs.StudyInfoDialog;

import java.util.ArrayList;
import java.util.List;

public class StudyListFragments extends Fragment {
    private MyViewModel viewModel;

    public StudyAdapter studyAdapter;
    public static List<Study> studyList = new ArrayList<>();
    private FragmentStudyListBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentStudyListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        viewModel.getText().observe(getViewLifecycleOwner(), new Observer<List<Study>>() {
            @Override
            public void onChanged(List<Study> list) {
                Thread thread = new Thread(() -> {
                    studyListInit(requireActivity(), requireContext(), list);
                    try {
                        Thread.sleep(2500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    requireActivity().runOnUiThread(() -> {
                        view.findViewById(R.id.progres).setVisibility(View.GONE);
                        view.findViewById(R.id.study_list).setVisibility(View.VISIBLE);
                    });
                });
                thread.start();
            }
        });
        FragmentActivity activity = requireActivity();
        Context context = requireContext();
        addStudyBtnInit();
        taskBtn();
        setBtn();
    }

    private void studyListInit(FragmentActivity activity, Context context, List<Study> list) {
        if (studyAdapter == null) {
            studyAdapter = new StudyAdapter(
                    getContext(),
                    R.layout.list_item,
                    list);
        }
        binding.studyList.setAdapter(studyAdapter);
        binding.studyList.setOnItemClickListener((adapterView, view, i, l) -> {
            Toast.makeText(getContext(), String.valueOf(i), Toast.LENGTH_LONG).show();
//            requireActivity().getSupportFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.main_fragment, StudyInfoDialog.getInstance(studyAdapter.getItem(i)))
//                    .addToBackStack("info_dialog")
//                    .commit();
            StudyInfoDialog dialog = StudyInfoDialog.getInstance(studyAdapter.getItem(i), studyAdapter);
            dialog.show(getChildFragmentManager(), "study_info");
        });
    }

    private void addStudyBtnInit() {
        binding.addStudyBtn.setOnClickListener((view) -> {

            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_fragment, new AddStudyFragments(), "add_study")
                    .addToBackStack(null)
                    .commit();
        });

    }

    private void taskBtn() {
        binding.taskBtn.setOnClickListener((view) -> {

            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_fragment, TaskFragment.getInstance(studyList), "task")
                    .addToBackStack("task")
                    .commit();
        });

    }

    private void setBtn() {
        binding.setBtn.setOnClickListener((view) -> {

            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_fragment, new SettingsFragment(studyAdapter), "settings")
                    .addToBackStack(null)
                    .commit();
        });
    }
}
