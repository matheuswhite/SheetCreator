package br.ufal.ic.sheetCreator.decorator;

import java.util.List;

import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Notes extends Decorator{

	private Hashtable<Flag, Integer> ordem;
	protected JLabel accidentalSymbol;
	
	public static final int CURSOR_POSITION = 1;
	public static final int TONE_POSITION = 2;
	public static final int ACCIDENTAL_SYMBOL = 3;
	
	public Notes(IComponent component, int position_x, int position_y, List<Flag> flag) {
		super(component, position_x, position_y, flag);
		
		this.ordem = new Hashtable<Flag, Integer>();
		
		this.fillOrdemTable(ordem);
		
		this.draw();
	}

	protected abstract void fillOrdemTable(Hashtable<Flag, Integer> table);
	protected abstract void drawAccidentalSymbol();
	
	@Override
	protected void draw() {
		this.icon = new ImageIcon(this.pathImage);
		this.label = new JLabel();
		
		icon.setImage(resize(icon.getImage(), this.getWidth(), this.getHeight()));
		label.setIcon(icon);
		
		this.myPosition_x = this.position_x + this.ordem.get(this.flags.get(Notes.CURSOR_POSITION));
		this.myPosition_y = this.position_y + this.ordem.get(this.flags.get(Notes.TONE_POSITION));
		
		label.setBounds(this.myPosition_x, this.myPosition_y, this.getWidth(), this.getWidth());
		
		if(this.flags.get(Notes.ACCIDENTAL_SYMBOL) != Flag.NONE) {
			this.drawAccidentalSymbol();
		}
	}
}
