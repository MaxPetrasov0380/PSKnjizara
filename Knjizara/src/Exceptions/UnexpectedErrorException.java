package Exceptions;

public class UnexpectedErrorException extends Exception
{
   private String additionalMessage;

	public UnexpectedErrorException(String message) 
	{
	    super(message);
	    additionalMessage = "";
	}

	public UnexpectedErrorException(String message, String additionalMessage) 
	{
	    super(message);
	    this.additionalMessage = additionalMessage;
	}

	public String getAdditionalMessage() 
	{
	    return additionalMessage;
	}
}
