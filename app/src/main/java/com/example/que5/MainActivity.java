package com.example.que5;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.que5.R;
import com.example.que5.Second;

public class MainActivity extends AppCompatActivity {
    private EditText editTextRadius;
    private TextView textViewResult;

    // Constants for result handling
    private static final int CALCULATION_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextRadius = findViewById(R.id.editTextRadius);
        Button buttonCircumference = findViewById(R.id.buttonCircumference);
        Button buttonArea = findViewById(R.id.buttonArea);
        textViewResult = findViewById(R.id.textViewResult);

        buttonCircumference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchResultActivity("Circumference");
            }
        });

        buttonArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchResultActivity("Area");
            }
        });
    }

    private void launchResultActivity(String calculationType) {
        String radius = editTextRadius.getText().toString();
        Intent intent = new Intent(this, Second.class);
        intent.putExtra("radius", radius);
        intent.putExtra("calculationType", calculationType);
        startActivityForResult(intent, CALCULATION_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CALCULATION_REQUEST && resultCode == RESULT_OK) {
            double result = data.getDoubleExtra("result", 0.0);
            textViewResult.setText("Result: " + result);
        }
    }
}