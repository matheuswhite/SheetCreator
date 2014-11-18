package br.ufal.ic.sheetCreator.decorator;

import java.util.Hashtable;
import java.util.List;

public class HalfNote extends Notes {

	public HalfNote(IComponent component, int position_x, int position_y,
			List<Flag> flag) {
		super(component, position_x, position_y, flag);
	}

	@Override
	protected void fillOrdemTable(Hashtable<Flag, Integer> table) {
		
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getPathImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPosisionCX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPositionCY() {
		// TODO Auto-generated method stub
		return 0;
	}
}
