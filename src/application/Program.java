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
		
		System.out.print("N�mero da reserva: ");
		int number = sc.nextInt();
		
		System.out.print("Check-in entre com a data (dia/m�s/ano): ");
		Date checkIn = sdf.parse(sc.next());	//converte do tipo texto
		
		System.out.print("Check-Out entre com a data (dia/m�s/ano): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva (A entrada de Check-in n�o pode ser depois do que a sa�da)");
		}else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println(reservation);
			
			System.out.println();
			System.out.println("Entre com atualiza��o da Reserva");
			System.out.print("Check-in entre com a data (dia/m�s/ano): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out entre com a data (dia/m�s/ano): ");
			checkOut = sdf.parse(sc.next());
			
			Date agora = new Date();
			//se a data de checkIn ou checkOut for antes de agora
			if(checkIn.before(agora) || checkOut.before(agora)) {
				System.out.println("Erro na reserva: As datas de reserva para atualiza��o devem ser datas futuras");
			}else if(!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva: A entrada de Check-in n�o pode ser depois do que a sa�da");
			}else {
				reservation.updateDate(checkOut, checkIn);
				System.out.println(reservation);
			}
			
			
			
			
		}
	}

}