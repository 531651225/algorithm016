public class QuickSort {

  static void quitSort(int[] arr, int  start, int end) {
    if (end <= start) return;
    int partition = partition(arr, start, end);
    quitSort(arr, start, partition - 1);
    quitSort(arr, partition + 1, end);
  }

  static int partition(int[] arr, int start, int end) {
    int privot = end, count = start;
    for (int i = start; i < end; i++) {
      if (arr[i] < arr[privot]) {
        int temp = arr[i];arr[i] = arr[count]; arr[count] = temp;
        count++;
      }
    }
    int temp = arr[count]; arr[count] = arr[privot]; arr[privot] = temp;
    return count;
  }

  public static void main(String[] args) {

    int[] arr = new int[]{1, 4, 2, 6,3};
    quitSort(arr, 0, arr.length - 1);
    for(int num : arr) {
      System.out.println(num);
    }
  }
}
