package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program{
	
	public static void main(String[] args) {
		
		
		try {
			Scanner sc = new Scanner(System.in);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			System.out.print("N�mero da reserva: ");
			int number = sc.nextInt();
			System.out.print("Check-in entre com a data (dia/m�s/ano): ");
			Date checkIn = sdf.parse(sc.next());	//converte do tipo texto
			System.out.print("Check-Out entre com a data (dia/m�s/ano): ");
			Date checkOut = sdf.parse(sc.next());
			
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println(reservation);
			
			System.out.println();
			System.out.println("Entre com atualiza��o da Reserva");
			System.out.print("Check-in entre com a data (dia/m�s/ano): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out entre com a data (dia/m�s/ano): ");
			checkOut = sdf.parse(sc.next());
			
		
			reservation.updateDate(checkOut, checkIn);//retorna string
			System.out.println("Reserva: "+ reservation);
		}
		catch(ParseException e) {
			System.out.println("Formato de data Inv�lido");
		}
		catch(IllegalArgumentException e) {
			System.out.println("Erro na reserva: "+e.getMessage());
		}
	}

}
