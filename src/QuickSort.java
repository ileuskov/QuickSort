public class QuickSort {
    int[] arr;

    public QuickSort(int[] arr) { // A class constructor
        this.arr = arr;
    }

    public void quickSort(int[] arr, int start, int end) { // a sorting method
        int partition = partition(arr, start, end); // a temporal variable that calls the partition method for the first time. It stores the value of the pivot's position. Further the rest of the array is sorted left and right from this element's position
        if (partition - 1 > start) {
            quickSort(arr, start, partition - 1); // sorting out the left part of the array (everything that is smaller than our first pivot) first. After it's done moving to the right part
        }
        if (partition + 1 < end) {
            quickSort(arr, partition + 1, end); // sorting out the right part of the array (everything that is bigger than our first pivot). When the start variable + 1 has the value of the last element's position in the array, the sorting is finished
        }
    }

    public int partition(int[] arr, int start, int end) { // a partition method that divides the array into 2 parts. Both parts are compared to the pivot and sorted out. This can be the whole array or its parts
        int pivot = arr[end]; // the pivot is the last element of the array. The whole array (its part) compared to it

        for (int i = start; i < end; i++) {  // a loop that runs through every element of that part of an array that is being sorted. Starting from "start" and ending with "end"
            if (arr[i] < pivot) { // if an element of the array is smaller than pivot the values of the start element and this element are swapped
                int temp = arr[start]; // first a temporal variable get the value of a first variable in the sorted part of an array
                arr[start] = arr[i]; // then this first variable gets the value of the variable that is smaller than pivot
                arr[i] = temp; // this smaller variable is equal to the initial value of the first variable
                start++; // start is post-incremented so that next time the partition method is called our array (its part) starts from the start position and not from 0.
            }
        }
        // the pivot element and the end element of an array (its part) are swapped
        int temp = arr[start]; // first we store the value of the element that begins the unsorted part of our array in a temporal variable
        arr[start] = pivot; // This element gets the value of the pivot since the loop couldn't find any number smaller than this element's value
        arr[end] = temp; // the last element of the array (its part) has the value of the start element

        return start; // returning a start position for the new sorting
    }

    public void print() { // a method to print out all the elements of an array in the beginning
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
