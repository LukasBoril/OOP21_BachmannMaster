package ch.zhaw.example.BoTests.extendedHelloWorld;

import javax.swing.*;
import java.io.IOException;

/**
 * Dieses Bsp zeigt die Basics von JOptionPane
 * JOptionPane kann direkt von der Tastatur einlesen und ein
 * /Scanner sc = new Scanner(System.in)
 * /String eingabe = sc.next()....
 * ...ist nicht mehr nötig.
 *
 * Ausserdem regelt JOptionPane auch ob man mit der Maus
 * OK wählt oder ob man Enter drückt.
 * cool
 *
 * Benötigte Klassen sind javax.swing.* und java.io.IOException falls
 * noch mit Exceptions gearbeitet wird
 */
public class App {
   public static void main(String[] args) throws IOException {

       //Hier ein Teil des Klassikers, just for fun
       String hi = "Hello Bo";
       HelloBo helloBo = new HelloBo(hi);

       try{     // JOptionPane.showInputDialog() gibt nicht nur die Info sonder liest grad mit ein
                // und schreibt dies in die variable <input>
           String input = JOptionPane.showInputDialog(
                   null,helloBo.getString() +" tip was ein...");

                //kopieren con <input> in eine neuen String var...
           String answer = "Hi du hast " +input +" eingegeben";

                //JOptionPane.showMessageDialog() kreiert ein neues Fenster und gibt
                //alles als String Info in dem Fenster wieder aus.
          JOptionPane.showMessageDialog(
                  null, input, "Eingabe war",JOptionPane.INFORMATION_MESSAGE);
       }
       catch(Exception e) {
           JOptionPane.showMessageDialog(
                   null, "bei der Eingabe ist was schiefgelaufen");
       }
    }
}