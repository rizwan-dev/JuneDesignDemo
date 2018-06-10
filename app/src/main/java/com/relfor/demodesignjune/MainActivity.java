package com.relfor.demodesignjune;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edtName, edtAddress, edtPhone;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edt_name);
        edtAddress = findViewById(R.id.edt_address);
        edtPhone = findViewById(R.id.edt_phone);

        btnSave = findViewById(R.id.btn_save);

        final DBHelper dbHelper = new DBHelper(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString().trim();
                String phone = edtPhone.getText().toString().trim();
                String address = edtAddress.getText().toString().trim();

                Person person = new Person(name, phone, address);
                boolean isSuccess = dbHelper.addPerson(person);

                if(isSuccess){
                    Toast.makeText(getApplicationContext(), "Data stored", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Insertion failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
















}
