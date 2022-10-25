package com.example.calcamia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {
    EditText ed1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.textView);
        ed1.setShowSoftInputOnFocus(false);

    }

    private void updateText(String str) {
        String old = ed1.getText().toString();
        int cPos = ed1.getSelectionStart();
        String left = old.substring(0, cPos);
        String right = old.substring(cPos);
        if (getString(R.string.display).equals(ed1.getText().toString())) {
            ed1.setText(str);
        } else {
            ed1.setText(String.format("%s%s%s", left, str, right));
        }
        ed1.setSelection(cPos + 1);
    }

    public void zeroBtn(View view) {
        updateText("0");
    }

    public void oneBtn(View view) {
        updateText("1");
    }

    public void twoBtn(View view) {
        updateText("2");
    }

    public void threeBtn(View view) {
        updateText("3");
    }

    public void fourBtn(View view) {
        updateText("4");
    }

    public void fiveBtn(View view) {
        updateText("5");
    }

    public void sixBtn(View view) {
        updateText("6");
    }

    public void sevenBtn(View view) {
        updateText("7");
    }

    public void eightBtn(View view) {
        updateText("8");
    }

    public void nineBtn(View view) {
        updateText("9");
    }

    public void plusBtn(View view) {
        updateText("+");
    }

    public void minusBtn(View view) {
        updateText("-");
    }

    public void divideBtn(View view) {
        updateText("÷");
    }

    public void multiplyBtn(View view) {
        updateText("×");
    }

    public void dotBtn(View view) {
        updateText(".");
    }

    public void modBtn(View view) {
        updateText("%");
    }

    public void clearBtn(View view) {
        ed1.setText("Φ");
    }

    public void plusMinusBtn(View view) {
        updateText("-");
    }

    public void equalBtn(View view) {
        String displayExp=ed1.getText().toString();
        displayExp=displayExp.replaceAll("tan-1","arctan");
        displayExp=displayExp.replaceAll("sin-1","arcsin");
        displayExp=displayExp.replaceAll("cos-1","arccos");
        displayExp=displayExp.replaceAll(getResources().getString(R.string.divide),"/");
        displayExp=displayExp.replaceAll(getResources().getString(R.string.multiply),"*");
        displayExp=displayExp.replaceAll(getResources().getString(R.string.pi),"pi");
        Expression exp= new Expression(displayExp);
        String result=String.valueOf(exp.calculate());
        ed1.setText(result);
        ed1.setSelection(result.length());
    }

    public void bracketsBtn(View view) {
        int cPos = ed1.getSelectionStart();
        int cB = 0;
        int oB = 0;
        int length = ed1.getText().length();

        for (int i = 0; i < cPos; i++) {
            if (ed1.getText().toString().substring(i, i + 1).equals("(")) {
                oB++;
            }
            if (ed1.getText().toString().substring(i, i + 1).equals(")")) {
                cB++;
            }
        }
        if (oB == cB || ed1.getText().toString().substring(length - 1, length).equals("(")) {
            updateText("(");
        } else if (cB < oB && !ed1.getText().toString().substring(length - 1, length).equals("(")) {
            updateText(")");
        }

        ed1.setSelection(cPos + 1);


    }

    public void backspaceBtn(View view) {
        int cPos = ed1.getSelectionStart();
        int length = ed1.getText().length();

        if (cPos != 0 && length != 0) {
            SpannableStringBuilder selection = (SpannableStringBuilder) ed1.getText();
            selection.replace(cPos - 1, cPos, "");
            ed1.setText(selection);
            ed1.setSelection(cPos - 1);

        }
    }
    public void sin(View view){updateText("sin(");int cPos=ed1.getSelectionStart();ed1.setSelection(cPos + 3);}
    public void cos(View view){updateText("cos(");int cPos=ed1.getSelectionStart();ed1.setSelection(cPos + 3);}
    public void tan(View view){updateText("tan(");int cPos=ed1.getSelectionStart();ed1.setSelection(cPos + 3);}
    public void sinInverse(View view){String st="sin-1(";updateText(st);int cPos=ed1.getSelectionStart();ed1.setSelection(cPos + 5);}
    public void cosInverse(View view){String st="cos-1(";updateText(st);int cPos=ed1.getSelectionStart();ed1.setSelection(cPos + 5);}
    public void tanInverse(View view){String st="tan-1(";updateText(st);int cPos=ed1.getSelectionStart();ed1.setSelection(cPos + 5);}
    public void ln(View view){updateText("ln(");int cPos=ed1.getSelectionStart();ed1.setSelection(cPos + 2);}
    public void lg(View view){updateText("log(");int cPos=ed1.getSelectionStart();ed1.setSelection(cPos + 3);}
    public void sqrt(View view){updateText("√");}
    public void eBtn(View view){updateText("e");}
    public void piBtn(View view){updateText("π");}
    public void factBtn(View view){updateText("!");}
    public void reciprocalBtn(View view){
        if(ed1.getText().toString().equals(getString(R.string.display))){
        ed1.setText("");}
        String reciprocal="1/";
        int len=ed1.getText().length();
        int cPos=ed1.getSelectionStart();
        String s=ed1.getText().toString().substring(0,len);
        ed1.setText(String.format("%s%s",reciprocal,s));
        ed1.setSelection(cPos + 2);
    }
    public void square(View view){updateText("^2");}
    public void squareY(View view){updateText("^(");int cPos=ed1.getSelectionStart();ed1.setSelection(cPos + 1);}

}
