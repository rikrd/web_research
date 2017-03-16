import processing.core.*; 
import processing.xml.*; 

import processing.opengl.*; 
import fisica.*; 

import java.applet.*; 
import java.awt.*; 
import java.awt.image.*; 
import java.awt.event.*; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class test_blobs extends PApplet {





FWorld world;

public void setup(){
  size(400, 400);
  smooth();

  Fisica.init(this);

  world = new FWorld();
  world.setGravity(0, 100);

  world.setEdges(this, color(0));
  world.remove(world.top);
  
  world.setGrabbable(false);
}

public void draw(){
  background(0);

  world.step();
  world.draw(this);
}

public void mousePressed(){
  FBlob blob2 = new FBlob();
  blob2.setStrokeColor(255);
  blob2.setVertexSize(5);
  blob2.setDamping(0.1f);
  blob2.setFrequency(10);
  blob2.setAsCircle(mouseX, mouseY, random(30, 50), 25);
  world.add(blob2); 
}



  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#ffffff", "test_blobs" });
  }
}
