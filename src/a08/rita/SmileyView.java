
package a08.rita;

import java.awt.Graphics;
import java.awt.Point;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import schimkat.berlin.lernhilfe2015ss.DIRTY.graphics.Drawable;

public class SmileyView extends JPanel implements Drawable, PropertyChangeListener {

	protected static int x;
	protected static int y;
	protected static int kopfradius;
	protected static int augenradius;
	protected static double ausrichtung;
	protected static boolean smile;
	protected SmileyModel model;

	public SmileyView(SmileyModel model){
		x = model.getX();
		y = model.getY();
		kopfradius = model.getKopfradius();
		augenradius = model.getAugenradius();
		ausrichtung = model.getAusrichtung();
		smile = model.isSmile();
		model.addPropertyChangeListener(this);
		this.model = model;
	}
	public void draw(Graphics g){
        GeoUtil gu = new GeoUtil();
		gu.drawFace(g);
		gu.drawEyes(g);
		gu.drawEyeball(g);
		gu.drawMouth(g);
	}
/*	public void moveRelativ(int dx, int dy){
		SmileyView.x = x+dx;
		SmileyView.y = y+dy;
	}
	public void setPosition(int x, int y){
		SmileyView.x = x;
		SmileyView.y = y;
	}*/
	public void propertyChange(PropertyChangeEvent pce){
		if(pce.getPropertyName().equals("MODEL_UPDATE")){
			x = model.getX();
			y = model.getY();
			kopfradius = model.getKopfradius();
			augenradius = model.getAugenradius();
			ausrichtung = model.getAusrichtung();
			smile = model.isSmile();
			repaint();
		}
	}
//	public static void setX(int x) {
//		SmileyView.x = x;
//	}
//	public void setY(int y) {
//		SmileyView.y = y;
//	}
//	public static void setKopfradius(int kopfradius) {
//		SmileyView.kopfradius = kopfradius;
//	}
//	public static void setAugenradius(int augenradius) {
//		SmileyView.augenradius = augenradius;
//	}
//	public static void setAusrichtung(double ausrichtung) {
//		SmileyView.ausrichtung = ausrichtung;
//	}
//	public static void setSmile(boolean smile) {
//		SmileyView.smile = smile;
//	}

	public class GeoUtil{

		int aradius;
		Point linkesAuge;
		Point rechtesAuge;
		int augapfel;
		Point ldrehzentrum;
		Point rdrehzentrum;

        public GeoUtil(){
            super();
        }

        public void createAtributs() {
            aradius = (int) (((augenradius/100.0)*(kopfradius*2))/2.0);
            linkesAuge = createLinkesAuge(x, y, aradius, kopfradius);
            rechtesAuge = createRechtesAuge(x, y, aradius, kopfradius);
            augapfel = (int)((40.0/100.0)*aradius);
            ldrehzentrum = new Point((int)(linkesAuge.getX()+aradius),(int)(linkesAuge.getY()+aradius));
            rdrehzentrum = new Point((int)(rechtesAuge.getX()+aradius),(int)(rechtesAuge.getY()+aradius));
        }
		public Point createLinkesAuge(int x, int y,int aradius, int kopfradius){
			return new Point(x+kopfradius-(aradius*2), y+kopfradius-(aradius*2));
		}
		public Point createRechtesAuge(int x, int y, int aradius, int kopfradius){
			return new Point(x+kopfradius, y+kopfradius-(aradius*2));
		}
		public Point createPunktRelativZu(Point drehzentrum, double winkel, double aradius,int augapfel){
			int abstand = (int)((60.0/100.0)*aradius);
			double bogenmas = (Math.PI / 180) * winkel;
			return new Point((int)(drehzentrum.getX()+(Math.cos(bogenmas)* abstand)-1.0/2.0*augapfel),(int)(drehzentrum.getY()+(Math.sin(bogenmas)* abstand)-1.0/2.0*augapfel));
		}
		public void drawEyes(Graphics g){
			g.drawOval((int)linkesAuge.getX(),(int)linkesAuge.getY(), aradius*2, aradius*2);
			g.drawOval((int)rechtesAuge.getX(), (int)rechtesAuge.getY(), aradius*2, aradius*2);
		}

		public void drawEyeball(Graphics g){
			Point lp = createPunktRelativZu(ldrehzentrum, ausrichtung, aradius, augapfel);
			g.drawOval((int)(lp.getX()),(int)(lp.getY()), augapfel, augapfel);
			Point rp = createPunktRelativZu(rdrehzentrum, ausrichtung, aradius, augapfel);
			g.drawOval((int)(rp.getX()), (int)(rp.getY()), augapfel, augapfel);
		}
		public void drawMouth(Graphics g){
			if(smile){
				g.drawArc((int)(linkesAuge.getX()), (int)(linkesAuge.getY()+(1.0/2.0*aradius)), (int)(rechtesAuge.getX()+aradius*2-rechtesAuge.getY()), (int)(rechtesAuge.getY()+(1.0/2.0*aradius)),0,-180);
			}else{
				g.drawArc((int)(linkesAuge.getX()), (int)(linkesAuge.getY()+(2*aradius)), (int)(rechtesAuge.getX()+aradius*2-rechtesAuge.getY()), (int)(rechtesAuge.getY()+(2*aradius)),40,100);
			}
		}
		public void drawFace(Graphics g){
            createAtributs();
			g.drawOval(x,y,kopfradius*2,kopfradius*2);
		}
	}
}
