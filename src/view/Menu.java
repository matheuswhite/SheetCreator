package view;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import br.ufal.ic.sheetCreator.PlayerSong;
import view.popUpMenus.NewDocument;
import view.popUpMenus.NewNote;
import view.popUpMenus.OpenDocument;
import view.popUpMenus.SaveDocument;

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
	
	public void newAction(DocumentView docview, PlayerSong player) {
		itens.get(0).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				NewDocument newDoc = new NewDocument(docview);
			}
		});
		
		itens.get(1).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				SaveDocument save = new SaveDocument();
			}
		});
		
		itens.get(2).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				OpenDocument open = new OpenDocument();
			}
		});
		
		itens.get(3).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				NewNote newnote = new NewNote();
			}
		});
		
		itens.get(4).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//deletar nota
			}
		});
		
		itens.get(5).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				docview.nextPage();
			}
		});
		
		itens.get(6).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				docview.prevPage();
			}
		});
		
		itens.get(7).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//desfazer
			}
		});
		
		itens.get(8).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//play music
			}
		});
	}
}
