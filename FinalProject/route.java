import java.util.*;
import java.lang.*;
import java.io.*;

public class route 
{
    //Room numbers
    int endR = 0;
    int startR = 0;

    
    //Times (seconds)
    int LHall = 31;
    int MHall = 21;
    int RHall = 18;
    int Esc = 36; //working escalator
    int UpEsc = 28; //walking up
    int DownEsc = 23; //walking down
    int UpStair= 15; //walking up stairs
    int DownStair= 13;
    int UpRiver= 13;
    int DownRiver   = 9;
    int HighEsc = 42;
    int UpHighEsc= 28;
    int DownHighEsc= 23;
    int LowsEsc = 20;
    int UpLowEsc= 14;
    int DownLowEsc= 12;
    int currentesc = 0;
    
    ArrayList<Double> BrokenEscalators = new ArrayList<Double>();

    int preference; //get from user input; 1 means they like escalators and 0 means they don't, so they like stairs

    


    int startF = 0; //Beginning floor
    int endF = 0; //End floor
    
    //char start = 0; //left(l), middle(m), or right(r) beginning section
    char end = 0; //left(l), middle(m), or right(r) beginning section
    char start = 0;    
    

    public route () 
    {
	Scanner scan = new Scanner(System.in);

	int startRoom;
        int endRoom;
	for(int i = 0; i < 3; i++)
	    {
		if(i == 0)
		    {
			System.out.println("Please input start destination: ");
			//if (scan.nextInt>101 && scan.nextInt < 1027)
			startRoom = scan.nextInt();
			startF = startRoom / 100;
			startR = startRoom % 100;
			//}
			/*else if(scan.nextInt < 101 || scan.nextInt > 1027)
			  {
			  System.out.println("");
			  } */
		    }
		else if (i == 1) 
		    {
			System.out.println("Please input end destination: ");
			endRoom = scan.nextInt();
			endF = endRoom / 100;
			endR = endRoom % 100;
		    }
		else 
		    {
		
			int numBroken;
			double esc2;
			System.out.println("Would you prefer escalators? 1 means yes and 0 means no or no preference: ");
			preference= scan.nextInt();
			if (preference == 1)
			    {
				System.out.println ("How many escalators on your route are broken?");
				numBroken=scan.nextInt();
				if (numBroken>0 && numBroken <= 4) 
				    {
					System.out.println("Which escalators on your route are broken? (floor1.floor2) Ex) 2.4 means the 2-4 escalator is broken");
					for (int j=0; j<numBroken; j++) 
					    {
						BrokenEscalators.add(scan.nextDouble());
					    }
				    }
				else if(numBroken>4)
				    System.out.println("Don't be a jerkface. Please input a number less than or equal to 4.");
			    }
		    }
	    }
    }
    
    public void setDir()
    {//sets startR and endR
	if ((startR >= 0) && (startR <= 12))
	    {
		start = 'r';
	    }
	else if (startR <= 27)
	    {
		start = 'm';
	    }
	else
	    {start = 'l';}
	
	if ((endR >= 0) && (endR <= 12))
	    {
		end = 'r';
	    }
	else if (endR <= 27)
	    {
		end = 'm';
	    }
	else
	    {end = 'l';}
    }
    
    public void escalatorRoute()
    {
	int numEsc = Math.abs(endF - startF) / 2; 
	
	
    }
    public void workingEscalatorRoute()
    {


	int numEsc = Math.abs(endF - startF) / 2;
	if (numEsc == 0) this.stairsRoute();
	int currentesc = startF;
	if (currentesc == 1) 
	    {
		System.out.println("Walk up to the second floor.");
		currentesc++;
		numEsc = Math.abs(endF - startF - 1) / 2;
	    }
	if (currentesc == 10) 
	    {
		System.out.println("Walk down to the ninth floor.");
		currentesc--;
		numEsc = Math.abs(endF - startF + 1) / 2;
	    }

	if (endF - startF < 0)
	    {
		for (int a = 0;a<numEsc;a++) 
		    {
			System.out.println("Walk to and take the "+currentesc+"-"+(currentesc-2)+" escalator");
			currentesc=currentesc-2;
		    }
		if (currentesc != endF)
		    { 
			System.out.println("Take the stairs down one floor.");
		    }
	    }
	
	else 
	    {
		for (int a = 0;a<numEsc;a++) 
		    {
			System.out.println("Walk to and take the "+currentesc+"-"+(currentesc+2)+" escalator");
			currentesc=currentesc+2;
		    }
		if (currentesc!= endF) 
		    System.out.println("Take the stairs up one floor.");
	    }
	if (end == 'l') System.out.println("Walk left to your destination.");
	if (end == 'm') System.out.println("Walk towards the middle of the hallway to your destination.");
	if (end == 'r') System.out.println("Walk right to your destination.");
    }
    
    /*~~~~~~~~~~~~~~~~~~~~~~~BROKEN ESCALATOR~~~~~~~~~~~~~~~~~~~~~~~~*/


    public void brokenEscalatorRoute() 
    { //optimize # of working escalators
	//odd or even, walk or no?
	int currentEsc=startF;
	int numEsc = Math.abs(endF - startF) / 2;
	double thisFloorEscUp = startF + ((startF + 2) * 0.1);
	double thisFloorEscDown= startF + ((startF-2) * 0.1);
	//what escalators to take
	
	if (numEsc == 0) 
	    this.stairsRoute();
	
	if (startF < endF)
	    { 
		if (((endF - startF) % 2) != 0)
		    {
		
			if (BrokenEscalators.contains(thisFloorEscUp))
			    {
				System.out.println("Walk to the East staircase and up one floor to floor" + (startF+1));
				currentEsc++;
				for (int a = 0; a < numEsc; a++) 
				    {
					if (BrokenEscalators.contains(currentEsc + (currentEsc + 2) / 10.0))
					    {
						// double thisEsc= thisFloorEsc+ 1.1 + (a* 1.1);
			    
						System.out.println("Walk to and walk up the" + currentEsc + "-" + (currentEsc+2));
						currentEsc+=2;
					    }
			
					else
					    { //still part of for loop
			    
						System.out.println("Walk to and take the " + currentEsc + "-" + (currentEsc+2));
						currentEsc+=2;

					    }

				    }
			    }
		
			else 
			    { //the floor you are on has a working escalator and you have an odd # of floors and are going up
				System.out.println ("Walk to and take the" + currentEsc + "-" + (currentEsc+2));
				for (int a = 1; a < numEsc; a++) 
				    { //starts at one bc an escalator has already been taken
					thisFloorEscUp+= 2.2;
					if (BrokenEscalators.contains(thisFloorEscUp + (a* 2.2)))
					    {
						// double thisEsc= thisFloorEsc+ 1.1 + (a* 1.1);
						currentEsc+=2;
						System.out.println("Walk to and walk up the" + currentEsc + "-" + (currentEsc+2));
					    }
			
					else
					    { //still part of the for loop
						currentEsc+=2;
						System.out.println("Walk to and take the " + currentEsc + "-" + (currentEsc+2));
			    

					    }

				    }
				System.out.println("Walk up the West staircase one floor up to floor " + (currentEsc + 1));
				System.out.println(currentEsc);
			    }
		    }//closes scenario where you have an odd # of floors
		else 
		    { //going up and have an even # of flights
		
			for (int a=0; a<numEsc; a++) 
			    {
				if (BrokenEscalators.contains(thisFloorEscUp + (2.2) * a))
				    {
					System.out.println("Walk to and walk up the "+ currentEsc + "-" + (currentEsc + 2) );
					currentEsc+=2;
			
				    }
		
				else 
				    {
					System.out.println("Walk to and take the " + currentEsc + "-" + (currentEsc + 2));
					currentEsc+=2;
				    }
			    }
		    }
	    }
	    
	//closes the part of the code if you're going up
    
	if (startF > endF) 
	    { 
		if (((startF - endF) % 2) != 0)
		    {//going down and have an odd # of floors
			if (BrokenEscalators.contains(thisFloorEscDown))
			    { //escalator on your floor is broken
				System.out.println("Walk to the West staircase and down one floor to floor " + (startF-1));
				for (int a = 0; a < numEsc; a++) 
				    {
					if (BrokenEscalators.contains(thisFloorEscDown + 2.2 - (a * 2.2)))
					    {
						currentEsc-=1;
						System.out.println("Walk to and walk down the " + currentEsc + "-" + (currentEsc-2));
						currentEsc-=1;
					    }
		    
					else
					    { //still part of for loop
						currentEsc-=1;
						System.out.println("Walk to and take the " + currentEsc + "-" + (currentEsc-2));
						currentEsc-=1;
			
					    }
		    
				    }
			    }//closes the scenario where u have a broken esc on your floor
	    
			else 
			    { //the floor you are on has a working escalator and you have an odd # of floors and are going up
				System.out.println ("Walk to and take the " + currentEsc + "-" + (currentEsc-2));
			
				for (int a = 1; a < numEsc; a++) 
				    { //starts at one bc an escalator has already been taken
					thisFloorEscDown-= 2.2;
					if (BrokenEscalators.contains(thisFloorEscDown - (a * 2.2)))
					    {
						// double thisEsc= thisFloorEsc+ 1.1 + (a* 1.1);
						currentEsc -= 2;
						System.out.println("Walk to and walk down the" + currentEsc + "-" + (currentEsc-2));
					    }
		    
					else
					    { //still part of the for loop
						currentEsc-=2;
						System.out.println("Walk to and take the " + currentEsc + "-" + (currentEsc-2));
					    }
				    }
				System.out.println("Walk down the West staircase one floor down to floor " + (currentEsc - 1));
				System.out.println(currentEsc);
			    }
		    }//closes scenario w odd # flights
	
	
		else 
		    { // going down and have an even # of flights
	    
			for (int a =0; a<numEsc; a++) 
			    {
				System.out.println(a);
				if (BrokenEscalators.contains(currentEsc + (currentEsc - 2) / 10.0))
				    {
					System.out.println ("Walk to and walk down the " + currentEsc + "-" + (currentEsc-2));
					currentEsc-=2;
				    }
				else 
				    {
					System.out.println("Walk to and take the " + currentEsc + "-" + (currentEsc-2));
					currentEsc -= 2;
			    
				    }
			    }
	    
		    }
	
	    }//closes scenario if you are going down at all
    }



    public void stairsRoute()
    {
	String s = "";
	if (preference == 0)
	    {
		//determines what part of hallway the end destination is in, which determines stair case(s) used                                                   
		if (endR>=27)
		    end='l';
		else if (endR< 13)
		    end='r';
		else
		    end='m';
	    
		if (endF > startF) 
		    {
			if (end=='l')
			    System.out.println("Walk to the Hudson staircase and up " + (endF-startF) + " floors to floor" + " " + endF);
			else if (end=='r')
			    System.out.println("Walk to the Hudson staircase and up " + (endF-startF) + " floors to floor" + " " + endF);
			else
			    System.out.println("Walk to the Hudson staircase and up " + (endF-startF) + " floors to floor" + " " + endF);
		
		    }
		if (endF < startF) 
		    {
			if (end=='l')
			    System.out.println("Walk to the Hudson staircase and down " + (endF-startF) + " floors to floor" + " " + endF);
			else if (end=='r')
			    System.out.println("Walk to the Hudson staircase and down " + (endF-startF) + " floors to floor" + " " + endF);
			else
			    System.out.println("Walk to the Hudson staircase and down " + (endF-startF) + " floors to floor" + " " + endF);
		    }
	    }   
    }
    
    public void sameFloor()
    {//What to do if destination is on same floor as start
	if (endF == startF)
	    {
		preference = 0;
		if (end==start)
		    System.out.println("Walk a few steps to your destination.");
		else if (((end=='l') && ((start=='m')|| (start=='r'))))
		    System.out.println("Walk right to your destination.");
		else if (((end=='r') && ((start=='m')|| (start=='l'))))
		    System.out.println("Walk left to your destination.");
		else 
		    { //start in the middle
			if (end=='l')
			    System.out.println("Walk left to your destination.");
			else //end=r 
			    System.out.println("Walk right to your destination.");
		    }
	    }
	
    }
    
    public int getSize()
    {//ArrayList size
	return BrokenEscalators.size();
    }
    
    public static void main(String[] args)
    {
	route r = new route();
	r.setDir();
	r.sameFloor();
	if (r.preference==0) 
	    r.stairsRoute();
	else 
	    {
		if (r.getSize() != 0) 
		    r.brokenEscalatorRoute();
		else
		    r.workingEscalatorRoute();
	    }
	
	
    }
    
}

