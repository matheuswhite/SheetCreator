package br.ufal.ic.sheetCreator.factory;

import java.util.List;

import br.ufal.ic.sheetCreator.decorator.*;

public abstract class Factory {
		public abstract Decorator createDecoratorItem(IComponent comp, int pos_x, int pos_y, List<Flag> flag); 
}
