package com.mukesh.mealorder;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mukesh.mealorder.others.ApplicationConstant;
import com.mukesh.mealorder.others.Query;


public class ForgotPassword extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        showToolbar(); getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((Button)findViewById(R.id.update)).setOnClickListener(this);

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        MenuItem item=menu.findItem(R.id.cart);
        item.setVisible(false);
        return super.onPrepareOptionsMenu(menu);

    }

    @Override
    public void onClick(View v)
    {
        String Username=((EditText)findViewById(R.id.updateuser)).getText().toString();
        String Password=((EditText)findViewById(R.id.updatepassword)).getText().toString();
        String Re_Password=((EditText)findViewById(R.id.updatepassword1)).getText().toString();

        if(Username.equals("")||Password.equals(""))
            showToast("null entry value");
        else if(!query.IsUserExists(Username))
            showToast("User not exits");
        else if(!Password.equals(Re_Password))
            showToast("Password Mismatch");
        else if(query.UpdateData(Username, Password))
            showToast("success");

    }

}
