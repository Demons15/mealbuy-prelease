package com.example.mealbuydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.cxsz.mealbuy.component.MealConstants;
import com.cxsz.mealbuy.component.MealInfoHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MealInfoHelper.getInstance().setNumber("17234248248");
    }

    public void businessManagement(View view) {
        MealInfoHelper.getInstance().doStartApplicationWithPackageName(this, MealConstants.BUSINESS_MANAGEMENT);
    }

    public void mineMeal(View view) {
        MealInfoHelper.getInstance().doStartApplicationWithPackageName(this, MealConstants.MINE_MEAL);
    }

    public void realName(View view) {
        MealInfoHelper.getInstance().doStartApplicationWithPackageName(this, MealConstants.REAL_NAME);
    }

    public void intelligentDiagnosis(View view) {
        MealInfoHelper.getInstance().doStartApplicationWithPackageName(this, MealConstants.INTELLIGENT_DIAGNOSIS);
    }

    public void whiteList(View view) {
        MealInfoHelper.getInstance().doStartApplicationWithPackageName(this, MealConstants.WHITE_LIST);
    }
}
