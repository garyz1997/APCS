class Ball {
  
  float x;
  float y;
  float size;
  
  Ball() {
   
   x = random(width);
   y = random(height);
   size = random( 25, 100 ); 
  }
  
  void display() {
    ellipse( x, y, size, size );
  }
}
