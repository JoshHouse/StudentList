package StudentList;
/**
 * Creates the student class
 * @author joshuahouse
 *
 */
public class Student {
	private String id, name, dateOfBirth, major;
	private char gender;
	/**
	 * Constructor that takes the id, name, gender, dateOfBirth, major and sets them as the
	 * values for the student object
	 * @param id
	 * @param n
	 * @param g
	 * @param DoB
	 * @param m
	 */
	public Student(String id, String n, char g, String DoB, String m)
	{
		this.id = id;
		this.name = n;
		this.gender = g;
		this.dateOfBirth = DoB;
		this.major = m;
	}
	/**
	 * Constructor that takes the id, name, gender, date of birth and sets them as the
	 * values for the student object and sets the major to "Undeclared"
	 * 
	 * @param id
	 * @param n
	 * @param g
	 * @param DoB
	 */
	public Student(String id, String n, char g, String DoB)
	{
		this.id = id;
		this.name = n;
		this.gender = g;
		this.dateOfBirth = DoB;
		this.major = "undeclared";
	}
	/**
	 * Returns the id
	 * @return id
	 */
	public String getId()
	{
		return id;
	}
	/**
	 * Returns the name
	 * @return name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * Returns the gender
	 * @return gender
	 */
	public char getGender()
	{
		return gender;
	}
	/**
	 * Returns the date of birth
	 * @return dateOfBirth
	 */
	public String getDateOfBirth()
	{
		return dateOfBirth;
	}
	/**
	 * Returns the major
	 * @return major
	 */
	public String getMajor()
	{
		return major;
	}
	/**
	 * Sets the Students id to the inputed string
	 * @param id
	 */
	public void setId(String id)
	{
		this.id = id;
	}
	/**
	 * Sets the Students name to the inputed string
	 * @param id
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	/**
	 * Sets the Students gender to the inputed character
	 * @param id
	 */
	public void setGender(char gender)
	{
		this.gender = gender;
	}
	/**
	 * Sets the Students date of birth to the inputed string
	 * @param id
	 */
	public void setDateOfBirth(String DoB)
	{
		this.dateOfBirth = DoB;
	}
	/**
	 * Sets the Students major to the inputed string
	 * @param id
	 */
	public void setMajor(String major)
	{
		this.major = major;
	}
	/**
	 * Overwritten toString method that puts the students information in the correct format
	 */
	public String toString()
	{
		return id + "," + name + "," + gender + "," + dateOfBirth + "," + major;
	}
	/**
	 * Finds a student by name
	 * @param StudentArray
	 * @param StudentCount
	 * @param Name
	 * @return student index
	 * @throws StudentNotFoundException
	 */
	static public int StudentSearchByName(Student[] StudentArray, int StudentCount, String Name) throws StudentNotFoundException
	{
		for(int x = 0; x < StudentCount; x++)
		{
			if (StudentArray[x].getName().equals(Name))
			{
				return x;
			}
		}
		throw new StudentNotFoundException();
	}
	/**
	 * Finds student by id
	 * @param StudentArray
	 * @param StudentCount
	 * @param Id
	 * @return student index
	 * @throws StudentNotFoundException
	 */
	static public int StudentSearchById(Student[] StudentArray, int StudentCount, String Id) throws StudentNotFoundException
	{
		for(int x = 0; x < StudentCount; x++)
		{
			if (StudentArray[x].getId().equals(Id))
			{
				return x;
			}
		}
		throw new StudentNotFoundException();
	}
}
