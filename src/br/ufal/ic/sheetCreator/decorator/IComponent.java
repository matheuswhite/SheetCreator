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
	protected int[] position;
	protected int[] myPosition;
	
	public IComponent() {
		this.position = new int[2];
		this.myPosition = new int[2];
	}
	
	protected abstract void draw();
	
	public JLabel getLabel() {
		return this.label;
	}
	
	public int[] getMyPosition() {
		return this.myPosition;
	}
	
	public int[] getPosition() {
		return this.position;
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
