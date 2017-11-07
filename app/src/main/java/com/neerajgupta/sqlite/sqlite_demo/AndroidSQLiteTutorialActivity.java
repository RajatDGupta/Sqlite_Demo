package com.neerajgupta.sqlite.sqlite_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class AndroidSQLiteTutorialActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Contact> contacts;
    RecyclerView.LayoutManager mLayoutManager;
    ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHandler db = new DatabaseHandler(this);

        recyclerView = findViewById(R.id.recyclerView);

      /*  *//**
         * CRUD Operations
         * *//*
        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.addContact(new Contact("Ravi", "9100000000"));
        db.addContact(new Contact("Srinivas", "9199999999"));
        db.addContact(new Contact("Tommy", "9522222222"));
        db.addContact(new Contact("Karthik", "9533333333"));*/

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        contacts = db.getAllContacts();

       /* for (Contact cn : contacts) {
            String log = "Id: " + cn.get_id() + " ,Name: " + cn.get_name() + " ,Phone: " + cn.get_phone_number();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }*/

        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        contactAdapter = new ContactAdapter(this, (ArrayList<Contact>) contacts);
        recyclerView.setAdapter(contactAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.operation_menu, menu);//Menu Resource, Menu
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.insert:
                Intent i1 = new Intent(this, InsertData.class);
                startActivity(i1);
                break;
            case R.id.read:
                Intent i2 = new Intent(this, ReadData.class);
                startActivity(i2);
                break;
            case R.id.update:
                Intent i3 = new Intent(this, UpdataData.class);
                startActivity(i3);
                break;
            case R.id.delete:
                Intent i4 = new Intent(this, DeleteData.class);
                startActivity(i4);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}

