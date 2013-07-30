package guitarTensionCalc;

import android.util.Log;

public class GuitarTensionCalc {
	
		public double unitWeight;
		public double scaleLength;
		public double freq;
		
		public char note;
		public char accidental;
		public int octave;
		
		public GuitarTensionCalc()
		{
			
			unitWeight = 0;
			scaleLength = 0;
			freq = 0;
			
			note = 'x';
			accidental = 'n';
			octave = 11;
			
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
		
		
}
