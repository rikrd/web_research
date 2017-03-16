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

public class Buttons extends PApplet {

/**
 *  Buttons and bodies
 *
 *  by Ricard Marxer
 *
 *  This example shows how to create bodies.
 *  It also demonstrates the use of bodies as buttons.
 */



FBox boxButton;
FCircle circleButton;
FPoly polyButton;

FWorld world;

int buttonColor = 0xff155AAD;
int hoverColor = 0xff55AA11;
int bodyColor = 0xff6E0595;

public void setup() {
  size(400, 400);
  smooth();

  Fisica.init(this);

  world = new FWorld();
  world.setEdges();
  world.remove(world.left);
  world.remove(world.right);
  world.remove(world.top);

  boxButton = new FBox(40, 40);
  boxButton.setPosition(width/4, 100);
  boxButton.setStatic(true);
  boxButton.setFillColor(buttonColor);
  boxButton.setNoStroke();
  world.add(boxButton);

  circleButton = new FCircle(40);
  circleButton.setPosition(2*width/4, 100);
  circleButton.setStatic(true);
  circleButton.setFillColor(buttonColor);
  circleButton.setNoStroke();
  world.add(circleButton);

  polyButton = new FPoly();
  polyButton.vertex(20, 20);
  polyButton.vertex(-20, 20);
  polyButton.vertex(0, -20);
  polyButton.setPosition(3*width/4, 100);
  polyButton.setStatic(true);
  polyButton.setFillColor(buttonColor);
  polyButton.setNoStroke();
  world.add(polyButton);

}

public void draw() {
  background(255);

  world.step();
  world.draw();
}

public void mousePressed() {
  FBody pressed = world.getBody(mouseX, mouseY);
  if (pressed == boxButton) {
    FBox myBox = new FBox(40, 40);
    myBox.setPosition(width/4, 200);
    myBox.setRotation(random(TWO_PI));
    myBox.setVelocity(0, 200);
    myBox.setFillColor(bodyColor);
    myBox.setNoStroke();
    world.add(myBox);
  } 
  else if (pressed == circleButton) {
    FCircle myCircle = new FCircle(40);
    myCircle.setPosition(2*width/4, 200);
    myCircle.setRotation(random(TWO_PI));
    myCircle.setVelocity(0, 200);
    myCircle.setFillColor(bodyColor);
    myCircle.setNoStroke();
    world.add(myCircle);
  } 
  else if (pressed == polyButton) {
    FPoly myPoly = new FPoly();
    myPoly.vertex(20, 20);
    myPoly.vertex(-20, 20);
    myPoly.vertex(0, -20);
    myPoly.setPosition(3*width/4, 200);
    myPoly.setRotation(random(TWO_PI));
    myPoly.setVelocity(0, 200);
    myPoly.setFillColor(bodyColor);
    myPoly.setNoStroke();
    world.add(myPoly);
  }
}

public void mouseMoved() {
  FBody hovered = world.getBody(mouseX, mouseY);
  if (hovered == boxButton 
      || hovered == circleButton
      || hovered == polyButton) {
    hovered.setFillColor(hoverColor);

  } else {
    boxButton.setFillColor(buttonColor);
    circleButton.setFillColor(buttonColor);
    polyButton.setFillColor(buttonColor);
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
    PApplet.main(new String[] { "--bgcolor=#DFDFDF", "Buttons" });
  }
}
