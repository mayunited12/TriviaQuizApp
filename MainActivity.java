package com.example.android.quizapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void viewResult(View view) {
        int currentScore = totalScore();
        int passRequirement = 5;

        String fetchGatheredUserResult = gatherUserResult(currentScore, passRequirement);

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, fetchGatheredUserResult, duration);
        toast.show();
    }

    //Calculates the TotalScore of User
    private int totalScore() {
        int question1 = question1scores();
        int question2 = question2scores();
        int question3 = question3scores();
        int question4 = question4scores();

        int total = question1 + question2 + question3 + question4;

        return total;
    }
    
    //Evaluates Question4
    private int question4scores() {
        int question4 = 0;

        EditText getWcHost = (EditText) findViewById(R.id.el_nino);
        String wcHostInput = getWcHost.getText().toString();

        String option1 = getString(R.string.F_Torres);
        String option2 = getString(R.string.F_TorresWithSpace);
        option2 += " ";
        String option3 = getString(R.string.f_torres);
        String option4 = getString(R.string.f_torresWithSpace);
        option4 += " ";
        String option5 = getString(R.string.T_Fernando);
        String option6 = getString(R.string.T_FernandoWithSpace);
        option6 += " ";
        String option7 = getString(R.string.t_fernando);
        String option8 = getString(R.string.t_fernandoWithSpace);
        option8 += " ";

        if (    wcHostInput.equals(option1) |
                wcHostInput.equals(option2) |
                wcHostInput.equals(option3) |
                wcHostInput.equals(option4) |
                wcHostInput.equals(option5) |
                wcHostInput.equals(option6) |
                wcHostInput.equals(option7) |
                wcHostInput.equals(option8))
        {
            question4 += 1;
        }

        else{
            question4 += 0;
        }

        return question4;
    }

    //Evaluates Question3
    private int question3scores() {
        int question3 = 0;

        RadioButton selectBrazil = (RadioButton) findViewById(R.id.brazil);
        if(selectBrazil.isChecked()){
            question3 += 1;
        }
        else{
            question3 += 0;
        }

        return question3;
    }

    //Evaluates Question2
    private int question2scores() {
        int question2 = 0;

        CheckBox argentinaCheckBox = (CheckBox) findViewById(R.id.argentina);
        boolean isArgentina = argentinaCheckBox.isChecked();

        CheckBox portugalCheckBox = (CheckBox) findViewById(R.id.portugal);
        boolean isPortugal = portugalCheckBox.isChecked();

        CheckBox italyCheckBox = (CheckBox) findViewById(R.id.italy);
        boolean isItaly = italyCheckBox.isChecked();

        CheckBox panamaCheckBox = (CheckBox) findViewById(R.id.panama);
        boolean isPanama = panamaCheckBox.isChecked();

        if (isArgentina && isPortugal && isPanama) {
            if (isArgentina && isPortugal && isPanama && isItaly) {
                question2 += 0;
            }
            question2 += 1;
        } else {
            question2 += 0;
        }

        return question2;
    }

    //Evaluates Question1
    private int question1scores() {
        int question1 = 0;

        EditText getWcHost = (EditText) findViewById(R.id.host_country);
        String wcHostInput = getWcHost.getText().toString();

        String option1 = getString(R.string.Russia);
        String option2 = getString(R.string.RussiaWithSpace);
        option2 += " ";
        String option3 = getString(R.string.russia);
        String option4 = getString(R.string.russiaWithSpace);
        option4 += " ";

        if (wcHostInput.equals(option1) |
                wcHostInput.equals(option2) |
                wcHostInput.equals(option3) |
                wcHostInput.equals(option4)) {
            question1 += 1;
        } else {
            question1 += 0;

        }

        return question1;
    }

    /**
     *
     * @param passStatus transmit the current score of the user
     * @param passRequirement trans,its the Overall mark to be obtained
     * @return String of output. This gets displayed on toast.
     */
    private String gatherUserResult(int passStatus, int passRequirement) {
        String message = "Hello there!";
        message += "Your Score is " + passStatus + "/" + passRequirement;
        if (passStatus == passRequirement) {
            message += "Great work! You scored all";
        }
        return message;
    }
}
