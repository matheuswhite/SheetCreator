package br.ufal.ic.sheetCreator.factory;

import br.ufal.ic.sheetCreator.Document;

public abstract class DocumentFactory {
	
	public abstract Document createDocument(String name, String author);
}
