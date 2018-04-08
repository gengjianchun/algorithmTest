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

    public  static void shellSort(int[] arr){
        int n = arr.length;
        int h = n/2;
        while (h >= 1){
            for(int i = h; i < n; i++){
                for(int j = i; j >= h; j = j -h){
                    if(arr[j] > arr[j-h]){
                        exch(arr,j, j-h);
                    }
                }
            }
            h = h/2;
        }

    }



    public  static  void merge(int[] arr, int lo, int hi){
        int mid = (lo + hi)/2;
        int  i = lo;
        int j = mid+1;
        int[] aux = new int[arr.length];
        for(int t = lo; t <= hi; t++){
           aux[t] = arr[t];
        }
        for(int k = lo; k <= hi; k++){
           if(i >  mid){
               arr[k] = aux[j++];
           }else if(j > hi){
               arr[k] = aux[i++];
           }else if( aux[i] < aux[j]){
               arr[k] = aux[j++];
           }else{
               arr[k] = aux[i++];
           }
        }

    }


    public static void  mergeSort(int[] arr,int lo, int hi){
        if(hi <= lo){
            return;
        }
        int mid = (lo+hi)/2;
        mergeSort(arr,lo,mid);
        mergeSort(arr,mid+1,hi);
        merge(arr,lo,hi);
    }

    /**
     * 自底向上的归并排序
     * @param arr
     * @param lo
     * @param hi
     */
    public  static void mergeSort2(int[] arr,int lo, int hi){
        int n = arr.length-1;
        for(int i = 1; i < n; i+=i){
            for(int j = lo; j < n-1; j+=i+i){
                merge(arr, j,Math.min(j+i+i-1,n));
            }
        }
    }

    public static int partition(int[] arr, int lo, int hi){
        int k = arr[lo];
        int i = lo+1;
        int j = hi;
        while( true){
            while(arr[i] > k){
                if(i >= hi){
                    break;
                }
                i++;
            }
            while(arr[j] < k){
                if(j <= lo){
                    break;
                }
                j--;
            }

            if(i >= j){
                break;
            }
            exch(arr,i,j);
            i++;
            j--;
        }
        arr[lo] = arr[j];
        arr[j] = k;

        return j;
    }


    public  static void quickSort(int[] arr, int lo, int hi){
        if(hi <= lo){
            return ;
        }
        int j = partition(arr,lo, hi);
        quickSort(arr,lo,j-1);
        quickSort(arr,j+1,hi);

    }

    public  static void quickSort3Way(int[] arr, int lo, int hi){
        if(lo >= hi){
            return ;
        }
        int l = lo;
        int i = lo+1;
        int r = hi;
        int v = arr[lo];
        while(i <= r){
            if(arr[i] > v){
                exch(arr,i,l);
                i++;
                l++;
            }else if(arr[i] < v){
                exch(arr,i,r);
                r--;
            }else{
                i++;
            }
        }
        quickSort3Way(arr,lo,l);
        quickSort3Way(arr, i,hi);

    }

    public static void main(String[] args) {
        int[] arr = {14,12,41,3,11,7,16,51,2};
        //selectionSort(arr);
        //insertSort(arr);
        //shellSort(arr);
       quickSort3Way(arr,0,arr.length-1);
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

}
