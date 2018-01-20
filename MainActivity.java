package com.example.android.soyouthinkyoucancode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /**
     * Variable that keeps track of correct answers
     * */
    int correct = 0;
    /*
    *will store ids for each answer
     */
    RadioButton q1c;

    RadioButton q2c;

    EditText et;

    CheckBox q4_cb1;
    CheckBox q4_cb2;
    CheckBox q4_cb3;
    CheckBox q4_cb4;

    CheckBox q5_cb1;
    CheckBox q5_cb2;
    CheckBox q5_cb3;
    CheckBox q5_cb4;
    CheckBox q5_cb5;
    CheckBox q5_cb6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    /**
     * This method updates the correct variable if question 1 is correct
     */
    public void questionOneResult() {
        q1c = (RadioButton) findViewById(R.id.question1_c);

        if (q1c.isChecked()) {
            correct++;
        }
    }

    /**
     * This method updates the correct variable if question 2 is correct
     */
    public void questionTwoResult() {
        q2c = (RadioButton) findViewById(R.id.question2_c);

        if (q2c.isChecked()) {
            correct++;
        }
    }

    /**
     * This method updates the correct variable if question 3 is correct
     */
    public void questionThreeResult() {
        et = (EditText) findViewById(R.id.user_answer);
        String answer = et.getText().toString();

        if (answer.equalsIgnoreCase("Prototype")) {
            correct++;
        }
    }

    /**
     * This method updates the correct variable if question 4 is correct
     */
    public void questionFourResult() {
        q4_cb1 = (CheckBox) findViewById(R.id.encap);
        q4_cb2 = (CheckBox) findViewById(R.id.simplify);
        q4_cb3 = (CheckBox) findViewById(R.id.convenient);
        q4_cb4 = (CheckBox) findViewById(R.id.none_of_the_above);

        if (q4_cb1.isChecked() && q4_cb2.isChecked() && q4_cb3.isChecked() && !q4_cb4.isChecked()) {
            correct++;
        }
    }

    /**
     * This method updates the correct variable if question 5 is correct
     */
    public void questionFiveResult() {
        q5_cb1 = (CheckBox) findViewById(R.id.button_h);
        q5_cb2 = (CheckBox) findViewById(R.id.vehicle_h);
        q5_cb3 = (CheckBox) findViewById(R.id.person_header);
        q5_cb4 = (CheckBox) findViewById(R.id.animal_head);
        q5_cb5 = (CheckBox) findViewById(R.id.employee_header);
        q5_cb6 = (CheckBox) findViewById(R.id.person_head);

        if (q5_cb1.isChecked() && q5_cb2.isChecked() && !q5_cb3.isChecked() && !q5_cb4.isChecked() && !q5_cb5.isChecked() && !q5_cb6.isChecked()) {
            correct++;
        }
    }

    /*
    Calculates the results of all questions and updates correct variable accordingly
     */
    private void calculateResult() {
        questionOneResult();
        questionTwoResult();
        questionThreeResult();
        questionFourResult();
        questionFiveResult();
    }

    /**
     * This method notifies the user of how many questions they got correct after the
     * submit button is clicked
     */
    public void result(View view) {
        calculateResult();
        String result = "You got " + correct + "/5 correct!";

        /*
        * Customize toast based on score
        */

        if (correct == 0 || correct == 1 || correct == 2 || correct == 3) {
            result += " Try again.";
        } else if (correct == 4) {
            result += " Almost there!";
        } else {
            result += "Good job!";
        }

        /*
        *Adds custom background to Toast while maintaining the rounded edges
        */
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.custom_toast_container));
        layout.setBackgroundResource(R.drawable.custom_toast_stuff);

        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText(result);

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();

    }

    /**
     * This method unchecks all checked answer, clears EditText and sets correct variable to 0
     */
    public void reset(View view) {
        correct = 0;

        RadioGroup rg_q1 = (RadioGroup) findViewById(R.id.radio_group_q1);
        rg_q1.clearCheck();

        RadioGroup rg_q2 = (RadioGroup) findViewById(R.id.radio_group_q2);
        rg_q2.clearCheck();

        et.getText().clear();

        if (q4_cb1.isChecked()){
            q4_cb1.setChecked(false);
        }

        if (q4_cb2.isChecked()){
            q4_cb2.setChecked(false);
        }

        if (q4_cb3.isChecked()){
            q4_cb3.setChecked(false);
        }

        if (q4_cb4.isChecked()){
            q4_cb4.setChecked(false);
        }

        if (q5_cb1.isChecked()){
            q5_cb1.setChecked(false);
        }

        if (q5_cb2.isChecked()){
            q5_cb2.setChecked(false);
        }

        if (q5_cb3.isChecked()){
            q5_cb3.setChecked(false);
        }

        if (q5_cb4.isChecked()){
            q5_cb4.setChecked(false);
        }

        if (q5_cb5.isChecked()){
            q5_cb5.setChecked(false);
        }

        if (q5_cb6.isChecked()){
            q5_cb6.setChecked(false);
        }

    }

}
