package com.example.que5;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Second extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button buttonCalculate = findViewById(R.id.buttonCalculate);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Receive radius and calculation type from the first activity
                Intent intent = getIntent();
                String radius = intent.getStringExtra("radius");
                String calculationType = intent.getStringExtra("calculationType");

                // Perform the calculation based on calculationType (Circumference or Area)
                double result = 0.0;
                if (calculationType.equals("Circumference")) {
                    // Calculate Circumference
                    result = 2 * Math.PI * Double.parseDouble(radius);
                } else if (calculationType.equals("Area")) {
                    // Calculate Area
                    result = Math.PI * Math.pow(Double.parseDouble(radius), 2);
                }

                // Send the result back to the first activity
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result", result);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}