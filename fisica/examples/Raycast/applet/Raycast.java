import processing.core.*; 
import processing.xml.*; 

import fisica.*; 
import org.jbox2d.common.*; 

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

public class Raycast extends PApplet {

/**
 *  Raycast
 *
 *  by Ricard Marxer
 *
 *  This example shows how to use the raycasts.
 */




FWorld world;
FBox obstacle;

public void setup() {
  size(400, 400);
  smooth();

  Fisica.init(this);

  world = new FWorld();

  obstacle = new FBox(150,150);
  obstacle.setRotation(PI/4);
  obstacle.setPosition(width/2, height/2);
  obstacle.setStatic(true);
  obstacle.setFill(0);
  obstacle.setRestitution(0);
  world.add(obstacle);
}

public void draw() {
  background(255);

  world.draw();
  world.step();
  
  castRay();
}

public void castRay() {
  FRaycastResult result = new FRaycastResult();
  FBody b = world.raycastOne(width/2, height, mouseX, mouseY, result, true);

  stroke(0);
  line(width/2, height, mouseX, mouseY);

  if (b != null) {
    b.setFill(120, 90, 120);
    fill(180, 20, 60);
    noStroke();
    
    float x = result.getX();
    float y = result.getY();
    ellipse(x, y, 10, 10);

  } 
  else {
    obstacle.setFill(0);
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
    PApplet.main(new String[] { "--bgcolor=#DFDFDF", "Raycast" });
  }
}
