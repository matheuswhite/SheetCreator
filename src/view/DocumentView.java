package view;

import java.awt.Color;


import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;







import br.ufal.ic.sheetCreator.*;
import br.ufal.ic.sheetCreator.decorator.Flag;
import br.ufal.ic.sheetCreator.factory.ClassicalDocumentFactory;
import br.ufal.ic.sheetCreator.factory.DocumentFactory;

public class DocumentView extends JPanel{
	
	private IDocument currentDoc;
	private IDocument currentEditDoc;
	private LinkedList<IDocument> pages;
	private DocumentFactory docFactory;
	private JFrame mainframe;
	
	private String title;
	private String autor;
	
	public DocumentView(JFrame frame) {
		this.currentDoc = null;
		this.docFactory = null;
		this.currentEditDoc = null;
		this.pages = new LinkedList<IDocument>();
		this.mainframe = frame;
		
		this.setBackground(Color.DARK_GRAY);
	}
	
	public void setPanel(JPanel newdoc) {
		if(newdoc != null) {
			this.mainframe.setContentPane(newdoc);
			this.mainframe.invalidate();
			this.mainframe.validate();
		}
	}
	
	public void nextPage() {
		if(this.pages.size() != 1 && this.pages.size() != 0) {
			if(! this.pages.getLast().equals(currentDoc)) {
				IDocument tempdoc = this.pages.get(this.pages.indexOf(currentDoc) + 1);
				this.currentDoc = tempdoc;
				this.setPanel((JPanel) ((ProxyDocument) tempdoc).getDoc());
			}
		}
	}
	
	public void prevPage() {
		if(this.pages.size() != 1 && this.pages.size() != 0) {
			if(! this.pages.getFirst().equals(currentDoc)) {
				IDocument tempdoc = this.pages.get(this.pages.indexOf(currentDoc) - 1);
				this.currentDoc = tempdoc;
				this.setPanel((JPanel) ((ProxyDocument) tempdoc).getDoc());
			}
		}
	}
	
	public void newPage() {
		IDocument doc = new ProxyDocument(this.docFactory.createDocument(this.title, this.autor));
		
		currentEditDoc = doc;
		this.pages.add(doc);
		
		this.nextPage();
	}
	
	public void createDocument(Flag typeDocument, String name, String author) {
		if(typeDocument.equals(Flag.CLASSICAL_DOCUMENT)) {
			this.docFactory = new ClassicalDocumentFactory();
			
			this.title = name;
			this.autor = author;
			
			IDocument doc = new ProxyDocument(this.docFactory.createDocument(name, author));
			
			currentDoc = doc;
			currentEditDoc = doc;
			pages.clear();
			pages.add(doc);
			
			this.setPanel((JPanel) ((ProxyDocument) this.currentDoc).getDoc());
		}
	}
}
