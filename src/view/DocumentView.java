package view;

import java.awt.Color;
import java.util.LinkedList;

import javax.swing.JPanel;

import br.ufal.ic.sheetCreator.*;

public class DocumentView extends JPanel{
	
	private IDocument currentDoc;
	private LinkedList<IDocument> pages;
	
	public DocumentView() {
		currentDoc = new ProxyDocument();
		
		this.setOpaque(true);
		this.setBackground(Color.WHITE);
		this.setSize(100, 100);
	}
}
