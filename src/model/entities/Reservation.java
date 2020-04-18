package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		if(!checkOut.after(checkIn)) {
			throw new DomainException("A entrada de Check-in não pode ser depois do que a saída");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public long duration() {
		long diff = this.checkOut.getTime() - checkIn.getTime();//Pega o tempo em milisegundos
		//Classe abaixo utiliza enumerações
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);//quantidade de milisegundos e o comando no argumento
		//comando acima converte me dias
	}
	
	public void updateDate(Date checkOut, Date checkIn) {
		
		Date agora = new Date();
		//se a data de checkIn ou checkOut for antes de agora
		if(checkIn.before(agora) || checkOut.before(agora)) {
			throw  new DomainException("As datas de reserva para atualização devem ser datas futuras"); //usando quando os argumentos da exceção são inválidos
		}
		if(!checkOut.after(checkIn)) {
			throw new DomainException("A entrada de Check-in não pode ser depois do que a saída");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	public String dias() {
		Long duracao = duration();
		String quant = null;
		
		if(duracao == 1) {
			quant = "dia";
		}else {
			quant = "dias";
		}
		
		return quant;
	}
	
	@Override
	public String toString() {
		return "Reserva "
			+ "Número da Reserva"
			+ ", Entrada "
			+ sdf.format(checkIn)
			+ ", Saída "
			+ sdf.format(checkOut)
			+ ", Duração "
			+ duration()
			+ " " + dias();
	}
}
