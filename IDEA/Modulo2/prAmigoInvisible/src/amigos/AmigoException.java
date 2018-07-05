package amigos;

public class AmigoException extends RuntimeException
{
    private String message;

    public AmigoException() { }

	public AmigoException(String message)
    {
        this.message = message;
    }

    @Override
    public String getMessage()
    {
        return message;
    }
}