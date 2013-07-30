package com.example.guitartensioncalculator;

import guitarTensionCalc.GuitarTensionCalc;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		setContentView(R.layout.activity_main);
		TextView text = (TextView)findViewById(R.id.textView1);
		text.setText("Test");
		// Getting listview from xml
		ListView stringList = (ListView) findViewById(R.id.GuitarStringList);
		 
		// Creating a button - Load More
		Button addStringButton = new Button(this);
		addStringButton.setText("+Add String");
		
		TextView headerTitle = new TextView(this);
		headerTitle.setText("This is the Title");
		// Adding button to listview at footer
		stringList.addHeaderView(headerTitle);
		stringList.addFooterView(addStringButton);
		
		//Intent intent = new Intent(MainActivity.this, StringInformationActivity.class);
		//startActivity(intent);
		
		
		final ArrayList<GuitarTensionCalc> stringArray = new ArrayList<GuitarTensionCalc>();
		//final CustomGuitarAdapter adapter = new CustomGuitarAdapter(stringArray, )
		
		
		
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
