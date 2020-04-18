package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program{
	
	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Número da reserva: ");
		int number = sc.nextInt();
		
		System.out.print("Check-in entre com a data (dia/mês/ano): ");
		Date checkIn = sdf.parse(sc.next());	//converte do tipo texto
		
		System.out.print("Check-Out entre com a data (dia/mês/ano): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva (A entrada de Check-in não pode ser depois do que a saída)");
		}else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println(reservation);
			
			System.out.println();
			System.out.println("Entre com atualização da Reserva");
			System.out.print("Check-in entre com a data (dia/mês/ano): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out entre com a data (dia/mês/ano): ");
			checkOut = sdf.parse(sc.next());
			
		
			String error = reservation.updateDate(checkOut, checkIn);//retorna string
			
			if(error != null) {
				System.out.println("Erro na reserva: "+error);
			}else {
				System.out.println("Reserva: "+ reservation);
			}
	
			
		}
	}

}
