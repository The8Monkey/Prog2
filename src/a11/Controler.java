package a11;

import a08.SmileyModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controler implements ActionListener{
    protected static boolean rollright;
    protected SmileyModel model;
    protected double eyeSize;
    protected JTextField jtf;
    protected String text;
    protected int number;
    
    public Controler(SmileyModel model){
        this.model=model;
        eyeSize=model.getEyeRad();
        rollright=true;
    }

    public void actionPerformed(ActionEvent e) {
        Commands c = Commands.valueOf(e.getActionCommand());
        switch (c) {
            case KOPFRADIUS_CHANGE:
                jtf= (JTextField) e.getSource();
                text = jtf.getText();
                if (text.isEmpty()){
                    model.setSize(model.getRadius()*2);
                }
                try {
                    number = Integer.parseInt(text);
                }catch (NumberFormatException ex){
                    ex.printStackTrace();
                    number = 0;
                    break;
                }
                if(number < 150){
                    model.setSize(150*2);
                }
                else if(number >2000){
                    model.setSize(2000*2);
                }else{
                    model.setSize(number*2);
                }
                eyeSize=model.getEyeRad();
                break;
            case AUGENROLLEN_RECHTS:
                rollright=true;
                model.setRoll(true);
                model.rotateEye(model.getEyeAngel()+10);
                break;
            case AUGENROLLEN_LINKS:
                rollright=false;
                model.setRoll(false);
                model.rotateEye(model.getEyeAngel() + 10);
                break;
            case SMILE_CHANGE:
                model.changeSmile();
                break;
            case HAPPY:
                model.setSmile(true);
                model.setEyeRad(eyeSize+15);
                break;
            case SAD:
                model.setSmile(false);
                model.setEyeRad(eyeSize-15);
                break;
            case PLUS:
                if(model.getRadius()+10 >2000){
                    model.setSize(2000*2);
                }else{
                    model.setSize((model.getRadius()+10)*2);
                }
                eyeSize=model.getEyeRad();
                break;
            case MINUS:
                if(model.getRadius()-10 <150){
                    model.setSize(150*2);
                }else{
                    model.setSize((model.getRadius()-10)*2);
                }
                eyeSize=model.getEyeRad();
                break;
        }
    }
}
