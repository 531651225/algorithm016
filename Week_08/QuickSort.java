public class QuickSort {

  static void quickSort(int[] nums, int left, int right) {
    if (right <= left) return;
    int partition = partion(nums, left, right);
    quickSort(nums, left, partition - 1);
    quickSort(nums, partition + 1, right);
  }

  static int partion(int[] nums, int left, int right) {
    int count=left, pivot = nums[right];
    for (int i=left; i < right; i++) {
      if (nums[i] < pivot) {
        int temp=nums[count];nums[count]=nums[i]; nums[i]=temp;
        count++;
      }
    }
    int temp=nums[count];nums[count]=pivot; nums[right]=temp;
    return count;
  }

  public static void main(String[] args) {
    int[] arr=new int[]{1, 9, 11, 5, 8, 10};
    quickSort(arr, 0, arr.length - 1);
    for (int n : arr) {
      System.out.println(n);
    }
  }

}


