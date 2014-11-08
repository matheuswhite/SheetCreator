package br.ufal.ic.sheetCreator.objects;

import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MusicalStaff extends IComponent{
	
	private int[] position;
	private Hashtable<Flag, Integer> ordem;
	private Flag ordemFlag;
	protected static final int STAFF_WIDTH = 0;
	protected static final int STAFF_HEITH = 0;
	protected static final int STAFF_POSITION_X = 0;
	
	public MusicalStaff(int[] positionDoc, Flag ordemFlag) {
		this.ordem = new Hashtable<Flag, Integer>();
		this.position = positionDoc;
		this.ordemFlag = ordemFlag;
		this.draw();
	}
	
	@Override
	protected void draw() {
		this.pathImage = "";
		this.icon = new ImageIcon(this.pathImage);
		this.label = new JLabel();
		
		this.icon.setImage(this.resize(this.icon.getImage(), MusicalStaff.STAFF_WIDTH, MusicalStaff.STAFF_HEITH));
		this.label.setIcon(this.icon);
		
		this.label.setBounds(this.position[0] + ordem.get(ordemFlag), this.position[1] + MusicalStaff.STAFF_POSITION_X, MusicalStaff.STAFF_WIDTH, MusicalStaff.STAFF_HEITH);
	}
}
