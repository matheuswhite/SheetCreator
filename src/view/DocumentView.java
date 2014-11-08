package view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class DocumentView extends JPanel{
	
	private Border border;
	
	public DocumentView() {
		this.border = BorderFactory.createLineBorder(Color.DARK_GRAY);
		this.setBorder(BorderFactory.createCompoundBorder(this.border, BorderFactory.createEmptyBorder(10, 200, 10, 200)));
		//(top, left, bottom, right)
		
		this.setOpaque(true);
		this.setBackground(Color.WHITE);
		this.setSize(10,10);
	}
}
