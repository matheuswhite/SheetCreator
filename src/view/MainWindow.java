package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class MainWindow extends JFrame{
	
	private JPanel panel;
	private Menu menu;
	private DocumentView docview;
	
	public MainWindow() {
		this.panel = new JPanel();
		this.menu = new Menu();
		this.docview = new DocumentView();
		
		this.setJMenuBar(this.menu);
		this.panel.add(docview, BorderLayout.LINE_START);
		
		this.add(panel);
		this.setSize(750, 550);
		this.setResizable(false);
		this.setTitle("SheetCreator");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
