package br.ufal.ic.sheetCreator.decorator;

import java.util.List;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Notes extends Decorator{

	protected Hashtable<Flag, Integer> ordem;
	protected JLabel accidentalSymbol;
	
	public static final int CURSOR_POSITION = 1;
	public static final int TONE_POSITION = 2;
	public static final int ACCIDENTAL_SYMBOL = 3;
	
	public Notes(IComponent component, int position_x, int position_y, List<Flag> flag) {
		super(component, position_x, position_y, flag);
		
		this.ordem = new Hashtable<Flag, Integer>();
		
		this.draw();
	}

	public abstract int getWidth();
	public abstract int getHeight();
	public abstract String getPathImage();
	public abstract int getPosisionCX();
	public abstract int getPositionCY();
	
	protected abstract void fillOrdemTable(Hashtable<Flag, Integer> table);
	
	@Override
	protected void draw() {
		/*
		this.icon = new ImageIcon(this.pathImage);
		this.label = new JLabel();
		
		icon.setImage(resize(icon.getImage(), this.getWidth(), this.getHeight()));
		label.setIcon(icon);
		
		Flag flag1 = this.flags.get(Notes.CURSOR_POSITION);
		Flag flag2 = this.flags.get(Notes.TONE_POSITION);
		
		this.myPosition_x = this.position_x + this.ordem.get(flag1);
		this.myPosition_y = this.position_y + this.ordem.get(flag2);
		
		label.setBounds(this.myPosition_x, this.myPosition_y, this.getWidth(), this.getWidth());
		
		/*
		if(this.flags.get(Notes.ACCIDENTAL_SYMBOL) != Flag.NONE) {
			
		}*/
		
		this.icon = new ImageIcon(this.getPathImage());
		this.label = new JLabel();
		
		icon.setImage(resize(icon.getImage(), this.getWidth(), this.getHeight()));
		label.setIcon(icon);
		
		this.myPosition_y = this.position_x + this.getPosisionCX();
		this.myPosition_x = this.position_y + this.getPositionCY();
		
		label.setBounds(this.myPosition_y, this.myPosition_x ,this.getWidth(), this.getWidth());
	}
}
