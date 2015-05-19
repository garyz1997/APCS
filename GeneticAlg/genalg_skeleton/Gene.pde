/*=====================================
   Each gene contains the code for a specific trait
   Instance Variables:
      genotype: int array to store a binary number
      value: corresponding base 10 number of the genotype
      geneLenght: desired length of the gene
  ====================================*/
import java.util.*;

class Gene {

 int geneLength;
  int[] genotype;
  int value;
  
  /*===================================== 
  Takes the length of the gene as a parameter,
  randomly sets every bit in the genotype array to
  a 1 or a 0, then calcuate the value.
  ====================================*/
  Gene(int l) {
    genotype = new int[l];
    for (int a = 0;a<l;a++)
    {
      genotype[a] = (int)(Math.random()*2);
      //println(genotype[a]);
    }
  }
  
  /*=====================================
    Create a new gene that is a copy
    of the parameter
  ====================================*/
  Gene(Gene g) {
    Gene x = new Gene(g.geneLength);
    x.genotype = g.genotype;
    x.value = g.value;
  }
       
  /*=====================================
    Pick a random element from genotype
    and switch it from 1 to 0 or vice-versa
  ====================================*/ 
  void mutate() {    
  }
  
  /*=====================================
  Go trhough the genotype and set value to the
  correct bast 10 equvalent of the binary number
  ====================================*/
  void setValue() {
  }
  
  /*=====================================
    Print the genotype array and value.
    used for debugging and development only
  ====================================*/
  void display() {
    
    println( genotype );
    println( value );
    println("hi");
  }
}
