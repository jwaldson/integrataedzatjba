package br.com.edza.cjus.excecao;

@SuppressWarnings("serial")
public class EdzaException extends Exception {

	private String [] args;

	public EdzaException() {	
	}

	public EdzaException(Throwable excecao) {
		super(excecao.getMessage());		
		super.initCause(excecao.getCause());
	}

	public EdzaException(String key, String ... args) {		
		super(key);
		setArgs(args);
	}


	public String[] getArgs() {
		return args;
	}

	public void setArgs(String[] args) {
		this.args = args;
	}
		
}
