package bits;

/** 
 * @author Abhijit Puri
 */
public class Masking_Merging 
{
	
    static int getBit(int n , int pos)
    {
        int mask = 1 << pos ;
        if ((n&mask) == 0) return 0 ;
        return 1 ;
    }

    static int setBit(int n, int pos)
    {
        // mask has bit 1 at pos and all other 0
        int mask = 1 << pos ;
        n |= mask ;
        return n ;
    }

    static int clearBit(int n, int pos)
    {
        // mask has 0 bit at pos and 1 at all other positions
        int mask = ~(1 << pos) ;
        n &= mask ;
        return n ;
    }

    static int clearLastLBits(int n , int l)
    {
        // 111 ... (0) l times
        int mask = (-1<<l) ;
        
        n &= mask ;
        return n ;
    }

    static int clearBitsInRange(int n , int i, int j)
    {
        int a = (-1 << (j+1)) ;
        int b = (1 << i) - 1 ;
        // mask has 0 bits in range [i, j]
        int mask = a|b ;
        n &= mask ;
        return n ;
    }

    static int setBitsInRangeTo(int n, int m , int i, int j)
    {
        n = clearBitsInRange(n, i, j) ;

        int mask = m << i ;

        n |= mask ;

        return n ;
    }
	

	public static void main(String[] args) 
	{
		System.out.println(clearBit(5, 0));
	}

}
