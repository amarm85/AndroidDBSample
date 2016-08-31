package com.example.dbapp4;



import java.util.List;

import com.example.dbapp4.model.Contact;
import com.example.dbapp4.model.Model;
import com.example.dbapp4.table.ContactTable;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {
	
	List<Model> contacts;
	ListView listView;
	
	public static final String TAG = MainActivity.class.getName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.activity_main);
		
		// create a new contact object
		Contact newContact = new Contact();
		// set the essential values
		newContact.setEmail("amarm85@gmail.com");
		newContact.setName("Amar Jeet Singh");
		newContact.setPhone("331-435-4848");
		
		// create ContactTable object
		ContactTable contactTable = new ContactTable(this);
		
		//add new contact to contactTable
		contactTable.add(newContact);
		
		// Find all the contacts in Contact Table and store in List of contact objects
		contacts =  contactTable.findAll();
		
		// get the object of ListView from UI
		listView = (ListView)findViewById(R.id.listView1);
		
		// Create the object for Contact Adapter passing the list of contacts from Database
		ContactAdapter contactAdapter = new ContactAdapter(this,contacts);
		// set the adapter to list view
		listView.setAdapter(contactAdapter);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
