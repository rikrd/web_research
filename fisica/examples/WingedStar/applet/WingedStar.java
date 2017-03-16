import processing.core.*; 
import processing.xml.*; 

import fisica.*; 
import geomerative.*; 

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

public class WingedStar extends PApplet {

/**
 *  Winged Star</br></br>
 *
 *  by Ricard Marxer</br></br>
 *
 *  It shows how to create bodies from SVG files.
 *  The used SVG file must contain two elements.
 *  One element with the id 'object'
 *  which will be used to draw the body.
 *  Another element must have the id 'outline'
 *  and it will be used as the contour
 *  of the body.</br></br>
 *
 *  This example require the library <a href="http://www.ricardmarxer.com/geomerative">Geomerative</a>.
 */




FWorld world;
String filename = "winged_star.svg";
  
public void setup(){
  size(400, 400);
  smooth();
  
  frameRate(60);

  Fisica.init(this);
  Fisica.setScale(10);
  
  RG.init(this);
  
  RG.setPolygonizer(RG.ADAPTATIVE);

  world = new FWorld();
  world.setEdges(this, color(0));
  world.setGravity(0, 300);
    
  createWingedStar(width/2, height/2);
}

public void draw(){
  background(255);

  world.draw(this);
  world.step();
}

public void mousePressed(){
  if (world.getBody(mouseX, mouseY) == null) {
    createWingedStar(mouseX, mouseY);
  }
}

public void keyPressed() {
  try {
    saveFrame("screenshot.png");
  } 
  catch (Exception e) {
  }
}

public void createWingedStar(float x, float y) {
  float angle = random(TWO_PI);
  float magnitude = 200;
  
  FSVG obj = new FSVG(filename);
  obj.setPosition(x, y);
  obj.setRotation(angle+PI/2);
  obj.setVelocity(magnitude*cos(angle), magnitude*sin(angle));
  obj.setDamping(0);
  obj.setRestitution(0.5f);
  world.add(obj);
}
class FSVG extends FPoly {
  RShape m_shape;
  
  float w = 100;
  float h = 100;  
  
  FSVG(String filename){
    super();
    
    RShape fullSvg = RG.loadShape(filename);
    m_shape = fullSvg.getChild("object");
    RShape outline = fullSvg.getChild("outline");
    
    if (m_shape == null || outline == null) {
      println("ERROR: Couldn't find the shapes called 'object' and 'outline' in the SVG file.");
      return;
    }
    
    // Make the shapes fit in a rectangle of size (w, h)
    // that is centered in 0
    m_shape.transform(-w/2, -h/2, w/2, h/2); 
    outline.transform(-w/2, -h/2, w/2, h/2); 
    
    RPoint[] points = outline.getPoints();

    if (points==null) return;
    
    for (int i=0; i<points.length; i++) {
      this.vertex(points[i].x, points[i].y);
    }

    this.setNoFill();
    this.setNoStroke();
  }
  
  public void draw(PGraphics applet) {
    preDraw(applet);
    m_shape.draw(applet);
    postDraw(applet);
  }
  
}

  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#DFDFDF", "WingedStar" });
  }
}
