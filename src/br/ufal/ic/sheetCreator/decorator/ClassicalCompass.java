package br.ufal.ic.sheetCreator.decorator;

import java.util.ArrayList;
import java.util.List;

public class ClassicalCompass extends Compass{

	public ClassicalCompass(IComponent component, int position_x,
			int position_y, List<Flag> flag) {
		super(component, position_x, position_y, flag);
	}

}
