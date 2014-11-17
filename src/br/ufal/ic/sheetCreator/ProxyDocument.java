package br.ufal.ic.sheetCreator;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import br.ufal.ic.sheetCreator.decorator.*;

public class ProxyDocument implements IDocument{
	
	private List<Decorator> notes;
	private Document doc;
	private StaffState state;
	
	private int currentValueInCompass = 0;
	private int currentPosition = 1;
	
	public boolean addBarCompass = false;
	
	private int currentStaff = 1;
	
	public ProxyDocument(Document doc) {
		this.doc = doc;
		this.notes = new LinkedList<Decorator>();
		this.state = new StaffState(doc.getStaffs().get(0));
	}
	
	public StaffState getStaffState() {
		return this.state;
	}
	
	public Document getDoc() {
		return this.doc;
	}
	
	private double valNote(Flag dec) {
		double exit = 0;
		
		if(dec.equals(Flag.WHOLE_NOTE)) {
			exit = 4;
		}
		else if(dec.equals(Flag.HALF_NOTE)) {
			exit = 2;
		}
		else if(dec.equals(Flag.QUARTER_NOTE)) {
			exit = 1;
		}
		else if(dec.equals(Flag.EIGHTH_NOTE)) {
			exit = 0.5; 
		}
		
		return exit;
	}
	
	@Override
	public void setTitle(String title) {
		this.doc.setTitle(title);
	}

	@Override
	public void setAuthor(String author) {
		this.doc.setAuthor(author);
	}

	@Override
	public Decorator addNote(int currentStaff, ArrayList<Flag> currentPosisition) {
		Decorator dec = null;
		double val = 0;
		ArrayList<Flag> listFlags = null;
		
		listFlags.add(currentPosisition.get(Document.TYPE_NOTE));
		
		val = this.valNote(currentPosisition.get(Document.TYPE_NOTE));
		
		this.currentValueInCompass += val;
		
		if(this.currentStaff >= 4){
			return null;
		}
		
		if(this.currentPosition >= 8) {
			this.currentPosition = 1;
			this.currentStaff++;
		}
		
		if(this.currentValueInCompass == 4){
			this.addBarCompass = true;
			this.currentValueInCompass = 0;
		}
		if(this.currentValueInCompass <= 4) {
			this.currentPosition++;
		}
		else if(this.currentValueInCompass > 4) {
			if(this.currentPosition >= 1 && this.currentPosition <= 3) {
				this.currentPosition = 5;
			}
			else if(this.currentPosition >= 5 && this.currentPosition <= 7) {
				this.currentPosition = 1;
				this.currentStaff++;
			}
		}
		
		
		
		
		listFlags.add();
		
		dec = this.doc.addNote(this.currentStaff, listFlags);
		this.notes.add(dec);
		
		//se retornar null o doc está cheio
		return dec;
	}
}
