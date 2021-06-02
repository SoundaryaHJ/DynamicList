package com.example.dynamiclist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    EditText editText;
    Button addData;
    ListView listView;

    ArrayList<String> arraylist;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=(EditText) findViewById(R.id.editText);
        addData=(Button) findViewById(R.id.addData);
        listView=(ListView) findViewById(R.id.listView);

        arraylist=new ArrayList<String>();
        adapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, arraylist);
        listView.setAdapter(adapter);
        OnButtonClick();
    }

    public void OnButtonClick()
    {
        addData.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String result= editText.getText().toString();
                arraylist.add(result);
                adapter.notifyDataSetChanged();

            }
        });
    }
}