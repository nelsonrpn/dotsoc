package exceptions;

public class NotHiddenLayerException extends Exception{

	private static final long serialVersionUID = 5242844824850131414L;
	
	public NotHiddenLayerException() {
		super("Attempt to access back layer in the input layer");
	}

}
