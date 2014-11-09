package br.ufal.ic.sheetCreator.factory;

import br.ufal.ic.sheetCreator.Document;
import br.ufal.ic.sheetCreator.decorator.*;

public abstract class DocumentFactory {
	
	public abstract Document createDocument(String name, String author, int[] docPos);
}
