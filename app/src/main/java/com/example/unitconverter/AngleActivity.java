package com.example.unitconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AngleActivity extends AppCompatActivity {

    EditText _input;
    Spinner _angleType;
    TextView _degree,_radian, _gradian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angle);

        _input = findViewById(R.id.etValue);
        _degree = findViewById(R.id.tvDegree);
        _radian = findViewById(R.id.tvRadian);
        _gradian = findViewById(R.id.tvGradian);
        _angleType = findViewById(R.id.spinAngleType);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Degree");
        categories.add("Radian");
        categories.add("Gradian");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        _angleType.setAdapter(dataAdapter);


        //set a default
        _angleType.setSelection(0);

        // Spinner click listener
        _angleType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (_input.getText().toString().length() == 0){
                    resetAll();
                }else{
                    showResult(position);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //text change listener
        _input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (_input.getText().toString().length() == 0){
                    resetAll();
                }else{
                    showResult(_angleType.getSelectedItemPosition());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void showResult(int position){
        double inputValue = Double.parseDouble(_input.getText().toString());

        double degree = 0,radian = 0,gradian = 0;

        switch (position)
        {
            case 0:
                degree = inputValue;
                radian = AngleConvert.degreeToRadian(inputValue);
                gradian = AngleConvert.degreeToGradian(inputValue);
                break;

            case 1:
                degree = AngleConvert.radianToDegree(inputValue);
                radian = inputValue;
                gradian = AngleConvert.radianToGradian(inputValue);
                break;

            case 2:
                degree = AngleConvert.gradianToDegree(inputValue);
                radian = AngleConvert.gradianToRadian(inputValue);
                gradian = inputValue;
                break;
        }

        _degree.setText(String.valueOf(degree));
        _radian.setText(String.valueOf(radian));
        _gradian.setText(String.valueOf(gradian));

    }

    private void resetAll(){
        _degree.setText("0");
        _radian.setText("0");
        _gradian.setText("0");
    }
}
