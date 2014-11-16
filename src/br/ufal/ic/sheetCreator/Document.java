package br.ufal.ic.sheetCreator;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import br.ufal.ic.sheetCreator.decorator.Decorator;
import br.ufal.ic.sheetCreator.decorator.Flag;
import br.ufal.ic.sheetCreator.decorator.MusicalStaff;
import br.ufal.ic.sheetCreator.decorator.Notes;
import br.ufal.ic.sheetCreator.factory.Factory;
import br.ufal.ic.sheetCreator.factory.WholeNoteFactory;

public abstract class Document extends JPanel implements IDocument {
	
	private JLabel title;
	private JLabel author;
	private Font auxfont;
	private String auxstring;
	private int titleWidth;
	private int titleCoordinate_x;
	private int titleCoordinate_y;
	
	private ArrayList<MusicalStaff> staffs;
	public static final int TYPE_NOTE = 2;
	
	public Document(String title, String author, ArrayList<MusicalStaff> staffs) {
		this.setLayout(null);
		this.staffs = staffs;
		this.titleWidth = 34;
		
		this.titleCoordinate_x = 20;
		this.titleCoordinate_y = 5;
		
		this.setBackground(Color.WHITE);
		
		this.setTitle(title);
		this.setAuthor(author);
		this.setStaffs(staffs);
	}
	
	public abstract void setStaffs(ArrayList<MusicalStaff> staffs);
	
	public ArrayList<MusicalStaff> getStaffs() {
		return this.staffs;
	}
	
	@Override
	public void setTitle(String title) {
		if(title == null || title == "") {
			title = "Sem Titulo";
		}
		
		this.title = new JLabel(title);
		this.title.setSize(500, 50);
		this.title.setLocation(titleCoordinate_x, titleCoordinate_y);
		this.title.setFont(new Font("Arial", Font.PLAIN, this.titleWidth));
		this.add(this.title);
	}
	
	@Override
	public void setAuthor(String author) {
		if(author == null || author == "") {
			author = "Sem Autor";
		}
		
		this.author = new JLabel(author);
		this.author.setSize(500, 50);
		this.author.setLocation(titleCoordinate_x, titleCoordinate_y + 35);
		this.author.setFont(new Font("Arial", Font.PLAIN, (this.titleWidth / 2) ));
		this.add(this.author);
	}
	
	@Override
	public Decorator addNote(int currentStaff, ArrayList<Flag> currrentPosition) {
		MusicalStaff staff = this.staffs.get(currentStaff);
		int pos_x = staff.getMyPositionX();
		int pos_y = staff.getMyPositionY();
		Factory factory = null;
		
		if(currrentPosition.get(Document.TYPE_NOTE).equals(Flag.WHOLE_NOTE)) {
			factory = new WholeNoteFactory();
		}
		
		currrentPosition.remove(Document.TYPE_NOTE);
		
		Decorator note = factory.createDecoratorItem(staff, pos_x, pos_y, currrentPosition);
		
		this.add(note.getLabel());
		
		return note;
	}
	
	@Override
	public Decorator delNote() {
		// TODO Auto-generated method stub
		return null;
	}
}
