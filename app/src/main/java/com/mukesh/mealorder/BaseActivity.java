package com.mukesh.mealorder;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mukesh.mealorder.others.ApplicationConstant;
import com.mukesh.mealorder.others.Query;

/**
 * Created by Mukesh on 12/21/2014.
 */
public abstract class BaseActivity  extends ActionBarActivity implements View.OnClickListener {
    private Toolbar toolbar;
    ApplicationConstant app;
    String[] Month={"01","02","03","04","05","06","07","08","09","10","11","12"},
             Year={"2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014"};
    Query query;

    int count=Userdata.i;
    TextView tv;ImageButton btn;
    private ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app = (ApplicationConstant) getApplication();
        query = new Query(app);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_log_in, menu);
         MenuItem cart=menu.findItem(R.id.cart);
         RelativeLayout cartlayout= (RelativeLayout) cart.getActionView();
        menu.getItem(0).getActionView().setOnClickListener(this);
         tv= (TextView) cartlayout.findViewById(R.id.Cartcount);

        if(count==0)
            tv.setVisibility(View.GONE);
       else
            tv.setText(""+count);
        return super.onCreateOptionsMenu(menu);
    }

    public void ExitDialog() {
       MyAlert myalert = new MyAlert();
        myalert.show(getFragmentManager(), "Myalert");

    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);

        }
        return super.onOptionsItemSelected(item);

    }

    protected void showProgress(String msg) {
        if (mProgressDialog != null && mProgressDialog.isShowing())
            dismissProgress();

        mProgressDialog = ProgressDialog.show(this, getResources().getString(R.string.app_name), msg);
    }

    protected void dismissProgress() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }

       public void showToolbar()
    {
        toolbar = (Toolbar) findViewById(R.id.app_bar);
         setSupportActionBar(toolbar);
         getSupportActionBar().setHomeButtonEnabled(true);

    }

    public void setCartcount(int count)
    {
        if(count==0)
        {
            tv.setVisibility(View.GONE);
        }
        else
            tv.setText(""+count);
    }

    protected void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    protected void showAlert(String msg) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.app_name))
                .setMessage(msg)
                .setCancelable(false)
                .setIcon(R.drawable.tick)
//              .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton("Thanks", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).create().show();
    }


}