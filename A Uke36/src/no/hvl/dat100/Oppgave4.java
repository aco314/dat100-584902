package no.hvl.dat100;
import javax.swing.JOptionPane;

// Oppgave 4 - Trinnskatt kalkulator (2017)
public class Oppgave4 {

	public static void main(String[] args) {
		
		// To tabeller, som inneholder grensen og satsen til hvert trinn, i synkende rekkefølge.
		int[] skatteGrenser = {934050, 580650, 230950, 164100};
		double[] skatteProsent = {0.1452, 0.1152, 0.0241, 0.0093};
		
		int inntekt = Integer.valueOf(JOptionPane.showInputDialog("Skriv inn inntekt:"));
		double sumSkatt = 0.0;
		
		// En løkke som kjører opptil 4 ganger. Den vil regne ut skatten til et nytt trinn hver gang den går.
		for (int i = 0; i < 4; i++) {
			
			if (inntekt > skatteGrenser[i]) {
				
				// Differansen mellom inntekten og minimumsbeløpet for dette trinnet. Det er denne
				// summen vi skal betale skatt på. 
				int diff = inntekt - skatteGrenser[i];
				System.out.println("Differanse: " + diff);
				
				// Regner ut skatten for dette trinnet.
				double delSkatt = skatteProsent[i] * diff;
				
				// Oppdaterer variabelen som lagrer summen av all skatt vi har betalt så langt.
				sumSkatt += delSkatt;
				
				// Variabelen som holder inntekten reduseres med differansen, sånn at neste gang løkken kjøres
				// vil skatten beregnes i neste trinn. 
				inntekt -= diff;
				System.out.println("--Gjenstående inntekt å beregne: " + inntekt);
				
				System.out.println("----Skatt så langt" + i + ": " + sumSkatt);
				
			// Om inntekten er mindre enn den minste grensen, trenger man ikke å betale noe
			// skatt på dette trinnet. Løkken kan også da avbrytes.
			} else if (inntekt <= skatteGrenser[skatteGrenser.length-1]) {
				System.out.println("SISTE");
				break;
			}
			
		}
		
		// Runder skattebeløpet av
		sumSkatt = Math.round(sumSkatt);
		
		// Caster skattebeløpet til int for å bli kvitt ".0" på slutten
		JOptionPane.showMessageDialog(null, "Din trinnskatt er " + (int)sumSkatt + "kr");

	}

}
