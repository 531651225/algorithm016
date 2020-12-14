public class MergeSort {
  static void mergeSort(int[] arr, int left, int right) {
    if (right > left) {
      int mid = left + (right - left) / 2;
      mergeSort(arr, left, mid);
      mergeSort(arr, mid + 1, right);
      merge(arr, left, mid, right);
    }
  }

  static  void merge(int[] arr, int left, int mid, int right) {
    int[] temp = new int[right - left + 1];
    int i = left, j = mid + 1;
    int count = 0;
    while (i <= mid && j <= right)
      temp[count++] = arr[i] > arr[j] ? arr[j++] : arr[i++];

    while(i <= mid)
      temp[count++] = arr[i++];

    while(j <= right)
      temp[count++] = arr[j++];

    for (int n = 0; n < count; n++) {
      arr[left + n] = temp[n];
    }

  }

  public static void main(String[] args) {
    int[] arr = new int[]{1, 4, 2, 6,3};
    mergeSort(arr, 0, arr.length - 1);
    for(int num : arr) {
      System.out.println(num);
    }
  }

}
