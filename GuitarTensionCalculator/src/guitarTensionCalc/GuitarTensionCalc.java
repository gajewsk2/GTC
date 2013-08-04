package guitarTensionCalc;

import android.util.Log;

public class GuitarTensionCalc {
	
		public double unitWeight;
		public double scaleLength;
		public double freq;
		
		public char note;
		public char accidental;
		public int octave;
		
		public char accidentalChar;
		
		public GuitarTensionCalc()
		{
			
			unitWeight = 0;
			scaleLength = 0;
			freq = 0;
			
			note = 'x';
			accidental = 'n';
			octave = 11;
			
			accidentalChar = ' ';
			
		}
		
		public double calculateTension()
		{	//T(Tension) = (UW x (2 x L x F)2) / 386.4
	        if( unitWeight == 0 )
                Log.w("warning","unitWeight = 0");
            if( scaleLength == 0)
                Log.w("warning","scaleLength = 0");
            if( scaleLength == 0)
                Log.w("warning","scaleLength = 0");
			return (unitWeight*(2*scaleLength*freq)*(2*scaleLength*freq))/386.4;
		}


		public double calculateFreq()
		{	
			
			switch( note ){

				case 'c': 
					if(accidental == 'n')
						freq = 16.352;
					else if(accidental == 's')
						freq = 17.324;
					else
						Log.e("error","Please change Cb to B");
					break;
				case 'd':
					if(accidental == 'n')
						freq = 18.354;
					else if(accidental == 's')
						freq = 19.445;
					else// flat case
						freq = 17.324;
					break;
				case 'e':
					if(accidental == 'n')
						freq = 20.602;
					else if(accidental == 's')
						Log.e("error","Please change E# to F");
					else// flat case
						freq = 19.445;
					break;
				case 'f':
					if(accidental == 'n')
						freq = 21.827;
					else if(accidental == 's')
						freq = 23.125;
					else
						Log.e("error","Please change Fb to E");
					break;
				case 'g':
					if(accidental == 'n')
						freq = 24.500;
					else if(accidental == 's')
						freq = 25.957;
					else// flat case
						freq = 23.125;
					break;
				case 'a':
					if(accidental == 'n')
						freq = 27.500;
					else if(accidental == 's')
						freq = 29.135;
					else// flat case
						freq = 25.957;
					break;
				case 'b':
					if(accidental == 'n')
						freq = 30.868;
					else if(accidental == 's')
						Log.e("error","Please change b# to c");
					else// flat case
						freq = 29.135;
					break;
				default:  Log.e("error","note is not a-g");
			}
			
			
			return (freq* Math.pow(2, octave) );
		}
		
		
		public void setFreqVars(int userInput){
			/*String[] notes = new String[12];
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
			notes[11] = "G#/Ab";*/
			
			switch (userInput){
			case -1:
				Log.e("error", "User value was not correctly passed to main activity,  -1");
				break;
			case 0:
				note = 'a';
				accidental='n';
				break;
			case 1:
				note = 'a';
				accidental = 's';
				accidentalChar = '#';
				break;
			case 2:
				note = 'b';
				accidental = 'n';
				break;
			case 3:
				note = 'c';
				accidental = 'n';
				break;
			case 4:
				note = 'c';
				accidental = 's';
				accidentalChar = '#';
				break;
			case 5:
				note = 'd';
				accidental = 'n';
				break;
			case 6:
				note = 'd';
				accidental = 's';
				accidentalChar = '#';
				break;
			case 7:
				note = 'e';
				accidental = 'n';
				break;
			case 8:
				note = 'f';
				accidental = 'n';
				break;
			case 9:
				note = 'f';
				accidental = 's';
				accidentalChar = '#';
				break;
			case 10:
				note = 'g';
				accidental = 'n';
				break;
			case 11:
				note = 'g';
				accidental = 's';
				accidentalChar = '#';
				break;
			default:
				Log.e("error", "error getting user input, number out of bounds");
				
			}
		}
		
}
