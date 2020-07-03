import java.util.Arrays;
import java.util.Random;

public class Sort {

  public static void main(String[] args) {
    int[] a = {3,2,1,5,6,4,2};
    //mergeSort(a);
    quickSort(a);
    //bubbleSort(a);
    //selectSort(a);
   // System.out.println(Arrays.toString(a));

  //  for(int i=0;i<6;i++)
    //System.out.println(quickSelect(a, 5));
    long x = Long.parseLong("ee675c",16);
    x |= 0x00000000ff000000;
    System.out.println(x);
  }

  public static void mergeSort(int[] a) {
    mergeSort(a, 0, a.length - 1);
  }

  private static void mergeSort(int[] a, int left, int right) {
    if (left >= right) {
      return;
    }
    int mid = left + (right - left) / 2;
    mergeSort(a, left, mid);
    mergeSort(a, mid + 1, right);
    int i = 0, j = 0;
    int index = left;
    int[] L = Arrays.copyOfRange(a, left, mid + 1);
    int[] R = Arrays.copyOfRange(a, mid + 1, right + 1);
    while (i < L.length && j < R.length) {
      if (L[i] <= R[j]) {
        a[index] = L[i++];
      } else {
        a[index] = R[j++];
      }
      index++;
    }
    while (i < L.length) {
      a[index++] = L[i++];
    }
  }

  public static void quickSort(int[] a) {
    quickSort(a, 0, a.length - 1);
  }

  private static void quickSort(int[] a, int left, int right) {
    if (left >= right) {
      return;
    }
    int p = partition(a, left, right);
    quickSort(a, left, p - 1);
    quickSort(a, p+1, right);
  }

  public static int quickSelect(int[] a, int k) {
    int left = 0, right = a.length - 1;
    while (left < right) {
      int p = partition(a, left, right);
      if (p == k) {
        break;
      }
      if (p < k) {
        left = p + 1;
      } else {
        right = p - 1;
      }
    }
    return a[k];
  }

  static int partition(int[] a, int left, int right) {
    int pivot = a[right];
    int i = left;
    for (int j = left; j < right; j++) {
      if (a[j] < pivot) {
        swap(a, i, j);
        i++;
      }
    }
    swap(a, i, right);
    return i;
  }

  static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public static void bubbleSort(int[] a) {
    for (int i = 0; i < a.length - 1; i++) {
      for (int j = 0; j < a.length - 1 - i; j++) {
        if (a[j] > a[j + 1]) {
          swap(a, j, j + 1);
        }
      }
    }
  }

  public static void selectSort(int[] a) {
    for (int i = 0; i < a.length - 1; i++) {
      int min = i;
      for (int j = i + 1; j < a.length; j++) {
        if (a[j] < a[min]) {
          min = j;
        }
      }
      swap(a, min, i);
    }
  }
}
