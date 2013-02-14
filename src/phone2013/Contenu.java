package phone2013;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Contenu extends JPanel {
	MainWindow fp;
	SaisieNumero saisieNumero;
	JToggleButton details;
	Onglets onglets;
	StatusBar statusBar;
	EtatTelephone et;

	public Contenu(MainWindow mainWindow) {
		super();
		this.fp = mainWindow;

		// assurer la cohérence entre les différents composants
		// en s'inspirant de MVC
		et = new EtatTelephone();

		/* initialisation des composants */
		saisieNumero = new SaisieNumero(et);
		onglets = new Onglets(et);
		details = new JToggleButton("Détails + / -");
		statusBar = new StatusBar();

		// associer les composants a l'etat qui assure la coherence - inspiré de
		// MVC
		et.ecoutePar(saisieNumero);
		et.ecoutePar(statusBar);

		// bascule vue petite/grande
		// NB: ici on utilise une classe interne car on peut parier que cet
		// actionListener ne servira pas ailleurs
		details.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((details.getModel()).isSelected()) {
					showAll(false);
				} else {
					showAll(true);
				}
			}
		});

		/* placement des composants */
		placeComposants();
	}

	public void placeComposants() {
		Box boite;
		Component glue;

		setLayout(new BorderLayout());

		boite = Box.createHorizontalBox();
		Component st;
		boite.add(saisieNumero);
		glue = Box.createHorizontalGlue();
		boite.add(glue);
		boite.add(details);
		st = Box.createHorizontalStrut(30);
		boite.add(st);

		add(boite, BorderLayout.NORTH);
		add(onglets, BorderLayout.CENTER);
		add(statusBar, BorderLayout.SOUTH);
	}

	public void showAll(boolean t) {
		if (t) {
			onglets.setVisible(true);
			fp.pack();
		} else {
			onglets.setVisible(false);
			fp.pack();
		}
	}
}
