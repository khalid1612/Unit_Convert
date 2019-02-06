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

import java.util.ArrayList;
import java.util.List;

public class DataActivity extends AppCompatActivity {

    private EditText _input1,_input2;
    private Spinner _dataType1,_dataType2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        _input1 = findViewById(R.id.etValue1);
        _input2 = findViewById(R.id.etValue2);
        _dataType1 = findViewById(R.id.spinDataType1);
        _dataType2 = findViewById(R.id.spinDataType2);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("bytes");
        categories.add("KB");
        categories.add("MB");
        categories.add("GB");
        categories.add("TB");
        categories.add("PB");
        categories.add("EB");
        categories.add("ZB");
        categories.add("YB");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        _dataType1.setAdapter(dataAdapter);
        _dataType2.setAdapter(dataAdapter);


        //set a default
        _dataType1.setSelection(0);
        _dataType2.setSelection(0);

        _input1.addTextChangedListener(input1);
        _input2.addTextChangedListener(input2);

        _dataType1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                try {
                    _input1.setText(DataConvert.convert(
                            Double.parseDouble(_input2.getText().toString()),
                            _dataType2.getSelectedItem().toString(),
                            _dataType1.getSelectedItem().toString()
                    ));
                }catch (Exception e){}
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        _dataType2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                try{
                    _input2.setText(DataConvert.convert(
                            Double.parseDouble(_input1.getText().toString()),
                            _dataType1.getSelectedItem().toString(),
                            _dataType2.getSelectedItem().toString()
                    ));
                }catch (Exception e){}
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private TextWatcher input1 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            _input2.removeTextChangedListener(input2);

            if (_input1.getText().toString().length() == 0){
                _input2.setText("");
            }else{
                try {
                    _input2.setText(DataConvert.convert(
                            Double.parseDouble(_input1.getText().toString()),
                            _dataType1.getSelectedItem().toString(),
                            _dataType2.getSelectedItem().toString()
                    ));
                }catch (Exception e){}
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
            _input2.addTextChangedListener(input2);
        }
    };

    private TextWatcher input2 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            _input1.removeTextChangedListener(input1);

            if (_input2.getText().toString().length() == 0){
                _input1.setText("");
            }else{
                try {
                    _input1.setText(DataConvert.convert(
                            Double.parseDouble(_input2.getText().toString()),
                            _dataType2.getSelectedItem().toString(),
                            _dataType1.getSelectedItem().toString()
                    ));
                }catch (Exception e){}
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
            _input1.addTextChangedListener(input1);
        }
    };
}
