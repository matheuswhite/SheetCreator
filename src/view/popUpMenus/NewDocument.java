package view.popUpMenus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sun.glass.events.KeyEvent;

import br.ufal.ic.sheetCreator.decorator.Flag;
import view.DocumentView;
import view.MainWindow;

public class NewDocument extends JFrame{
	
	private JButton btnclose;
	private JButton btncreate;
	private JTextField titletext;
	private JTextField authortext;
	private JLabel titlelabel;
	private JLabel authorlabel;
	private JPanel panel;
	private DocumentView docview;
	
	public NewDocument(DocumentView docview) {
		btnclose = new JButton("Fechar");
		btncreate = new JButton("Novo Documento");
		this.getRootPane().setDefaultButton(btncreate);
		titletext = new JTextField(30);
		authortext = new JTextField(30);
		titlelabel = new JLabel("Titulo: ");
		authorlabel = new JLabel("Autor: ");
		panel = new JPanel();
		this.docview = docview;
		
		panel.add(titlelabel);
		panel.add(titletext);
		panel.add(authorlabel);
		panel.add(authortext);
		panel.add(btnclose);
		panel.add(btncreate);
		this.setCloseWindowAction(btnclose, this);
		this.setNewDocumentAction(btncreate, this);
		
		this.add(panel);
		this.pack();
		this.setLocation(50, 50);
		this.setSize(400, 120);
		this.setResizable(false);
		this.setTitle("Novo Documento");
		this.setVisible(true);
	}
	
	public String getTitleString() {
		return this.titletext.getText();
	}
	
	public String getAuthorString() {
		return this.authortext.getText();
	}
	
	private void setCloseWindowAction(JButton btn, final JFrame frame) {
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
	}
	
	private void setNewDocumentAction(JButton btn, final NewDocument frame) {
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				docview.createDocument(Flag.CLASSICAL_DOCUMENT, frame.getTitleString(), frame.getAuthorString());
				frame.dispose();
			}
		});
	}
}
