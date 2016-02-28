package com.mukesh.mealorder;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;


public class ItemList extends BaseActivity {
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        showToolbar();getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        list= (ListView) findViewById(R.id.listView);
      ((TextView)(findViewById(R.id.cuurentMenu))).setText("Menu:- "+Userdata.cuurentItem);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cart:
                startActivity(new Intent(getApplicationContext(),ItemDetail.class));
                break;

            default:
                break;
        }
    }
}

