public class BinarySearch {
  static int binarySearch(int[] array, int x) {
    int low = 0;
    int high = array.length-1;
    int mid;

    while (low <= high) {
      mid = low + (high - low) / 2;
      if(array[mid] < x) {
        low = mid + 1;
      } else if(array[mid] > x) {
        high = mid - 1;
      } else {
        return mid;
      }
    }
    return -1;
  }

  static int binarySearchRecursive(int [] array,  int x, int low, int high) {
    if (low > high) return -1;//error

    int mid = low + (high - low) / 2;
    if (array[mid] < x){
      return binarySearchRecursive(array, x, mid +1, high);
    } else if (array[mid] > x) {
      return binarySearchRecursive(array, x, low,mid-1);
    } else {
      return mid;
    }
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

    MergeSort.mergeSort(arr);
    System.out.println("Sorted array: ");
    printArray(arr, n);
    System.out.println("Search 5: " +  binarySearch(arr, 5));
    System.out.println("Search 5 recursive: " +  binarySearchRecursive(arr, 5, 0, arr.length-1));
  }
}
