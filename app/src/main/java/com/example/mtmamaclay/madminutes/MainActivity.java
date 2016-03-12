package com.example.mtmamaclay.madminutes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
public class MainActivity extends AppCompatActivity {
    TextView display;
    TextView scoreDisplay;
    EditText input;
    Button easyButton, mediumButton, hardButton, submitButton;
    int counter = 0;
    int firstGlobal;
    int secondGlobal;
    int sumGlobal;
    boolean powerOperator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        easyButton = (Button) findViewById(R.id.easy);
        mediumButton = (Button) findViewById(R.id.medium);
        hardButton = (Button) findViewById(R.id.hard);
        submitButton = (Button) findViewById(R.id.submit);
        display = (TextView) findViewById(R.id.question);
        scoreDisplay = (TextView) findViewById(R.id.score);

        easyButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                display.setText("" + EasyGen());
            }
        });

        mediumButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                display.setText("" + MedGen());
            }
        });
        hardButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (powerOperator == false)
                    display.setText("" + HardGen());
                if (powerOperator == true)
                    display.setText(Html.fromHtml("<sub>" + firstGlobal + "</sub> <sup>" + secondGlobal + "</sup>"));
                powerOperator = false;
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                input   = (EditText)findViewById(R.id.userInput);
                String placeholder = input.getText().toString();
                int userInputInt =  Integer.parseInt(placeholder);
                if (userInputInt == sumGlobal) {
                    counter++;
                    scoreDisplay.setText("" + counter);
                }
            }
        });
    }

    public String EasyGen() {
        int firstNum;
        int secondNum;
        int operator;
        String opString = "N/a";
        String printedString;
        int answer = 0;
        //public void generateVaues(){
        firstNum = 1 + (int)(Math.random() * 40);
        secondNum = 1 + (int)(Math.random() * 40);
        operator = 1 + (int)(Math.random() * 2);
        //}
        // public String generateEquation(){
        if(operator == 1) {
            opString = "+";
            answer = firstNum + secondNum;
        }else if(operator == 2) {
            opString = "-";
            answer = firstNum - secondNum;
        }
        printedString = firstNum + " " + opString + " " + secondNum;
        firstGlobal = firstNum;
        secondGlobal= secondNum;
        sumGlobal = answer;
        return printedString;
    }

    public String MedGen() {
        int firstNum;
        int secondNum;
        int operator;
        String opString = "N/A";
        int answer = 0;
        String printedString = "n/A";

        firstNum = 1 + (int)(Math.random() * 50);
        secondNum = 1 + (int)(Math.random() * 50);
        operator = 1 + (int)(Math.random() * 3);
        if (firstNum%secondNum == 0){
            operator = 1 + (int)(Math.random() * 4);
        }


        if(operator == 1) {
            opString = "+";
            answer = firstNum + secondNum;
        }else if(operator == 2) {
            opString = "-";
            answer = firstNum - secondNum;
        }else if(operator == 3){
            opString = "*";
            answer = firstNum * secondNum;
        }else if(operator == 4){
            opString = "/";
            answer = firstNum / secondNum;
        }


        printedString = firstNum + " " + opString + " " + secondNum;
        firstGlobal = firstNum;
        secondGlobal= secondNum;
        sumGlobal = answer;
        return printedString;
    }
    public String HardGen() {
        int firstNum;
        int secondNum;
        int operator;
        //int expoBase;
        //int exponent;
        String opString = "N/A";
        int answer = 0;
        String printedString = "n/A";

        firstNum = 1 + (int)(Math.random() * 100);
        secondNum = 1 + (int)(Math.random() * 100);
        operator = 1 + (int)(Math.random() * 4);
        //expoBase = 1 + (int)(Math.random() * 20);
        //exponent = 1 + (int)(Math.random() * 3);
        if (firstNum%secondNum == 0){
            operator = 1 + (int)(Math.random() * 5);
        }
        if (operator == 4){
            firstNum = 1 + (int)(Math.random() * 20);
            secondNum = 2 + (int)(Math.random() * 2);
        }


        if(operator == 1) {
            opString = "+";
            answer = firstNum + secondNum;
        }else if(operator == 2) {
            opString = "-";
            answer = firstNum - secondNum;
        }else if(operator == 3){
            opString = "*";
            answer = firstNum * secondNum;
        }else if(operator == 4){
            opString = "^";
            answer = (int)Math.pow(firstNum, secondNum);
            powerOperator = true;
        }else if(operator == 5){
            opString = "/";
            answer = firstNum / secondNum;
        }


        printedString = firstNum + " " + opString + " " + secondNum;
        firstGlobal = firstNum;
        secondGlobal= secondNum;
        sumGlobal = answer;
        return printedString;
    }
}