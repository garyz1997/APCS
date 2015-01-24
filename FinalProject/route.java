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
    
    int nearestStairs=12;//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    int oneFloor=14;//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    int halfHall=23;//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    int totalTime=0;
    int betweenEsc=19;


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
		totalTime+=oneFloor;
	    }
	if (currentesc == 10) 
	    {
		System.out.println("Walk down to the ninth floor.");
		currentesc--;
		numEsc = Math.abs(endF - startF + 1) / 2;               
		totalTime+=oneFloor;
	    }

	if (endF - startF < 0)
	    {
		for (int a = 0;a<numEsc;a++) 
		    {
			if (currentesc-2 == 1)
			    {
				System.out.println("Walk down 2 floors to your destination.");
				totalTime+=2*oneFloor;
				currentesc-=2;
				break;
			    }
			System.out.println("Walk to and take the "+currentesc+"-"+(currentesc-2)+" escalator");
			currentesc=currentesc-2;
			totalTime+=Esc+betweenEsc;
		    }
		totalTime-=betweenEsc;
		if (currentesc != endF)
		    { 
			System.out.println("Take the stairs down one floor.");
			totalTime+=oneFloor;
		    }
	    }
	
	else 
	    {
		for (int a = 0;a<numEsc;a++) 
		    {
			if (currentesc+2 == 10)
			    {
				System.out.println("Walk up 2 floors to your destination.");
				totalTime+=2*oneFloor;
				currentesc+=2;
				break;
			    }
			System.out.println("Walk to and take the "+currentesc+"-"+(currentesc+2)+" escalator");
			currentesc=currentesc+2;
			totalTime+=Esc+betweenEsc;
		    }
		totalTime-=betweenEsc;
		if (currentesc!= endF)
		    { 
			System.out.println("Take the stairs up one floor.");
			totalTime+=oneFloor;
		    }
	    }
	if (end == 'l') System.out.println("Walk left to your destination.");
	if (end == 'm') System.out.println("Walk towards the middle of the hallway to your destination.");
	if (end == 'r') System.out.println("Walk right to your destination.");
	totalTime+=nearestStairs;
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
	if (currentEsc == 1)
            {
                System.out.println("Walk up to the second floor.");
                currentEsc=2;
		thisFloorEscUp = 2 + ((4) * 0.1);
		thisFloorEscDown= 2 + ((0) * 0.1);
                numEsc = Math.abs(endF - 2) / 2;
		startF=2;
		totalTime+=oneFloor;
            }
        if (currentEsc == 10)
            {
                System.out.println("Walk down to the ninth floor.");
                currentEsc--;
                thisFloorEscUp = startF - 1 + ((startF + 1) * 0.1);
                thisFloorEscDown= startF - 1 + ((startF- 3) * 0.1);
                numEsc = Math.abs(endF - startF + 1) / 2;
		startF=9;
                totalTime+=oneFloor;
            }

	if (numEsc == 0) 
	    this.stairsRoute();
	
	if (startF < endF)
	    { 
		if (((endF - startF) % 2) != 0)
		    {
		
			if (BrokenEscalators.contains(thisFloorEscUp))
			    {
				System.out.println("Walk to the East staircase and up one floor to floor" + (startF+1));
				totalTime+=oneFloor;
				currentEsc++;
				for (int a = 0; a < numEsc; a++) 
				    {
					if (BrokenEscalators.contains(currentEsc + (currentEsc + 2) / 10.0))
					    {
						// double thisEsc= thisFloorEsc+ 1.1 + (a* 1.1);
						if (currentEsc+2 == 10) 
						    {
							System.out.println("Walk up 2 floors to your destination.");
							totalTime+=2*oneFloor;
							break;
						    }
						System.out.println("Walk to and walk up the " + currentEsc + "-" + (currentEsc+2));
						totalTime+=UpEsc+betweenEsc;
						currentEsc+=2;
					    }
			
					else
					    { //still part of for loop
						if (currentEsc+2 == 10)
                                                    {
                                                        System.out.println("Walk up 2 floors to your destination.");
                                                        totalTime+=2*oneFloor;
                                                        break;
                                                    }
						System.out.println("Walk to and take the " + currentEsc + "-" + (currentEsc+2));
						totalTime+=Esc+betweenEsc;
						currentEsc+=2;

					    }

				    }
				totalTime-=betweenEsc;
			    }
		
			else 
			    { //the floor you are on has a working escalator and you have an odd # of floors and are going up
				System.out.println ("Walk to and take the " + currentEsc + "-" + (currentEsc+2));
				totalTime+=Esc;
				currentEsc= startF+2;
				for (int a = 1; a < numEsc; a++) 
				    { //starts at one bc an escalator has already been taken
					thisFloorEscUp+= 2.2;
					if (BrokenEscalators.contains(thisFloorEscUp))
					    {
						// double thisEsc= thisFloorEsc+ 1.1 + (a* 1.1);
						if (currentEsc+2 == 10)
                                                    {
                                                        System.out.println("Walk up 2 floors to your destination.");
                                                        totalTime+=2*oneFloor;
                                                        break;
                                                    }
						System.out.println("Walk to and walk up the " + currentEsc + "-" + (currentEsc+2));						
						currentEsc+=2;
						totalTime+=UpEsc+betweenEsc;
					    }
			
					else
					    { //still part of the for loop
						if (currentEsc+2 == 10)
                                                    {
                                                        System.out.println("Walk up 2 floors to your destination.");
                                                        totalTime+=2*oneFloor;
                                                        break;
                                                    }
						System.out.println("Walk to and take the " + currentEsc + "-" + (currentEsc+2));
						currentEsc+=2;
						totalTime+=Esc+betweenEsc;
			    

					    }

				    }
				totalTime-=betweenEsc;
				System.out.println("Walk up the West staircase one floor up to floor " + (currentEsc + 1));
				totalTime+=oneFloor;
				//System.out.println(currentEsc);
			    }
		    }//closes scenario where you have an odd # of floors
		else 
		    { //going up and have an even # of flights
		
			for (int a=0; a<numEsc; a++) 
			    {
				if (BrokenEscalators.contains(thisFloorEscUp))
				    {
					if (currentEsc+2 == 10)
					    {
						System.out.println("Walk up 2 floors to your destination.");
						totalTime+=2*oneFloor;
						break;
					    }
					System.out.println("Walk to and walk up the "+ currentEsc + "-" + (currentEsc + 2) );
					currentEsc+=2;
					thisFloorEscUp+=2.2;
					totalTime+=UpEsc+betweenEsc;
				    }
		
				else 
				    {
					if (currentEsc+2 == 10)
					    {
						System.out.println("Walk up 2 floors to your destination.");
						totalTime+=2*oneFloor;
						break;
					    }
					System.out.println("Walk to and take the " + currentEsc + "-" + (currentEsc + 2));
					currentEsc+=2;
					thisFloorEscUp+=2.2;
					totalTime+=Esc+betweenEsc;
				    }
			    }
			totalTime-=betweenEsc;
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
				totalTime+=oneFloor;
				currentEsc--;
				for (int a = 0; a < numEsc; a++) 
				    {
					if (BrokenEscalators.contains(currentEsc+(currentEsc-2)/10.0))
					    {
                                                if (currentEsc-2 == 1)
                                                    {
                                                        System.out.println("Walk down 2 floors to your destination.");
                                                        totalTime+=2*oneFloor;
                                                        break;
                                                    }
						System.out.println("Walk to and walk down the " + currentEsc + "-" + (currentEsc-2));
						currentEsc-=2;
						totalTime+=DownEsc+betweenEsc;
					    }
		    
					else
					    { //still part of for loop
						if (currentEsc-2 == 1)
                                                    {
                                                        System.out.println("Walk down 2 floors to your destination.");
                                                        totalTime+=2*oneFloor;
                                                        break;
                                                    }
						System.out.println("Walk to and take the " + currentEsc + "-" + (currentEsc-2));
						currentEsc-=2;
						totalTime+=Esc+betweenEsc;
					    }
		    
				    }
				totalTime-=betweenEsc;
			    }//closes the scenario where u have a broken esc on your floor
	    
			else 
			    { //the floor you are on has a working escalator and you have an odd # of floors and are going down
				System.out.println ("Walk to and take the " + currentEsc + "-" + (currentEsc-2));
				currentEsc-=2;
				totalTime+=Esc;
				for (int a = 1; a < numEsc; a++) 
				    { //starts at one bc an escalator has already been taken
					thisFloorEscDown-= 2.2;
					if (BrokenEscalators.contains(thisFloorEscDown))
					    {
						if (currentEsc-2 == 1)
                                                    {
                                                        System.out.println("Walk down 2 floors to your destination.");
                                                        totalTime+=2*oneFloor;
                                                        break;
                                                    }
						// double thisEsc= thisFloorEsc+ 1.1 + (a* 1.1);
						System.out.println("Walk to and walk down the" + currentEsc + "-" + (currentEsc-2));
						currentEsc-=2;
						totalTime+=DownEsc+betweenEsc;
					    }
		    
					else
					    { //still part of the for loop
						if (currentEsc-2 == 1)
                                                    {
                                                        System.out.println("Walk down 2 floors to your destination.");
                                                        totalTime+=2*oneFloor;
                                                        break;
                                                    }
						System.out.println("Walk to and take the " + currentEsc + "-" + (currentEsc-2));
						currentEsc-=2;
						totalTime+=Esc+betweenEsc;
					    }
				    }
				totalTime-=betweenEsc;
				System.out.println("Walk down the West staircase one floor down to floor " + (currentEsc - 1));
				totalTime+=oneFloor;
				//System.out.println(currentEsc);
			    }
		    }//closes scenario w odd # flights
	
	
		else 
		    { // going down and have an even # of flights
	    
			for (int a =0; a<numEsc; a++) 
			    {
				//System.out.println(a);
				if (BrokenEscalators.contains(currentEsc+(currentEsc-2)/10.0))
				    {
					if (currentEsc-2 == 1)
					    {
						System.out.println("Walk down 2 floors to your destination.");
						totalTime+=2*oneFloor;
						break;
					    }
					System.out.println ("Walk to and walk down the " + currentEsc + "-" + (currentEsc-2));
					currentEsc-=2;
					thisFloorEscDown-=2.2;
					totalTime+=DownEsc+betweenEsc;
				    }
				else 
				    {
					if (currentEsc-2 == 1)
					    {
						System.out.println("Walk down 2 floors to your destination.");
						totalTime+=2*oneFloor;
						break;
					    }
					System.out.println("Walk to and take the " + currentEsc + "-" + (currentEsc-2));
					currentEsc -= 2;
					thisFloorEscDown-=2.2;
					totalTime+=Esc+betweenEsc;
				    }
			    }
			totalTime-=betweenEsc;
	    
		    }
	
	    }//closes scenario if you are going down at all
        if (end == 'l') System.out.println("Walk left to your destination.");
	if (end == 'm') System.out.println("Walk towards the middle of the hallway to your destination.");
        if (end == 'r') System.out.println("Walk right to your destination.");
        totalTime+=nearestStairs;
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
			    System.out.println("Walk to the East staircase and up " + (endF-startF) + " floors to floor" + " " + endF);
			else
			    System.out.println("Walk to the West staircase and up " + (endF-startF) + " floors to floor" + " " + endF);
		
		    }
		if (endF < startF) 
		    {
			if (end=='l')
			    System.out.println("Walk to the Hudson staircase and down " + (startF-endF) + " floors to floor" + " " + endF);
			else if (end=='r')
			    System.out.println("Walk to the East staircase and down " + (startF-endF) + " floors to floor" + " " + endF);
			else
			    System.out.println("Walk to the West staircase and down " + (startF-endF) + " floors to floor" + " " + endF);
		    }
	    }   
	totalTime+=Math.abs(endF-startF)*oneFloor;//14 sec per flight of stairs//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	totalTime+=nearestStairs;//12 sec to walk to nearest staircase//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
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
		totalTime+=halfHall;//it takes an average of 23 sec to walk down half the whole hallway
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
	System.out.println("Your journey will take "+r.totalTime/60+" minutes and "+r.totalTime%60+" seconds.");
	
    }
    
}

