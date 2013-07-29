package guitarTensionCalc;

import android.util.Log;

public class GuitarTensionCalc {

		public double unitWeight;
		public double scaleLength;
		public double freq;
		
		public GuitarTensionCalc()
		{
			unitWeight = 0;
			scaleLength = 0;
			freq = 0;
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
		
}
