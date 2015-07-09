package a11;


import javax.swing.*;
import java.util.ResourceBundle;

public class Menu extends JMenuBar {
    protected JMenu menu;
    protected JMenuItem menuItem;
    protected JCheckBoxMenuItem cbMenuItem;

    public Menu(Controler con, ResourceBundle rb){
        menu = new JMenu(rb.getString("menu"));
        menuItem = new JMenuItem(rb.getString("eyerollright"));
        menuItem.setActionCommand(Commands.AUGENROLLEN_RECHTS.toString());
        menuItem.addActionListener(con);
        menu.add(menuItem);

        menuItem = new JMenuItem(rb.getString("eyerollleft"));
        menuItem.setActionCommand(Commands.AUGENROLLEN_LINKS.toString());
        menuItem.addActionListener(con);
        menu.add(menuItem);

        menu.addSeparator();

        cbMenuItem = new JCheckBoxMenuItem(rb.getString("smile"));
        cbMenuItem.setActionCommand(Commands.SMILE_CHANGE.toString());
        cbMenuItem.addActionListener(con);
        menu.add(cbMenuItem);

        menu.addSeparator();

        menuItem = new JMenuItem(rb.getString("happy"));
        menuItem.setActionCommand(Commands.HAPPY.toString());
        menuItem.addActionListener(con);
        menu.add(menuItem);

        menuItem = new JMenuItem(rb.getString("sad"));
        menuItem.setActionCommand(Commands.SAD.toString());
        menuItem.addActionListener(con);
        menu.add(menuItem);
        add(menu);
    }
}
