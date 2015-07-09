package a11;


import javax.swing.*;

public class Menu extends JMenuBar {
    protected JMenu menu;
    protected JMenuItem menuItem;
    protected JCheckBoxMenuItem cbMenuItem;

    public Menu(Controler con){
        menu = new JMenu("Settings");
        menuItem = new JMenuItem("Augen rollen rechtsrum");
        menuItem.setActionCommand(Commands.AUGENROLLEN_RECHTS.toString());
        menuItem.addActionListener(con);
        menu.add(menuItem);

        menuItem = new JMenuItem("Augen rollen linksrum");
        menuItem.setActionCommand(Commands.AUGENROLLEN_LINKS.toString());
        menuItem.addActionListener(con);
        menu.add(menuItem);

        menu.addSeparator();

        cbMenuItem = new JCheckBoxMenuItem("Smile");
        cbMenuItem.setActionCommand(Commands.SMILE_CHANGE.toString());
        cbMenuItem.addActionListener(con);
        menu.add(cbMenuItem);

        menu.addSeparator();

        menuItem = new JMenuItem("Happy");
        menuItem.setActionCommand(Commands.HAPPY.toString());
        menuItem.addActionListener(con);
        menu.add(menuItem);

        menuItem = new JMenuItem("Sad");
        menuItem.setActionCommand(Commands.SAD.toString());
        menuItem.addActionListener(con);
        menu.add(menuItem);
        add(menu);
    }
}
