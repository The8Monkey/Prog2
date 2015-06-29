package a10;

import a08.SmileyModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controler implements ActionListener{
    protected static boolean rollright;
    SmileyModel model;
    double eyeSize;
    public Controler(SmileyModel model){
        this.model=model;
        eyeSize=model.getEyeRad();
        rollright=true;
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case Commands.KOPFRADIUS_CHANGE:
                System.out.println(e.getSource());
                break;
            case Commands.AUGENROLLEN_RECHTS:
                rollright=true;
                model.setRoll(true);
                model.rotateEye(model.getEyeAngel()+10);
                break;
            case Commands.AUGENROLLEN_LINKS:
                rollright=false;
                model.setRoll(false);
                model.rotateEye(model.getEyeAngel() + 10);
                break;
            case Commands.SMILE_CHANGE:
                model.changeSmile();
                break;
            case Commands.HAPPY:
                model.setSmile(true);
                model.setEyeRad(eyeSize+15);
                break;
            case Commands.SAD:
                model.setSmile(false);
                model.setEyeRad(eyeSize-15);
                break;
        }
    }
}
