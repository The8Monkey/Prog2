package a10;

import a08.SmileyModel;
import a09.FirstSmileyPanel;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class SecondGui {
    public static void main(String[] args) {
        int radius=500;
        SmileyModel test = new SmileyModel(radius, true);
        FirstSmileyPanel view = new FirstSmileyPanel(test);
        ButtonPanel bp = new ButtonPanel(new Controler(test));
        JFrame frame = new JFrame("Smiley of DOOM!!!");
        Container container = frame.getContentPane();
        container.setLayout(new BorderLayout());
        container.add(view, BorderLayout.CENTER);
        container.add(bp, BorderLayout.WEST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200,1000);
        frame.setVisible(true);
        int i=0;
        while(true){
            test.rotateEye(i);
            i+=10;
            if(i%90==0){
                test.changeSmile();
                test.setSmile(true);
                //test.setSize(radius+=20);
            }
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
