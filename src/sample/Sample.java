package sample;

import org.junit.Test;

public class Sample {

    @Test
    public void Test1(){
        int a[] = {9,8,7,6,5,4,3,2,1};
        int j,temp;
        for(int i=1;i<a.length;i++){
            temp = a[i];
            for(j=i;j>0;j--){
                if(temp<a[j-1]){
                    a[j] = a[j-1];
                }else {
                    break;
                }
            }
            a[j]=temp;
        }
        for(int i=0;i<a.length;i++){
            System.out.print(" "+a[i]);
        }
    }

    @Test
    public void Test2(){
        int a[] = {9,8,7,6,5,4,3,2,1};
        for(int i=1;i<a.length;i++){
            int low = 0,high=i-1,temp = a[i];
            int mid = (low+high)/2;
            while (low<=high){
                if(a[mid]<temp){
                    low = mid+1;
                }else {
                    high = mid-1;
                }
                mid = (low+high)/2;
            }
            for(int j=i;j>high+1;j--){
                a[j]=a[j-1];
            }
            a[high+1]=temp;
            for(int f=0;f<a.length;f++){
                System.out.print(a[f]+"   ");
            }
            System.out.println( );
        }
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+"   ");
        }
    }


    @Test
    public void test3(){
        int a[] = {9,8,7,6,5,4,3,2,1,0};
        for(int dk=a.length/2;dk>=1;dk--){
            for(int i=dk;i<a.length;i++){
                int temp = a[i];
                int j=i;
                for(;j>=0&&temp<a[j-dk];j-=dk){
                    a[j]=a[j-dk];
                }
                System.out.println(j);
                a[j+dk] =temp;
            }
        }
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }


    @Test
    public void Test4(){
        System.out.println(mySqrt(2147395599));
    }


    public int mySqrt(int x) {
        double e = 0.000001;
        double high = x*1.0;
        double low = 0;
        double mid = (low+high)/2;
        while ((high-low)>e){
            if(mid*mid>x){
                high = mid;
            }else {
                low = mid;
            }
            mid = (low+high)/2;
        }
        return (int)high;
    }

}
