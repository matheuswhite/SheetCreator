package view;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;

import view.popUpMenus.NewDocument;

import com.sun.xml.internal.ws.api.server.Container;

public class Menu extends JMenuBar {
	private LinkedList<JMenuItem> itens;
	private LinkedList<JMenu> menus;
	
	public Menu() {
		this.itens = new LinkedList<JMenuItem>();
		this.menus = new LinkedList<JMenu>();
		
	}
	
	public JMenu createMenu(String name, int keyAction, String description) {
		JMenu temp = new JMenu(name);
		temp.setMnemonic(keyAction);
		temp.getAccessibleContext().setAccessibleDescription(description);
		this.add(temp);
		this.menus.add(temp);
		
		return temp;
	}
	
	public void addMenuItem(JMenu menu, String name, String description, LinkedList<Integer> keyAction) {
		JMenuItem temp = new JMenuItem(name ,keyAction.get(0));
		
		if(keyAction.get(2) != null) {
			temp.setAccelerator(KeyStroke.getKeyStroke(keyAction.get(1), keyAction.get(2)));
		}
		
		temp.getAccessibleContext().setAccessibleDescription(description);
		
		menu.add(temp);
		this.itens.add(temp);
	}
	
	public void newAction() {
		itens.get(0).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				NewDocument newDoc = new NewDocument();
			}
		});
		
		
	}
}
