package br.ufal.ic.sheetCreator.decorator;

import java.util.ArrayList;

import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Notes extends Decorator{

	private Hashtable<Flag, Integer> ordem;
	private JLabel accidentalSymbol;
	
	public static final int CURSOR_POSITION = 0;
	public static final int TONE_POSITION = 1;
	
	public Notes(IComponent component, int position_x, int position_y, ArrayList<Flag> ordemFlag) {
		super(component, position_x, position_y, ordemFlag);
		
		this.ordem = new Hashtable<Flag, Integer>();
		
		this.fillOrdemTable(ordem);
		
		this.draw();
	}

	protected abstract void fillOrdemTable(Hashtable<Flag, Integer> table);
	
	@Override
	protected void draw() {
		this.icon = new ImageIcon(this.pathImage);
		this.label = new JLabel();
		
		icon.setImage(resize(icon.getImage(), this.getWidth(), this.getHeight()));
		label.setIcon(icon);
		
		this.myPosition_x = this.position_x + this.ordem.get(this.flags.get(Notes.CURSOR_POSITION));
		this.myPosition_y = this.position_y + this.ordem.get(this.flags.get(Notes.TONE_POSITION));
		
		label.setBounds(this.myPosition_x, this.myPosition_y, this.getWidth(), this.getWidth());
		
	}
}
