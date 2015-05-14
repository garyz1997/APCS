Ball b1;
Ball b2;

void setup() {
  b1 = new Ball();
  b2 = new Ball();
  frameRate( 5 );
  size( 400, 400 );
  println( "hello" );
}

void draw() {
  background(150, 0, 255);
  b1.display();
  b2.display();
}
