package a11;

import javax.swing.*;

public class Toolbar extends JToolBar{
    protected JButton button;
    public Toolbar(Controler con) {

        button = new JButton();
        button.setActionCommand(Commands.HAPPY.toString());
        button.addActionListener(con);
        button.setIcon(new ImageIcon("./Test/a11/good4.png"));
        add(button);

        button = new JButton();
        button.setActionCommand(Commands.SAD.toString());
        button.addActionListener(con);
        button.setIcon(new ImageIcon("./Test/a11/weep.png"));
        add(button);

        button = new JButton();
        button.setActionCommand(Commands.PLUS.toString());
        button.addActionListener(con);
        button.setIcon(new ImageIcon("./Test/a11/add182.png"));
        add(button);

        button = new JButton();
        button.setActionCommand(Commands.MINUS.toString());
        button.addActionListener(con);
        button.setIcon(new ImageIcon("./Test/a11/minus75.png"));
        add(button);
    }
}
