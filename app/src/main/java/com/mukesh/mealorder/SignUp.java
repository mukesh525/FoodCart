package com.mukesh.mealorder;

import android.content.Intent;
import android.support.v4.app.NavUtils;
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


public class SignUp extends BaseActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        showToolbar(); getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      ((Button)findViewById(R.id.Reg)).setOnClickListener(this);
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        MenuItem item=menu.findItem(R.id.cart);
        item.setVisible(false);
        return super.onPrepareOptionsMenu(menu);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.exit) {
            return true;
        }
        if(id==android.R.id.home)
        {
            NavUtils.navigateUpFromSameTask(this);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Reg:

                String Username = ((EditText) findViewById(R.id.RegUsername)).getText().toString();
                String Password = ((EditText) findViewById(R.id.RegPassword)).getText().toString();
                String Re_Password = ((EditText) findViewById(R.id.RegPassword1)).getText().toString();
                String Phone = ((EditText) findViewById(R.id.RegPhone)).getText().toString();
                String Firstname = ((EditText) findViewById(R.id.RegFirstName)).getText().toString();
                String Lastname = ((EditText) findViewById(R.id.RegLasttName)).getText().toString();
                String Email = ((EditText) findViewById(R.id.RegEmail)).getText().toString();
               if (Username.equals("") || Password.equals("") || Phone.equals("") || Phone.equals("") || Firstname.equals("") || Lastname.equals(""))
                    showToast("null entry value");
                else if (query.IsUserExists(Username))
                    showToast("UserNmae Alreday Exits");
                else if (!Password.equals(Re_Password))
                    showToast("Password Mismatch");
                else if (query.insertData(Username, Password, Phone, Firstname, Lastname, Email))
                    showToast("Sucessfull");
                else
                    showToast("Unsucessfull");
                break;
            case R.id.CartImage:
                startActivity(new Intent(getApplicationContext(), SignUp.class));
                break;
            default:
                break;
        }

    }
}
