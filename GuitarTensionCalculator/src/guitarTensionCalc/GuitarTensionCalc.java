package guitarTensionCalc;

import android.util.Log;

public class GuitarTensionCalc {
	
		public double unitWeight; 
		public double scaleLength;
		public double freq;
		public double gauge;
		public double strType;
		public String strStrType;
		
		public char note;
		public char accidental;
		public int octave;
		
		public char accidentalChar;
		
		public GuitarTensionCalc()
		{
			
			unitWeight = 0;
			gauge = 0;
			strType = -1;
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
		
		
		public double getUnitWeight(int strType, double gauge){
			
			double[][] PL = {
					{ .007	, .00001085	},
					{ .008	, .00001418 },
					{ .0085	, .00001601 },
					{ .009	, .00001794 },
					{ .0095	, .00001999 },
					{ .010	, .00002215 },
					{ .0105	, .00002442 },
					{ .011	, .00002680 },
					{ .0115	, .00002930 },
					{ .012	, .00003190 },
					{ .013	, .00003744 },
					{ .0135	, .00004037 },
					{ .014	, .00004342 },
					{ .015	, .00004984 },
					{ .016	, .00005671 },
					{ .017	, .00006402 },
					{ .018	, .00007177 },
					{ .019	, .00007997 },
					{ .020	, .00008861 },
					{ .022	, .00010722 },
					{ .024	, .00012760 },
					{ .026	, .00014975 }
					};
			double[][] PB = {
			{ .020	, .00008106 },
			{ .021	, .00008944 },
			{ .022	, .00009876 },
			{ .023	, .00010801 },
			{ .024	, .00011682 },
			{ .025	, .00012686 },
			{ .026	, .00013640 },
			{ .027	, .00014834 },
			{ .029	, .00017381 },
			{ .030	, .00018660 },
			{ .032	, .00021018 },
			{ .034	, .00023887 },
			{ .035	, .00025365 },
			{ .036	, .00026824 },
			{ .039	, .00031124 },
			{ .042	, .00036722 },
			{ .045	, .00041751 },
			{ .047	, .00045289 },
			{ .049	, .00049151 },
			{ .052	, .00055223 },
			{ .053	, .00056962 },
			{ .056	, .00063477 },
			{ .059	, .00070535 }
			};
			double[][] XS = {
			{ .018	, .00006153 },
			{ .020	, .00007396 },
			{ .021	, .00008195 },
			{ .022	, .00009089 },
			{ .024	, .00010742 },
			{ .026	, .00012533 },
			{ .028	, .00014471 },
			{ .030	, .00017002 },
			{ .032	, .00019052 },
			{ .034	, .00021229 },
			{ .036	, .00023535 },
			{ .038	, .00025969 },
			{ .040	, .00028995 },
			{ .042	, .00031685 },
			{ .046	, .00037449 },
			{ .048	, .00040523 },
			{ .050	, .00043726 },
			{ .052	, .00047056 },
			{ .054	, .00052667 },
			{ .056	, .00056317 },
			{ .070	, .00087444 }
			};
			double[][] NW = {
			{ .017	, .00005524	},
			{ .018	, .00006215	},
			{ .019	, .00006947	},
			{ .020	, .00007495	},
			{ .021	, .00008293	},
			{ .022	, .00009184	},
			{ .024	, .00010857	},
			{ .026	, .00012671	},
			{ .028	, .00014666	},
			{ .030	, .00017236	},
			{ .032	, .00019347	},
			{ .034	, .00021590	},
			{ .036	, .00023964	},
			{ .038	, .00026471	},
			{ .039	, .00027932	},
			{ .042	, .00032279	},
			{ .044	, .00035182	},
			{ .046	, .00038216	},
			{ .048	, .00041382	},
			{ .049	, .00043014	},
			{ .052	, .00048109	},
			{ .056	, .00057598	},
			{ .059	, .00064191	},
			{ .060	, .00066542	},
			{ .062	, .00070697	},
			{ .064	, .00074984	},
			{ .066	, .00079889	},
			{ .068	, .00084614	},
			{ .070	, .00089304	},
			{ .072	, .00094124	},
			{ .074	, .00098869	},
			{ .080	, .00115011	},
			};
			double[][] HR = {
					{ .022	, .00011271	},
					{ .024	, .00013139	},
					{ .026	, .00015224	},
					{ .030	, .00019916	},
					{ .032	, .00022329	},
					{ .036	, .00027556	},
					{ .039	, .00032045	},
					{ .042	, .00036404	},
					{ .046	, .00043534	},
					{ .052	, .00054432	},
					{ .056	, .00062758	}
					};

			switch(strType){
			
			
			case 0://pl
				strStrType = "PL";
				for(int i=PL.length; i>=0; --i)
					if(PL[i][0] <= gauge)
						return (double)PL[i][0];
						
			break;
			
			case 1://PB
				strStrType = "PB";
				for(int i=PB.length; i>=0; --i)
					if(PB[i][0] <= gauge)
						return (double)PB[i][0];

			break;
			
			case 2://xs
				strStrType = "XS";
				for(int i=XS.length; i>=0; --i)
					if(XS[i][0] <= gauge)
						return (double)XS[i][0];
			break;
			
			case 3://NW
				strStrType = "NW";
				for(int i=NW.length; i>=0; --i)
					if(NW[i][0] <= gauge)
						return (double)NW[i][0];

			break;
			
			case 4://hr
				strStrType = "HR";
				for(int i=HR.length; i>=0; --i)
					if(HR[i][0] <= gauge)
						return (double)HR[i][0];
			break;
			
			default:
				Log.e("error", "strType was not correctly passed to main activity,  -1");
				return -1;
			}
			return -1;
		}

}
