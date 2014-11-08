package view;

import java.awt.event.ActionEvent;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

import com.sun.glass.events.KeyEvent;

public class Menu extends JMenuBar {
	private JMenuItem button;
	private JMenu menu, submenu;
	
	public Menu() {
		this.menu = new JMenu("Arquivo");
		this.menu.setMnemonic(KeyEvent.VK_A);
		this.menu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");		
		this.add(menu);
		
		this.button = new JMenuItem("Novo", KeyEvent.VK_N);
		this.button.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.ALT_MASK));
		this.button.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
		this.menu.add(button);
	}
}
