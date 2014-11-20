package br.ufal.ic.sheetCreator;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import br.ufal.ic.sheetCreator.decorator.*;

public class ProxyDocument implements IDocument{
	
	private List<Decorator> notes;
	private Document doc;
	private Hashtable<Integer, Flag> positionFlags;
	
	private int currentValueInCompass = 0;
	private int currentPosition = 1;
	
	public boolean addBarCompass = false;
	
	private int currentStaff = 1;
	
	public ProxyDocument(Document doc) {
		this.doc = doc;
		this.notes = new LinkedList<Decorator>();
		this.fillPositionFlagsTable();
	}
	
	public Document getDoc() {
		return this.doc;
	}
	
	private void fillPositionFlagsTable() {
		this.positionFlags = new Hashtable<Integer, Flag>();
		
		this.positionFlags.put(1, Flag.PRIMEIRA);
		this.positionFlags.put(2, Flag.SEGUNDA);
		this.positionFlags.put(3, Flag.TERCEIRA);
		this.positionFlags.put(4, Flag.QUARTA);
		this.positionFlags.put(5, Flag.QUINTA);
		this.positionFlags.put(6, Flag.SEXTA);
		this.positionFlags.put(7, Flag.SETIMA);
		this.positionFlags.put(8, Flag.OITAVA);
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
		ArrayList<Flag> listFlags = new ArrayList<Flag>();
		
		listFlags.add(currentPosisition.get(Document.TYPE_NOTE));
		listFlags.add(Flag.NONE);
		listFlags.add(currentPosisition.get(Notes.TONE_POSITION));
		listFlags.add(currentPosisition.get(Notes.ACCIDENTAL_SYMBOL));
		
		val = this.valNote(currentPosisition.get(Document.TYPE_NOTE));
		
		this.currentValueInCompass += val;
		
		if(this.currentStaff > 4){
			System.out.println("staff autual: " + this.currentStaff);
			return null;
		}
		
		if(this.currentPosition >= 1 && this.currentPosition <= 4) {
			if(this.currentValueInCompass == 4) {
				dec = this.updateNotes(listFlags);
				this.currentPosition = 5;
				this.currentValueInCompass = 0;
			}
			else if(this.currentValueInCompass < 4) {
				dec = this.updateNotes(listFlags);
				this.currentPosition++;
			}
			else {
				this.currentPosition = 5;
				dec = this.updateNotes(listFlags);
				this.currentPosition++;
				this.currentValueInCompass = 0;
			}
		}
		else if(this.currentPosition >= 5 && this.currentPosition <= 7) {
			if(this.currentValueInCompass == 4) {
				dec = this.updateNotes(listFlags);
				this.currentPosition = 1;
				this.currentStaff++;
				this.currentValueInCompass = 0;
			}
			else if(this.currentValueInCompass < 4) {
				dec = this.updateNotes(listFlags);
				this.currentPosition++;
			}
			else {
				this.currentPosition = 1;
				this.currentStaff++;
				dec = this.updateNotes(listFlags);
				this.currentPosition++;
				this.currentValueInCompass = 0;
			}
		}
		else if(this.currentPosition == 8) {
			if(this.currentValueInCompass < 4) {
				dec = this.updateNotes(listFlags);
				this.currentPosition = 1;
				this.currentStaff++;
			}
			else if(this.currentValueInCompass == 4) {
				dec = this.updateNotes(listFlags);
				this.currentPosition = 1;
				this.currentStaff++;
				this.currentValueInCompass = 0;
			}
			else {
				this.currentPosition = 1;
				this.currentStaff++;
				dec = this.updateNotes(listFlags);
				this.currentValueInCompass = 0;
			}
		}
		
		return dec;
	}
	
	private Decorator updateNotes(ArrayList<Flag> listFlags) {
		Decorator dec = null;
		
		Flag aux = listFlags.get(Notes.TONE_POSITION);
		Flag aux2 = listFlags.get(Notes.ACCIDENTAL_SYMBOL);
		
		listFlags.add(Notes.CURSOR_POSITION, this.positionFlags.get(this.currentPosition));
		listFlags.add(Notes.TONE_POSITION, aux);
		listFlags.add(Notes.ACCIDENTAL_SYMBOL, aux2);
		
		dec = this.doc.addNote(this.currentStaff - 1, listFlags);
		
		
		try {
			this.notes.add(dec);
		}
		catch (NullPointerException ex) {
			ex.printStackTrace();
		}
		
		return dec;
	}
}
