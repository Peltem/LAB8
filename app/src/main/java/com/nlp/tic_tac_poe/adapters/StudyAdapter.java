package com.nlp.tic_tac_poe.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.nlp.tic_tac_poe.R;
import com.nlp.tic_tac_poe.Study;

import java.util.List;

public class StudyAdapter extends ArrayAdapter<Study> {
    private LayoutInflater inflater;
    private List<Study> studies;
    private int resource;
    public StudyAdapter(@NonNull Context context, int resource, @NonNull List<Study> studies) {
        super(context, resource, studies);
        this.resource = resource;
        this.studies = studies;
        //Класс для генерации UI
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View viewGroup, @NonNull ViewGroup parent) {
        View studyView = inflater.inflate(resource, parent, false);
        Study study = studies.get(position);
        TextView studyName =
                studyView.findViewById(R.id.name);
        TextView studyHours =
                studyView.findViewById(R.id.chas);
        studyName.setText(study.Name);
        studyHours.setText(String.format("Hours: %d hours", study.Chas));
        return studyView;
    }

    public List<Study> getStudies() {
        return studies;
    }
}

