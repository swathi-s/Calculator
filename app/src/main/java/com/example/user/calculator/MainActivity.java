package com.example.user.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

    public void calculateResult(View view) {
        TextView ansTxt = (TextView) findViewById(R.id.anstxt);
        Toast.makeText(this, "text message is " + ansTxt.getText().toString(), Toast.LENGTH_SHORT).show();
        String data = ansTxt.getText().toString();
        int finalAns = 0;
        char[] values = new char[data.length()];
        char operand = 0;
        boolean operand_found = false;
        String value1= null;
        String value2 = null;
        for(int i=0;i<data.length();i++) {


            values[i] = ansTxt.getText().charAt(i);
            Log.d("values", String.valueOf(values[i]));
            if(!operand_found){
                if (ansTxt.getText().charAt(i) == '+'
                        || ansTxt.getText().charAt(i) == '-'
                        || ansTxt.getText().charAt(i) == '/'
                        || ansTxt.getText().charAt(i) == '*'
                        || ansTxt.getText().charAt(i) == '^'
                        || ansTxt.getText().charAt(i) == '%'
                        )
                {
                    operand = ansTxt.getText().charAt(i);
                    Log.d("operator found", String.valueOf(operand_found));
                    operand_found = true;

                }
                else
                {
                    operand_found = false;
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
                    operand_found = false;

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

        TextView ansTxt = (TextView) findViewById(R.id.anstxt);
        String previousTxt = String.valueOf(ansTxt.getText());
        if(view.getId() == R.id.sevenBtn)
        {
            ansTxt.setText(previousTxt+7);
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
        //Log.d("id is ",String.valueOf(view.get()));
        //ansTxt.setText();
    }
}
