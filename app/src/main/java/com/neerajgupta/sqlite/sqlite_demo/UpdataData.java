package com.neerajgupta.sqlite.sqlite_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UpdataData extends AppCompatActivity implements View.OnClickListener {
    EditText et_Id, et_Name, et_Phone;
    Button bt_Update;
    DatabaseHandler databaseHandler;
    TextView tv_getData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updata_data);

        databaseHandler = new DatabaseHandler(this);

        init();
        setListener();
    }

    private void setListener() {
        bt_Update.setOnClickListener(this);
    }

    private void init() {
        et_Id = findViewById(R.id.et_Id);
        et_Name = findViewById(R.id.et_Name);
        et_Phone = findViewById(R.id.et_Phone);

        tv_getData = findViewById(R.id.tv_getData);

        bt_Update = findViewById(R.id.bt_Update);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_Update:


                    int id = Integer.parseInt(et_Id.getText().toString());
                    String name = et_Name.getText().toString();
                    String phone = et_Phone.getText().toString();

                    Contact contact = new Contact(id,name,phone);
                    databaseHandler.updateContact(contact);

                break;
        }
    }


    private boolean submitForm() {
        if (et_Id.getText().toString().isEmpty() || et_Name.getText().toString().isEmpty() || et_Phone.getText().toString().isEmpty()) {

            return false;
        } else {
            return true;
        }
    }
}
