public class route {
	//Room numbers
	int endRoom;
	int startRoom;

	
	//Times (seconds)
	int LHall 		= 31;
	int MHall 		= 21;
	int RHall	 	= 18;
	int Esc 		= 36; //working escalator
	int UpEsc 		= 28; //walking up
	int DownEsc 	= 23; //walking down
	int UpStair		= 15; //walking up stairs
	int DownStair	= 13;
	int UpRiver		= 13;
	int DownRiver   = 9;
	int HighEsc 	= 42;
	int UpHighEsc	= 28;
	int DownHighEsc	= 23;
	int LowsEsc 	= 20;
	int UpLowEsc	= 14;
	int DownLowEsc	= 12;

	
	int startF; //Beginning floor
	int endF; //End floor
	
	char start; //left(l), middle(m), or right(r) beginning section
	char end; //left(l), middle(m), or right(r) beginning section
	
	
	public route (int startL; int endL) {
		start=startL;
		end=endL;
		startRoom= start%100;
		startF= (start/100)
		endRoom= end%100;
		endF=(end/100);
		
	}


	public void setValues() {
    	Scanner scan = new Scanner(System.in);
        int x;
        System.out.print("Please input source classroom: ");	
			x = scan.nextInt();
        	
		System.out.println("Please input destination classroom: ");
			x = scan.nextInt();
        }	
    }		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}