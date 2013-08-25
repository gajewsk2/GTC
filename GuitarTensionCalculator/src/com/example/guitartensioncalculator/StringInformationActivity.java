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
		
		final NumberPicker np2 = (NumberPicker) findViewById(R.id.numberPicker2);
		np1.setMaxValue(10);
		
		String[] strType = new String[5];
		strType[0] = "Plain Steel";
		strType[1] = "PhosBronze";
		strType[2] = "Nickel";
		strType[3] = "Stainless";
		strType[4] = "Half Round";

		
		final NumberPicker np3 = (NumberPicker) findViewById(R.id.numberPicker3);
		

		np2.setMaxValue(notes.length-1);
		np2.setMinValue(0);
		np2.setWrapSelectorWheel(true);
		np2.setDisplayedValues(notes);
		
		np3.setMaxValue(strType.length-1);
		np3.setMinValue(0);
		np3.setWrapSelectorWheel(true);
		np3.setDisplayedValues(strType);
		
		Button submit = (Button)findViewById(R.id.buttonSubmit);
		submit.setOnClickListener(new Button.OnClickListener() { public void onClick (View v){
			EditText userGauge = (EditText)findViewById(R.id.editTextGauge);
			Log.i("submit", "submit");
			Log.i("OctavePicker", Integer.toString(np1.getValue()));
			Log.i("NotePicker", Integer.toString(np2.getValue()));
			Log.i("Gauge", userGauge.getText().toString());
			String gauge = userGauge.getText().toString();
			if(gauge.matches("") || gauge.matches(".")){
				Log.i("Gauge", "null");
			}else{
//
			Intent returnToCaller = new Intent();
		    returnToCaller.putExtra("octave", np1.getValue());
		    returnToCaller.putExtra("note", np2.getValue());
		    returnToCaller.putExtra("gauge", Double.parseDouble(gauge));
		    returnToCaller.putExtra("StrType", np3.getValue());
		    
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
