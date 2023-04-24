package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView resultTV;
    MaterialButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button0;
    MaterialButton buttonC, buttonPlus, buttonMinus, buttonMultiply, buttonDivide, buttonEqual;

    double n1, n2, result;
    char operation;
    String resultStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTV = findViewById(R.id.result_tv);
        assignID(buttonC, R.id.button_c);
        assignID(buttonPlus, R.id.button_plus);
        assignID(buttonMinus, R.id.button_minus);
        assignID(buttonDivide, R.id.button_divide);
        assignID(buttonMultiply, R.id.button_multiply);
        assignID(buttonEqual, R.id.button_equal);

        assignID(button1, R.id.button_1);
        assignID(button2, R.id.button_2);
        assignID(button3, R.id.button_3);
        assignID(button4, R.id.button_4);
        assignID(button5, R.id.button_5);
        assignID(button6, R.id.button_6);
        assignID(button7, R.id.button_7);
        assignID(button8, R.id.button_8);
        assignID(button9, R.id.button_9);
        assignID(button0, R.id.button_0);
    }
    void assignID(MaterialButton btn, int id)
    {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        MaterialButton button = (MaterialButton) view;
        String buttonText=button.getText().toString();
        if(buttonText.equals("C")) {
            resultTV.setText("0");
        }
        else if(buttonText.equals("+"))
        {
            n1=Double.parseDouble(resultTV.getText().toString());
            resultTV.setText("0");
            operation='+';
        }
        else if(buttonText.equals("-"))
        {
            n1=Double.parseDouble(resultTV.getText().toString());
            resultTV.setText("0");
            operation='-';
        }
        else if(buttonText.equals("*"))
        {
            n1=Double.parseDouble(resultTV.getText().toString());
            resultTV.setText("0");
            operation='*';
        }
        else if(buttonText.equals("/"))
        {
            n1=Double.parseDouble(resultTV.getText().toString());
            resultTV.setText("0");
            operation='/';
        }
        else if(resultTV.getText().equals("0"))
        {
            resultTV.setText("");
            resultTV.setText(buttonText);
        }
        else if(buttonText.equals("="))
        {
            n2=Double.parseDouble(resultTV.getText().toString());
            switch (operation) {
                case '+':
                    result = n1 + n2;
                    resultStr=result + "";
                    resultTV.setText(resultStr);
                    break;
                case '-':
                    result = n1 - n2;
                    resultStr=result + "";
                    resultTV.setText(resultStr);
                    break;
                case '*':
                    result = n1 * n2;
                    resultStr=result + "";
                    resultTV.setText(resultStr);
                    break;
                case '/':
                    if (n2 != 0) {
                        result = n1 / n2;
                        resultStr=result + "";
                        resultTV.setText(resultStr);
                        break;
                    } else {
                        resultTV.setText("Error");
                    }
            }
        }
        else
        {
            String display = resultTV.getText() + buttonText;
            resultTV.setText(display);
        }

    }
}