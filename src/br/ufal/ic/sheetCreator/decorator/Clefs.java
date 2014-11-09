package br.ufal.ic.sheetCreator.decorator;

import java.util.ArrayList;

import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Clefs extends Decorator {
	
	private Hashtable<Flag, Integer> types;
	//arraylist flags
	
	public Clefs(IComponent component, int[] position, ArrayList<Flag> type) {
		super(component, position, type);
		this.draw();
	}
	
	public abstract int getPosition_X();
	public abstract int getPosition_Y();
	
	@Override
	protected void draw() {
		this.icon = new ImageIcon(this.pathImage);
		this.label = new JLabel();
		
		icon.setImage(resize(icon.getImage(), this.getWidth(), this.getHeight()));
		label.setIcon(icon);
		
		label.setBounds(this.getPosition()[0] + this.getPosition_X(),
				this.getPosition()[1] + this.getPosition_Y(),
				this.getWidth(), this.getWidth());
	}
}