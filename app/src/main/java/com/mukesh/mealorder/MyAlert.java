package com.mukesh.mealorder;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class MyAlert extends DialogFragment
{
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState)
	{

      AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());
      builder.setMessage("Are you sure you want to exit? ");
      setCancelable(false);
      builder.setNegativeButton(R.string.Cancel,new DialogInterface.OnClickListener() {
		
		@SuppressLint("NewApi") @Override
		public void onClick(DialogInterface dialog, int which) {
	    	dialog.dismiss();
			
		}
	   });
     
      builder.setPositiveButton(R.string.OK,new DialogInterface.OnClickListener(){

		@Override
		public void onClick(DialogInterface dialog, int which)
        {
			System.exit(1);

          }
      });
      
     Dialog dialog=builder.create();
		return dialog;
	   }
}
