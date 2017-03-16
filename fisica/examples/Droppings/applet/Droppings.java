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

public class Droppings extends PApplet {

/**
 *  Droppings Remade
 *
 *  This example shows how to create a simple remake of my favorite
 *  soundtoy:<br/>
 *
 *    <a href=http://www.balldroppings.com/>BallDroppings</a> 
 *       by Josh Nimoy.
 */
 


FWorld mundo;
FBox caja;

float x, y;

public void setup() {
  size(400, 400);
  smooth();
  
  Fisica.init(this);
  
  mundo = new FWorld();
  mundo.setGravity(0, 200);
  
  frameRate(24);
  background(0);
}

public void draw() {
  fill(0, 100);
  noStroke();
  rect(0, 0, width, height);
  
  if ((frameCount % 24) == 0) {
    FCircle bolita = new FCircle(8);
    bolita.setNoStroke();
    bolita.setFill(255);
    bolita.setPosition(100, 20);
    bolita.setVelocity(0, 400);
    bolita.setRestitution(0.9f);
    bolita.setDamping(0);
    mundo.add(bolita);
  }
  
  mundo.step();
  mundo.draw(this);
}

public void mousePressed() {
  caja = new FBox(4, 4);
  caja.setStaticBody(true);
  caja.setStroke(255);
  caja.setFill(255);
  caja.setRestitution(0.9f);
  mundo.add(caja);
  
  x = mouseX;
  y = mouseY;
}

public void mouseDragged() {
  if (caja == null) {
    return;
  }
  
  float ang = atan2(y - mouseY, x - mouseX);
  caja.setRotation(ang);
  caja.setPosition(x+(mouseX-x)/2.0f, y+(mouseY-y)/2.0f);
  caja.setWidth(dist(mouseX, mouseY, x, y));
  
}

public void contactStarted(FContact contacto) {
  FBody cuerpo1 = contacto.getBody1();
  cuerpo1.setFill(255, 0, 0);
  cuerpo1.setStroke(255, 0, 0);
  
  noFill();
  stroke(255);
  ellipse(contacto.getX(), contacto.getY(), 30, 30);
}

public void contactEnded(FContact contacto) {
  FBody cuerpo1 = contacto.getBody1();
  cuerpo1.setFill(255);
  cuerpo1.setStroke(255);
}

public void keyPressed() {
  try {
    saveFrame("screenshot.png");
  } 
  catch (Exception e) {
  }
}




  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#DFDFDF", "Droppings" });
  }
}
