package com.nlp.tic_tac_poe;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity {

        @SuppressLint("DefaultLocale")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_test);
                Log.d("INFO =>","onCreate");
                //Получаем переданный возраст
                Button backButton = findViewById(R.id.back_btn);
                backButton.setOnClickListener((view)->{
                        Intent intent = new Intent(this, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        startActivity(intent);
                });
        }

        @Override
        protected void onStart() {
                super.onStart();
                Log.d("INFO =>","onStart");
        }

        @Override
        protected void onResume() {
                super.onResume();
                Log.d("INFO =>","onResume");
        }

        @Override
        protected void onPause() {
                super.onPause();
                Log.d("INFO =>","onPause");
        }

        @Override
        protected void onStop() {
                super.onStop();
                Log.d("INFO =>","onStop");
        }

        @Override
        protected void onDestroy() {
                super.onDestroy();
                Log.d("INFO =>","onDestroy");
        }
}