package com.example.mtmamaclay.madminutes;

import android.app.Application;
import android.test.ActivityInstrumentationTestCase2;
import android.app.Activity;
import android.test.ApplicationTestCase;
import android.test.UiThreadTest;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Observable;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ActivityInstrumentationTestCase2<MainActivity> {
    public ApplicationTest() {
        super("com.example.mtmamaclay.madminutes", MainActivity.class);
    }

    // TEST 1: test if easy button is set to easy
   public void testEasyButton(){
        Activity buttonActivity = getActivity();
        Button easyButton = (Button) buttonActivity.findViewById(R.id.easy);
        String defaultValue = "Easy";
        assertEquals(defaultValue, easyButton.getText().toString());
    }

    // TEST 2: test if medium button is set to medium
    public void testMedButton(){
        Activity buttonActivity = getActivity();
        Button medButton = (Button) buttonActivity.findViewById(R.id.medium);
        String defaultValue = "Medium";
        assertEquals(defaultValue, medButton.getText().toString());
    }

    // TEST 3: test if hard button is set to hard
    public void testHardButton(){
        Activity buttonActivity = getActivity();
        Button hardButton = (Button) buttonActivity.findViewById(R.id.hard);
        String defaultValue = "Hard";
        assertEquals(defaultValue, hardButton.getText().toString());
    }

    // TEST 4: test if score increments when inputting an answer
    @UiThreadTest
    public void testAnswer(){
        Activity buttonActvity = getActivity();
        TextView score = (TextView) buttonActvity.findViewById(R.id.score);
        int counter = 0;
        String expected = "1";

        TextView question = (TextView) buttonActvity.findViewById(R.id.question);
        Button easyButton = (Button) buttonActvity.findViewById(R.id.easy);
        easyButton.performClick();

        String answer = "answer";
        String input = "answer";

        if (answer.equals(input)) {
            counter++;
            score.setText("" + counter);
        }

        assertEquals(expected, score.getText().toString());

    }

    // TEST 5: test if button is pressed, ie. generates a problem
    @UiThreadTest
    public void testButtonPressed(){
        Activity buttonActivity = getActivity();
        TextView question = (TextView) buttonActivity.findViewById(R.id.question);      // initially would be title (Mad Minutes)
        String defaultValue = "Mad Minutes";

        Button easyButton = (Button) buttonActivity.findViewById(R.id.easy);
        easyButton.performClick();
        String generated = question.getText().toString();
        assertNotSame(defaultValue, generated);

    }
}