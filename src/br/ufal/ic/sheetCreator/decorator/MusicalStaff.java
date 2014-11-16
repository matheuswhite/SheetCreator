package br.ufal.ic.sheetCreator.decorator;

import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MusicalStaff extends IComponent{
	
	private Hashtable<Flag, Integer> ordem;
	private Flag ordemFlag;
	private Decorator clef = null;
	private Decorator compass = null;
	private Decorator ksignature = null;
	private int firstlocation;
	
	protected static final int STAFF_WIDTH = 620;
	protected static final int STAFF_HEITH = 50;
	protected static final int STAFF_POSITION_X = 10;
	
	public MusicalStaff(Flag ordemFlag /*1�,2�,3� ou 4� staff */) {
		this.ordem = new Hashtable<Flag, Integer>();
		this.ordemFlag = ordemFlag;
		this.firstlocation = 80;
		
		this.fillHash_Ordem();
		
		this.draw();
	}
	
	private void fillHash_Ordem() {
		this.ordem.put(Flag.PRIMEIRA, this.firstlocation + 100);
		this.ordem.put(Flag.SEGUNDA, this.firstlocation + 200);
		this.ordem.put(Flag.TERCEIRA, this.firstlocation + 300);
		this.ordem.put(Flag.QUARTA, this.firstlocation + 400);
	}
	
	public void setClef(Decorator decorator) {
		this.clef = decorator;
	}
	
	public Decorator getClef() {
		return this.clef;
	}
	
	@Override
	protected void draw() {
		try {
			this.pathImage = "resource/musicstaff.svg.png";
			this.icon = new ImageIcon(this.pathImage);
			
			this.label = new JLabel();
		
			this.icon.setImage(this.resize(this.icon.getImage(), MusicalStaff.STAFF_WIDTH, MusicalStaff.STAFF_HEITH));
			this.label.setIcon(this.icon);
			
			this.myPosition_x = MusicalStaff.STAFF_POSITION_X;
			this.myPosition_y = ordem.get(this.ordemFlag);
		
			this.label.setBounds(this.myPosition_x, this.myPosition_y,
					MusicalStaff.STAFF_WIDTH, MusicalStaff.STAFF_HEITH);
		}
		catch (NullPointerException ex) {
			System.out.println("erro");
		}
		
		
	}

	public Decorator getCompass() {
		return compass;
	}

	public void setCompass(Decorator compass) {
		this.compass = compass;
	}

	public Decorator getKsignature() {
		return ksignature;
	}

	public void setKsignature(Decorator ksignature) {
		this.ksignature = ksignature;
	}
}
