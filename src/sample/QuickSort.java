package sample;

import org.junit.Test;

import java.util.Arrays;

public class QuickSort {

    void QuickSort(int a[],int low,int high){
        if(low<high){
            int pivotpos = Partition(a,low,high);
            QuickSort(a,low,pivotpos-1);
            QuickSort(a,pivotpos+1,high);
        }
    }

    int Partition(int a[],int low,int high){
        int pivot = a[low];
        while (low<high){
            while (low<high&&a[high]>=pivot) --high;
            a[low] = a[high];
            while (low<high&&a[low]<=pivot) ++low;
            a[high] = a[low];
        }
        a[low] = pivot;
        return low;
    }


    @Test
    public void test(){
        int[] arr = new int[] {1,6,9,8,74,52,36,59};
        QuickSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
