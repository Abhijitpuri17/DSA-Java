package segmentTrees.sumInRange;

import java.util.Scanner;

class SegmentTree
{
    long[] seg ;

    SegmentTree(int n)
    {
        seg = new long[4 * n] ;
    }

    public void build(long[] arr, int low, int high, int ind)
    {
        if (low == high) {
            seg[ind] = arr[low] ;
            return;
        }

        int mid =  low + ((high - low)>>1) ;

        build(arr, low, mid, 2 * ind + 1) ;
        build(arr, mid+1, high, 2 * ind + 2) ;

        seg[ind] = seg[2 * ind + 1] + seg[2 * ind + 2] ;
    }

    long query(int low, int high, int l, int h, int ind)
    {
        if (h < low || l > high) return 0 ;

        if (l <= low && high <= h)
        {
            return seg[ind] ;
        }

        int mid = low + ((high-low)>>1) ;

        long left = query(low, mid, l, h, 2 * ind + 1) ;

        long right = query(mid+1, high, l, h, 2 * ind + 2) ;

        return left + right ;

    }

    void pointUpdate(int pos, int val, int low, int high, int ind)
    {
        if (low == high) {
            seg[ind] = val ;
            return;
        }

        int mid =  low + ((high-low)>>1) ;

        if (pos <= mid)
            pointUpdate(pos, val, low, mid, 2 * ind + 1);
        else
            pointUpdate(pos, val, mid+1, high, 2 * ind + 2) ;

        seg[ind] = seg[2 * ind + 1] + seg[2 * ind + 2] ;

    }

}

public class SumInRange
{


    public static void main(String[] args) {

        long[] arr = {1,2,3,4,5} ;

        SegmentTree st = new SegmentTree(arr.length) ;

        Scanner sc = new Scanner(System.in) ;

        st.build(arr, 0, arr.length-1, 0);

        for (int i = 0 ; i < 10 ; i++)
        {
            int type = sc.nextInt() ;

            if (type == 1)
            {
                int pos = sc.nextInt() ;
                int val = sc.nextInt() ;

                st.pointUpdate(pos, val, 0, arr.length-1, 0);
            }
            else{
                int l = sc.nextInt(), h = sc.nextInt();

                System.out.println(st.query(0, arr.length-1, l, h, 0)) ;
            }
        }

    }


}
