package exception;

import javassist.SerialVersionUID;

public class ResourceNotFoundException extends RuntimeException{
	
	public ResourceNotFoundException(String msg){
		super(msg);
	}

}
