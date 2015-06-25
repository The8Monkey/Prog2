package a10;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel{
    protected JTextField headSize;
    protected JButton rechts;
    protected JButton links;
    protected JCheckBox smile;
    protected JButton happy;
    protected JButton sad;

     public ButtonPanel(Controler controler){
         headSize =  new JTextField("Kopfgroesse");
         headSize.setActionCommand(Commands.KOPFRADIUS_CHANGE);
         rechts =  new JButton("Augen Rollen rechtsrum");
         rechts.setActionCommand(Commands.AUGENROLLEN_RECHTS);
         links =  new JButton("Augen Rollen linksrum");
         links.setActionCommand(Commands.AUGENROLLEN_LINKS);
         smile =  new JCheckBox("Laecheln");
         smile.setActionCommand(Commands.SMILE_CHANGE);
         happy = new JButton("Zufrieden");
         happy.setActionCommand(Commands.HAPPY);
         sad = new JButton("Traurig");
         sad.setActionCommand(Commands.SAD);

         headSize.addActionListener(controler);
         rechts.addActionListener(controler);
         links.addActionListener(controler);
         smile.addActionListener(controler);
         happy.addActionListener(controler);
         sad.addActionListener(controler);

         setLayout(new GridLayout(6, 0));
         add(headSize);
         add(rechts);
         add(links);
         add(smile);
         add(happy);
         add(sad);
     }
}
