package br.ufal.ic.sheetCreator.decorator;

import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MusicalStaff extends IComponent{
	
	private Hashtable<Flag, Integer> ordem;
	private Flag ordemFlag;
	protected static final int STAFF_WIDTH = 620;
	protected static final int STAFF_HEITH = 50;
	protected static final int STAFF_POSITION_X = 10;
	
	public MusicalStaff(Flag ordemFlag /*1º,2º,3º ou 4º staff */) {
		this.ordem = new Hashtable<Flag, Integer>();
		this.ordemFlag = ordemFlag;
		
		this.ordem.put(Flag.PRIMEIRA, 100);
		this.ordem.put(Flag.SEGUNDA, 200);
		this.ordem.put(Flag.TERCEIRA, 300);
		this.ordem.put(Flag.QUARTA, 400);
		
		this.draw();
	}
	
	@Override
	protected void draw() {
		try {
			this.pathImage = "resource/musicstaff.svg.png";
			this.icon = new ImageIcon(this.pathImage);
			
			this.label = new JLabel();
		
			this.icon.setImage(this.resize(this.icon.getImage(), MusicalStaff.STAFF_WIDTH, MusicalStaff.STAFF_HEITH));
			this.label.setIcon(this.icon);
			
			this.myPosition[0] = MusicalStaff.STAFF_POSITION_X;
			this.myPosition[1] = ordem.get(this.ordemFlag);
		
			this.label.setBounds(this.myPosition[0], this.myPosition[1],
					MusicalStaff.STAFF_WIDTH, MusicalStaff.STAFF_HEITH);
		}
		catch (NullPointerException ex) {
			System.out.println("erro");
		}
		
		
	}
}
