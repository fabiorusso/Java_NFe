package br.com.samuelweb.nfe;

public class ArquivoConfiguracaoNaoEncontradoException extends ConfiguracaoNfeException {

	private static final long serialVersionUID = -1957441622097471684L;

	public ArquivoConfiguracaoNaoEncontradoException() {
	}

	public ArquivoConfiguracaoNaoEncontradoException(String message) {
		super(message);
	}

	public ArquivoConfiguracaoNaoEncontradoException(Throwable exception) {
		super(exception);
	}

	public ArquivoConfiguracaoNaoEncontradoException(String message, Throwable e) {
		super(message, e);
	}

	public ArquivoConfiguracaoNaoEncontradoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
