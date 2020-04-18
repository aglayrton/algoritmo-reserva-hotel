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
			System.out.print("Número da reserva: ");
			int number = sc.nextInt();
			System.out.print("Check-in entre com a data (dia/mês/ano): ");
			Date checkIn = sdf.parse(sc.next());	//converte do tipo texto
			System.out.print("Check-Out entre com a data (dia/mês/ano): ");
			Date checkOut = sdf.parse(sc.next());
			
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println(reservation);
			
			System.out.println();
			System.out.println("Entre com atualização da Reserva");
			System.out.print("Check-in entre com a data (dia/mês/ano): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out entre com a data (dia/mês/ano): ");
			checkOut = sdf.parse(sc.next());
			
		
			reservation.updateDate(checkOut, checkIn);//retorna string
			System.out.println("Reserva: "+ reservation);
		}
		catch(ParseException e) {
			System.out.println("Formato de data Inválido");
		}
		catch(IllegalArgumentException e) {
			System.out.println("Erro na reserva: "+e.getMessage());
		}
	}

}
