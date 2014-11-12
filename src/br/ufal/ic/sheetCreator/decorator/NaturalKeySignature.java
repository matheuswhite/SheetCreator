package br.ufal.ic.sheetCreator.decorator;

import java.util.List;

public class NaturalKeySignature extends KeySignature{

	public NaturalKeySignature(IComponent component, int position_x,
			int position_y, List<Flag> flags) {
		super(component, position_x, position_y, flags);
	}

}
