package segmentTrees.lazyPropagation.minInRange;

import java.util.Scanner;

public class SegmentTree
{
    long[] seg, lazy ;

    SegmentTree(int n)
    {
        seg = new long[4 * n] ;
        lazy = new long[4 * n] ;
    }

    void build(int low, int high, int ind, long[] arr)
    {
        if (low == high){
            seg[ind] = arr[low] ;
            return;
        }

        int mid = low  + ((high - low)>>1) ;

        build(low, mid, 2 * ind + 1, arr);
        build(mid+1, high, 2*ind+2, arr) ;

        seg[ind] = Math.min(seg[2*ind+1], seg[2*ind+2]) ;
    }

    void rangeUpdate(int l, int r, int low, int high, int ind, long val)
    {
        if (lazy[ind] != 0)
        {
            seg[ind] += lazy[ind] ;

            if (low != high)
            {
                lazy[2*ind+1] += lazy[ind] ;
                lazy[2*ind+2] += lazy[ind] ;
            }

            lazy[ind] = 0 ;
        }


        if (l > high || r < low) return;

        if (l <= low && high <= r)
        {
            seg[ind] += val ;

            if (low != high)
            {
                lazy[2*ind + 1] += val ;
                lazy[2*ind + 2] += val ;
            }

            return;
        }

        int mid = low + ((high - low)>>1) ;
        rangeUpdate(l, r, low, mid, 2*ind+1, val);
        rangeUpdate(l, r, mid+1, high, 2*ind+2, val);

        seg[ind] = Math.min(seg[2*ind+1], seg[2*ind+2]) ;

    }

    long query(int l, int r, int low, int high, int ind)
    {
        if (lazy[ind] != 0)
        {
            seg[ind] += lazy[ind] ;

            if (low != high)
            {
                lazy[2*ind+1] += lazy[ind] ;
                lazy[2*ind+2] += lazy[ind] ;
            }

            lazy[ind] = 0 ;
        }

        if (r < low || l > high) return Long.MAX_VALUE ;

        if (l <= low && high <= r) return seg[ind] ;

        int mid = low + ((high-low)>>1) ;

        long left = query(l, r, low, mid, 2*ind+1) ;
        long right = query(l, r, mid+1, high, 2*ind+2) ;

        return Math.min(left, right) ;
    }

    public static void main(String[] args) {
        long[] arr = {1,2,3,4,5,6,7,8,9,10} ;
        SegmentTree st = new SegmentTree(arr.length) ;

        st.build(0, arr.length-1, 0, arr);

        Scanner sc =  new Scanner(System.in) ;
        int q = sc.nextInt() ;

        while (q-- > 0)
        {
            int type = sc.nextInt() ;
            if (type == 1) {
                int l = sc.nextInt(), r = sc.nextInt() ;
                System.out.println(st.query(l, r, 0, arr.length-1, 0)) ;
            } else if (type == 2){
                int l = sc.nextInt(), r= sc.nextInt();
                long val = sc.nextLong() ;

                st.rangeUpdate(l, r, 0, arr.length-1, 0, val);

            }

        }

    }

}
