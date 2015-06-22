package a09;

import a08.SmileyModel;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class FirstGui {
    public static void main(String[] args) {
        int radius=500;
        SmileyModel test = new SmileyModel(radius, true);
        FirstSmileyPanel view = new FirstSmileyPanel(test);
        AAPCEventPrinter ep = new AAPCEventPrinter(test);
        JFrame frame = new JFrame("Smiley of DOOM!!!");
        Container container = frame.getContentPane();
        container.add(view);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setVisible(true);
        int i=0;
        while(true){
            test.rotateEye(i);
            i+=10;
            if(i%90==0){
                if(test.isSmile()){
                    test.setSmile(false);
                    continue;
                }
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
