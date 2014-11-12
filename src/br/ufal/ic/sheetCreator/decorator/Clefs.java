package br.ufal.ic.sheetCreator.decorator;

import java.util.List;

import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Clefs extends Decorator {
	
	private Hashtable<Flag, Integer> types;
	protected int width;
	protected int height;
	protected int position_x;
	protected int position_y;
	
	public Clefs(IComponent component, int position_x, int position_y, List<Flag> flag) {
		super(component, position_x, position_y, flag);
		
		this.types = new Hashtable<Flag, Integer>();
		
		this.draw();
	}
	
	public int getPosition_X() {
		return this.myPosition_x;
	}
	public int getPosition_Y() {
		return this.myPosition_y;
	}
	
	@Override
	public int getWidth() {
		return this.width;
	}

	@Override
	public int getHeight() {
		return this.height;
	}
	
	@Override
	protected void draw() {
		this.icon = new ImageIcon(this.pathImage);
		this.label = new JLabel();
		
		icon.setImage(resize(icon.getImage(), this.getWidth(), this.getHeight()));
		label.setIcon(icon);
		
		this.myPosition_y = this.position_x + this.getPosition_X();
		this.myPosition_x = this.position_y + this.getPosition_Y();
		
		label.setBounds(this.myPosition_x, this.myPosition_y ,this.getWidth(), this.getWidth());
	}

	
}
