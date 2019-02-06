package com.example.unitconverter;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ProgrammerActivity extends AppCompatActivity {

    private EditText _input;
    private Spinner _programmerType;
    private TextView _decimal, _binary, _octal, _hex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programmer);

        _input = findViewById(R.id.etValue);
        _decimal = findViewById(R.id.tvDecimal);
        _binary = findViewById(R.id.tvBinary);
        _octal = findViewById(R.id.tvOctal);
        _hex = findViewById(R.id.tvHex);
        _programmerType = findViewById(R.id.spinProgrammerType);


        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Decimal");
        categories.add("Binary");
        categories.add("Octal");
        categories.add("Hex");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        _programmerType.setAdapter(dataAdapter);


        //set a default
        _programmerType.setSelection(0);

        // Spinner click listener
        _programmerType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
                    showResult(_programmerType.getSelectedItemPosition());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void showResult(int position){

        String inputValue = _input.getText().toString();

        switch (position)
        {
            case 0:
                try {
                    _decimal.setText(inputValue);
                    _binary.setText(ProgrammerConvert.decimalToBinary(Long.parseLong(inputValue)));
                    _octal.setText(ProgrammerConvert.decimalToOctal(Long.parseLong(inputValue)));
                    _hex.setText(ProgrammerConvert.decimalToHex(Long.parseLong(inputValue)));
                }catch (Exception e){
                    ShowToast.LongToast(this,e.toString());
                }
                break;

            case 1:
                try {
                    _decimal.setText(String.valueOf(ProgrammerConvert.binaryToDecimal(inputValue)));
                    _binary.setText(inputValue);
                    _octal.setText(ProgrammerConvert.binaryToOctal(inputValue));
                    _hex.setText(ProgrammerConvert.binaryToHex(inputValue));
                }catch (Exception e){
                    ShowToast.LongToast(this,e.toString());
                }
                break;

            case 2:
                try {
                    _decimal.setText(String.valueOf(ProgrammerConvert.octalToDecimal(inputValue)));
                    _binary.setText(ProgrammerConvert.octalToBinary(inputValue));
                    _octal.setText(inputValue);
                    _hex.setText(ProgrammerConvert.octalToHex(inputValue));
                }catch (Exception e){
                    ShowToast.LongToast(this,e.toString());
                }

                break;

            case 3:
                try{
                    _decimal.setText(String.valueOf(ProgrammerConvert.hexToDecimal(inputValue)));
                    _binary.setText(ProgrammerConvert.hexToBinary(inputValue));
                    _octal.setText(ProgrammerConvert.hexToOctal(inputValue));
                    _hex.setText(inputValue);
                }catch (Exception e){
                    ShowToast.LongToast(this,e.toString());
                }

                break;
        }

    }

    private void resetAll(){
        _decimal.setText("0");
        _binary.setText("0");
        _octal.setText("0");
        _hex.setText("0");
    }
}
