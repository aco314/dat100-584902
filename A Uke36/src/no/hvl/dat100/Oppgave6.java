package no.hvl.dat100;
import java.util.Scanner;

public class Oppgave6 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Skriv inn et tall:");
		int tall = Integer.valueOf(scanner.nextLine());
		int sum = 1;
		
		if (tall >= 0) {
			
			for (int i = 1; i <= tall; i++) {
				
				sum *= i;
				//System.out.println(sum);
			}
			
			System.out.println(tall + "! = " + sum);
		}
		
		

	}

}
