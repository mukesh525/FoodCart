package com.mukesh.mealorder;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class ItemDetail extends BaseActivity {
    String quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
       showToolbar();getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        quantity=((EditText)findViewById(R.id.qedit)).getText().toString();
        ((Button)findViewById(R.id.addbasket)).setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.cart)
            startActivity(new Intent(getApplicationContext(),Basket.class));
        if(v.getId()==R.id.addbasket)
            startActivity(new Intent(getApplicationContext(),Basket.class));

    }


}
