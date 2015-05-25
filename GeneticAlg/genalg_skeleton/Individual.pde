/*=====================================
  Each individual contains an array of genes that code for
  particular traits to be visually represented as a
  regular polygon.
  Instance variables:
      chromosome
        An array of genes, each entry corresponds to a
        specific trait in the following order:
          sides: number of sides
          rad: the distance from the center of the regulargon to any vertex
          red_color: red value
          green_color: green value
          blue_color: blue value
          x_factor: "wobble" factor for x values
          y_factos: "wobbly" factor for y values
      phenotype
        A regularGon object with traits the correspond to
        the values found in chromosome.
      fitness
        how "close" the Individual is to the desired state
====================================*/

class Individual {
  
  /*=====================================
  Number of genes in each chromosome and the
  unique indentifier for each gene type
  ====================================*/
  int CHROMOSOME_LENGTH = 7;
  int SIDES = 0;
  int RAD = 1;
  int RED_COLOR = 2;
  int GREEN_COLOR = 3;
  int BLUE_COLOR = 4;
  int X_FACTOR = 5;
  int Y_FACTOR = 6;
  /*=====================================
  Constants defining how long each gene will be.
  For initial developmen set these to lower
  values to make testing easier.
  ====================================*/
  int SIDE_GENE_SIZE = 6;
  int RADIUS_GENE_SIZE = 5;
  int COLOR_GENE_SIZE = 8;
  int FACTOR_GENE_SIZE = 4;
  //Instance variables
  Gene[] chromosome;
  Blob phenotype;
  float fitness;
  /*=====================================
  Create a New Individual by setting each entry in chromosome
  to a new randomly created gene of the appropriate length.
  
  After the array is populated, set phenotype to a new regulargon
  with center cx, cy and properties that align with gene values.
  (i.e. if the sides gene is 4, the regulargon should have 4
    sides...)
  ====================================*/
  Individual(float cx, float cy) { 
   chromosome = new Gene[CHROMOSOME_LENGTH];
   Gene s = new Gene(SIDE_GENE_SIZE);
   Gene r = new Gene(RADIUS_GENE_SIZE);
   Gene rc = new Gene(COLOR_GENE_SIZE);
   Gene gc = new Gene(COLOR_GENE_SIZE);
   Gene bc = new Gene(COLOR_GENE_SIZE);
   Gene x = new Gene(FACTOR_GENE_SIZE);
   Gene y = new Gene(FACTOR_GENE_SIZE);
   chromosome[SIDES] = s;
   chromosome[RAD] = r;
   chromosome[RED_COLOR] = rc;
   chromosome[GREEN_COLOR] = gc;
   chromosome[BLUE_COLOR] = bc;
   chromosome[X_FACTOR] = x;
   chromosome[Y_FACTOR] = y;
   phenotype = new Blob(cx, cy, s.value, r.value, x.value, y.value, rc.value,gc.value,bc.value);
   
  }

  /*=====================================
  Call the display method of the phenotype, make sure to set the fill
  color appropriately
  ====================================*/
  void display() {
    phenotype.display();
  }

  /*=====================================
  Set phenotype to a new regulargon with center cx, cy and 
    properties that align with gene values.
  ====================================*/
  void setPhenotype(int cx, int cy) {    
  phenotype = new Blob(cx,cy,chromosome[SIDES].value,chromosome[RAD].value,chromosome[X_FACTOR].value,chromosome[Y_FACTOR].value,chromosome[RED_COLOR].value,chromosome[GREEN_COLOR].value,chromosome[BLUE_COLOR].value);  
  }
  
  /*=====================================
  Print the value of each gene in chromosome, useful for
  debugging and development
  ====================================*/
 void printIndividual() {
   println();
   for (int a = 0;a<CHROMOSOME_LENGTH;a++)
   {
     println( chromosome[a].value );
   }
 }

  /*=====================================
    Return a new Individual based on the genes of the calling
    chromosome and the parameter, "other". A random number of
    genes should be taken from one of the 2 individuals and the
    rest from the other.
    The phenotype of the new Individual must be set, using cs and cy
    as the center
  ====================================*/
 Individual mate(Individual other, int cx, int cy) {
   Individual b = new Individual(cx,cy);
   for (int a = 0; a<CHROMOSOME_LENGTH;a++)
   {
    if ((int)random(2)==0)
     {
       Gene x = new Gene(this.chromosome[a]);
       b.chromosome[a]=x;
     } 
    else
     {
       Gene y = other.chromosome[a];
       b.chromosome[a]=y;
     }
   }
   b.setPhenotype(cx,cy);
   return b;
 }

  /*=====================================
    Set the fitness value of the calling individual by
    comparing it to the parameter, "goal"
    The closer the two are, the higher the fitness value
    should be
  ====================================*/
 void setFitness( Individual goal ) {
   int thisvalue=0;
   int goalvalue = 0;
   for (int a = 0;a<CHROMOSOME_LENGTH;a++)
   {
    thisvalue+=this.chromosome[a].value;
    goalvalue+=goal.chromosome[a].value; 
   }
   fitness = 889 - abs(thisvalue-goalvalue);
 }

  /*=====================================
    Call the mutate method on a random number
    of genes.
  ====================================*/
 void mutate() {
   for (int a = 0;a<CHROMOSOME_LENGTH;a++)
   {
     if (int(random(2))==0)
      chromosome[a].mutate(); 
   }
 }

}
