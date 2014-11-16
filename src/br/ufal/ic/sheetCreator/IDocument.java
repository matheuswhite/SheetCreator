package br.ufal.ic.sheetCreator;

import java.util.ArrayList;

import br.ufal.ic.sheetCreator.decorator.*;

public interface IDocument {
	public Decorator addNote(int currentStaff, ArrayList<Flag> currentPosisiton);
	public Decorator delNote();
	public void setTitle(String title);
	public void setAuthor(String author);
}
