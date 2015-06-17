
package a08;

import schimkat.berlin.lernhilfe2015ss.DIRTY.graphics.Drawable;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SmileyView extends JPanel implements Drawable, PropertyChangeListener {
	protected SmileyModel model;
	protected Point start;
	protected int radius;
	protected double eyeRad;
	protected double  eyeAngel;
	protected boolean smile;
	
	public SmileyView(SmileyModel model) {
		this.model = model;
		start = model.getStart();
		radius=model.getRadius();
		eyeRad = model.getEyeRad();
		eyeAngel = model.getEyeAngel();
		smile = model.isSmile();
		model.addPropertyChangeListener(this);
	}
	
	
	public void draw(Graphics g) {
		GeoUtil gu = new GeoUtil();
		Point leftEye = gu.leftEye();
		Point rightEye = gu.rightEye();
		drawHead(g,model.getStart());
		drawLeftEye(g,leftEye, gu);
		drawRightEye(g,rightEye, gu);
		drawMouth(g,gu);
	}

	private void drawMouth(Graphics g, GeoUtil gu) {
		g.setColor(Color.RED);
		if(smile){
			int nPoints= gu.mouthXPoints().length;
			g.fillPolygon(gu.mouthXPoints(), gu.mouthYPoints(), nPoints);
		}else{
			Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(10));
            g2.draw(new Line2D.Float((int)gu.mouthAnfang().getX(), (int)gu.mouthAnfang().getY(), (int)gu.mouthEnde().getX(), (int)gu.mouthEnde().getY()));
		}
		
	}

	private void drawRightEye(Graphics g, Point p, GeoUtil gu) {
		g.setColor(Color.BLACK);
		g.fillOval(p.x, p.y, (int)(eyeRad), (int)(eyeRad));
		drawrightPupil(g, p, gu);
	}

	private void drawrightPupil(Graphics g, Point p, GeoUtil gu) {
		Point rightEyeMiddle = gu.pupilMiddle(p);
		Point rightPupil = gu.turnPupil();
		g.setColor(Color.RED);
		g.fillOval(rightPupil.x+rightEyeMiddle.x,rightPupil.y+rightEyeMiddle.y, (int)(4*eyeRad/10), (int)(4*eyeRad/10));
	}

	private void drawLeftEye(Graphics g, Point p, GeoUtil gu) {
		g.setColor(Color.BLACK);
		g.fillOval(p.x, p.y, (int)(eyeRad), (int)(eyeRad));
		
		drawLeftPupil(g,p, gu);
	}

	private void drawLeftPupil(Graphics g, Point p, GeoUtil gu) {
		Point leftEyeMiddle = new Point((int)(p.x+eyeRad/4),(int)(p.y+eyeRad/4));
		Point leftPupil = gu.turnPupilRevers();
		g.setColor(Color.RED);
		g.fillOval(leftPupil.x+leftEyeMiddle.x, leftPupil.y+leftEyeMiddle.y, (int)(4*eyeRad/10), (int)(4*eyeRad/10));
	}
	
	private void drawHead(Graphics g, Point p) {
		g.setColor(Color.DARK_GRAY);
		g.fillOval(p.x, p.y, 2*radius, 2*radius);
	}
	
	private class GeoUtil{
		private GeoUtil() {
			super();
		}
		private Point faceMiddle(){
			return new Point(start.x+radius,start.y+radius);
		}
		private Point leftEye() {
			return new Point((int)(faceMiddle().x - Math.cos(Math.toRadians(30))*radius), (int)(faceMiddle().y - Math.sin(Math.toRadians(30))*radius));
		}
		private Point rightEye(){
			return new Point((int)(faceMiddle().x + (Math.cos(Math.toRadians(30))*radius)-eyeRad), (int)(faceMiddle().y - Math.sin(Math.toRadians(30))*radius));
		}
		private Point turnPupil(){
			return new Point((int)(start.x/2+Math.cos(Math.toRadians(eyeAngel))*eyeRad/4),(int)(start.y/2+Math.sin(Math.toRadians(eyeAngel))*eyeRad/4));
		}
		private Point pupilMiddle(Point p){
			return new Point((int)(p.x+eyeRad/4),(int)(p.y+eyeRad/4));
		}
		private Point turnPupilRevers(){
			return new Point((int)(start.x/2+Math.sin(Math.toRadians(eyeAngel))*eyeRad/4),(int)(start.y/2+Math.cos(Math.toRadians(eyeAngel))*eyeRad/4));
		}
		private Point mouthAnfang(){
			return new Point((int)(leftEye().x+eyeRad/2),(int)(start.y+radius*1.5));
		}
		private Point mouthEnde(){
			return new Point((int)(rightEye().x+eyeRad/2),(int)(start.y+radius*1.5));
		}
		private int[] mouthXPoints(){
			Point pAnfang= mouthAnfang();
			Point pEnde=mouthEnde();
			int[] xPoints={pAnfang.x,(int)(pAnfang.x+(pEnde.x-pAnfang.x)/6),(int)(pAnfang.x+(pEnde.x-pAnfang.x)/4)+6,
					(int)(pAnfang.x+(pEnde.x-pAnfang.x)/2),(int)(pEnde.x-(pEnde.x-pAnfang.x)/4)-6,(int)(pEnde.x-(pEnde.x-pAnfang.x)/6),pEnde.x};
			return xPoints;
		}
		private int[] mouthYPoints(){
			Point pAnfang= mouthAnfang();
			Point pEnde=mouthEnde();
			int[] yPoints={pAnfang.y,(int)(pEnde.y+eyeRad/3),(int)(pEnde.y+eyeRad/2),(int)(pEnde.y+eyeRad/2),
					(int)(pEnde.y+eyeRad/2),(int)(pEnde.y+eyeRad/3),pEnde.y};
			return yPoints;
		}
	}

	public void propertyChange(PropertyChangeEvent e) {
		if(e.getPropertyName().equals("MODEL_UPDATED")){
			start = model.getStart();
			radius=model.getRadius();
			eyeRad = model.getEyeRad();
			eyeAngel = model.getEyeAngel();
			smile = model.isSmile();
			repaint();
		}
	}
}