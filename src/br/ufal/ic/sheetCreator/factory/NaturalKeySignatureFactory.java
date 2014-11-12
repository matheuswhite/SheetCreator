package br.ufal.ic.sheetCreator.factory;

import java.util.List;

import br.ufal.ic.sheetCreator.decorator.*;

public class NaturalKeySignatureFactory extends Factory {

	@Override
	public Decorator createDecoratorItem(IComponent comp, int pos_x, int pos_y, List<Flag> flag) {
		return new NaturalKeySignature(comp, pos_x, pos_y, flag);
	}

}
