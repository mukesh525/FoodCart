package com.mukesh.mealorder;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.mukesh.mealorder.others.ApplicationConstant;
import com.mukesh.mealorder.others.Query;


public class LogIn extends BaseActivity {

    public static final String DEAFULT = "n/a";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        showToolbar(); load();
        (findViewById(R.id.Signin)).setOnClickListener(this);
        (findViewById(R.id.signup)).setOnClickListener(this);
        (findViewById(R.id.fp)).setOnClickListener(this);

    }

    public void save() {
        if (((CheckBox) findViewById(R.id.checkBox)).isChecked()) {
            SharedPreferences pref = getSharedPreferences("Mydata", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("name", ((EditText) findViewById(R.id.loginuser)).getText().toString());
            editor.putString("password", ((EditText) findViewById(R.id.loginpassword)).getText().toString());
            editor.commit();

        }
    }

    public void load() {
        SharedPreferences pref = getSharedPreferences("Mydata", Context.MODE_PRIVATE);
        String name = pref.getString("name", DEAFULT);
        String password = pref.getString("password", DEAFULT);
        if (!name.equals(DEAFULT) || !password.equals(DEAFULT)) {
            ((EditText) findViewById(R.id.loginuser)).setText(name);
            ((EditText) findViewById(R.id.loginpassword)).setText(password);
        }


    }

    @Override
    public void onBackPressed() {
        ExitDialog();
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

       MenuItem item=menu.findItem(R.id.cart);
        item.setVisible(false);
        return super.onPrepareOptionsMenu(menu);

    }


    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub

        String Username = ((EditText) findViewById(R.id.loginuser)).getText().toString();
        String Password = ((EditText) findViewById(R.id.loginpassword)).getText().toString();
        switch (v.getId()) {
             case R.id.Signin:
                if (Username.equals("") || Password.equals(""))
                    showToast("Value must be Non-Empty");
                else if (query.Login(Username, Password))
                {
                    Userdata.i = 11;
                    Userdata.username = Username;
                    save();
                    Intent i=new Intent(LogIn.this, MainMenu.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
                else
                    showToast("Wrong Username Or Password");
                break;
            case R.id.signup:
                startActivity(new Intent(LogIn.this, SignUp.class));
                break;
            case R.id.fp:
                startActivity(new Intent(LogIn.this, ForgotPassword.class));
                break;
            case R.id.cart:
                showToast("Log In first");
                break;
           default:
          break;
        }
    }
}
