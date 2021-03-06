package no.hvl.dat100;
import javax.swing.JOptionPane;

// Oppgave 4 - Trinnskatt kalkulator (2017)
public class Oppgave4 {

	public static void main(String[] args) {
		
		// To tabeller, som inneholder grensen og satsen til hvert trinn, i synkende rekkef�lge.
		int[] skatteGrenser = {934050, 580650, 230950, 164100};
		double[] skatteProsent = {0.1452, 0.1152, 0.0241, 0.0093};
		
		int inntekt = Integer.valueOf(JOptionPane.showInputDialog("Skriv inn inntekt:"));
		double sumSkatt = 0.0;
		
		// En l�kke som kj�rer opptil 4 ganger. Den vil regne ut skatten til et nytt trinn hver gang den g�r.
		for (int i = 0; i < 4; i++) {
			
			if (inntekt > skatteGrenser[i]) {
				
				// Differansen mellom inntekten og minimumsbel�pet for dette trinnet. Det er denne
				// summen vi skal betale skatt p�. 
				int diff = inntekt - skatteGrenser[i];
				System.out.println("Differanse: " + diff);
				
				// Regner ut skatten for dette trinnet.
				double delSkatt = skatteProsent[i] * diff;
				
				// Oppdaterer variabelen som lagrer summen av all skatt vi har betalt s� langt.
				sumSkatt += delSkatt;
				
				// Variabelen som holder inntekten reduseres med differansen, s�nn at neste gang l�kken kj�res
				// vil skatten beregnes i neste trinn. 
				inntekt -= diff;
				System.out.println("--Gjenst�ende inntekt � beregne: " + inntekt);
				
				System.out.println("----Skatt s� langt" + i + ": " + sumSkatt);
				
			// Om inntekten er mindre enn den minste grensen, trenger man ikke � betale noe
			// skatt p� dette trinnet. L�kken kan ogs� da avbrytes.
			} else if (inntekt <= skatteGrenser[skatteGrenser.length-1]) {
				System.out.println("SISTE");
				break;
			}
			
		}
		
		// Runder skattebel�pet av
		sumSkatt = Math.round(sumSkatt);
		
		// Caster skattebel�pet til int for � bli kvitt ".0" p� slutten
		JOptionPane.showMessageDialog(null, "Din trinnskatt er " + (int)sumSkatt + "kr");

	}

}
