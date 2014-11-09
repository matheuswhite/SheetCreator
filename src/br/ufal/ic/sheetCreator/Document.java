package br.ufal.ic.sheetCreator;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import br.ufal.ic.sheetCreator.decorator.MusicalStaff;

public abstract class Document extends JPanel implements IDocument {
	
	private int[] position;
	private JLabel title;
	private JLabel author;
	private JTextArea editTitle;
	
	private JLabel firstStaff;
	private JLabel secondStaff;
	private JLabel thirdStaff;
	private JLabel fourthStaff;
	
	public Document(String title, String author, ArrayList<MusicalStaff> staffs) {
		this.setLayout(null);
		this.position = new int[1];
		
		this.setTitle(title);
		this.setAutor(author);
		this.setStaffs(staffs);
	}
	
	public abstract void setStaffs(ArrayList<MusicalStaff> staffs);
	
	public void setTitle(String title) {
		if(title == null) {
			this.title = new JLabel("Sem Título");
		}
		else {
			this.title = new JLabel(title);
		}
	}
	
	public void setAutor(String author) {
		if(author == null) {
			this.author = new JLabel("Sem Título");
		}
		else {
			this.author = new JLabel(author);
		}
	}
}
