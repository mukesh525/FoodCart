package com.mukesh.mealorder;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.mukesh.mealorder.others.ApplicationConstant;


public class Welcome extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        TextView text=(TextView) findViewById(R.id.textView1);
        Typeface font=Typeface.createFromAsset(getAssets(), "SEASRN__.ttf");
        // text.setTypeface(font);

       try {
            ApplicationConstant app = (ApplicationConstant) getApplication();
            app.ReadyApplicationDatabase(Welcome.this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        GoToNextScreen(10000);
    }

    private void GoToNextScreen(long deley){
        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                startActivity(new Intent(Welcome.this, LogIn.class));
                finish();
            }};
        handler.sendEmptyMessageDelayed(0, deley);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_welcome, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}