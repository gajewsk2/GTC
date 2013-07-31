package com.example.guitartensioncalculator;

import guitarTensionCalc.GuitarTensionCalc;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity {
	final ArrayList<GuitarTensionCalc> stringArray = new ArrayList<GuitarTensionCalc>();
	final CustomGuitarAdapter adapter = new CustomGuitarAdapter(stringArray,this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		setContentView(R.layout.activity_main);
		final Intent intent = new Intent(MainActivity.this, StringInformationActivity.class);

		
		// Getting listview from xml
		ListView stringList = (ListView) findViewById(R.id.GuitarStringList);
		 
		// *Temporary* Create a Button at the bottom to add more strings
		Button addStringButton = new Button(this);
		addStringButton.setText("+Add String");
		stringList.addFooterView(addStringButton);
		
		addStringButton.setOnClickListener(new Button.OnClickListener() { public void onClick (View v){
			startActivityForResult(intent, 1);
			Log.i("button", "Click");
			
		}});
	
		
		
		
		
		// *Temporary* Create a Header Title for the ListView
		//TextView headerTitle = new TextView(this);
		//headerTitle.setText("This is the Title");
		//stringList.addHeaderView(headerTitle);
		
		
		
		
		
		
		LayoutInflater inflater = getLayoutInflater();
		ViewGroup header = (ViewGroup)inflater.inflate(R.layout.listview_header, stringList, false);
		stringList.addHeaderView(header, null, false);
		
		GuitarTensionCalc temp = new GuitarTensionCalc();
		temp.freq = 1;
		temp.scaleLength = 2;
		temp.unitWeight = 3;
		stringArray.add(temp);
		stringList.setAdapter(adapter);
		
		
		
		GuitarTensionCalc gtc = new GuitarTensionCalc();
	    gtc.scaleLength = 25.5;
//	            E - 82.4
//	            A - 110
//	            D - 146.8
//	            G - 196
//	            B - 246.9
//	            E - 329.6
	    gtc.freq = 329.6;
//	    gtc.unitWeight = .000022;
	    Log.i("test1", Double.toString(gtc.calculateTension()));
	    
	    
	    
	    
	    
	    stringList.setOnItemClickListener(new OnItemClickListener()
	    {
	    public void onItemClick(AdapterView<?> arg0, View v, int position, long id)
	    {

    		Log.i("adapter size", Integer.toString(adapter.getCount()));
    		startActivity(intent);
	        }
	    });
	    }
	
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    // TODO Auto-generated method stub
	    super.onActivityResult(requestCode, resultCode, data);
	    Intent intent = new Intent();
	    if (requestCode == 1){
    		Log.i("Activity", "Returned From Activity:1");
	    	if(data == null){
	    		Log.i("Add String", "Data bundle was empty");
	    		return;
	    	}
	    int octave = data.getIntExtra("octave", -1);
	    int note = data.getIntExtra("note", -1);
	    Double guage = data.getDoubleExtra("guage", -1);

	    Log.i("Caller", Integer.toString(octave));
	    Log.i("Caller", Integer.toString(note));
	    Log.i("Caller", Double.toString(guage));
	    //
		GuitarTensionCalc temp = new GuitarTensionCalc();
		temp.freq = octave;
		temp.scaleLength = note;
		temp.unitWeight = guage;
		stringArray.add(temp);
		adapter.notifyDataSetChanged();

	    
	    	
	    }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


}
