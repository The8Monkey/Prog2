package a08.rita;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SmileyModel {

	protected int x;
	protected int y;
	protected int kopfradius;
	protected int augenradius;
	protected double ausrichtung;
	protected boolean smile;
	PropertyChangeEvent evt;
	PropertyChangeSupport pcs;

	public SmileyModel(){
		this(100,100,200,40,180.0,true);
	}

	public SmileyModel(int x, int y, int kopfradius, int augenradius, double ausrichtung, boolean smile){
		this.x = x;
		this.y = y;
		this.kopfradius = kopfradius;
		this.augenradius = augenradius;
		this.ausrichtung = ausrichtung;
		this.smile = smile;
		pcs = new PropertyChangeSupport(this);

	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getKopfradius() {
		return kopfradius;
	}
	public int getAugenradius() {
		return augenradius;
	}
	public double getAusrichtung() {
		return ausrichtung;
	}
	public boolean isSmile() {
		return smile;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setKopfradius(int kopfradius) {
		this.kopfradius = kopfradius;
	}
	public void setAugenradius(int augenradius) {
		this.augenradius = augenradius;
	}
	public void setAusrichtung(double ausrichtung) {
		this.ausrichtung = ausrichtung;
	}
	public void setSmile(boolean smile) {
		this.smile = smile;
	}

	public void wachse(){
		int oldkopfradius = kopfradius;
		kopfradius +=10;
		pcs.firePropertyChange("MODEL_UPDATE", oldkopfradius, kopfradius);
	}
	public void setPupille(double winkel){
		double oldausrichtung = ausrichtung;
		ausrichtung = winkel;
		pcs.firePropertyChange("MODEL_UPDATE", oldausrichtung, ausrichtung);
	}
	public void drehen(){
		double oldausrichtung = ausrichtung;
		ausrichtung += 5.0;
		pcs.firePropertyChange("MODEL_UPDATE", oldausrichtung, ausrichtung);
	}
	public void setSize(int size){
		int oldkopfradius = kopfradius;
		kopfradius = size;
		pcs.firePropertyChange("MODEL_UPDATE", oldkopfradius, kopfradius);
	}

	public void zustandAendern(SmileyView source,Object old, Object neu) {
		evt = new PropertyChangeEvent(source, "MODEL_UPDATE",old, neu);
		pcs = new PropertyChangeSupport(this);
		pcs.firePropertyChange(evt);
	}
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		this.pcs.addPropertyChangeListener(listener);
	}
	public void removePropertyChangeListener(PropertyChangeListener listener){
		this.pcs.removePropertyChangeListener(listener);
	}
}
