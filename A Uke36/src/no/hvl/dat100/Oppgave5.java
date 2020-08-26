package no.hvl.dat100;
import javax.swing.JOptionPane;

// Oppgave 5 - Karakter og poengsum
public class Oppgave5 {

	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {

			System.out.println(i);
			int poengInput = Integer.valueOf(JOptionPane.showInputDialog("Skriv inn poengsum"));
			
			String karakter = "";
			
			if (poengInput < 0 || poengInput > 100) {
				karakter = "Ugyldig sum tastet inn";
				i--;
			} else if (poengInput >= 90) {
				karakter = "A";
			} else if (poengInput >= 80) {
				karakter = "B";
			} else if (poengInput >= 60) {
				karakter = "C";
			} else if (poengInput >= 50) {
				karakter = "D";
			} else if (poengInput >= 40) {
				karakter = "E";
			} else {
				karakter = "F";
			}
			
			JOptionPane.showMessageDialog(null, karakter);
		
		}

	}

}
