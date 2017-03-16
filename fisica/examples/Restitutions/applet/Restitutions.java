import processing.core.*; 
import processing.xml.*; 

import fisica.*; 

import java.applet.*; 
import java.awt.Dimension; 
import java.awt.Frame; 
import java.awt.event.MouseEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.FocusEvent; 
import java.awt.Image; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class Restitutions extends PApplet {

/**
 *  Restitutions
 *
 *  by Ricard Marxer
 *
 *  This example shows how the restitution coefficients works.
 */



FWorld world;
int ballCount = 10;

public void setup() {
  size(400, 400);
  smooth();

  Fisica.init(this);

  world = new FWorld();
  world.setEdges();
  world.remove(world.left);
  world.remove(world.right);
  world.remove(world.top);
  world.setEdgesRestitution(0.0f);
 
  for (int i=0; i<ballCount; i++) {
    FCircle b = new FCircle(25);
    b.setPosition(map(i, 0, ballCount-1, 40, width-40), height/6);
    b.setRestitution(map(i, 0, ballCount-1, 0.0f, 1.0f));
    b.setNoStroke();
    b.setFill(map(i, 0, ballCount-1, 60, 255), 80, 120);
    world.add(b);
  }
}

public void draw() {
  background(255);

  world.step();
  world.draw();
}

public void keyPressed() {
  try {
    saveFrame("screenshot.png");
  } 
  catch (Exception e) {
  }
}


  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#DFDFDF", "Restitutions" });
  }
}
