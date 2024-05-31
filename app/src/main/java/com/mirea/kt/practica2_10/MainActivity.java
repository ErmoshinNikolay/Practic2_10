package com.mirea.kt.practica2_10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextModel, editTextSerialNumber, editTextPrice;
    private DBManager dbManager;

    // Конструктор по умолчанию
    public MainActivity() {
        // Необходимо для правильной инициализации активности
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextModel = findViewById(R.id.etModel);
        editTextSerialNumber = findViewById(R.id.etSErialNumber);
        editTextPrice = findViewById(R.id.etPrice);
        this.dbManager = new DBManager(new MyAppSQLiteHelper(this,"my_database.db",null,1));
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnNext = findViewById(R.id.btnNext);
        btnAdd.setOnClickListener(this);
        btnNext.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAdd){
            if(this.dbManager != null){
                String model = editTextModel.getText().toString();
                String serial_number = editTextSerialNumber.getText().toString();
                String price = editTextPrice
                        .getText().toString();
                if (!model.isEmpty() && !serial_number.isEmpty() && !price.isEmpty()){
                    boolean result = dbManager.savePhoneToDatabase(new Phone(model,serial_number, Integer.parseInt(price)));
                    if(result){
                        Toast.makeText(this, R.string.insert_success, Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(this, R.string.inser_error, Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(this, R.string.incorrect_value, Toast.LENGTH_LONG).show();
                }

            }
        }else if(v.getId() == R.id.btnNext){
            startActivity(new Intent(this,PhoneActivity.class));

        }
    }
}