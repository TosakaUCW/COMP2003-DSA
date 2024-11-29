/*Part 1*/
public class QuickSelection{
	public int findKthLargest(int[] nums, int k){
		/*Your code here.*/
        int indexToFind = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, indexToFind);
    }

    private int quickSelect(int[] nums, int left, int right, int indexToFind) {
        int pivotIndex = partition(nums, left, right);

        if (pivotIndex == indexToFind) {
            return nums[pivotIndex];
        } else if (pivotIndex < indexToFind) {
            return quickSelect(nums, pivotIndex + 1, right, indexToFind);
        } else {
            return quickSelect(nums, left, pivotIndex - 1, indexToFind);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right);
        return i;
    }
		
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
	}
	
	public static void main(String[] args){
		/*testing code here.*/
		QuickSelection qs = new QuickSelection();
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        System.out.println("The " + k1 + "th largest element is: " + qs.findKthLargest(nums1, k1));

        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        System.out.println("The " + k2 + "th largest element is: " + qs.findKthLargest(nums2, k2));
	}
}