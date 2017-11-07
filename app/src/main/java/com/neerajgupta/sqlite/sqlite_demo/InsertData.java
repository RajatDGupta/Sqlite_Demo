package com.neerajgupta.sqlite.sqlite_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class InsertData extends AppCompatActivity implements View.OnClickListener {

    EditText et_Name, et_Phone;
    Button bt_Insert;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);

        db = new DatabaseHandler(this);

        init();
        setAction();
    }

    private void setAction() {
        bt_Insert.setOnClickListener(this);
    }

    private void init() {
        et_Name = findViewById(R.id.et_Name);
        et_Phone = findViewById(R.id.et_Phone);

        bt_Insert = findViewById(R.id.bt_Insert);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_Insert:
                if (submitForm()) {
                    db.addContact(new Contact(et_Name.getText().toString(), et_Name.getText().toString()));
                }
                break;
        }
    }

    private boolean submitForm() {
        if (et_Name.getText().toString().isEmpty() || et_Name.getText().toString().isEmpty()) {
            bt_Insert.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            return false;
        }
        else {
        return true;}
    }
}
