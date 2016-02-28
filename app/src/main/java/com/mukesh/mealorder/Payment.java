package com.mukesh.mealorder;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class Payment extends BaseActivity {
    Spinner MonthSp,YearSp;
    int month,year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        showToolbar();getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        (findViewById(R.id.paynow)).setOnClickListener(this);
        MonthSp= (Spinner) findViewById(R.id.spmonth);
        YearSp= (Spinner) findViewById(R.id.spyear);
        MonthSp.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,Month));
        YearSp.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,Year));
        month= Integer.parseInt(MonthSp.getSelectedItem().toString());
        year= Integer.parseInt(YearSp.getSelectedItem().toString());
        showToast(""+month+""+year);

    }

    @Override
    public void onClick(View v)
    {
        if(v.getId()==R.id.cart)
        startActivity(new Intent(getApplicationContext(),ItemList.class));
        if(v.getId()==R.id.paynow)
        showAlert("Order Confirmed");

    }

}
