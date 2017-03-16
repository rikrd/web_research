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

public class Inherit extends PApplet {



String msg = "";
FWorld world;
PFont font;

public void setup(){
  size(400, 400);
  smooth();

  Fisica.init(this);

  font = loadFont("FreeMonoBold-24.vlw");
  textFont(font, 24);

  world = new FWorld();
  world.setEdges(this, color(120));
  world.remove(world.top);
  world.setGravity(0, 500);

  Texto t = new Texto("Type and ENTER");
  t.setPosition(width/2, height/2);
  t.setRotation(random(-1, 1));
  t.setFill(255);
  t.setNoStroke();
  t.setRestitution(0.75f);
  world.add(t);
}

public void draw() {
  background(120);

  world.step();
  world.draw(this);
}

public void keyPressed() {
  if (key == ENTER) {
    if (!msg.equals("")) {
      Texto t = new Texto(msg);
      t.setPosition(width/2, height/2);
      t.setRotation(random(-1, 1));
      t.setFill(255);
      t.setNoStroke();
      t.setRestitution(0.65f);
      world.add(t);
      msg = "";
    }
  }  
  else if (key == CODED && keyCode == CONTROL) {
    try {
      saveFrame("screenshot.png");
    } 
    catch (Exception e) {
    }
  }
  else {
    msg+= key;
  }
}

class Texto extends FBox {
  
  String texto;
  float textOffset;

  Texto(String _texto){
    super(textWidth(_texto), textAscent() + textDescent());
    texto = _texto;
    textOffset = textAscent() - getHeight()/2;
  }
  
  public void draw(PGraphics applet) {
    super.draw(applet);

    preDraw(applet);
    fill(0);
    stroke(0);
    textAlign(CENTER);
    text(texto, 0, textOffset);
    postDraw(applet);
  }
  
}

  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#DFDFDF", "Inherit" });
  }
}
