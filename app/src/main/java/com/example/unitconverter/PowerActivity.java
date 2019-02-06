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

public class PowerActivity extends AppCompatActivity {

    EditText _input;
    Spinner _powerType;
    TextView _watt, _kilowatt, _horsePower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angle);

        _input = findViewById(R.id.etValue);
        _watt = findViewById(R.id.tvWatt);
        _kilowatt = findViewById(R.id.tvKilowatt);
        _horsePower = findViewById(R.id.tvHorsePower);
        _powerType = findViewById(R.id.spinPowerType);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Watt");
        categories.add("Kilowatt");
        categories.add("Horse power");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        _powerType.setAdapter(dataAdapter);


        //set a default
        _powerType.setSelection(0);

        // Spinner click listener
        _powerType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
                    showResult(_powerType.getSelectedItemPosition());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void showResult(int position){
        double inputValue = Double.parseDouble(_input.getText().toString());

        double watt = 0,kilowatt = 0,horsePower = 0;

        switch (position)
        {
            case 0:
                watt = inputValue;
                kilowatt = PowerConvert.wattToKilowatt(inputValue);
                horsePower = PowerConvert.wattToHorsepower(inputValue);
                break;

            case 1:
                watt = PowerConvert.kilowattToWatt(inputValue);
                kilowatt = inputValue;
                horsePower = PowerConvert.kilowattToHorsepower(inputValue);
                break;

            case 2:
                watt = PowerConvert.horsepowerToWatt(inputValue);
                kilowatt = PowerConvert.horsepowerToKilowatt(inputValue);
                horsePower = inputValue;
                break;
        }

        _watt.setText(String.valueOf(watt));
        _kilowatt.setText(String.valueOf(kilowatt));
        _horsePower.setText(String.valueOf(horsePower));

    }

    private void resetAll(){
        _watt.setText("0");
        _kilowatt.setText("0");
        _horsePower.setText("0");
    }
}
