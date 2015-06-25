package a10;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel{
    protected JTextField headSize;
    protected JTextField eyeRad;
    protected JTextField eyeAngle;
    protected JCheckBox smile;
    protected JButton happy;
    protected JButton sad;

     public ButtonPanel(Controler controler){
         headSize =  new JTextField("Kopfgröße");
         headSize.setActionCommand(Commands.KOPFRADIUS_CHANGE);
         eyeRad =  new JTextField("Augenradius");
         eyeRad.setActionCommand(Commands.AUGENRADIUS_CHANGE);
         eyeAngle =  new JTextField("Augenwinkel");
         eyeAngle.setActionCommand(Commands.AUGEN_AUSRICHTUNG_CHANGE);
         smile =  new JCheckBox();
         smile.setActionCommand(Commands.SMILE_CHANGE);
         happy = new JButton("Zufrieden");
         happy.setActionCommand(Commands.HAPPY);
         sad = new JButton("Traurig");
         sad.setActionCommand(Commands.SAD);

         headSize.addActionListener(controler);
         eyeRad.addActionListener(controler);
         eyeAngle.addActionListener(controler);
         smile.addActionListener(controler);
         happy.addActionListener(controler);
         sad.addActionListener(controler);

         setLayout(new GridLayout(6, 0));
         add(headSize);
         add(eyeRad);
         add(eyeAngle);
         add(smile);
         add(happy);
         add(sad);
     }
}
