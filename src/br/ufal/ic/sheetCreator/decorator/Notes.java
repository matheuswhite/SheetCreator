package br.ufal.ic.sheetCreator.decorator;

import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

import javafx.geometry.Bounds;

public abstract class Notes extends Decorator{

	private Hashtable<Flag, Integer> ordem;
	public static final int CURSOR_POSITION = 0;
	public static final int TONE_POSITION = 1;
	
	public Notes(IComponent component, int[] position, ArrayList<Flag> ordemFlag) {
		super(component, position, ordemFlag);
	}

	@Override
	protected void draw() {
		this.icon = new ImageIcon(this.pathImage);
		this.label = new JLabel();
		
		icon.setImage(resize(icon.getImage(), this.getWidth(), this.getHeight()));
		label.setIcon(icon);
		
		this.myPosition[0] = this.getPosition()[0] + this.ordem.get(this.flags.get(Notes.CURSOR_POSITION));
		this.myPosition[1] = this.getPosition()[1] + this.ordem.get(this.flags.get(Notes.TONE_POSITION));
		
		label.setBounds(this.myPosition[0], this.myPosition[1], this.getWidth(), this.getWidth());
		
	}
}
