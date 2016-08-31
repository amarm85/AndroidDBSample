package com.example.dbapp4;

import java.util.ArrayList;
import java.util.List;

import com.example.dbapp4.model.Contact;
import com.example.dbapp4.model.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

/* Contact Adapter class the supply the data to ListView */ 

public class ContactAdapter  extends ArrayAdapter<Model>{

	private final Context _context;
	
	private ArrayList<Model> contacts;
	
	public ContactAdapter(Context context,List<Model> models) 
	{
		super(context, -1, models);
		this._context = context;
		this.contacts = (ArrayList<Model>) models;
			
		
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View row = convertView;
		
		ViewHolder  viewHolder = null;
		
		// use View Holder pattern to avoid using Layout inflater service if the view already exits 
		
		if (row == null){
			LayoutInflater inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = (LinearLayout)inflater.inflate(R.layout.row, parent,false);
			viewHolder = new ViewHolder(row);
			// store the view holder object as a Tag to View 
			row.setTag(viewHolder);
		}else{
			// Get the view holder object from View Tag
			viewHolder = (ViewHolder) row.getTag();
		}
		
		// get the contact object in provided position		
		Contact contact = (Contact) contacts.get(position);
		// set the text view as the name of the contact.
		viewHolder.getTextView().setText(contact.getName());
		viewHolder.getTextViewEmail().setText(contact.getEmail());
		
		
		return row;
		
	}

	// view holder class the retain the reference of the view in row view 
	private class ViewHolder{		
		// view holder class for row.xml Layout.
		private TextView textView;
		private TextView textViewEmail;

		public TextView getTextView() {
			return textView;
		}

		public TextView getTextViewEmail() {
			return textViewEmail;
		}

		public ViewHolder(View view) {
			
			this.textView = (TextView) view.findViewById(R.id.textView1);
			this.textViewEmail = (TextView) view.findViewById(R.id.textViewEmail);
		}
		
		
		
	}

	
	
	
}
