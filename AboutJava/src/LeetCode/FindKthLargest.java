package LeetCode;

/**
 * @author Ling
 * Created on 2019/10/1
 */
public class FindKthLargest {
    public int findKthLargest(int[] arr, int k) {
        int len = arr.length;
        return getK(arr,len-k,0,len-1);
    }

    public int getK(int[] arr, int k, int left, int right) {
        int l = left;
        int r = right;
        int base = arr[l];
        while (l<r) {
            while (l<r && arr[r]>=base)   r--; // 先从左往右扫到小于base的停止，所以l和r相遇时可以将之与左边的base交换，而不破坏顺序
            while (l<r && arr[l]<=base)   l++;// 如果base选取最右边的话，则要先从左往右扫。
            swap(arr, l, r);
        }
        swap(arr,l,left);
        if (l==k)
            return base;
        if (l<k)
            return getK(arr,k,l+1,right);
        else
            return getK(arr,k,left,l-1);
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        FindKthLargest f = new FindKthLargest();
        int[] a = {3,2,3,1,2,4,5,5,6};
        System.out.println(f.findKthLargest(a,4));
    }
}
