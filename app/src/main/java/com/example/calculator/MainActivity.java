package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean isOperator = false;
    private Double num1,num2,answer;
    private  Character currentOp;
    private int num2Index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView calcScreen = findViewById(R.id.CalculatorScreen);
        final Button n0 = findViewById(R.id.n0);
        final Button n1 = findViewById(R.id.n1);
        final Button n2 = findViewById(R.id.n2);
        final Button n3 = findViewById(R.id.n3);
        final Button n4 = findViewById(R.id.n4);
        final Button n5 = findViewById(R.id.n5);
        final Button n6 = findViewById(R.id.n6);
        final Button n7 = findViewById(R.id.n7);
        final Button n8 = findViewById(R.id.n8);
        final Button n9 = findViewById(R.id.n9);
        final Button dot = findViewById(R.id.dot);
        final Button add = findViewById(R.id.add);
        final Button sub = findViewById(R.id.sub);
        final Button mult = findViewById(R.id.mult);
        final Button div = findViewById(R.id.div);
        final Button equals = findViewById(R.id.equal);
        final Button AC = findViewById(R.id.ac);
        final Button DEL = findViewById(R.id.del);

        final View.OnClickListener calcListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int id = view.getId();
                switch (id) {
                    case R.id.n0:
                        calcScreen.append("0");
                        break;
                    case R.id.n1:
                        calcScreen.append("1");
                        break;
                    case R.id.n2:
                        calcScreen.append("2");
                        break;
                    case R.id.n3:
                        calcScreen.append("3");
                        break;
                    case R.id.n4:
                        calcScreen.append("4");
                        break;
                    case R.id.n5:
                        calcScreen.append("5");
                        break;
                    case R.id.n6:
                        calcScreen.append("6");
                        break;
                    case R.id.n7:
                        calcScreen.append("7");
                        break;
                    case R.id.n8:
                        calcScreen.append("8");
                        break;
                    case R.id.n9:
                        calcScreen.append("9");
                        break;
                    case R.id.equal:
                        if (isOperator){
                            String screenContext = calcScreen.getText().toString();
                            num2 = Double.parseDouble(screenContext.substring(num2Index,screenContext.length()));
                            if(currentOp == '+'){
                                answer = num1 + num2;
                                calcScreen.setText(String.valueOf(answer));
                                isOperator = false;
                            }
                            else if(currentOp == '-'){
                                answer = num1 - num2;
                                calcScreen.setText(String.valueOf(answer));
                                isOperator = false;
                            }
                            else if(currentOp == '*'){
                                answer = num1*num2;
                                calcScreen.setText(String.valueOf(answer));
                                isOperator = false;
                            }
                            else if(currentOp == '/'){
                                answer = num1/num2;
                                calcScreen.setText(String.valueOf(answer));
                                isOperator = false;
                            }
                        }
                        else {
                            calcScreen.setText("");
                        }
                        break;
                    case R.id.add:
                        String screenContext = calcScreen.getText().toString();
                        if(screenContext.length()>0){
                            num1 = Double.parseDouble(screenContext);
                            num2Index = screenContext.length()+1;
                            calcScreen.append("+");
                            isOperator = true;
                            currentOp = '+';
                        }
                        break;
                    case R.id.sub:
                        screenContext = calcScreen.getText().toString();
                        if(screenContext.length()>0){
                            num1 = Double.parseDouble(screenContext);
                            num2Index = screenContext.length()+1;
                            calcScreen.append("-");
                            isOperator = true;
                            currentOp = '-';
                        }
                        break;
                    case R.id.mult:
                        screenContext = calcScreen.getText().toString();
                        if(screenContext.length()>0){
                            num1 = Double.parseDouble(screenContext);
                            num2Index = screenContext.length()+1;
                            calcScreen.append("*");
                            isOperator = true;
                            currentOp = '*';
                        }
                        break;
                    case R.id.div:
                        screenContext = calcScreen.getText().toString();
                        if(screenContext.length()>0){
                            num1 = Double.parseDouble(screenContext);
                            num2Index = screenContext.length()+1;
                            calcScreen.append("/");
                            isOperator = true;
                            currentOp = '/';
                        }
                        break;
                    case R.id.ac:
                        calcScreen.setText("");
                        break;
                    case R.id.del:
                        String currentInput = calcScreen.getText().toString();
                        int l = currentInput.length();
                        if(l>0){
                            String newInput = currentInput.substring(0,l-1);
                            calcScreen.setText(newInput);
                        }
                        break;
                    case R.id.dot:
                        calcScreen.append(".");
                        break;
                }
            }
        };

        n0.setOnClickListener(calcListener);
        n1.setOnClickListener(calcListener);
        n2.setOnClickListener(calcListener);
        n3.setOnClickListener(calcListener);
        n4.setOnClickListener(calcListener);
        n5.setOnClickListener(calcListener);
        n6.setOnClickListener(calcListener);
        n7.setOnClickListener(calcListener);
        n8.setOnClickListener(calcListener);
        n9.setOnClickListener(calcListener);
        equals.setOnClickListener(calcListener);
        add.setOnClickListener(calcListener);
        sub.setOnClickListener(calcListener);
        mult.setOnClickListener(calcListener);
        div.setOnClickListener(calcListener);
        AC.setOnClickListener(calcListener);
        DEL.setOnClickListener(calcListener);
        dot.setOnClickListener(calcListener);
    }
}