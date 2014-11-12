package br.ufal.ic.sheetCreator.decorator;

import java.util.ArrayList;
import java.util.Hashtable;

public class WholeNote extends Notes{

	private final int width = 20;
	private final int height = 40;
	
	public WholeNote(IComponent component, int position_x, int position_y, ArrayList<Flag> ordemFlag) {
		super(component, position_x, position_y, ordemFlag);
		this.pathImage = "resource/wholenote.svg.png";
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
	protected void fillOrdemTable(Hashtable<Flag, Integer> table) {
		/*preencher as flags da posição do cursor e do tom*/
		
	}

}
