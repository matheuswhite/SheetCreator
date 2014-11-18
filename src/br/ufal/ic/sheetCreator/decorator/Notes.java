package br.ufal.ic.sheetCreator.decorator;

import java.util.HashMap;
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
		System.out.println("test1");
		
		this.ordem = new Hashtable<Flag, Integer>();
		
		System.out.println("test2");
		
		int initval = 130;
		int initvaly = 40;
		
		ordem.put(Flag.PRIMEIRA, initval);
		ordem.put(Flag.SEGUNDA, initval + 10);
		ordem.put(Flag.TERCEIRA, initval + 20);
		ordem.put(Flag.QUARTA, initval + 30);
		ordem.put(Flag.QUINTA, initval + 40);
		ordem.put(Flag.SEXTA, initval + 50);
		ordem.put(Flag.SETIMA, initval + 60);
		ordem.put(Flag.OITAVA, initval + 70);
		
		ordem.put(Flag.C, initvaly);
		ordem.put(Flag.D, initvaly + 20);
		ordem.put(Flag.E, initvaly + 40);
		ordem.put(Flag.F, initvaly + 60);
		ordem.put(Flag.G, initvaly + 80);
		ordem.put(Flag.A, initvaly + 100);
		ordem.put(Flag.B, initvaly + 120);
		
		System.out.println("test3");
	}
	
	@Override
	protected void draw() {
		this.fillOrdemTable();
		
		if(flags.get(0).equals(Flag.WHOLE_NOTE)) {
			System.out.println("126");
		}
		if(flags.get(1).equals(Flag.PRIMEIRA)) {
			System.out.println("127");
		}
		if(flags.get(2).equals(Flag.C)) {
			System.out.println("128");
		}
		if(flags.get(3).equals(Flag.NATURAL_SIGN)) {
			System.out.println("129");
		}
		
		this.icon = new ImageIcon(this.getPathImage());
		this.label = new JLabel();
		
		icon.setImage(resize(icon.getImage(), this.getWidth(), this.getHeight()));
		label.setIcon(icon);
		
		this.myPosition_y = this.position_x + this.getPosisionCX();
		this.myPosition_x = this.position_y + this.getPositionCY();
		
		System.out.println("pos_x: " + this.myPosition_x);
		System.out.println("pos_y: " + this.myPosition_y);
		
		label.setBounds(this.myPosition_x, this.myPosition_y ,this.getWidth(), this.getWidth());
	}
}
