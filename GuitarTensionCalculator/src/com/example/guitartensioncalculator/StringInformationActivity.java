package com.example.guitartensioncalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

public class StringInformationActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_layout);
		
		final NumberPicker np1 = (NumberPicker) findViewById(R.id.numberPicker1);
		np1.setMaxValue(10);
		
		final NumberPicker np2 = (NumberPicker) findViewById(R.id.numberPicker2);
		String[] notes = new String[12];
		notes[0] = "A";
		notes[1] = "A#/Bb";
		notes[2] = "B";
		notes[3] = "C";
		notes[4] = "C#/Db";
		notes[5] = "D";
		notes[6] = "D#/Eb";
		notes[7] = "E";
		notes[8] = "F";
		notes[9] = "F#/Gb";
		notes[10] = "G";
		notes[11] = "G#/Ab";

		np2.setMaxValue(notes.length-1);
		np2.setMinValue(0);
		np2.setWrapSelectorWheel(true);
		np2.setDisplayedValues(notes);
		
		
		Button submit = (Button)findViewById(R.id.buttonSubmit);
		submit.setOnClickListener(new Button.OnClickListener() { public void onClick (View v){
			EditText userGuage = (EditText)findViewById(R.id.editTextGauge);
			Log.i("submit", "submit");
			Log.i("OctavePicker", Integer.toString(np1.getValue()));
			Log.i("NotePicker", Integer.toString(np2.getValue()));
			Log.i("Gauge", userGuage.getText().toString());
			String guage = userGuage.getText().toString();
			if(guage.matches("") || guage.matches(".")){
				Log.i("Gauge", "null");
			}else{
//
			Intent returnToCaller = new Intent();
		    returnToCaller.putExtra("octave", np1.getValue());
		    returnToCaller.putExtra("note", np2.getValue());
		    returnToCaller.putExtra("guage", Double.parseDouble(guage));

		    setResult(1,returnToCaller);        
		    finish();
			}
		}});	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.string_information, menu);
		return true;
	}

}
