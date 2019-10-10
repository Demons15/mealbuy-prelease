package com.example.mealbuydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.cxsz.mealbuy.component.MealInfoHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MealInfoHelper.getInstance().setNumber("17234248248");
        MealInfoHelper.getInstance().doStartApplicationWithPackageName(this, "com.concat.businessManagement");
    }
}