package a10;

import a08.SmileyModel;
import a09.AAPCEventPrinter;

import javax.swing.*;
import java.awt.*;

public class SecondGui {
    public static void main(String[] args) {
        int size=300;
        SmileyModel test = new SmileyModel(size, true);
        View view = new View(test);
        AAPCEventPrinter aapc = new AAPCEventPrinter();
        test.addPropertyChangeListener(aapc);
        ButtonPanel bp = new ButtonPanel(new Controler(test), new EventPrinter());
        JFrame frame = new JFrame("Smiley of DOOM!!!");
        Container container = frame.getContentPane();
        container.setLayout(new BorderLayout());
        container.add(view, BorderLayout.CENTER);
        container.add(bp, BorderLayout.WEST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200,1000);
        frame.setVisible(true);
    }
}
