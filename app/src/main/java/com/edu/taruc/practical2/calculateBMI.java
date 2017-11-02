package com.edu.taruc.practical2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class calculateBMI extends AppCompatActivity {

    TextView textViewResults;
    EditText editTextWeight;
    EditText editTextHeight;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //Display UI of an Activity
        setContentView(R.layout.activity_calculate_bmi);// R represent resources class

        //Link UI to program
        textViewResults = (TextView)findViewById(R.id.textViewResults);
        editTextHeight = (EditText)findViewById(R.id.editTextHeight);
        editTextWeight = (EditText)findViewById(R.id.editTextWeight);
        image= (ImageView)findViewById(R.id.imageView);
    }

    public void calculateBMI(View view)
    {
        Double bmi;
        Double height =  ((Double.parseDouble(editTextHeight.getText().toString()))/100);
        Double weight = Double.parseDouble(editTextWeight.getText().toString());
        bmi= weight/Math.pow(height,2);
        textViewResults.setText("BMI: "+bmi);

        if(bmi>=25)
        {
            image.setImageResource(R.drawable.over);
        }

        else if (bmi>=18.5 || bmi<=24.9)
        {
            image.setImageResource(R.drawable.normal);
        }

        else
        {
            image.setImageResource(R.drawable.under);
        }
    }

    public void resetValues(View view)
    {
        editTextHeight.setText("");
        editTextWeight.setText("");
        textViewResults.setText("BMI: None");
        image.setImageResource(R.drawable.empty);
    }
}
