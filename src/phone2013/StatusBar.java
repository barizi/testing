package phone2013;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class StatusBar extends JLabel implements Vue {
  public StatusBar(String st){
    super(st);
  }
  public StatusBar(){
    super("Etat: hors communication");
  }
  public void maj(boolean enCom, String numero){
    if (enCom){
      setText("Etat: En communication avec " + numero);
    }else{
      setText("Etat: Hors communication");
    }
  }
}

