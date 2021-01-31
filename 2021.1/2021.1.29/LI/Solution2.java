public class Solution2 {
    public static void main(String[] args) {
        int[] a = {1, 3};
        int[] b = {2};
        Solution2 s = new Solution2();
        System.out.println(s.findMedianSortedArrays(a, b));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        if(n == 0){return MedianForAnArray(nums2);}
        if(m == 0){return MedianForAnArray(nums1);}
        return (findKth(nums1, 0, n-1, nums2, 0, m - 1, (n+m+1)/2) + findKth(nums1, 0, n-1, nums2, 0, m - 1, (n+m+2)/2))/2.;
    }

    public int findKth(int[] nums1, int debut1, int fin1, int[] nums2, int debut2, int fin2, int k){
        int n = fin1 - debut1 + 1;
        int m = fin2 - debut2 + 1;
        if(n>m){
            return findKth(nums2, debut2, fin2, nums1, debut1, fin1, k);
        }
        if(n == 0){
            return nums2[debut2 + Math.min(k, m) - 1];
        }
        if(k == 1){
            return Math.min(nums1[debut1], nums2[debut2]);
        }

        int i = debut1 + (Math.min(k/2, n) - 1);
        int j = debut2 + (Math.min(k/2, m) - 1);
        if(nums1[i] <= nums2[j]){
            return findKth(nums1, i + 1, fin1, nums2, debut2, fin2, k - (i - debut1 + 1));
        }else{
            return findKth(nums1, debut1, fin1, nums2, j + 1, fin2, k - (j - debut2 + 1));
        }
    } 

    public double MedianForAnArray(int[] nums){
        int len = nums.length;
        if(len == 0){
            return 0.;
        }
        boolean unOuDeux = len%2==1;
        int medianIndex = len/2;
        if (unOuDeux){
            return nums[medianIndex];
        }else{
            return (nums[medianIndex] + nums[medianIndex - 1])/2.;
        }
    } 

    
}