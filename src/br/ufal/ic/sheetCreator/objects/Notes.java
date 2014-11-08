package br.ufal.ic.sheetCreator.objects;

import java.util.Hashtable;

import javax.swing.JComponent;

import javafx.geometry.Bounds;

public abstract class Notes extends Decorator{

	private Hashtable<Flag, Integer> ordem;
	private Flag ordemFlag;
	
	public Notes(IComponent component, int[] position, Flag ordemFlag) {
		super(component, position);
		this.ordemFlag = ordemFlag;
	}

	@Override
	protected void draw() {
		// TODO Auto-generated method stub
		
	}
}
