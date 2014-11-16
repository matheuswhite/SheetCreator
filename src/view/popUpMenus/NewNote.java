package view.popUpMenus;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.ufal.ic.sheetCreator.IDocument;
import br.ufal.ic.sheetCreator.PlayerSong;
import view.DocumentView;

public class NewNote extends JFrame {
	
	private IDocument doc;
	private PlayerSong player;
	
	private JPanel panelbtn, panel, panelAccidents;
	
	private JComboBox<String> types_notes, tones, accidents;
	
	private JButton btncreate, btnclose;
	
	private JLabel lbltype_notes, lbltones, lblaccidents;
	
	public NewNote(DocumentView view, PlayerSong player) {
		this.doc = view.getCurrenteEditDoc();
		this.player = player;
		
		this.initComponents(this);
		
		this.addComponents();
		
		this.initFrame();
	}
	
	private void initFrame() {
		this.setLayout(new BorderLayout());
		this.getContentPane().add(panel, BorderLayout.NORTH);
		this.getContentPane().add(panelAccidents, BorderLayout.CENTER);
		this.getContentPane().add(panelbtn, BorderLayout.SOUTH);
		
		this.setLocation(50, 50);
		this.setSize(400, 150);
		this.setResizable(false);
		this.setTitle("Nova Nota");
		this.setVisible(true);
	}
	
	private void initComponents(NewNote frame) {
		String[] listTypeNotes = {"Semibreve", "Seminima", "Minima", "Colcheia"};
		String[] listTons = {"Do", "Re", "Mi", "Fa", "Sol", "La", "Si"};
		String[] listAccidents = {"# - Sustenido", "b - Bemol", "Natural"};
		
		this.panel = new JPanel();
		this.panelAccidents = new JPanel();
		this.panelbtn = new JPanel();
		
		this.lbltype_notes = new JLabel("Tipos de notas");
		this.types_notes = new JComboBox<String>(listTypeNotes);
		
		this.lbltones = new JLabel("Tons");
		this.tones = new JComboBox<String>(listTons);
		
		this.lblaccidents = new JLabel("Acidentes");
		this.accidents = new JComboBox<String>(listAccidents);
		
		this.btnclose = new JButton("Fechar");
		this.btncreate = new JButton("Criar");
		
		this.btnclose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		
		this.btncreate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.createNote();
			}
		});
	}
	
	private void addComponents() {
		this.panel.add(this.lbltype_notes);
		this.panel.add(this.types_notes);
		this.panel.add(this.lbltones);
		this.panel.add(this.tones);
		
		this.panelAccidents.add(this.lblaccidents);
		this.panelAccidents.add(this.accidents);
		
		this.panelbtn.add(this.btnclose);
		this.panelbtn.add(this.btncreate);
	}
	
	public void createNote() {
		
		
		
		this.dispose();
	}
}
