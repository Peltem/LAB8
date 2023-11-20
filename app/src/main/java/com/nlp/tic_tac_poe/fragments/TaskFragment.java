package com.nlp.tic_tac_poe.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.nlp.tic_tac_poe.R;
import com.nlp.tic_tac_poe.Study;
import com.nlp.tic_tac_poe.MyViewModel;
import com.nlp.tic_tac_poe.adapters.StudyAdapter;
import com.nlp.tic_tac_poe.databinding.TaskFragmentBinding;

import java.io.Serializable;
import java.util.List;

public class TaskFragment extends Fragment {
    private static final String ARG_TASKS = "tasks";
    private List<Study> tasks;
    private TaskFragmentBinding binding;
    public MyViewModel viewModel;


    public static TaskFragment getInstance(List<Study> tasks) {
        TaskFragment fragment = new TaskFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_TASKS, (Serializable) tasks);
        fragment.setArguments(args);
        return fragment;

    }

    public TaskFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            tasks = (List<Study>) (getArguments().getSerializable(ARG_TASKS));
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = TaskFragmentBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        return binding.getRoot();


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView list = view.findViewById(R.id.task_fr);
        ArrayAdapter adapter = new StudyAdapter(
                requireContext(),
                R.layout.list_item,
                tasks
        );
        list.setAdapter(adapter);
    }
}
