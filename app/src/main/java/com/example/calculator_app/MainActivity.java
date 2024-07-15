package com.example.calculator_app;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edit1;
    boolean isNewOp = true;
    String oldNum = "";
    String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edit1 = findViewById(R.id.editText);
    }

    public void numEvent(View view) {
        if (isNewOp) {
            edit1.setText("");
        }
        isNewOp = false;
        if (view.getId() == R.id.btn0) {
            edit1.append("0");
        } else if (view.getId() == R.id.btn1) {
            edit1.append("1");
        } else if (view.getId() == R.id.btn2) {
            edit1.append("2");
        } else if (view.getId() == R.id.btn3) {
            edit1.append("3");
        } else if (view.getId() == R.id.btn4) {
            edit1.append("4");
        } else if (view.getId() == R.id.btn5) {
            edit1.append("5");
        } else if (view.getId() == R.id.btn6) {
            edit1.append("6");
        } else if (view.getId() == R.id.btn7) {
            edit1.append("7");
        } else if (view.getId() == R.id.btn8) {
            edit1.append("8");
        } else if (view.getId() == R.id.btn9) {
            edit1.append("9");
        } else if (view.getId() == R.id.btnDot) {
            edit1.append(".");
        }
    }

    public void operatorEvent(View view) {
        isNewOp = true;
        oldNum = edit1.getText().toString();
        if (view.getId() == R.id.btnDiv) {
            operator = "/";
        } else if (view.getId() == R.id.btnMultiply) {
            operator = "X";
        } else if (view.getId() == R.id.btnPlus) {
            operator = "+";
        } else if (view.getId() == R.id.btnMinus) {
            operator = "-";
        }

    }

    public void equalEvent(View view) {
        String newNum = edit1.getText().toString();
        double result = 0.0;
        switch (operator) {
            case "+":
                result = Double.parseDouble(oldNum) + Double.parseDouble(newNum);
                break;
            case "-":
                result = Double.parseDouble(oldNum) - Double.parseDouble(newNum);
                break;
            case "/":
                result = Double.parseDouble(oldNum) / Double.parseDouble(newNum);
                break;
            case "X":
                result = Double.parseDouble(oldNum) * Double.parseDouble(newNum);
                break;
        }
        edit1.setText(result + "");
    }

    public void clearEvent(View view) {
        edit1.setText("0");
        isNewOp = true;
    }
    public void deleteEvent(View view) {
        String currentText = edit1.getText().toString();
        if (currentText.length() > 0) {
            String newText = currentText.substring(0, currentText.length() - 1);
            edit1.setText(newText);
        }
    }
}