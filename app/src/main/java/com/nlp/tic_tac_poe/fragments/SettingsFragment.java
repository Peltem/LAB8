package com.nlp.tic_tac_poe.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.nlp.tic_tac_poe.R;
import com.nlp.tic_tac_poe.Study;
import com.nlp.tic_tac_poe.adapters.StudyAdapter;
import com.nlp.tic_tac_poe.databinding.SettingsFragmentBinding;

public class SettingsFragment extends Fragment {

    private static final String AUTOCHANGE_KEY = "AUTOCHANGE";
    private StudyAdapter adapter;
    private Study study;
    SettingsFragmentBinding binding;
    String[] countries = {"Россия", "Ангилйский"};


    public SettingsFragment(StudyAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = SettingsFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Spinner spinner = view.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, countries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        boolean autchange = loadDataBoolean(requireContext(), AUTOCHANGE_KEY);
        binding.switch1.setChecked(autchange);
        binding.switch1.setOnCheckedChangeListener((buttonView, isChecked) -> saveDataBoolean(requireContext(), AUTOCHANGE_KEY, isChecked));
        binding.switch2.setChecked(autchange);
        binding.switch2.setOnCheckedChangeListener((buttonView, isChecked) -> saveDataBoolean(requireContext(), AUTOCHANGE_KEY, isChecked));
        binding.switch3.setChecked(autchange);
        binding.switch3.setOnCheckedChangeListener((buttonView, isChecked) -> saveDataBoolean(requireContext(), AUTOCHANGE_KEY, isChecked));
    }

    public void saveData() {
        binding.saveBtn.setOnClickListener((v) -> {
            String name = binding.nameBox.getText().toString();
            SharedPreferences prefs = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("NAME", name);
            editor.apply();
            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_fragment, new StudyListFragments(), "studyListFragment")
                    .addToBackStack("studyListFragment")
                    .commit();
        });

    }

    public String loadData(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, "");
    }

    public boolean loadDataBoolean(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, false);
    }

    public void saveDataBoolean(Context context, String key, Boolean value) {
        binding.saveBtn.setOnClickListener((v) -> {
            SharedPreferences sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(key, value);
            editor.apply();
        });
    }
}


