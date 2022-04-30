package segmentTrees.minInRange;

class SegmentTree {

    int[] seg ;
    void build(int[] arr, int low, int high, int ind)
    {
        if (low == high) {
            seg[ind] = arr[low] ;
            return ;
        }
        int mid = low + ((high - low)>>1) ;

        build(arr, low, mid, 2 * ind + 1) ;
        build(arr, mid+1, high, 2 * ind + 2);

        seg[ind] = Math.min(seg[2 * ind + 1] , seg[2 * ind + 2]) ;
    }

    SegmentTree(int n){
        seg = new int[4 * n] ;
    }

    int query(int l, int h, int low, int high, int ind)
    {
        if (high < l || low > h) return Integer.MAX_VALUE ;

        if (l <= low && high <= h)
            return seg[ind] ;

        int mid = low + ((high - low)>>1) ;

        int left = query(l, h, low, mid, 2 * ind + 1) ;
        int right = query(l, h, mid + 1, high, 2 * ind + 2) ;


        return Math.min(left, right) ;

    }


    void update(int i, int val, int ind, int low, int high) {
        if (high == low) {
            seg[ind] = val;
            return;
        }

        int mid = low + ((high - low) >> 1);

        if (i <= mid) {
            update(i, val, 2 * ind + 1, low, mid);
        } else {
            update(i, val, 2 * ind + 2, mid + 1, high);
        }

        seg[ind] = Math.min(seg[2 * ind + 1], seg[2 * ind + 2]);

    }
}


public class MinInRange
{




    public static void main(String[] args) {

        int[] arr = {1,2,3} ;

        SegmentTree sg = new SegmentTree(arr.length) ;

        sg.build(arr, 0, arr.length-1, 0);

        System.out.println(sg.query(1,2,0,arr.length-1,0));

        sg.update(1, 5, 0, 0, arr.length-1);

        System.out.println(sg.query(1,2,0,arr.length-1,0));


    }



}



