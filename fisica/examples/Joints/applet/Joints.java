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

public class Joints extends PApplet {

/**
 *  Joints
 *
 *  by Ricard Marxer
 *
 *  This example shows how to access all the joints of a given body.
 */



FWorld world;

int bodyColor = 0xff6E0595;
int hoverColor = 0xffF5B502;

int spiderCount = 10;
int mainSize = 40;
int legCount = 10;
float legSize = 100;

ArrayList mains = new ArrayList();

public void setup() {
  size(400, 400);
  smooth();

  Fisica.init(this);

  world = new FWorld();
  world.setEdges();
  world.setGravity(0, 0);

  for (int i=0; i<spiderCount; i++) {
    createSpider();
  }
}

public void draw() {
  background(255);

  world.step();
  world.draw();
}

public void mouseMoved() {
  FBody hovered = world.getBody(mouseX, mouseY);

  for (int i=0; i<mains.size(); i++) {
    FBody other = (FBody)mains.get(i);

    if (hovered == other) {
      setJointsDrawable(other, true);
      setJointsColor(other, hoverColor);
    } 
    else {
      setJointsDrawable(other, false);
      setJointsColor(other, bodyColor);
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

public void createSpider() {
  float posX = random(mainSize/2, width-mainSize/2);
  float posY = random(mainSize/2, height-mainSize/2);

  FCircle main = new FCircle(mainSize);
  main.setPosition(posX, posY);
  main.setVelocity(random(-20,20), random(-20,20));
  main.setFillColor(bodyColor);
  main.setNoStroke();
  main.setGroupIndex(2);
  world.add(main);

  mains.add(main);

  for (int i=0; i<legCount; i++) {
    float x = legSize * cos(i*TWO_PI/3) + posX; 
    float y = legSize * sin(i*TWO_PI/3) + posY;

    FCircle leg = new FCircle(mainSize/2);
    leg.setPosition(posX, posY);
    leg.setVelocity(random(-20,20), random(-20,20));
    leg.setFillColor(bodyColor);
    leg.setNoStroke();
    world.add(leg);

    FDistanceJoint j = new FDistanceJoint(main, leg);
    j.setLength(legSize);
    j.setNoStroke();
    j.setStroke(0);
    j.setFill(0);
    j.setDrawable(false);
    j.setFrequency(0.1f);
    world.add(j);
  }
}

public void setJointsColor(FBody b, int c) {
  ArrayList l = b.getJoints();

  for (int i=0; i<l.size(); i++) {
    FJoint j = (FJoint)l.get(i);
    j.setStrokeColor(c);
    j.setFillColor(c);
    j.getBody1().setFillColor(c);
    j.getBody2().setFillColor(c);
  }
}

public void setJointsDrawable(FBody b, boolean c) {
  ArrayList l = b.getJoints();

  for (int i=0; i<l.size(); i++) {
    FJoint j = (FJoint)l.get(i);
    j.setDrawable(c);
  }
}


  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#DFDFDF", "Joints" });
  }
}
