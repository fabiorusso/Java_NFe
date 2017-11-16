package br.com.samuelweb.nfe;

public class ConfiguracaoNfeException extends Exception {

	/**
	 * version 1.0
	 */
	private static final long serialVersionUID = -4892522965740849773L;

	public ConfiguracaoNfeException() {
	}

	public ConfiguracaoNfeException(String message) {
		super(message);
	}

	public ConfiguracaoNfeException(Throwable exception) {
		super(exception);
	}

	public ConfiguracaoNfeException(String message, Throwable e) {
		super(message, e);
	}

	public ConfiguracaoNfeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
