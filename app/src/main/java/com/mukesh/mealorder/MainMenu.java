package com.mukesh.mealorder;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mukesh.mealorder.others.ApplicationConstant;
import com.mukesh.mealorder.others.Query;
import com.mukesh.mealorder.others.User_SetGet;

import java.util.ArrayList;


public class MainMenu extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
         showToolbar(); getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        (findViewById(R.id.salad)).setOnClickListener(this);
        (findViewById(R.id.chinese)).setOnClickListener(this);
        (findViewById(R.id.chicken)).setOnClickListener(this);
        (findViewById(R.id.drinks)).setOnClickListener(this);setCurrentuserData();
        ((TextView)(findViewById(R.id.texthead))).setText("Hi, "+Userdata.Firstname);
      }


    public void  setCurrentuserData ()
    {

        User_SetGet currentUser = new User_SetGet();
        currentUser=query.getdata(Userdata.username);
        Userdata.Firstname=currentUser.getFirstname();
        Userdata.password=currentUser.getPassowrd();
        Userdata.email=currentUser.getEmail();
        Userdata.Lastname=currentUser.getLastname();
        Userdata.phone=currentUser.getPhone();

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == android.R.id.home) {
            Userdata.i=0;
            startActivity(new Intent(MainMenu.this,LogIn.class));

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId()==R.id.cart)
        startActivity(new Intent(MainMenu.this,ItemList.class));
        else
        {
        switch (v.getId())
        {
            case R.id.salad:
                Userdata.cuurentItem="Salad";
             break;
            case R.id.chicken:
                Userdata.cuurentItem="Chicken";
                break;
            case R.id.chinese:
                Userdata.cuurentItem="Chinese";
                startActivity(new Intent(MainMenu.this,ItemList.class));
                break;
            case R.id.drinks:
                Userdata.cuurentItem="Drinks";
                break;
             default:
              break;
        }
            startActivity(new Intent(MainMenu.this,ItemList.class));
        }


    }
}
