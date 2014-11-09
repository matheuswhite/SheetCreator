package view.popUpMenus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class NewDocument extends JFrame{
	
	JButton btnclose;
	JPanel panel;
	
	public NewDocument() {
		btnclose = new JButton("Close");
		panel = new JPanel();
		
		panel.add(btnclose);
		this.setCloseWindowAction(btnclose, this);
		
		this.add(panel);
		this.setLocation(50, 50);
		this.setSize(400, 150);
		this.setResizable(false);
		this.setTitle("Novo Documento");
		this.setVisible(true);
	}
	
	private void setCloseWindowAction(JButton btn, JFrame frame) {
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
	}
}
