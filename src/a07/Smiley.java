package a07;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;

import schimkat.berlin.lernhilfe2015ss.DIRTY.graphics.Drawable;

public class Smiley implements Drawable{
	protected int radius;
	protected double eyeRad;
	protected double eyeAngel;
	protected boolean smile;
	protected Point start;
	
	public Smiley(int wigth, boolean smile){
		this.radius=wigth/2;
		eyeRad = radius * 0.75;
		this.eyeAngel = 0;
		this.smile=smile;
		this.start = new Point(20,20);
	}
	
	public Smiley(int wigth, boolean smile, int x, int y){
		this.radius=wigth/2;
		eyeRad = radius * 0.75;
		this.eyeAngel = 0;
		this.smile=smile;
		this.start = new Point(x,y);
	}
	
	public Smiley(int wigth, boolean smile, Point start){
		this.radius=wigth/2;
		eyeRad = radius * 0.75;
		this.eyeAngel = 0;
		this.smile=smile;
		this.start = start;
	}

	public void setRadius(int radius) {
		this.radius = radius;
		eyeRad = radius * 0.75;
	}

	public void setEyeAngel(int eyeAngel) {
		this.eyeAngel = eyeAngel;
	}

	public void setSmile(boolean smile) {
		this.smile = smile;
	}
	
	public void moveRelative(int dx, int dy){
		start.x += dx;
		start.y += dy;
	}
	
	public void setPosition(int x, int y){
		start.x = x;
		start.y = y;
	}

	public void draw(Graphics g){
		Point leftEye = leftEye();
		Point rightEye = rightEye();
		//startpunkt + endpunkt mund(später ändern das es ein polygon werden kann für smile ja/nein
		Point mouthStart = new Point((int)(leftEye.x+eyeRad/2),(int)(start.y+radius*1.5));
		Point mouthEnde = new Point((int)(rightEye.x+eyeRad/2),(int)(start.y+radius*1.5));
		Point leftPupil = leftPupil();
		Point rightPupil = rightPupil();
		drawHead(g,start);
		drawLeftEye(g,leftEye, leftPupil);
		drawRightEye(g,rightEye, rightPupil);
		drawMouth(g,mouthStart,mouthEnde);
	}

	private void drawMouth(Graphics g, Point pAnfang, Point pEnde) {
		g.setColor(Color.RED);
		if(smile){
			int[] xPoints={pAnfang.x,(int)(pAnfang.x+(pEnde.x-pAnfang.x)/6),(int)(pAnfang.x+(pEnde.x-pAnfang.x)/4)+6,
					(int)(pAnfang.x+(pEnde.x-pAnfang.x)/2),(int)(pEnde.x-(pEnde.x-pAnfang.x)/4)-6,(int)(pEnde.x-(pEnde.x-pAnfang.x)/6),pEnde.x};
			int[] yPoints={pAnfang.y,(int)(pEnde.y+eyeRad/3),(int)(pEnde.y+eyeRad/2),(int)(pEnde.y+eyeRad/2),
					(int)(pEnde.y+eyeRad/2),(int)(pEnde.y+eyeRad/3),pEnde.y};
			int nPoints= xPoints.length;
			g.fillPolygon(xPoints, yPoints, nPoints);
		}else{
			Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(8));
            g2.draw(new Line2D.Float(pAnfang.x, pAnfang.y, pEnde.x, pEnde.y));
		}
		
	}

	private void drawRightEye(Graphics g, Point p, Point rightPupil) {
		g.setColor(Color.BLUE);
		g.fillOval(p.x, p.y, (int)(eyeRad), (int)(eyeRad));
		Point rightEyeMiddle = new Point((int)(p.x+eyeRad/4),(int)(p.y+eyeRad/4));
		drawrightPupil(g,rightPupil, rightEyeMiddle);
	}

	private void drawrightPupil(Graphics g, Point p, Point pMiddle) {
		g.setColor(Color.BLACK);
		g.fillOval(p.x+pMiddle.x, p.y+pMiddle.y, (int)(eyeRad/2-eyeRad/10), (int)(eyeRad/2-eyeRad/10));
	}

	private void drawLeftEye(Graphics g, Point p, Point leftPupil) {
		g.setColor(Color.BLUE);
		g.fillOval(p.x, p.y, (int)(eyeRad), (int)(eyeRad));
		Point leftEyeMiddle = new Point((int)(p.x+eyeRad/4),(int)(p.y+eyeRad/4));
		drawLeftPupil(g,leftPupil, leftEyeMiddle);
	}

	private void drawLeftPupil(Graphics g, Point p, Point pMiddle) {
		g.setColor(Color.BLACK);
		g.fillOval(p.x+pMiddle.x, p.y+pMiddle.y, (int)(eyeRad/2-eyeRad/10), (int)(eyeRad/2-eyeRad/10));
	}
	
	private void drawHead(Graphics g, Point p) {
		g.setColor(Color.YELLOW);
		g.fillOval(p.x, p.y, 2*radius, 2*radius);
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
	private Point leftPupil(){
		return new Point((int)(Math.cos(Math.toRadians(eyeAngel))*eyeRad/4),(int)(Math.sin(Math.toRadians(eyeAngel))*eyeRad/4));
	}
	private Point rightPupil(){
		return new Point((int)(Math.cos(Math.toRadians(eyeAngel))*eyeRad/4),(int)(Math.sin(Math.toRadians(eyeAngel))*eyeRad/4));
	}
}
