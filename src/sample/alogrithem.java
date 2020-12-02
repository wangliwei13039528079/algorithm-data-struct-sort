package sample;

import com.sun.org.apache.bcel.internal.generic.SWAP;
import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;
import org.junit.Test;

public class alogrithem {

    @Test
    public void DirectInsertSort(){
        int a[] = {99,9,20,17,19,5};
        for(int i=1;i<a.length;i++){
            int temp = a[i];
            int j;
            for(j = i;j>0;j--){
                if(temp<a[j-1]){
                    a[j] = a[j-1];
                }else {
                    break;
                }
            }
            a[j] = temp;
        }
        print(a);
    }

    @Test
    public void HalfInsertSort(){
        int a[] = {99,9,20,17,19,5,23,25,16,2};
        int low,high,mid,j;
        for(int i=1;i<a.length;i++){
            int temp = a[i];
            low = 0;high = i;
            while (low<=high){
                mid = (low+high)/2;
                if(a[mid]<temp){
                    low = mid+1;
                }else {
                    high = mid -1;
                }
            }
            System.out.println(high);
            for( j=i;j>high+1;j--){
                a[j]=a[j-1];
            }
            a[high+1] = temp;
            for(int f=0;f<a.length;f++){
                System.out.print(a[f]+"  ");
            }
            System.out.println();
        }
        print(a);
    }

    @Test
    public void ShellSort(){
        int a[] = {99,9,20,17,19,5,23,25,16,2};
        int n = a.length;
        for(int dk = n/2;dk>=1;dk=dk/2){
            for(int i=dk;i<n;i++){
                if(a[i]<a[i-dk]){
                    int temp = a[i];
                    int j;
                        for(j=i-dk;j>=0&&temp<a[j];j-=dk){
                        a[j+dk] = a[j];
                    }
                    a[j+dk] = temp;
                }
            }
            for(int i=0;i<n;i++){
                System.out.print(a[i]+"  ");
            }
            System.out.println();
        }
        print(a);
    }

    public void print(int a[]){
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]+"  ");
        }
    }


    @Test
    public void DirectSelectSort(){
        int a[] = {99,9,20,17,19,5,23,25,16,2};
        for(int i=0;i<a.length;i++){
            int min = i;
            for(int j=i+1;j<a.length;j++){
                if(a[min]>a[j]){
                    min = j;
                }
            }
            int tem = a[min];
            a[min] = a[i];
            a[i] = tem;
        }
        print(a);
    }

    @Test
    public void BubbleSort(){
        int a[] = {99,9,20,17,19,5,23,25,16,2};
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length-i-1;j++){
                if(a[j]>a[j+1]){
                    int tep = a[j];
                    a[j] = a[j+1];
                    a[j+1]=tep;
                }
            }
        }
        print(a);
    }




}
