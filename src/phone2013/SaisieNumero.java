package phone2013;

import java.awt.datatransfer.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SaisieNumero extends Box implements Vue {
	EtatTelephone etat; // le modele
	JComboBox<String> comboBox;
	JToggleButton raccrocher, decrocher;
	Box boxNum;
		Dimension cbdim = new Dimension(120, 25);
		Dimension sndim = new Dimension(500, 40);
	
	public SaisieNumero(EtatTelephone et) {
		super(BoxLayout.LINE_AXIS);
		Component strut;
		this.etat = et;
		setPreferredSize(sndim);
		setMaximumSize(sndim);
		setMinimumSize(sndim);

		/* Creation des composants */
		raccrocher = new JToggleButton("Raccrocher", true);
		raccrocher.setEnabled(false);
		decrocher = new JToggleButton("Décrocher", false);
		comboBox = new JComboBox<String>();
		comboBox.setPreferredSize(cbdim);
		comboBox.setMaximumSize(cbdim);
		comboBox.setMaximumRowCount(4); // les 4 derniers numeros sont visibles
										// pour plus il faut "scroller"
		comboBox.setEditable(true);

		// Interaction avec les boutons et la combo
		ControleSaisieNumero csn = new ControleSaisieNumero(this);
		comboBox.getEditor().addActionListener(csn);
		decrocher.addActionListener(csn);
		raccrocher.addActionListener(csn);

		strut = Box.createHorizontalStrut(10);
		add(strut);
		add(raccrocher);
		strut = Box.createHorizontalStrut(10);
		add(strut);
		add(comboBox);
		strut = Box.createHorizontalStrut(10);
		add(strut);
		add(decrocher);
		strut = Box.createHorizontalStrut(10);
		add(strut);
	}

	// methode pour implementer l'interface Ecouteur
	public void maj(boolean enCom, String numero) {
		decrocher.getModel().setSelected(enCom);
		decrocher.setEnabled(!enCom);
		raccrocher.getModel().setSelected(!enCom);
		raccrocher.setEnabled(enCom);
		if (enCom) {
			comboBox.insertItemAt(numero, 0);
			comboBox.setSelectedItem(numero);
			comboBox.setEnabled(false);
		} else {
			comboBox.setEnabled(true);
		}
	}

}
