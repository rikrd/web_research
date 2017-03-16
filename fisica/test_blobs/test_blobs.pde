import processing.opengl.*;

import fisica.*;

FWorld world;

void setup(){
  size(400, 400);
  smooth();

  Fisica.init(this);

  world = new FWorld();
  world.setGravity(0, 100);

  world.setEdges(this, color(0));
  world.remove(world.top);
  
  world.setGrabbable(false);
}

void draw(){
  background(0);

  world.step();
  world.draw(this);
}

void mousePressed(){
  FBlob blob2 = new FBlob();
  blob2.setStrokeColor(255);
  blob2.setVertexSize(5);
  blob2.setDamping(0.1);
  blob2.setFrequency(10);
  blob2.setAsCircle(mouseX, mouseY, random(30, 50), 25);
  world.add(blob2); 
}


