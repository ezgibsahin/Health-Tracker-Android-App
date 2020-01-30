package com.example.admin.healthtracker;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

public class BMIActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        button = (Button)findViewById(R.id.BMIResultButtonId);
        button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                boolean calculate = true;
                double height = 0.0;
                double weight = 0.0;
                String weightCategories = null;

                EditText yourHeight = (EditText) findViewById(R.id.heightId);
                try {
                    String height_S = yourHeight.getText().toString();
                    height = Double.parseDouble(height_S);
                }catch(Exception e) {
                    Toast.makeText(getApplicationContext(),"Please enter your height correctly.",Toast.LENGTH_LONG).show();
                    calculate = false;
                }
                if(height <0.0 || height >3.5)
                {
                    Toast.makeText(getApplicationContext(),"Please enter your height correctly.",Toast.LENGTH_LONG).show();
                    calculate = false;
                }

                EditText yourWeight = (EditText) findViewById(R.id.weightId);
                try{
                    String weight_S = yourWeight.getText().toString();
                    weight = Double.parseDouble(weight_S);
                }catch(Exception e) {

                    Toast.makeText(getApplicationContext(),"Please enter your weight correctly.",Toast.LENGTH_LONG).show();
                    calculate = false;
                }
                if(weight < 0.0)
                {
                    Toast.makeText(getApplicationContext(),"Please enter your weight correctly.",Toast.LENGTH_LONG).show();
                    calculate = false;
                }

                if(calculate == true)
                {
                    double BMI = weight / Math.pow(height,2);

                    if(BMI <18.5)
                    {
                        weightCategories = "Underweight";
                    }
                    else if(BMI >=18.5 && BMI <= 24.9)
                    {
                        weightCategories = "Normal weight";
                    }
                    else if(BMI == 25 && BMI <=29.9)
                    {
                        weightCategories = "Overweight";
                    }
                    else if(BMI >= 30)
                    {
                        weightCategories = "Obesity";
                    }

                    AlertDialog.Builder bmiBuilder = new AlertDialog.Builder(BMIActivity.this);
                    bmiBuilder.setCancelable(true);
                    bmiBuilder.setTitle("Calculated BMI Result & Your Category of Weight");
                    bmiBuilder.setMessage("BMI = "+ BMI + "\n" + "Your Category of Weight = " + weightCategories);

                    bmiBuilder.setNegativeButton("CALCULATE AGAIN", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                            finish();
                            startActivity(getIntent());
                        }
                    });
                    bmiBuilder.show();
                }

            }

        });
    }
}
