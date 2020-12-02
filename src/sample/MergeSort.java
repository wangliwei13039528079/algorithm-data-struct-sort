package sample;

import org.junit.Test;

public class MergeSort {



    public void merge(int a[],int low,int mid,int high){
        int b[] = new int[high+1];
        int i,j,k;
        for(i=0;i<=high;i++){
            b[i] = a[i];
        }
        for(i=low,j=mid+1,k=i;i<=mid&&j<=high;k++){
            if(b[i]<=b[j]){
                a[k] = b[i++];
            }else {
                a[k] = b[j++];
            }
        }
        while (i<=mid){
            a[k++] = b[i++];
        }
        while (j<=high){
            a[k++] = b[j++];
        }
    }


    public void mergeSort(int a[],int low,int high){
        if(low<high){
            int mid = (low+high)/2;
            mergeSort(a,low,mid);
            mergeSort(a,mid+1,high);
            merge(a,low,mid,high);
        }
    }

    @Test
    public void Test(){
        int[] arr = {9,8,7,6,5,4,3,2,1};
        //sort(arr, 0, arr.length -1);
        mergeSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"  ");
        }
    }
}
