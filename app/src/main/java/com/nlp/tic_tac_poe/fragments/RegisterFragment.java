package com.nlp.tic_tac_poe.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.nlp.tic_tac_poe.MyViewModel;
import com.nlp.tic_tac_poe.Study;
import com.nlp.tic_tac_poe.databinding.FragmentAddStudyBinding;

import java.util.List;
import java.util.Random;

public class RegisterFragment extends Fragment {
    FragmentAddStudyBinding binding;
    private MyViewModel viewModel;

    public RegisterFragment(){

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAddStudyBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(requireActivity()).get(MyViewModel.class);
        return binding.getRoot();
    }

}
