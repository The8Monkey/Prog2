package a08.anthony;


import schimkat.berlin.lernhilfe2015ss.DIRTY.graphics.Drawable;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SmileyView extends JPanel implements Drawable, PropertyChangeListener {

    protected int x;
    protected int y;
    protected int radius;
    protected int angleOfEyes;
    protected boolean smileStatus;
    protected boolean gridOnOff;
    protected SmileyModel model;
//    protected PropertyChangeListener pcl;

    public SmileyView(SmileyModel model){
        this.model = model;
        model.addPropertyChangeListener(this);
        x = model.getX();
        y = model.getY();
        radius = model.getRadius();
        angleOfEyes = model.getAngleOfEyes();
        gridOnOff = model.getGridOnOff();
        smileStatus = model.smileStatus;
    }

    public void draw(Graphics g) {

        int x = this.x;
        int y = this.y;
        int radius = this.radius;
        int angleOfEyes = this.angleOfEyes;
        boolean smileStatus = this.smileStatus;
        boolean gridOnOff = this.gridOnOff;

        drawHead(x, y, radius, g);
        drawEyes(x, y , radius, angleOfEyes, g);
        if (smileStatus){
            drawMouthHappy(x, y, radius, g);
        } else {
            drawMouthSad(x, y, radius, g);
        }
        if (gridOnOff){
            drawGrid(g);
        }
        drawNose(x, y, radius, g);
    }

    public void drawHead(int x, int y, int r, Graphics g){
        int calc = 8*r/15;

        //right and left ear, black head
        g.setColor(new Color(0, 0, 0));
        g.fillOval(x, y, r, r);
        g.fillOval(28*r/15 + x, y, r, r);
        g.fillOval(6*r/15 + x, 6*r/15 + y, r*2, r*2);

        //skincolored parts of the head
        g.setColor(new Color(255, 220, 180));
        g.fillArc(6*r/15 + x,6*r/15 + y, r*2, r*2, 180, 180);
        g.fillOval(9*r/15 + x, calc + y, calc*2, 20*r/15);
        g.fillOval(17*r/15 + x, calc + y, calc*2, 20*r/15);
    }

    public void drawEyes(int x, int y, int r, int angle, Graphics g){
        g.setColor(new Color (255, 255, 255));
        g.fillOval(4*r/5 + x, 4*r/5 + y, 8*r/15, 11*r/15); 		//left
        g.fillOval(22*r/15 + x, 4*r/5 + y, 8*r/15, 11*r/15 ); 	//right
        drawPupil(x, y, r, angle, g);
    }

    public void drawPupil(int x, int y, int r, int angle, Graphics g){
        g.setColor(new Color(0, 0, 0));
        int a = (int) (Math.sin(angle) * 1.4*r/15);
        int b = (int) (Math.cos(angle) * 1.4*r/15);
        int calc = 14*r/15;
        g.fillOval(calc + x + b, calc + y + a, 4*r/15, calc/2); 	//left
        g.fillOval(24*r/15 + x + b, calc + y + a, 4*r/15, calc/2); 	//right
        g.setColor(new Color(255, 255, 255));
        int z = 2*r/15;
        //white reflection in the right pupille-corner
        g.fillOval(16*r/15 + x + b, calc + y + a, z, z); 	//left
        g.fillOval(26*r/15 + x + b, calc + y + a, z, z); 	//right
    }

    public void drawNose(int x, int y, int r, Graphics g){
        g.setColor(new Color(0, 0, 0));
        g.fillOval(6*r/5 + x, 21*r/15 + y, 6*r/15, 4*r/15);
    }

    public void drawMouthHappy(int x, int y, int r, Graphics g){
        int calc = 8*r/15;
        g.setColor(new Color(0, 0, 0));
        g.fillArc(calc*2 + x, calc*3 + y, 2*r/3, calc, 180, 180);
        g.setColor(new Color(255, 220, 180));
        g.fillArc(calc*2 + x, calc*3 + y, 2*r/3, 6*r/15, 180, 180);
    }

    public void drawMouthSad(int x, int y, int r, Graphics g){
        g.setColor(new Color(0, 0, 0));
        g.fillArc(16*r/15 + x, 28*r/15 + y, 2*r/3, 8*r/15, 0, 180);
        g.setColor(new Color(255, 220, 180));
        g.fillArc(16*r/15 + x, 26*r/15 + y, 2*r/3, 6*r/15, 0, 180);
    }


    public void drawGrid(Graphics g){
        g.setColor(new Color(50, 50, 50));
        int w = 0;
        while(w < 1080){
            for(int v = 0;v < 1920; v += 25){
                g.drawLine(0 + w, 5 + v, 0 + w, 20 + v);
                g.drawLine(1100 + w, 5 + v, 1100 + w, 20 + v);
                g.drawLine(5 + v, 0 + w, 20 + v, 0 + w);
                ;
            }
            w += 100;
        }
    }

    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("MODEL_UPDATE")){
            x = model.getX();
            y = model.getY();
            radius = model.getRadius();
            angleOfEyes = model.getAngleOfEyes();
            gridOnOff = model.getGridOnOff();
            repaint();
        }
    }
}
