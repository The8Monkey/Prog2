package a08.anthony;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SmileyModel {

    protected int x;
    protected int y;
    protected int radius;
    protected int angleOfEyes;
    protected boolean smileStatus;
    protected boolean gridOnOff;
    protected PropertyChangeSupport support;

    public SmileyModel(int x, int y, int radius, int angleOfEyes, boolean smileStatus, boolean gridOnoff){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.smileStatus = smileStatus;
        this.gridOnOff = gridOnoff;
        this.angleOfEyes = angleOfEyes;
        support = new PropertyChangeSupport(this);
    }

    public SmileyModel(){
        this(0, 0, 150, 90, true, false);
    }

    //___________GETTER_________________
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getRadius(){
        return radius;
    }

    public int getAngleOfEyes(){
        return angleOfEyes;
    }

    public boolean getSmileStatus(){
        return smileStatus;
    }

    public boolean getGridOnOff(){
        return gridOnOff;
    }

//________________SETTER____________________

    public void setRadius(int radius){
        this.radius = radius;
    }

    public void setPosition(int newX, int newY){
        int oldX = x;
        x = newX;
        int oldY = y;
        newY = y;
        support.firePropertyChange("MODAL_UPDATE", oldX, newX);
        support.firePropertyChange("MODAL_UPDATE", oldY, newY);
    }

    public void setX(int newX){
        int oldx = x;
        x = newX;
        support.firePropertyChange("MODEL_UPDATE", oldx, x);
    }
    public void setPupile(int winkel){
        int oldwinkel = angleOfEyes;
        angleOfEyes = winkel;
        support.firePropertyChange("MODEL_UPDATE", oldwinkel, angleOfEyes);

    }

    public void setAngleOfEyes(int newAngle){
        int oldAngle = angleOfEyes;
        angleOfEyes = newAngle;
        support.firePropertyChange("MODEL_UPDATE", oldAngle, newAngle);

    }

    public void setSmileStatus(boolean newSmileStatus){
        boolean oldSmileStatus = smileStatus;
        smileStatus = newSmileStatus;
        support.firePropertyChange("MODEL_UPDATE", oldSmileStatus, smileStatus);
    }

    public void moveRealativ(int newX, int newY){
        int oldX = x;
        x += newX;
        int oldY = y;
        y += newY;
        support.firePropertyChange("MODAL_UPDATE", oldX, x);
        support.firePropertyChange("MODAL_UPDATE", oldY, y);
    }


    public void addPropertyChangeListener(PropertyChangeListener listener){
        support.addPropertyChangeListener(listener);
    }
}
