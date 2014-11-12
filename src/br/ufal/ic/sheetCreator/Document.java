package br.ufal.ic.sheetCreator;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import br.ufal.ic.sheetCreator.decorator.Decorator;
import br.ufal.ic.sheetCreator.decorator.Flag;
import br.ufal.ic.sheetCreator.decorator.MusicalStaff;
import br.ufal.ic.sheetCreator.decorator.Notes;
import br.ufal.ic.sheetCreator.factory.Factory;
import br.ufal.ic.sheetCreator.factory.WholeNoteFactory;

public abstract class Document extends JPanel implements IDocument {
	
	private JLabel title;
	private JLabel author;
	
	private ArrayList<MusicalStaff> staffs;
	public static final int TYPE_NOTE = 2;
	
	public Document(String title, String author, ArrayList<MusicalStaff> staffs) {
		this.setLayout(null);
		this.staffs = staffs;
		
		this.setTitle(title);
		this.setAuthor(author);
		this.setStaffs(staffs);
	}
	
	public abstract void setStaffs(ArrayList<MusicalStaff> staffs);
	
	@Override
	public void setTitle(String title) {
		if(title == null) {
			this.title = new JLabel("Sem T�tulo");
		}
		else {
			this.title = new JLabel(title);
		}
	}
	
	@Override
	public void setAuthor(String author) {
		if(author == null) {
			this.author = new JLabel("Sem Autor");
		}
		else {
			this.author = new JLabel(author);
		}
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
}
