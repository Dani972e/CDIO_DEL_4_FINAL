
public class Die {

	
	private final int MAX = 6;  // maximum øjne værdi

	private int faceValue;  // nuværende øjne værdi

	// konstruktør
	public Die(int value)
	{
		faceValue = value;
	}

	// kast terning og returner øjne værdi
	public int roll()
	{
		faceValue = (int)(Math.random() * MAX) + 1;
		return faceValue;
	}

	// sæt øjne værdi
	public  void setFaceValue (int value)
	{
		faceValue = value;
	}

	// hent øjne værdi
	public int getFaceValue()
	{
		return faceValue;
	}

	// returnerer en streng repræsentation af objektets data
	public String toString()
	{
		String result = "" + faceValue;
		return result;
	}
}
