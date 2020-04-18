package model.exceptions;

public class DomainException extends Exception{

	/**
	 * Classe personalizada para exceção
	 * Abaixo temos a versão da classe Serializable
	 */
	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg) {
		super(msg);
	}
}
