package phone2013;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

interface Vue {
  public void maj(boolean enCom, String numero);
}

class EtatTelephone {
  private boolean enCom;
  String numeroAppele;
  Vector observateurs;
    int i;

  public EtatTelephone(){
	      enCom = false;
	      numeroAppele = "";
	      observateurs = new Vector();
  }

  public void ecoutePar(Object o) {
      observateurs.add(o);
  }

//cette methode est utilisee principalement par les controleurs qui peuvent changer l'�tat du t�l�phone.
  public void change(boolean enCom, String numero) {
      // pour pouvoir passer en communication il faut ne pas d�j� �tre en com...	  
      System.out.println("Etat Change"+ this.enCom + " -> " + enCom + " - " + i++ );

    if (this.enCom == true && enCom == true){
	JOptionPane.showMessageDialog(null, "Attention: vous �tes d�j� en communication, raccrocher avant d'entamer une nouvelle communication", "Erreur: ligne occup�e", JOptionPane.ERROR_MESSAGE);
    }else{
	/* NB: on genere ici une maj meme si rien n'a chang� (quand this.enCom == false et enCom == false !!) on pourrait �viter ca en ajoutant 2/3 lignes de code mais pour le moment on n'en n'a pas besoin car pour le moment, cette situation ne peut pas arriver.*/
	this.enCom = enCom ;
	numeroAppele = numero;
	for (Enumeration e = observateurs.elements(); e.hasMoreElements();){
	    Vue tmp = (Vue) e.nextElement();
	    tmp.maj(enCom,numero);
	}
    }
  }
}




