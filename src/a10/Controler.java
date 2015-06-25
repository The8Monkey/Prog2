package a10;

import a08.SmileyModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controler implements ActionListener{
    private static boolean rollright;
    SmileyModel model;
    public Controler(SmileyModel model){
        this.model=model;
        rollright=true;
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case Commands.KOPFRADIUS_CHANGE:

            case Commands.AUGENROLLEN_RECHTS:
                rollright=true;
                model.setRoll(true);
                //while (rollright) {
                    model.rotateEye(model.getEyeAngel()+10);
                //}
            case Commands.AUGENROLLEN_LINKS:
                rollright=false;
                model.setRoll(false);
                //while (!rollright) {
                    model.rotateEye(model.getEyeAngel()+10);
                //}
            case Commands.SMILE_CHANGE:
                model.changeSmile();
            case Commands.HAPPY:

            case Commands.SAD:
        }
    }
}
