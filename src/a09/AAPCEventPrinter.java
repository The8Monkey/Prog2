package a09;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AAPCEventPrinter implements ActionListener, PropertyChangeListener{
    public AAPCEventPrinter(){
        super();
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("AciontEvent!!!");
    }

    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println(evt.getPropertyName()+" old value:"+evt.getOldValue()+" new value:"+evt.getNewValue());
    }
}
