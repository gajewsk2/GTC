package com.example.guitartensioncalculator;

import guitarTensionCalc.GuitarTensionCalc;

import java.util.ArrayList;

import android.R.bool;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;

public class MainActivity extends Activity {
	final ArrayList<GuitarTensionCalc> stringArray = new ArrayList<GuitarTensionCalc>();
	final CustomGuitarAdapter adapter = new CustomGuitarAdapter(stringArray,this);
	double scaleLength = 0;
	boolean imperial = true;
	final Context parentContext = this;

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
	
		
		
		LayoutInflater inflater = getLayoutInflater();
		ViewGroup header = (ViewGroup)inflater.inflate(R.layout.listview_header, stringList, false);
		stringList.addHeaderView(header, null, false);
		
		final Button setScale_1 = (Button)findViewById(R.id.button1);
		Button setScale_2 = (Button)findViewById(R.id.button2);
		
		
		setScale_1.setOnClickListener(new Button.OnClickListener() { public void onClick (View v){
			Log.i("header", "Click1");
			
			final Dialog dialog = new Dialog(parentContext);
			dialog.setContentView(R.layout.scale_length);
			dialog.setTitle("Set Scale Length");
 
			// set the custom dialog components - text, image and button
			final EditText editTextScale = (EditText) dialog.findViewById(R.id.editTextScale);
			final Switch switchScale = (Switch)dialog.findViewById(R.id.switch1);
			Button buttonSubmit = (Button)dialog.findViewById(R.id.button2);

			buttonSubmit.setOnClickListener(new Button.OnClickListener() {
				@Override
				public void onClick(View v) {
					String temp1 = editTextScale.getText().toString();
					if(!temp1.matches(""))
					{
					boolean temp2 = switchScale.isChecked();
					scaleLength = Double.parseDouble(temp1);
					imperial = temp2;
					setScale_1.setText("Scale Length : " + temp1 + (imperial?"in":"cm"));
					Log.i("edit", temp1);
					Log.i("switch",Boolean.toString(temp2));
					}
					dialog.dismiss();
				}
			});
			dialog.show();
		}});
		
		setScale_2.setOnClickListener(new Button.OnClickListener() { public void onClick (View v){
			Log.i("header", "Click2");
			
			final Dialog dialog = new Dialog(parentContext);
			dialog.setContentView(R.layout.scale_length);
			dialog.setTitle("Set Scale Length");
 
			// set the custom dialog components - text, image and button
			final EditText editTextScale = (EditText) dialog.findViewById(R.id.editTextScale);
			final Switch switchScale = (Switch)dialog.findViewById(R.id.switch1);
			Button buttonSubmit = (Button)dialog.findViewById(R.id.button2);

			buttonSubmit.setOnClickListener(new Button.OnClickListener() {
				@Override
				public void onClick(View v) {
					String temp1 = editTextScale.getText().toString();
					boolean temp2 = switchScale.isChecked();
					if(!temp1.matches(""))
					{
					scaleLength = Double.parseDouble(temp1);
					imperial = temp2;
					setScale_1.setText("Scale Length : " + temp1 + (imperial?"in":"cm"));
					Log.i("edit", temp1);
					Log.i("switch",Boolean.toString(temp2));
					}
					dialog.dismiss();
				}
			});
			dialog.show();		
		}});
		
		
		/*final Button headerButton = new Button(this);
		headerButton.setText("Set Scale Length");
		stringList.addHeaderView(headerButton);
		
		headerButton.setOnClickListener(new Button.OnClickListener() { public void onClick (View v){
			Log.i("header", "Click");
			headerButton.setVisibility(View.GONE);
		}});*/
		
/*		GuitarTensionCalc temp = new GuitarTensionCalc();
		temp.freq = 1;
		temp.scaleLength = 2;
		temp.unitWeight = 3;
		stringArray.add(temp);*/
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
	    Double gauge = data.getDoubleExtra("gauge", -1);
	    int strType = data.getIntExtra("strType", -1);
	    
	    Log.i("Caller", Integer.toString(octave));
	    Log.i("Caller", Integer.toString(note));
	    Log.i("Caller", Double.toString(gauge));
	    //
		GuitarTensionCalc temp = new GuitarTensionCalc();
		temp.freq = octave;
		temp.scaleLength = note;
		temp.gauge = gauge;
		temp.strType = strType;
		
		temp.setFreqVars(note);
		temp.calculateFreq();
		temp.getUnitWeight(strType, gauge);
		
		Log.i("note", Character.toString(temp.note));
		stringArray.add(temp);
		adapter.notifyDataSetChanged();

	    
	    	
	    }
	}
	
	// Call when the user changes the guitar scale length to update the strings
	public void onScaleChange(){
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


}
