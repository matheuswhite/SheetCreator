package br.ufal.ic.sheetCreator.decorator;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

public abstract class IComponent extends JComponent{

	protected JLabel label;
	protected ImageIcon icon;
	protected String pathImage;
	protected int position_x;
	protected int myPosition_x;
	protected int position_y;
	protected int myPosition_y;
	
	protected abstract void draw();
	
	public JLabel getLabel() {
		return this.label;
	}
	
	public int getMyPositionX() {
		return this.myPosition_x;
	}
	
	public int getPositionX() {
		return this.position_x;
	}
	
	public int getMyPositionY() {
		return this.myPosition_y;
	}
	
	public int getPositionY() {
		return this.position_y;
	}
	
	public Image resize(Image img, int width, int height) {
		BufferedImage resizedImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();
	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(img, 0, 0, width, height, null);
	    g2.dispose();
	    return resizedImg;
	}
}
