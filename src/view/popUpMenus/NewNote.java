package view.popUpMenus;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.ufal.ic.sheetCreator.FlagSongs;
import br.ufal.ic.sheetCreator.IDocument;
import br.ufal.ic.sheetCreator.PlayerSong;
import br.ufal.ic.sheetCreator.ProxyDocument;
import view.DocumentView;

public class NewNote extends JFrame {
	
	private IDocument doc;
	private PlayerSong player;
	
	private Hashtable<String, FlagSongs> typesTable, tonesTable, accidentTable, toneNumberTable;
	
	private JPanel panelbtn, panel, panelAccidents;
	
	private JComboBox<String> types_notes, tones, accidents;
	
	private JButton btncreate, btnclose;
	
	private JLabel lbltype_notes, lbltones, lblaccidents;
	
	public NewNote(DocumentView view, PlayerSong player) {
		this.doc = view.getCurrenteEditDoc();
		this.player = player;
		
		this.fillTables();
		
		this.initComponents(this);
		
		this.addComponents();
		
		this.initFrame();
	}
	
	private void fillTables() {
		this.typesTable.put("Semibreve", FlagSongs.WHOLE_NOTE);
		this.typesTable.put("Seminima", FlagSongs.HALF_NOTE);
		this.typesTable.put("Minima", FlagSongs.QUARTER_NOTE);
		this.typesTable.put("Colcheia", FlagSongs.EIGHTH_NOTE);
		
		this.tonesTable.put("C", FlagSongs.C);
		this.tonesTable.put("D", FlagSongs.D);
		this.tonesTable.put("E", FlagSongs.E);
		this.tonesTable.put("F", FlagSongs.F);
		this.tonesTable.put("G", FlagSongs.G);
		this.tonesTable.put("A", FlagSongs.A);
		this.tonesTable.put("B", FlagSongs.B);
		
		this.toneNumberTable.put("3", FlagSongs.TONE_5);
		this.toneNumberTable.put("4", FlagSongs.TONE_6);
		
		this.accidentTable.put("# - Sustenido", FlagSongs.SHARP);
		this.accidentTable.put("b - Bemol", FlagSongs.FLAT);
		this.accidentTable.put("Natural", FlagSongs.NATURAL);
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
		String[] listTons = {"C3", "D3", "E3", "F3", "G3", "A3", "B3", "C4", "D4", "E4", "F4", "G4"};
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
		String type = (String) this.types_notes.getSelectedItem();
		String tone = (String) this.tones.getSelectedItem();
		String accident = (String) this.accidents.getSelectedItem();
		
		this.player.addNote(this.tonesTable.get(tone.charAt(0)), this.accidentTable.get(accident), 
				this.toneNumberTable.get(tone.charAt(1)), this.typesTable.get(type));
		
		if(((ProxyDocument) this.doc).addBarCompass) {
			this.player.addBarCompass();
			((ProxyDocument) this.doc).addBarCompass = false;
		}
		
		((ProxyDocument) this.doc).addNote(0, null);
		
		this.dispose();
	}
}
