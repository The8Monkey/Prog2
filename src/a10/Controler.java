package a10;

import a08.SmileyModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controler implements ActionListener{
    SmileyModel model;
    public Controler(SmileyModel model){
        this.model=model;
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case Commands.KOPFRADIUS_CHANGE:

            case Commands.AUGENRADIUS_CHANGE:

            case Commands.AUGEN_AUSRICHTUNG_CHANGE:

            case Commands.SMILE_CHANGE:

            case Commands.HAPPY:

            case Commands.SAD:
        }
    }
}
