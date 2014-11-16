package br.ufal.ic.sheetCreator;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;

import br.ufal.ic.sheetCreator.decorator.*;

public class ProxyDocument implements IDocument{
	
	private List<Decorator> notes;
	private Document doc;
	private StaffState state;
	
	public ProxyDocument(Document doc) {
		this.doc = doc;
		this.notes = new LinkedList<Decorator>();
		this.state = new StaffState(doc.getStaffs().get(0));
	}
	
	public Document getDoc() {
		return this.doc;
	}
	
	@Override
	public void setTitle(String title) {
		this.doc.setTitle(title);
	}

	@Override
	public void setAuthor(String author) {
		this.doc.setAuthor(author);
	}

	//fazer
	@Override
	public Decorator addNote(int currentStaff, ArrayList<Flag> currentPosisition) {
		Flag created = null;
		Decorator dec = null;
		
		created = this.state.incrementState(currentPosisition.get(Document.TYPE_NOTE));
		
		if(created.equals(Flag.NO_FULL)) {
			dec = this.doc.addNote(currentStaff, currentPosisition);
			this.notes.add(dec);
		}
		else if(created.equals(Flag.CHANGE_STAFF)) {
			dec = this.doc.addNote(currentStaff, currentPosisition);
			this.notes.add(dec);
			//mudar de staff
		}
		else if(created.equals(Flag.NOT_CREATED)) {
			//está cheio o documento
		}
		
		//se retornar null o doc está cheio
		return dec;
	}
	
	@Override
	public Decorator delNote() {
		// TODO Auto-generated method stub
		return null;
	}

}
