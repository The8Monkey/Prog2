package a10;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel{
    protected JLabel label;
    protected JTextField headSize;
    protected JButton rechts;
    protected JButton links;
    protected JButton stop;
    protected JCheckBox smile;
    protected JButton happy;
    protected JButton sad;

    public ButtonPanel(Controler controler, EventPrinter ep){
        label = new JLabel("Kopfgroesse in Int");
        headSize =  new JTextField(5);
        headSize.setActionCommand(Commands.KOPFRADIUS_CHANGE);
        rechts =  new JButton("Augen rollen rechtsrum");
        rechts.setActionCommand(Commands.AUGENROLLEN_RECHTS);
        links =  new JButton("Augen rollen linksrum");
        links.setActionCommand(Commands.AUGENROLLEN_LINKS);
        stop= new JButton("Stop Augen");
        smile =  new JCheckBox("Laecheln");
        smile.setActionCommand(Commands.SMILE_CHANGE);
        happy = new JButton("Zufrieden");
        happy.setActionCommand(Commands.HAPPY);
        sad = new JButton("Traurig");
        sad.setActionCommand(Commands.SAD);

        Timer leftTurn =new Timer(0,controler);
        leftTurn.setActionCommand(Commands.AUGENROLLEN_LINKS);
        leftTurn.setDelay(20);

        Timer rightTurn =new Timer(0,controler);
        rightTurn.setActionCommand(Commands.AUGENROLLEN_RECHTS);
        rightTurn.setDelay(20);

        links.addActionListener(e -> {
            rightTurn.stop();
            leftTurn.start();
        });

        rechts.addActionListener(e -> {
            leftTurn.stop();
            rightTurn.start();
        });

        stop.addActionListener(e -> {
            leftTurn.stop();
            rightTurn.stop();
        });

        headSize.addActionListener(controler);
        rechts.addActionListener(controler);
        links.addActionListener(controler);
        smile.addActionListener(controler);
        happy.addActionListener(controler);
        sad.addActionListener(controler);

        headSize.addActionListener(ep);
        rechts.addActionListener(ep);
        links.addActionListener(ep);
        smile.addActionListener(ep);
        happy.addActionListener(ep);
        sad.addActionListener(ep);

        setLayout(new GridLayout(8, 0));
        add(label);
        add(headSize);
        add(rechts);
        add(links);
        add(stop);
        add(smile);
        add(happy);
        add(sad);
    }
}
