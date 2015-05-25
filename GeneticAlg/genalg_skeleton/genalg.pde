//"Constants"
int POPULATION_SIZE = 100;

//Global Variables
int selectedX;
int selectedY;
int bestX;
int bestY;
boolean continuous = false;
float totalFitness;
int speed;
int generation;
float mutationRate = 0.05;

//The actual individuals
Individual[] population;
Individual selected;
Blob b1;
Gene g1;
Individual I1;

/*=====================================
  Create an initial population of randomly
  generated individuals.
  Setup the basic window properties
  ====================================*/
void setup() {
  size(620,620);
  background(255,255,255);
  frameRate(1);
  populate();
  Individual goal1 = select();
  population[0]= new Individual(31,31);
  for (int a = 0; a<7;a++)
   {
       Gene y = goal1.chromosome[a];
       population[0].chromosome[a]=y;
   }
  //I1 = new Individual(200,300);
  //Blob b2 = new Blob();
  //g1 = new Gene(8);
}

/*=====================================
  Redraw every Individual in the population
  each frame. Make sure they are drawn in a grid without
  overlaping each other.
  If an individual has been slected (by the mouse), draw a box
  around it and draw a box around the individual with the
  highest fitness value.
  If mating mode is set to continuous, call mating season
  ====================================*/
void draw() {
  background(255,255,255);

  generation++;
  println(generation);
  matingSeason();
  //mutate();
  population[0].display();
  findBest();
  //I1.display();
  //I1.printIndividual();
  //g1.display();
  //g1.mutate();
  //g1.display();
  //b2.diplay();
}

/*=====================================
When the mouse is clicked, set selected to
the individual clicked on, and set 
selectedX and selectedY so that a box can be
drawn around it.
  ====================================*/
void mouseClicked() {
  int x = mouseX;
  int y = mouseY;
  for (int r = 0; r < 10; r++)
  {
    for (int c = 0; c < 10; c++)
    {
      if((x<=(c+1)*62)&&(y<=(r+1)*62))
      {
       selected = population[10*r+c]; 
       selectedX=31+62*c;
       selectedY=31+62*r;
      }
    }
  }
}

/*====================================
The following keys are mapped to actions:

Right Arrow: move forard one generation
Up Arrow: speed up when in continuous mode
Down Arrow: slow down when in continuous mode
Shift: toggle continuous mode
Space: reset the population
f: toggle fitness value display
s: toggle smiley display
m: increase mutation rate
n: decrease mutation rate
  ==================================*/
void keyPressed() {
  println(keyCode); //wil display the integer value for whatever key has been pressed
  if (key == RIGHT)
  {
  generation++;
  println(generation);
  matingSeason();
  mutate();
  population[0].display();
  findBest(); 
  }
  if (key == ' ')
    populate();
  if (key == SHIFT)
    exit();
  if (key == 'm')
    mutationRate+=0.05;
  if (key == 'n')
    mutationRate-=0.05;
  if (mousePressed==true)
    mouseClicked();
}


/*====================================
  select will return a pseudo-random chromosome from the population
   Uses roulette wheel selection:
     A random number is generated between 0 and the total fitness 
     Go through the population and add each member's fitness until you exceed the random 
     number that was generated.
     Return the individual that the algorithm stopped on
     Do not include the "selected" Blob as a possible return value
  ==================================*/
Individual select() {
  setTotalFitness();
  float x = random(int(totalFitness));
  float comp = 0;
  for (Individual a:population)
  {
    comp+=a.fitness;
    if (comp>x)
      return a;
  }
  return null;
}

/*====================================

  Replaces the current population with a totally new one by
  selecting pairs of Individuals and "mating" them.
  Make sure that totalFitness is set before you use select().
  The goal shape (selected) should always be the frist Individual
  in the population, unmodified.
  ==================================*/
void matingSeason() {
  background(255,255,255);
  setTotalFitness();

  for (int c = 0;c<population.length;c++)
  {
   if (c!=0)
    {
     population[c]= population[0].mate(population[c],31+62*(c%10),31+62*(c/10));
     population[c].display();
    } 
  }
  
}

/*====================================

  Randomly call the mutate method an Individual (or Individuals)
  in the population.
  ==================================*/
void mutate() {
  for (Individual a:population)
  {
   if (int(random(2))==0)
     a.mutate(); 
  }
}

/*====================================

  Set the totalFitness to the sum of the fitness values
  of each individual.
  Make sure that each individual has an accurate fitness value
  ==================================*/
void setTotalFitness() {
  totalFitness=0;
  for (Individual a:population)
    totalFitness+=a.fitness;
}

/*====================================
  Fill the population with randomly generated Individuals
  Make sure to set the location of each individual such that
  they display nicely in a grid.
  ==================================*/
void populate() {
  population = new Individual[POPULATION_SIZE];
  int rowcount = 31;
  int colcount = 31;
  for (int r = 0; r < 10; r++)
  {
    for (int c = 0; c < 10; c++)
    {
      population[10*r+c] = new Individual(rowcount+(62*r),colcount+(62*c));
      selected = population[0];
      population[10*r+c].display();
      if (r+c!=0)
        population[10*r+c].setFitness(selected);
    }
  }
}

/*====================================
  Go through the population and find the Individual with the 
  highest fitness value.
  Set bestX and bestY so that the best Individual can have a 
  square border drawn around it.
  ==================================*/
void findBest() {
  float fit = 0;
  int x = 0;
  int y = 0;
  for (int a = 0;a<population.length;a++)
  {
    if (a!=0){
    if (population[a].fitness>fit)
    {
          fit = population[a].fitness;
          x= a%10;
          y= a/10;
    }
    }
  }
  bestX=x;
  bestY=y;
}
       
     
     

