import processing.core.*; 
import processing.xml.*; 

import fisica.*; 
import geomerative.*; 
import org.apache.batik.svggen.font.table.*; 
import org.apache.batik.svggen.font.*; 

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

public class Letters extends PApplet {

/**
 *  Falling letters <br/><br/>
 *
 *  by Ricard Marxer <br/><br/>
 *
 *  This example shows how the use <a href="http://www.ricardmarxer.com/geomerative">Geomerative</a> to access
 *  the contours of letters and create them as physical objects.<br/><br/>
 *
 *  <b>Click on the applet and type!</b>
 */






FWorld world;
float posX = 0;
RFont font;

public void setup() {
  size(400, 400);
  smooth();

  frameRate(60);

  Fisica.init(this);
  Fisica.setScale(4);
  RG.init(this);

  RG.setPolygonizer(RG.ADAPTATIVE);

  world = new FWorld();
  world.setGravity(0, 200);
  world.setEdges(this, color(255));
  world.remove(world.top);

  font = RG.loadFont("LiberationSerif-Bold.ttf");
}

public void draw() {
  background(255);
  fill(0);
  stroke(0);
  world.draw(this);
  world.step();
}

public void keyPressed() {  
  FChar chr = new FChar(key);
  if (chr.bodyCreated()) {
    world.add(chr);
  }

  if (key == ' ') {
    world.clear();
    world.setEdges(this, color(255));
    world.remove(world.top);
    posX = 0;
  }

  try {
    if (keyCode==CONTROL) {
      saveFrame("screenshot.png");
    }
  } 
  catch (Exception e) {
  }
}

class FChar extends FPoly {
  RShape m_shape;
  RShape m_poly;
  boolean m_bodyCreated;
    
  FChar(char chr){
    super();
    
    String txt = "";
    txt += chr;
    
    RG.textFont(font, (int)random(72, 120));
    m_shape = RG.getText(txt);
    m_poly = RG.polygonize(m_shape);
    
    if (m_poly.countChildren() < 1) return;
    m_poly = m_poly.children[0];    
    
    // Find the longest contour of our letter
    float maxLength = 0.0f;
    int maxIndex = -1;
    for (int i = 0; i < m_poly.countPaths(); i++) {
      float currentLength = m_poly.paths[i].getCurveLength();
      if (currentLength > maxLength) {
        maxLength = currentLength;
        maxIndex = i;
      }
    }
  
    if (maxIndex == -1) return;
    
    RPoint[] points = m_poly.paths[maxIndex].getPoints();

    for (int i=0; i<points.length; i++) {
      this.vertex(points[i].x, points[i].y);
    }

    this.setFill(0, 100, 150);
    this.setStroke(0);
    this.setStrokeWeight(2);
    
    this.setDamping(0);
    this.setRestitution(0.5f);
    this.setBullet(true);
    this.setPosition(posX+10, height/5);
    
    posX = (posX + m_poly.getWidth()) % (width-100);
  
    m_bodyCreated = true;
  }
  
  public boolean bodyCreated(){
    return m_bodyCreated;  
  }
  
  public void draw(PGraphics applet){
    preDraw(applet);
    m_shape.draw(applet);
    postDraw(applet);
  }
}

  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#DFDFDF", "Letters" });
  }
}
