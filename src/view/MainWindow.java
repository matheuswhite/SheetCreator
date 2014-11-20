package view;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;

import br.ufal.ic.sheetCreator.PlayerSong;

public class MainWindow extends JFrame{
	
	private Menu menu;
	private DocumentView docview;
	private PlayerSong player;
	
	public MainWindow() {
		this.menu = new Menu();
		this.docview = new DocumentView(this);
		this.player = new PlayerSong();
		
		this.setJMenuBar(this.menu);
		this.createMenus();
		this.menu.newAction(this.docview, this.player);
		
		this.getContentPane().add(docview);
		this.setSize(650, 650);
		this.setResizable(false);
		this.setLocation(50, 50);
		this.setTitle("SheetCreator");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public PlayerSong getPlayer() {
		return this.player;
	}
	
	public void createMenus() {
		LinkedList<Integer> listTemp = new LinkedList<Integer>();
		
		
		/*Arquivo*/
		JMenu temp = this.menu.createMenu("Arquivo", KeyEvent.VK_A, "");
		
		listTemp.add(KeyEvent.VK_N);
		listTemp.add(KeyEvent.VK_N);
		listTemp.add(ActionEvent.CTRL_MASK);
		this.menu.addMenuItem(temp, "Novo Documento", "", listTemp);
		listTemp.clear();
		
		listTemp.add(KeyEvent.VK_S);
		listTemp.add(KeyEvent.VK_S);
		listTemp.add(ActionEvent.CTRL_MASK);
		this.menu.addMenuItem(temp, "Salvar Documento", "", listTemp);
		listTemp.clear();
		
		listTemp.add(KeyEvent.VK_O);
		listTemp.add(KeyEvent.VK_O);
		listTemp.add(ActionEvent.CTRL_MASK);
		this.menu.addMenuItem(temp, "Abrir Documento", "", listTemp);
		listTemp.clear();
		
		/*Editar*/
		
		temp = this.menu.createMenu("Editar", KeyEvent.VK_E, "");
		
		listTemp.add(KeyEvent.VK_W);
		listTemp.add(KeyEvent.VK_W);
		listTemp.add(ActionEvent.CTRL_MASK);
		this.menu.addMenuItem(temp, "Nova Nota", "", listTemp);
		listTemp.clear();
		
		/*Navegacao*/
		temp = this.menu.createMenu("Navegacao", KeyEvent.VK_V, "");
		
		listTemp.add(KeyEvent.VK_RIGHT);
		listTemp.add(KeyEvent.VK_RIGHT);
		listTemp.add(ActionEvent.CTRL_MASK);
		this.menu.addMenuItem(temp, "Proxima Pagina", "", listTemp);
		listTemp.clear();
		
		listTemp.add(KeyEvent.VK_LEFT);
		listTemp.add(KeyEvent.VK_LEFT);
		listTemp.add(ActionEvent.CTRL_MASK);
		this.menu.addMenuItem(temp, "Pagina Anterior", "", listTemp);
		listTemp.clear();
		
		listTemp.add(KeyEvent.VK_Z);
		listTemp.add(KeyEvent.VK_Z);
		listTemp.add(ActionEvent.CTRL_MASK);
		this.menu.addMenuItem(temp, "Desfazer", "", listTemp);
		listTemp.clear();
		
		/*Player*/
		temp = this.menu.createMenu("Player", KeyEvent.VK_Y, "");
		
		listTemp.add(KeyEvent.VK_P);
		listTemp.add(KeyEvent.VK_P);
		listTemp.add(ActionEvent.CTRL_MASK);
		this.menu.addMenuItem(temp, "Play!", "", listTemp);
		listTemp.clear();
		
	}
}
