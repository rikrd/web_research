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

public class ContactResize extends PApplet {

/**
 *  ContactRemove
 *
 *  by Ricard Marxer
 *
 *  This example shows how to use the contact events in order to remove bodies.
 */



FWorld world;

public void setup() {
  size(400, 400);
  smooth();

  Fisica.init(this);

  world = new FWorld();
  world.setGravity(0, 100);
  world.setEdges();
}

public void draw() {
  background(255);

  if (frameCount % 50 == 0) {
    float sz = random(30, 60);
    FCircle b = new FCircle(sz);
    b.setPosition(random(0+30, width-30), 50);
    b.setVelocity(0, 100);
    b.setRestitution(0.7f);
    b.setDamping(0.01f);
    b.setNoStroke();
    b.setFill(200, 30, 90);
    world.add(b);
  }

  world.draw();
  world.step();
}

public void contactEnded(FContact c) {  
  if (!c.getBody1().isStatic()) {
    FCircle b = (FCircle)c.getBody1();
    if (b.getSize()>5) {
      b.setSize(b.getSize()*0.9f);
    }
  } 

  if (!c.getBody2().isStatic()) {
    FCircle b = (FCircle)c.getBody2();
    if (b.getSize()>5) {
      b.setSize(b.getSize()*0.9f);
    }
  }
}

public void keyPressed() {
  try {
    saveFrame("screenshot.png");
  } 
  catch (Exception e) {
  }
}


  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#DFDFDF", "ContactResize" });
  }
}
