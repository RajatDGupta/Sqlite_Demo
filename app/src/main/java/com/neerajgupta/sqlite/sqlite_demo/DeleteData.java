package com.neerajgupta.sqlite.sqlite_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DeleteData extends AppCompatActivity implements View.OnClickListener {
    EditText et_delete;
    Button bt_delete;
    DatabaseHandler databaseHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_data);

        databaseHandler=new DatabaseHandler(this);

        init();
        setListener();
    }

    private void setListener() {
        bt_delete.setOnClickListener(this);
    }

    private void init() {
        et_delete=findViewById(R.id.et_delete);
        bt_delete=findViewById(R.id.bt_delete);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_delete:
                 if(submitForm()){
                     databaseHandler.deleteData(et_delete.getText().toString());
                 }
                break;
        }
    }

    private boolean submitForm() {
        if (et_delete.getText().toString().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}
