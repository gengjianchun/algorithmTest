package sort;

import sun.applet.Main;

public class Sorts {

    public static  void selectionSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int maxIndex = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] > arr[maxIndex]){
                    maxIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
        }
    }

    public  static void exch(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public  static void insertSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            for(int j = i; j >= 1; j--){
                if(arr[j] > arr[j-1]){
                    exch(arr,j,j-1);
                }else{
                    break;
                }
            }

        }
    }






    public static void main(String[] args) {
        int[] arr = {1,2,13,1,14,5,6,7,2};
        //selectionSort(arr);
        insertSort(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

}
