public class MergeSort {

  void mergeSort(int[] nums, int left, int right){
    if (left >= right) return;
    int mid = left + (right - left) / 2;
    mergeSort(nums, left, mid);
    mergeSort(nums, mid + 1, right);
    merge(nums, left, mid, right);

  }

  void merge(int[] nums, int left, int mid, int right) {
    int[] temp = new int[right - left + 1];
    int c = 0, l = left, r = mid + 1;

    while (l <= mid && r <= right) {
      temp[c++] = nums[l] > nums[r] ? nums[r++] : nums[l++];
    }
    while (l <= mid) temp[c++] = nums[l++];
    while (r <= right) temp[c++] = nums[r++];

//    System.arraycopy(temp, 0, nums, left, right - left + 1);

    for (int i = 0; i < temp.length; i++) {
      nums[left ++] = temp[i];
    }




  }

  public static void main(String[] args) {
    int[] arr = new int[]{1, 9, 11, 5, 8, 9};
    MergeSort sort = new MergeSort();
    sort.mergeSort(arr, 0, arr.length - 1);
    for (int n : arr) {
      System.out.println(n);
    }
  }

}
