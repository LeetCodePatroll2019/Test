public class Solution {
    public static void main(String[] args) {
        int[] a = {1};
        int[] b = {2, 3, 4};
        Solution s = new Solution();
        System.out.println(s.findMedianSortedArrays(a, b));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        if(n == 0){return MedianForAnArray(nums2);}
        if(m == 0){return MedianForAnArray(nums1);}
        return MedianForAnArray(mergeArray(nums1, nums2));
        // boolean unOuDeux1 = n%2 == 1, unOuDeux2 = m%2 == 1;
        // if(unOuDeux1 && unOuDeux2){
            // return (nums1[n/2]+nums2[m/2])/2.;
        // }else{
            // int[] tmp1, tmp2;
            // if(unOuDeux1){
            //     tmp1 = new int[]{nums1[n/2]};
            // }else{
            //     tmp1 = new int[]{nums1[n/2-1], nums1[n/2]};
            // }
            // if(unOuDeux2){
            //     tmp2 = new int[]{nums2[m/2]};
            // }else{
            //     tmp2 = new int[]{nums2[m/2-1], nums2[m/2]};
            // }
            // return MedianForAnArray(mergeArray(tmp1, tmp2));
        // }
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

    public int[] mergeArray(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        System.out.println("m+n = " + (m + n));
        int[] res = new int[n+m];
        int i = 0, j = 0;
        int n1, m1;
        while(i+j < n+m && i < n && j < m) {
            n1 = nums1[i];
            m1 = nums2[j];
            System.out.println(" in : res, n1, m1, i, j = " + res[i+j] + " " + n1 + " " + m1  + " " + i + " " + j);
            if(n1 < m1){
                res[i+j] = n1;
                i += 1;
            }else{
                res[i+j] = m1;
                j += 1;
            }
        }
        // System.out.println(" out 0 : res, i, j , n, m = " + res[i+j] + " " + i + " " + j + " " + n  + " " + m);
        while(i < n){
            res[i+j] = nums1[i];
            i++;
        }
        while(j < m){
            res[i+j] = nums2[j];
            j++;
        }
        for (int k = 0; k < res.length; k++) {
            System.out.println(res[k]);
        }
        return res;
    }
}