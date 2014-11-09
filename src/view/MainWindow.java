package view;

import java.awt.event.ActionEvent;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;

import com.sun.glass.events.KeyEvent;

public class MainWindow extends JFrame{
	
	private JPanel panel;
	private Menu menu;
	private DocumentView docview;
	
	public MainWindow() {
		this.panel = new JPanel();
		this.menu = new Menu();
		this.docview = new DocumentView();
		
		this.setJMenuBar(this.menu);
		this.createMenus();
		this.menu.newAction();
		
		this.panel.add(docview);
		
		this.add(panel);
		this.setSize(650, 650);
		this.setResizable(false);
		this.setTitle("SheetCreator");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void createMenus() {
		JMenu temp = this.menu.createMenu("Arquivo", KeyEvent.VK_A, "test description");
		LinkedList<Integer> listTemp = new LinkedList<Integer>();
		
		listTemp.add(KeyEvent.VK_N);
		listTemp.add(KeyEvent.VK_N);
		listTemp.add(ActionEvent.CTRL_MASK);
		this.menu.addMenuItem(temp, "Novo Documento", "test description 2", listTemp);
		listTemp.clear();
		
		listTemp.add(KeyEvent.VK_S);
		listTemp.add(KeyEvent.VK_S);
		listTemp.add(ActionEvent.CTRL_MASK);
		this.menu.addMenuItem(temp, "Salvar Documento", "test description 3", listTemp);
		listTemp.clear();
		
		temp = this.menu.createMenu("Editar", KeyEvent.VK_E, "test description 4");
		
		listTemp.add(KeyEvent.VK_W);
		listTemp.add(KeyEvent.VK_W);
		listTemp.add(ActionEvent.CTRL_MASK);
		this.menu.addMenuItem(temp, "Nova Nota", "test description 5", listTemp);
		listTemp.clear();
	}
}
