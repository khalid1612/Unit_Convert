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

public class TemperatureActivity extends AppCompatActivity {

    private EditText _input;
    private Spinner _tempType;
    private TextView _celsius, _fahrenheit, _kelvin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        _input = findViewById(R.id.etValue);
        _celsius = findViewById(R.id.tvCelsius);
        _fahrenheit = findViewById(R.id.tvFahrenheit);
        _kelvin = findViewById(R.id.tvKelvin);
        _tempType = findViewById(R.id.spinTempType);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Celsius");
        categories.add("Fahrenheit");
        categories.add("Kelvin");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        _tempType.setAdapter(dataAdapter);


        //set a default
        _tempType.setSelection(0);

        // Spinner click listener
        _tempType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
                    showResult(_tempType.getSelectedItemPosition());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void showResult(int position){
        double inputValue = Double.parseDouble(_input.getText().toString());

        double celsius = 0,fahrenheit = 0,kelvin = 0;

        switch (position)
        {
            case 0:
                celsius = inputValue;
                fahrenheit = TemperatureConvert.celsiusToFahrenheit(inputValue);
                kelvin = TemperatureConvert.celsiusToKelvin(inputValue);
                break;

            case 1:
                celsius = TemperatureConvert.fahrenheitToCelsius(inputValue);
                fahrenheit = inputValue;
                kelvin = TemperatureConvert.fahrenheitToKelvin(inputValue);
                break;

            case 2:
                celsius = TemperatureConvert.kelvinToCelsius(inputValue);
                fahrenheit = TemperatureConvert.kelvinToFahrenheit(inputValue);
                kelvin = inputValue;
                break;
        }

        _celsius.setText(String.valueOf(celsius));
        _fahrenheit.setText(String.valueOf(fahrenheit));
        _kelvin.setText(String.valueOf(kelvin));

    }

    private void resetAll(){
        _celsius.setText("0");
        _fahrenheit.setText("0");
        _kelvin.setText("0");
    }
}
