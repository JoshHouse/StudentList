package StudentList;

public class StudentNotFoundException extends Exception
{
	private static final long serialVersionUID = 1L;
	/**
	 * Default constructor
	 */
	public StudentNotFoundException()
	{
		super("Student not found");
	}
	/**
	 * Constructor that allows you to return a specific message
	 * @param s
	 */
	public StudentNotFoundException(String s)
	{
		super(s);
	}
}
