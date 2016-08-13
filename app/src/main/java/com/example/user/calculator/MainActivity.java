package com.example.user.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button equateBtn = (Button) findViewById(R.id.equateBtn);

    }

    /**
     * This function is called on clicking of "=" button, it will calculate the result and set that result into ansTxt box
     *
     * for OnClick functions we have to pass "View view" to get the details about clicked button
     *
     * @param view
     */
    public void calculateResult(View view) {
        //Create a object of TextView to hold the ansTxt
        EditText ansTxt = (EditText) findViewById(R.id.anstxt);

        /**
         * show a notification message to display the contents of ansTxt, Toast.makeText() will require 3 arguments
         * One for context, second one for actual message shown to the user, and 3rd one for duration
         * After writing this we have to add show(), to show this message to user.
         */
        Toast.makeText(this, "text message is " + ansTxt.getText().toString(), Toast.LENGTH_SHORT).show();

        //get the data of ansTxt
        String data = ansTxt.getText().toString();

        //initialize a int variable to hold the final answer
        int finalAns = 0;

        //create a char array to store ansTxt in array format
        char[] values = new char[data.length()];

        //initialize a character to hold the operand
        char operand = 0;

        //initialize a boolean variable to notify whether operator found or not
        boolean operator_found = false;
        String value1= null;
        String value2 = null;
        for(int i=0;i<data.length();i++) {


            values[i] = ansTxt.getText().charAt(i);
            Log.d("values", String.valueOf(values[i]));
            if(!operator_found){
                if (ansTxt.getText().charAt(i) == '+'
                        || ansTxt.getText().charAt(i) == '-'
                        || ansTxt.getText().charAt(i) == '/'
                        || ansTxt.getText().charAt(i) == '*'
                        || ansTxt.getText().charAt(i) == '^'
                        || ansTxt.getText().charAt(i) == '%'
                        )
                {
                    operand = ansTxt.getText().charAt(i);
                    Log.d("operator found", String.valueOf(operator_found));
                    operator_found = true;

                }
                else
                {
                    operator_found = false;
                    if(value1 == null)
                    {
                        value1 = String.valueOf(ansTxt.getText().charAt(i));
                    }
                    else {
                        value1 = value1 + ansTxt.getText().charAt(i);
                    }
                }
            }
            else
            {
                if (ansTxt.getText().charAt(i) == '+'
                        || ansTxt.getText().charAt(i) == '-'
                        || ansTxt.getText().charAt(i) == '/'
                        || ansTxt.getText().charAt(i) == '*'
                        || ansTxt.getText().charAt(i) == '^'
                        || ansTxt.getText().charAt(i) == '%'
                        )
                {

                    operand = ansTxt.getText().charAt(i);
                    operator_found = false;

                }
                else
                {
                    if(value2 == null)
                    {
                        value2 = String.valueOf(ansTxt.getText().charAt(i));
                        //finalAns = Integer.parseInt(value1) + Integer.parseInt(value2);
                        finalAns = calculate(value1,value2,operand);
                        Log.d("final ans",String.valueOf(finalAns));
                    }
                    else {
                        value2 = value2 + ansTxt.getText().charAt(i);
                        //finalAns = Integer.parseInt(value1) + Integer.parseInt(value2);
                        finalAns = calculate(value1,value2,operand);
                        Log.d("final ans",String.valueOf(finalAns));
                    }
                }
            }

        }

        ansTxt.setText(String.valueOf(finalAns));
        ansTxt.setSelection(ansTxt.getText().length());
        Log.d("values",values.toString());

    }


    public int calculate(String value1,String value2,char operand)
    {
        int answer = 0;
        switch(operand)
        {
            case '+':
                answer = Integer.parseInt(value1) + Integer.parseInt(value2);
                break;
            case '-':
                answer = Integer.parseInt(value1) - Integer.parseInt(value2);
                break;
            case '*':
                answer = Integer.parseInt(value1) * Integer.parseInt(value2);
                break;
            case '/':
                answer = Integer.parseInt(value1) / Integer.parseInt(value2);
                break;
            case '%':
                answer = Integer.parseInt(value1) % Integer.parseInt(value2);
                break;


        }
        return answer;
    }

    public void clearResult(View view)
    {
        TextView anstxt = (TextView) findViewById(R.id.anstxt);
        anstxt.setText(null);
    }

    public void addToTextBox(View view) {

        EditText ansTxt = (EditText) findViewById(R.id.anstxt);
        String previousTxt = String.valueOf(ansTxt.getText());
        if(view.getId() == R.id.sevenBtn)
        {
            ansTxt.setText(previousTxt+7);
            ansTxt.setSelected(true);
        }
        if(view.getId() == R.id.eightBtn)
        {
            ansTxt.setText(previousTxt+8);
        }
        if(view.getId() == R.id.nineBtn)
        {
            ansTxt.setText(previousTxt+9);
        }
        if(view.getId() == R.id.sixBtn)
        {
            ansTxt.setText(previousTxt+6);
        }
        if(view.getId() == R.id.fiveBtn)
        {
            ansTxt.setText(previousTxt+5);
        }
        if(view.getId() == R.id.fourBtn)
        {
            ansTxt.setText(previousTxt+4);
        }
        if(view.getId() == R.id.threeBtn)
        {
            ansTxt.setText(previousTxt+3);
        }
        if(view.getId() == R.id.twoBtn)
        {
            ansTxt.setText(previousTxt+2);
        }
        if(view.getId() == R.id.oneBtn)
        {
            ansTxt.setText(previousTxt+1);
        }
        if(view.getId() == R.id.plusBtn)
        {
            ansTxt.setText(previousTxt+'+');
        }
        if(view.getId() == R.id.minusBtn)
        {
            ansTxt.setText(previousTxt+'-');
        }
        if(view.getId() == R.id.starBtn)
        {
            ansTxt.setText(previousTxt+'*');
        }
        if(view.getId() == R.id.devBtn)
        {
            ansTxt.setText(previousTxt+'/');
        }
        if(view.getId() == R.id.zeroBtn)
        {
            ansTxt.setText(previousTxt+'0');
        }
        if(view.getId() == R.id.dotBtn)
        {
            ansTxt.setText(previousTxt+'.');
        }
        if(view.getId() == R.id.sinBtn)
        {
            ansTxt.setText(previousTxt);
        }
        //TextView et = (TextView) findViewById(R.id.anstxt);
        ansTxt.setSelection(ansTxt.getText().length());
        //Log.d("id is ",String.valueOf(view.get()));
        //ansTxt.setText();
    }
}
