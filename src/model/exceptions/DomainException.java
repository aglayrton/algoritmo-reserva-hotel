package model.exceptions;

public class DomainException extends Exception{

	/**
	 * Classe personalizada para exce��o
	 * Abaixo temos a vers�o da classe Serializable
	 */
	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg) {
		super(msg);
	}
}
