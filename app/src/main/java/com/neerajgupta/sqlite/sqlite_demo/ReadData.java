package com.neerajgupta.sqlite.sqlite_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ReadData extends AppCompatActivity implements View.OnClickListener {

    EditText et_read;
    Button bt_read;
    DatabaseHandler databaseHandler;
    TextView tv_read_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        databaseHandler = new DatabaseHandler(this);

        setContentView(R.layout.activity_read_data);
        init();
        setOnClick();


    }

    private void setOnClick() {
        bt_read.setOnClickListener(this);
    }

    private void init() {
        et_read = findViewById(R.id.et_read);
        bt_read = findViewById(R.id.bt_read);
        tv_read_data = findViewById(R.id.tv_read_data);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_read:
                if (submitForm()) {
                    tv_read_data.setText("");

                    Contact contact = databaseHandler.getContact(Integer.parseInt(et_read.getText().toString()));

                    String id = String.valueOf(contact.get_id());
                    String name = contact.get_name();
                    String phone = contact.get_phone_number();
                    tv_read_data.setText(id + '\n' + name + '\n' + phone);

                }
                break;
        }
    }

    private boolean submitForm() {
        if (bt_read.getText().toString().isEmpty()) {
            bt_read.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            return false;
        } else {
            return true;
        }
    }
}
