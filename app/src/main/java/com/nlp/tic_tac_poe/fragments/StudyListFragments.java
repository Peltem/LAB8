package com.nlp.tic_tac_poe.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import com.nlp.tic_tac_poe.MyViewModel;
import com.nlp.tic_tac_poe.R;
import com.nlp.tic_tac_poe.adapters.StudyAdapter;
import com.nlp.tic_tac_poe.Study;
import com.nlp.tic_tac_poe.databinding.FragmentStudyListBinding;

import java.util.ArrayList;
import java.util.List;

public class StudyListFragments extends Fragment {
    private MyViewModel viewModel;
    public StudyAdapter studyAdapter;
    private FragmentStudyListBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentStudyListBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(requireActivity()).get(MyViewModel.class);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FragmentActivity activity = requireActivity();
        Context context = requireContext();
        registerInit();
        loginInit();
    }
    private void registerInit() {
        binding.Reg.setOnClickListener((view) -> {

            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_fragment, new RegisterFragment(), "register")
                    .addToBackStack(null)
                    .commit();
        });

    }
    private void loginInit() {
        binding.Log.setOnClickListener((view) -> {

            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_fragment, new LoginFragment(), "login")
                    .addToBackStack(null)
                    .commit();
        });
    }
}
