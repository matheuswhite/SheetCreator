package view;

import java.awt.Component;


import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;

import br.ufal.ic.sheetCreator.IDocument;
import br.ufal.ic.sheetCreator.factory.ClassicalDocumentFactory;
import br.ufal.ic.sheetCreator.factory.DocumentFactory;

public class MainWindow extends JFrame{
	
	private Menu menu;
	private DocumentView docview;
	private IDocument doc;
	private DocumentFactory docfactory;
	
	public MainWindow() {
		this.menu = new Menu();
		this.docview = new DocumentView();
		//this.docfactory = new ClassicalDocumentFactory();
		
		//this.doc = this.docfactory.createDocument("Musica 1", "Matheus Ten�rio");
		
		this.setJMenuBar(this.menu);
		this.createMenus();
		this.menu.newAction();
		
		this.getContentPane().add(docview);
		this.setSize(650, 650);
		this.setResizable(false);
		this.setTitle("SheetCreator");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	//remover os 'KeyEvents'.
	//aparentemente não funcionam no linux
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
