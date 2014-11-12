package br.ufal.ic.sheetCreator.decorator;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

public class TrebleClef extends Clefs{
	
	public TrebleClef(IComponent component, int position_x, int position_y, List<Flag> flag) {
		super(component, position_x, position_y,flag);
		//this.pathImage = "resource/trebleclef.png";
		
		this.width = 20;
		this.height = 50;
		
		this.position_x = 20;
		this.position_y = 40;
	}
}
