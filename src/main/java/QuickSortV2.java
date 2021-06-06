public class QuickSortV2 {
  // A utility function to swap two elements
  static void swap(int[] arr, int left, int right)
  {
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }

  static void quickSort(int[] arr, int left, int right) {
    int index = partition(arr, left, right);
    if(left < index - 1) { //sort left half
      quickSort(arr, left, index - 1);
    }
    if(index < right) { //sort right half
      quickSort(arr, index, right);
    }
  }

  static int partition(int[] arr, int left, int right){
    int pivot = arr[left + (right - left) / 2]; //pick pivot
    while(left <= right) {
      //find element on left that should be on right
      while(arr[left] < pivot) left++;

      //find element on right that should be on left
      while(arr[right] > pivot ) right--;

      //swap elements, and move left and right indices
      if(left <= right) {
        swap(arr, left, right);//swap elements
        left++;
        right--;
      }
    }
    return left;
  }

  // Function to print an array
  static void printArray(int[] arr, int size)
  {
    for(int i = 0; i < size; i++)
      System.out.print(arr[i] + " ");

    System.out.println();
  }
  // Driver Code
  public static void main(String[] args)
  {
    int[] arr = { 10, 7, 8, 9, 1, 5 };
    int n = arr.length;

    quickSort(arr, 0, n - 1);
    System.out.println("Sorted array: ");
    printArray(arr, n);
  }
}
