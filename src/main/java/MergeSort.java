public class MergeSort {
  static void mergeSort(int[] array) {
    int [] helper = new int[array.length];
    mergeSort(array, helper, 0, array.length - 1);
  }

  static void mergeSort(int[] array, int[] helper, int low, int high) {
    if(low < high) {
      int middle = low + (high-low)/2;
      mergeSort(array, helper, middle + 1, high);
      mergeSort(array, helper, low, middle);
      merge(array, helper, low, middle, high);
    }
  }

  static void merge(int[] array, int[] helper, int low, int middle, int high){
    //copy both halves into a helper array
    for(int i=low; i <= high; i++){
      helper[i] = array[i];
    }

    int helperLeft = low;
    int helperRight = middle +1;
    int current = low;

    /*
     * Iterate through helper array. Compare the left and right half, copying back
     * the smaller element frm the two halves into the original array
     */
    while(helperLeft <= middle && helperRight <= high){
      if(helper[helperLeft] <= helper[helperRight]){
        array[current] = helper[helperLeft];
        helperLeft++;
      } else { //if right element is smaller then left element
        array[current] = helper[helperRight];
        helperRight++;
      }
      current++;
    }

    //copy the rest of the left side of the array into the target array
    int remaining = middle - helperLeft;
    for(int i=0; i <= remaining; i++) {
      array[current+i] = helper[helperLeft + i];
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

    mergeSort(arr);
    System.out.println("Sorted array: ");
    printArray(arr, n);
  }
}
