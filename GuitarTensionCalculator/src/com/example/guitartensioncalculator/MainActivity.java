package com.example.guitartensioncalculator;

import guitarTensionCalc.GuitarTensionCalc;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	    
		
		
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
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


}
