package br.ufal.ic.sheetCreator.decorator;

import java.util.Hashtable;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Notes extends Decorator{

	protected Hashtable<Flag, Integer> ordem;
	
	public static final int CURSOR_POSITION = 1;
	public static final int TONE_POSITION = 2;
	public static final int ACCIDENTAL_SYMBOL = 3;
	
	public Notes(IComponent component, int position_x, int position_y, List<Flag> flag) {
		super(component, position_x, position_y, flag);
		
		this.draw();
	}

	public abstract int getWidth();
	public abstract int getHeight();
	public abstract String getPathImage();
	public abstract int getPosisionCX();
	public abstract int getPositionCY();
	
	protected void fillOrdemTable() {
		
		this.ordem = new Hashtable<Flag, Integer>();
		
		int initval = 130;
		int initvaly = 15;
		
		ordem.put(Flag.PRIMEIRA, initval);
		ordem.put(Flag.SEGUNDA, initval + 60);
		ordem.put(Flag.TERCEIRA, initval + 120);
		ordem.put(Flag.QUARTA, initval + 180);
		ordem.put(Flag.QUINTA, initval + 240);
		ordem.put(Flag.SEXTA, initval + 300);
		ordem.put(Flag.SETIMA, initval + 360);
		ordem.put(Flag.OITAVA, initval + 420);
		
		ordem.put(Flag.C, initvaly);
		ordem.put(Flag.D, initvaly - 3);
		ordem.put(Flag.E, initvaly - 12);
		ordem.put(Flag.F, initvaly - 18);
		ordem.put(Flag.G, initvaly - 25);
		ordem.put(Flag.A, initvaly - 30);
		ordem.put(Flag.B, initvaly - 37);
		
	}
	
	@Override
	protected void draw() {
		this.fillOrdemTable();
		
		this.icon = new ImageIcon(this.getPathImage());
		this.label = new JLabel();
		
		icon.setImage(resize(icon.getImage(), this.getWidth(), this.getHeight()));
		label.setIcon(icon);
		
		this.myPosition_y = this.position_x + this.getPosisionCX();
		this.myPosition_x = this.position_y + this.getPositionCY();
		
		System.out.println("pos_x: " + this.myPosition_x);
		System.out.println("pos_y: " + this.myPosition_y);
		
		label.setBounds(this.myPosition_y ,this.myPosition_x ,this.getWidth(), this.getWidth());
	}
}
