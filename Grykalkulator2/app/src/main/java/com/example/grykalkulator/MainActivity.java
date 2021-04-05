package com.example.grykalkulator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    private TextView previousCalculation;
    private EditText display;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        previousCalculation = findViewById(R.id.previousCalculatingView);
        display = findViewById(R.id.displayEditText);

        display.setShowSoftInputOnFocus(false);
    }

    private void updateText (String strToAdd)
    {
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftString = oldStr.substring(0,cursorPos);
        String rightString = oldStr.substring(cursorPos);
        display.setText(String.format("%s%s%s", leftString, strToAdd, rightString));
        display.setSelection(cursorPos + strToAdd.length());
    }

    public void zeroButtonPush(View view) { updateText(getResources().getString(R.string.zeroText)); }
    public void oneButtonPush(View view) { updateText(getResources().getString(R.string.oneText)); }
    public void twoButtonPush(View view) { updateText(getResources().getString(R.string.twoText)); }
    public void threeButtonPush(View view) { updateText(getResources().getString(R.string.threeText)); }
    public void fourButtonPush(View view) { updateText(getResources().getString(R.string.fourText)); }
    public void fiveButtonPush(View view) { updateText(getResources().getString(R.string.fiveText)); }
    public void sixButtonPush(View view) { updateText(getResources().getString(R.string.sixText)); }
    public void sevenButtonPush(View view) { updateText(getResources().getString(R.string.sevenText)); }
    public void eightButtonPush(View view) { updateText(getResources().getString(R.string.eightText)); }
    public void nineButtonPush(View view) { updateText(getResources().getString(R.string.nineText)); }
    public void bracket1ButtonPush(View view) { updateText(getResources().getString(R.string.parenthesesOpenText)); }
    public void bracket2ButtonPush(View view) { updateText(getResources().getString(R.string.parenthesesCloseText)); }
    public void divideButtonPush(View view) { updateText(getResources().getString(R.string.divideText)); }
    public void multiplyButtonPush(View view) { updateText(getResources().getString(R.string.multiplyText)); }
    public void addButtonPush(View view) { updateText(getResources().getString(R.string.addText)); }
    public void subtractButtonPush(View view) { updateText(getResources().getString(R.string.subtractText)); }
    public void decimalButtonPush(View view) { updateText(getResources().getString(R.string.decimalText)); }
    public void clearButtonPush(View view) { display.setText(""); }
    public void equalButtonPush(View view)
    {
        String userExp = display.getText().toString();

        previousCalculation.setText(userExp);

        userExp = userExp.replaceAll("÷", "/");
        userExp = userExp.replaceAll("×", "*");

        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());
    }
    public void backspaceButtonPush(View view)
    {
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen !=0)
        {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos-1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }
    }

    public void trigSinButtonPush(View view) { updateText("sin ("); }
    public void trigCosButtonPush(View view) { updateText("cos ("); }
    public void trigTanButtonPush(View view) { updateText("tan ("); }
    public void trigArcSinButtonPush(View view) { updateText("arcsin ("); }
    public void trigArcCosButtonPush(View view) { updateText("arccos ("); }
    public void trigArcTanButtonPush(View view) { updateText("arctan ("); }
    public void naturalLogButtonPush(View view) { updateText("ln ("); }
    public void LogButtonPush(View view) { updateText("log ("); }
    public void squareRootButtonPush(View view) { updateText("sqrt ("); }
    public void absoluteValueButtonPush(View view) { updateText("abs ("); }
    public void piTextButtonPush(View view) { updateText("pi"); }
    public void eTextButtonPush(View view) { updateText("e"); }
    public void xSquaredButtonPush(View view) { updateText("^(2)"); }
    public void xPowerButtonPush(View view) { updateText("^("); }
    public void isPrimeFunctionButtonPush(View view) { updateText("ispr ("); }

}