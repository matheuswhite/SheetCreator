package view;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JPanel;

import org.jfugue.Player;

import br.ufal.ic.sheetCreator.*;
import br.ufal.ic.sheetCreator.decorator.Flag;
import br.ufal.ic.sheetCreator.factory.ClassicalDocumentFactory;
import br.ufal.ic.sheetCreator.factory.DocumentFactory;
import br.ufal.ic.sheetCreator.factory.Factory;
import br.ufal.ic.sheetCreator.factory.WholeNoteFactory;

public class DocumentView extends JPanel{
	
	private IDocument currentDoc;
	private LinkedList<IDocument> pages;
	private DocumentFactory docFactory;
	private ArrayList<Flag> flags;
	
	public DocumentView() {
		
		//docFactory = new ClassicalDocumentFactory();
		
		//currentDoc = docFactory.createDocument("Musica 1", "Matheus Tenorio");
		
		//this.add((Component) this.currentDoc);
		
		this.setBackground(Color.WHITE);
	}
}
