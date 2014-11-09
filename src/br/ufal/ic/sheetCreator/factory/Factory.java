package br.ufal.ic.sheetCreator.factory;

import java.util.ArrayList;

import br.ufal.ic.sheetCreator.decorator.*;

public abstract class Factory {
		public abstract Decorator createDecoratorItem(IComponent comp, int[] pos, ArrayList<Flag> flag); 
}
