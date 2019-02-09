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

public class LengthActivity extends AppCompatActivity {

    private EditText _input;
    private Spinner _lengthType;
    private TextView _cm, _m, _km;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);

        _input = findViewById(R.id.etValue);
        _cm = findViewById(R.id.tvCm);
        _m = findViewById(R.id.tvM);
        _km = findViewById(R.id.tvKm);
        _lengthType = findViewById(R.id.spinLengthType);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Centimeter");
        categories.add("Meter");
        categories.add("Kilometer");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        _lengthType.setAdapter(dataAdapter);


        //set a default
        _lengthType.setSelection(0);

        // Spinner click listener
        _lengthType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
                    showResult(_lengthType.getSelectedItemPosition());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void showResult(int position){
        double inputValue = Double.parseDouble(_input.getText().toString());

        double cm = 0,m = 0,km = 0;

        switch (position)
        {
            case 0:
                cm = inputValue;
                m = LengthConvert.cmToM(inputValue);
                km = LengthConvert.cmToKm(inputValue);
                break;

            case 1:
                cm = LengthConvert.mToCm(inputValue);
                m = inputValue;
                km = LengthConvert.mToKm(inputValue);
                break;

            case 2:
                cm = LengthConvert.kToCm(inputValue);
                m = LengthConvert.kToM(inputValue);
                km = inputValue;
                break;
        }

        _cm.setText(String.valueOf(cm));
        _m.setText(String.valueOf(m));
        _km.setText(String.valueOf(km));

    }

    private void resetAll(){
        _cm.setText("0");
        _m.setText("0");
        _km.setText("0");
    }
}
