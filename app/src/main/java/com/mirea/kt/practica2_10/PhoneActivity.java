package com.mirea.kt.practica2_10;

import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class PhoneActivity extends AppCompatActivity {

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        ActionBar ab = getSupportActionBar();
        if (ab != null){
            ab.setTitle("Phones");
            ab.setHomeButtonEnabled(true);
            ab.setDisplayHomeAsUpEnabled(true);
        }

        DBManager dbManager = new DBManager(new MyAppSQLiteHelper(this, "my_database.db", null, 1));
        ArrayList<Phone> phones = dbManager.LoadAllPhoneFromDatabase();
        RecyclerView rcView = findViewById(R.id.recyclerView);
        PhoneAdapter adapter = new PhoneAdapter(phones);

        rcView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rcView.setAdapter(adapter);



    }
}