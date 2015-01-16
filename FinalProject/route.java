import java.util.*;
import java.lang.*;
import java.io.*;
public class route {
	//Room numbers
	int endR = 0;
	int startR = 0;

	
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
	
	double BrokenEscalator1 = 0.0;
	double BrokenEscalator2 = 0.0;
	double BrokenEscalator3 = 0.0;
	double BrokenEscalator4 = 0.0;

	


	int startF = 0; //Beginning floor
	int endF = 0; //End floor
	
	char start = ''; //left(l), middle(m), or right(r) beginning section
	char end = ''; //left(l), middle(m), or right(r) beginning section
	
	

    public route () {
	Scanner scan = new Scanner(System.in);

	int startRoom;
        int endRoom;
	for(int i = 0; i < 3; i++){
            if(i == 0){
				System.out.println("Please input start destination: ");
				startRoom = scan.nextInt();
        		startF = startRoom / 100;
				startR = startRoom % 100;
            }
            if (i == 1) {
                System.out.println("Please input end destination: ");
        		endRoom = scan.nextInt();
				endF = endRoom / 100;
				endR = endRoom % 100;
            }
			else {
				String preference;
				int numBroken;
				int esc2;
				System.out.println("Would you prefer escalators? 1 means yes and 0 means no or no preference: ");
					preference= scan.nextInt();
						if (preference == 1){
							System.out.println ("How many escalators on your route are broken?");
								numBroken=scan.nextInt();
							if (numBroken>0) {
								System.out.println("Which escalators on your route are broken? (floor1.floor2) Ex) 2.4 means the 2-4 escalator is broken");
									for (int i=0; i<numBroken; i++) {
										esc2=scan.nextLine();
										if (BrokenEscalator1 == 0.0)
											BrokenEscalator1 = esc2;
										else if (BrokenEscalator2 == 0.0)
											BrokenEscalator2 = esc2;
											else if (BrokenEscalator3 == 0.0)
												BrokenEscalator3 = esc2;
											else 
												BrokenEscalator4 = esc2;
												}
								}
							}
				}
		}
		}
	
	public void setDir(){//sets startR and endR
		if (((startR >= 0) && (startR <= 12)){
			start = 'r';
		}
		else if (startR <= 27){
			start = 'm';
		}
		else{start = 'r'}
		
		if (((endR >= 0) && (endR <= 12)){
			end = 'r';
		}
		else if (endR <= 27){
			end = 'm';
		}
		else{end = 'r'}
	}
	
	public void escalatorRoute(){
		int numEsc = Math.abs(endF - startF) / 2; 
		
	
	}
	
	public void generalRoute(){
		
	}

	
    public static void main(String[] args){
	route r = new route();

    }
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}