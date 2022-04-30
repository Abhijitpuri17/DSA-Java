package bits;

/** 
 * @author Abhijit Puri
 */
public class Masking_Merging 
{
	
	/** 
	 * @param a = number
	 * @param pos = position where bit has to be set i.e. set bit to 1
	 * @return number after setting bit at given position
	 * This is called as merging
	 */
	static long setBit(long a, long pos)
	{
		return a | (1 << pos) ;
	}
	
	/**
	 * @param a
	 * @param pos
	 * @return number after clearing bit at given position i.e. setting bit to 0
	 */
	static long clearBit(long a, long pos)
	{
	    return (a & ~(1 << pos)) ;
	}
	
	/**
	 * @param a = number to check
	 * @param pos = position at which bit has to be found
	 * @return bit at given position for given number (1 or 0)
	 */
	static int findBit(long a, long pos)
	{
		long mask = 1 << pos ;
		if ((a & mask) == 0) return 0 ;
		return 1 ;
	}
	

	public static void main(String[] args) 
	{
		System.out.println(clearBit(5, 0));
	}

}
