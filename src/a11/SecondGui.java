package a11;

import a08.SmileyModel;
import a09.AAPCEventPrinter;

import javax.swing.*;
import java.awt.*;

public class SecondGui {
    public static void main(String[] args) {
        int size=300;
        SmileyModel model = new SmileyModel(size, true);
        View view = new View(model);
        AAPCEventPrinter aapc = new AAPCEventPrinter();
        model.addPropertyChangeListener(aapc);
        Controler con = new Controler(model);
        ButtonPanel bp = new ButtonPanel(con, new EventPrinter());
        JFrame frame = new JFrame("Smiley of DOOM!!!");
        Container container = frame.getContentPane();
        container.setLayout(new BorderLayout());
        container.add(view, BorderLayout.CENTER);
        container.add(bp, BorderLayout.WEST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(new Menu(con));
        frame.setSize(800,600);
        frame.setVisible(true);
    }
}
