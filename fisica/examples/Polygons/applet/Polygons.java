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

public class Polygons extends PApplet {

/**
 *  Polygons
 *
 *  by Ricard Marxer
 *
 *  This example shows how to create polygon bodies.
 */



FWorld world;
FPoly poly;

public void setup() {
  size(400, 400);
  smooth();

  Fisica.init(this);

  world = new FWorld();
  world.setGravity(0, 800);
  world.setEdges();
  world.remove(world.left);
  world.remove(world.right);
  world.remove(world.top);
  
  world.setEdgesRestitution(0.5f);
}

public void draw() {
  background(255);

  world.step();
  world.draw(this);  

  // Draw the polygon while
  // while it is being created
  // and hasn't been added to the
  // world yet
  if (poly != null) {
    poly.draw(this);
  }
}


public void mousePressed() {
  if (world.getBody(mouseX, mouseY) != null) {
    return;
  }

  poly = new FPoly();
  poly.setStrokeWeight(3);
  poly.setFill(120, 30, 90);
  poly.setDensity(10);
  poly.setRestitution(0.5f);
  poly.vertex(mouseX, mouseY);
}

public void mouseDragged() {
  if (poly!=null) {
    poly.vertex(mouseX, mouseY);
  }
}

public void mouseReleased() {
  if (poly!=null) {
    world.add(poly);
    poly = null;
  }
}

public void keyPressed() {
  if (key == BACKSPACE) {
    FBody hovered = world.getBody(mouseX, mouseY);
    if ( hovered != null &&
         hovered.isStatic() == false ) {
      world.remove(hovered);
    }
  } 
  else {
    try {
      saveFrame("screenshot.png");
    } 
    catch (Exception e) {
    }
  }
}





  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#DFDFDF", "Polygons" });
  }
}
