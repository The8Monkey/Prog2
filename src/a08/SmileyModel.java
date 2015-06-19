package a08;

import java.awt.Point;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SmileyModel{
	protected int radius;
	protected double eyeRad;
	protected double eyeAngel;
	protected boolean smile;
	protected Point start;
	protected final PropertyChangeSupport pcs;
	protected final String MODEL_UPDATED;	

	public SmileyModel(int size, boolean smile){
		this.radius=size/2;
		eyeRad = radius * 0.75;
		this.eyeAngel = 0;
		this.smile=smile;
		this.start = new Point(20,20);
		this.pcs = new PropertyChangeSupport(this);
		MODEL_UPDATED = "MODEL_UPDATED";
	}
	
	public SmileyModel(int size, boolean smile, int x, int y){
		this(size, smile);
		this.start = new Point(x,y);
	}
	
	public SmileyModel(int size, boolean smile, Point start){
		this(size,smile);
		this.start = start;
	}

	public int getRadius() {
		return radius;
	}

	public double getEyeRad() {
		return eyeRad;
	}

	public double getEyeAngel() {
		return eyeAngel;
	}

	public boolean isSmile() {
		return smile;
	}

	public Point getStart() {
		return start;
	}
	
	public void setSize(int size) {
		pcs.firePropertyChange(MODEL_UPDATED, radius, size/2);
		radius = size/2;
		setEyeRad(radius * 0.75);
		
	}

	public void setEyeRad(double eyeRad) {
		pcs.firePropertyChange(MODEL_UPDATED, this.eyeRad, eyeRad);
		this.eyeRad = eyeRad;
	}

	public void rotateEye(double eyeAngel) {
		pcs.firePropertyChange(MODEL_UPDATED, this.eyeAngel, eyeAngel);
		this.eyeAngel = eyeAngel;
	}

	public void setSmile(boolean smile) {
		pcs.firePropertyChange(MODEL_UPDATED, this.smile, smile);
		this.smile = smile;
	}
	
	public void moveRelative(int dx, int dy){
		pcs.firePropertyChange(MODEL_UPDATED, start.x+start.y, dx+dy);
		start.x += dx;
		start.y += dy;
	}
	
	public void setPosition(int x, int y){
		pcs.firePropertyChange(MODEL_UPDATED, start.x+start.y, x+y);
		start.x = x;
		start.y = y;
	}
	
	public void changeSmile(){
		smile = !smile;
	}
	public void addPropertyChangeListener(PropertyChangeListener l) {
        pcs.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        pcs.removePropertyChangeListener(l);
    }
}
