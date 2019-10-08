package com.example.phonecall;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {
    private ListView listview;
    private Button Send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview=(ListView)findViewById(R.id.listview);
        Send = (Button)findViewById(R.id.sendb);
    }
    public void get(View v){
        Cursor cursor =getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
        startManagingCursor(cursor);
        String[] from ={ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER,ContactsContract.CommonDataKinds.Phone._ID};
        int [] to  = {android.R.id.text1,android.R.id.text2};
        SimpleCursorAdapter simpleCursorAdapter= new SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,cursor,from,to);
        listview.setAdapter(simpleCursorAdapter);
        listview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }}
