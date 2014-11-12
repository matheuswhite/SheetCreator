package br.ufal.ic.sheetCreator.decorator;

import java.util.LinkedList;
import java.util.List;

import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MusicalStaff extends IComponent{
	
	private Hashtable<Flag, Integer> ordem;
	private Flag ordemFlag;
	private List<Decorator> listItens;
	
	protected static final int STAFF_WIDTH = 620;
	protected static final int STAFF_HEITH = 50;
	protected static final int STAFF_POSITION_X = 10;
	
	public MusicalStaff(Flag ordemFlag /*1�,2�,3� ou 4� staff */) {
		this.ordem = new Hashtable<Flag, Integer>();
		this.listItens = new LinkedList<Decorator>();
		this.ordemFlag = ordemFlag;
		
		this.fillHash_Ordem();
		
		this.draw();
	}
	
	private void fillHash_Ordem() {
		this.ordem.put(Flag.PRIMEIRA, 100);
		this.ordem.put(Flag.SEGUNDA, 200);
		this.ordem.put(Flag.TERCEIRA, 300);
		this.ordem.put(Flag.QUARTA, 400);
	}
	
	public void delItem(Decorator item) {
		this.listItens.remove(item);
	}
	
	public void addItem(Decorator item) {
		boolean exists = isthere(item);
	
		if(!exists) {
			this.listItens.add(item);
		}
	}
	
	private boolean isthere(Decorator item) {
		for (Decorator dec  : this.listItens) {
			if(item instanceof Clefs || item instanceof Compass || item instanceof KeySignature) {
				return true;
			}
		}
		
		return false;
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
}
