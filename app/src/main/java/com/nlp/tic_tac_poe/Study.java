package com.nlp.tic_tac_poe;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Study implements Serializable {
    public static String [] ClassroomNumbers = {
            "B101", ",Б305", "A407",
            "B111", "A311", "Б206"
    };
    public String Name;
    public int Chas;
    public List<String> studyClassroomNumbers = new ArrayList<>();
    public Study(String name, int chas) {
        this.Name = name;
        this.Chas = chas;
    }
    public static List<Study> generateTestStudies(int StudyCount){
        List<Study> testStudies = new ArrayList<>();
        Random random = new Random();
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        for(int i = 0; i < StudyCount;i++) {
            double randomNumber = random.nextInt() * 100;
            String roundedNumber = decimalFormat.format(randomNumber);
            Study tempStudy = new Study(
                    "studyName" + i,
                    random.nextInt(360));
            Study.generateStudyClass(
                    tempStudy,
                    random.nextInt(Study.ClassroomNumbers.length));
            testStudies.add(tempStudy);

        }
        return testStudies;
    }
    public static void generateStudyClass(Study study, int classCount){
        List<String> classrooms = new ArrayList<>(Study.ClassroomNumbers.length);
        Collections.addAll(classrooms, Study.ClassroomNumbers);
        Random random = new Random();
        for(int i = 0; i<classCount;i++){
            int randomDigit = random.nextInt(classrooms.size());
            study.studyClassroomNumbers.add(classrooms.get(randomDigit));
            classrooms.remove(randomDigit);
        }
    }
}

