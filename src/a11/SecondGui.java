package a11;

import a08.SmileyModel;
import a09.AAPCEventPrinter;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class SecondGui {
    public static void main(String[] args) {
        int size=300;
        ResourceBundle rb = ResourceBundle.getBundle("text",new Locale("de"));
        SmileyModel model = new SmileyModel(size, true);
        View view = new View(model);
        AAPCEventPrinter aapc = new AAPCEventPrinter();
        model.addPropertyChangeListener(aapc);
        Controler con = new Controler(model);
        ButtonPanel bp = new ButtonPanel(con, new EventPrinter(),rb);
        JFrame frame = new JFrame("Smiley of DOOM!!!");
        Container container = frame.getContentPane();
        container.setLayout(new BorderLayout());
        container.add(view, BorderLayout.CENTER);
        container.add(bp, BorderLayout.WEST);
        container.add(new Toolbar(con),BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(new Menu(con,rb));
        frame.setSize(800,600);
        frame.setVisible(true);
    }
}
