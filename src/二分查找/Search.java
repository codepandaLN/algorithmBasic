package 二分查找;

//非递归
public class Search {
    public int search1(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    //递归
    public int search_interval(int[] num, int l, int h, int target) {
        if (l > h) {
            return -1;
        }
        int mid = l + (h - l) / 2;
        if (num[mid] == target) {
            return mid;
        } else if (num[mid] > target) {
            return search_interval(num, l, h - 1, target);
        } else {
            return search_interval(num, l + 1, h, target);
        }
    }

    public int search2(int[] nums, int target) {
        //递归
        return search_interval(nums, 0, nums.length - 1, target);
    }


    //变形版
    public int search3(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (left != nums.length && nums[left] == target) return left;
        return -1;
    }

    public int search4(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {3, 5, 9, 12, 14, 15};
        Search s = new Search();
//        int res1 = s.search1(nums, 3);
//        int res2 = s.search2(nums, 3);
//        System.out.println(res1);
//        System.out.println(res2);
//        System.out.println(s.search1(nums, 27));
//        System.out.println(s.search2(nums, 27));
//        System.out.println(s.search1(nums, -2));
//        System.out.println(s.search1(nums, 31));
        System.out.println(s.search3(nums, 3));
        System.out.println(s.search4(nums, 3));
        System.out.println(s.search1(nums, 3));
        System.out.println(s.search2(nums, 3));
        System.out.println(s.search3(nums, 15));
        System.out.println(s.search4(nums, 15));


    }
}
