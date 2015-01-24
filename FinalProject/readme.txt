Mary McGreal, Ose Agboneni, Gary Zheng- Period 10

Our project provides Stuyvesant students with the most efficient way in terms of time to get to class depending on their preferences.
The user inputs his/her start location and destination, followed by whether or not they would prefer to take escalators.
If their answer is yes, they input the number of broken escalators and the names of the broken escalators.  If the user says
that he/she would like to take escalators on his/her route, the program optimizes the number of working escalators
that the student can take in order to give him/her the best route possible.  A possible bug is that if you do not put a room number that corresponds to a Stuyvesant classroom the program will result in an error.  In addition, the program isn't built to respond correctly if you input that a down escalator is broken while going up and vice versa.  The program will not break, it will just give you incorrect directions.

How To:
Our program consists of one route class which provides the user with instructions on how to get to his/her destination from
the start location.  After the user inputs his/her information, the program initially tests whether or not the start and
end locations are on the same floor.  If so, the program provides the user with instructions dictating which direction they should walk in.  Otherwise, the user inputs whether or not they would prefer to take escalators to their destination.  If the answer is no, the program gives them a detailed way to get to their destination using only stairs and walking.  If the user would like to take escalators, they input what escalators are broken.  Based on this information, the program gives them the fastest route possible.  If they are traveling an odd number of flights, the program will direct them towards the nearest working escalator.  It will determine whether or not the user should walk one flight of stairs and then take escalators from there or take escalators first and then walk one flight of stairs.  If they are traveling an even number of flights, the program will tell them either to walk up/down or take the appropriate escalator(s) if they are broken or working, respectively.  Considering human traffic on the stairs, a broken escalator would take about the same amount of time as two flights of stairs.  The program will then return the amount of time it will take to get from the start location to the destination.  This way, the user will have both a comprehensive description of the route they will take and the exact amount of time it will take them to complete it. This program also proves that it is possible to get from any class to any destination in the school within the passing time, 4 minutes, assuming regular human traffic in the hallways and the stairs.

Files included:
readme.txt
route.java


