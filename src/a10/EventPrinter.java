package a10;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventPrinter implements ActionListener{
    public EventPrinter(){
        super();
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }
}