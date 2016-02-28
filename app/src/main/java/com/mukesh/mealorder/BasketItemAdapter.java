package com.mukesh.mealorder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mukesh.mealorder.others.User_SetGet;

import java.util.ArrayList;

public class BasketItemAdapter extends BaseAdapter{
	 ArrayList<User_SetGet> data=null;
	 Context context;
	 LayoutInflater layoutinflater;
	public BasketItemAdapter(Context context, ArrayList<User_SetGet> data)
	{
		this.data=data;
		this.context=context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		// TODO Auto-generated method stub
		
		View row=convertView;
		if(row==null)
		{
			layoutinflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
			row=layoutinflater.inflate(R.layout.basket_item_list,parent,false);
		}
		
		    User_SetGet obj=new User_SetGet();
		     obj=data.get(position);
		 ((TextView)row.findViewById(R.id.basketitem)).setText(obj.getBasketItem());
		 ((TextView)row.findViewById(R.id.basketquantity)).setText(obj.getBasketItemQuantity());
		 ((TextView)row.findViewById(R.id.basketprice)).setText(obj.getBasketItemPrice());
       return row;
	}

}
