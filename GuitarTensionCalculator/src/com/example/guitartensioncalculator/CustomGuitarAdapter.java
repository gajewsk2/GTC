package com.example.guitartensioncalculator;

import guitarTensionCalc.GuitarTensionCalc;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class CustomGuitarAdapter extends BaseAdapter{

	//Array that holds the data for the strings
	private ArrayList<GuitarTensionCalc> _gString;
	
	Context _context;
	 
	//Adapter that binds the user data to the listView
	CustomGuitarAdapter (ArrayList<GuitarTensionCalc> gString, Context context){
		_gString = gString;
		_context = context;
	}
	
	
	//Number elements in the ArrayList<GuitarTensionCalc> which is the number of strings
	@Override
	public int getCount() {
		return _gString.size();
	}

	//Returns the element that is clicked by the user which is the the string they clicked on the listView
	@Override
	public Object getItem(int position){
		return _gString.get(position);
	}

	//Returns the index of of ArrayList<GuitarTensionCalc> that the user clicked on the ListView, only the index and not the string Object
	@Override
	public long getItemId(int position) {
		return position;
	}

	
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
        if (v == null)
        {
           LayoutInflater layout_inflater = (LayoutInflater)_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           v = layout_inflater.inflate(R.layout.string_layout, null);
        }
        
        //Gets the address of the Buttons on the ListView Row
		//TextView frequencyButton = (TextView) v.findViewById(R.id.buttonFrequency);
		TextView gaugeButton = (TextView) v.findViewById(R.id.buttonGauge);
		TextView noteButton = (TextView) v.findViewById(R.id.buttonNote);
		TextView octaveButton = (TextView) v.findViewById(R.id.buttonOctave);
		
		TextView stringTypeButton = (TextView) v.findViewById(R.id.buttonStringType);
		TextView tensionButton = (TextView) v.findViewById(R.id.buttonTension);

		//Gets the Values from the gString to set on the ListView row
		GuitarTensionCalc guitarString = _gString.get(position);
		
		//Sets the Correct Values to the Buttons  
//		frequencyButton.setText(Double.toString(guitarString.freq));
		
//		gaugeButton.setText(Double.toString(guitarString.unitWeight));
		noteButton.setText(Character.toString(guitarString.note).toUpperCase() + Character.toString(guitarString.accidentalChar));
		stringTypeButton.setText(guitarString.strStrType);
		octaveButton.setText(Integer.toString(guitarString.octave));
		gaugeButton.setText( Double.toString(guitarString.gauge) );
		tensionButton.setText(Double.toString(guitarString.calculateTension()));
		return v;
	}
	
}
