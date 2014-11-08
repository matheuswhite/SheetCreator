package br.ufal.ic.sheetCreator.objects;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

import javafx.geometry.Bounds;

public abstract class Clefs extends Decorator {
	
	public Clefs(IComponent component, int[] position) {
		super(component, position);
		this.draw();
	}
	
	public abstract int getPosition_X();
	public abstract int getPosition_Y();
	
	@Override
	protected void draw() {
		this.icon = new ImageIcon(this.pathImage);
		this.label = new JLabel();
		
		icon.setImage(resize(icon.getImage(), this.getWidth(), this.getHeight()));
		label.setIcon(icon);
		
		label.setBounds(this.getPosition()[0] + this.getPosition_X(), this.getPosition()[1] + this.getPosition_Y(), this.getWidth(), this.getWidth());
	}
}
