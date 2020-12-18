package sample;

import org.junit.Test;

public class Kao2016 {

    @Test
    public void NumberOne(){
        int m=1,n=3,sum=0;
        for(int i=m;i<=n;i++){
            if(i%2==0){
                sum = sum + i;
            }
        }
        System.out.println(sum);
    }

    @Test
    public void NumberTwo(){
        Double f1=1.0,e=f1,fn=f1;
        int i=1;
        while (fn<(10*e-6)){
            fn = 1.0/(getJc(i)*1.0);
            e = e + fn;
            i++;
        }
        System.out.println(e);
    }

    public int getJc(int n){
        if(n==1){
            return 1;
        }
        return n*getJc(n-1);
    }

    @Test
    public void NumberThree(){
        int n = 4;
        int a[][] = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                if(j==0||j==i){
                    a[i][j]=1;
                }else {
                    a[i][j]=a[i-1][j]+a[i-1][j-1];
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int k=i;k<n-1;k++){
                System.out.print(" ");
            }
            for(int j=0;j<=i;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }

    @Test
    public void NumberFour(){
        int a[][] = {{3,2,1},{6,5,4},{9,8,7}};
        int m = a.length,n=a[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int d=0;d<n-j-1;d++){
                    if(a[i][d]>a[i][d+1]){
                        int tmp = a[i][d];
                        a[i][d] = a[i][d+1];
                        a[i][d+1] = tmp;
                    }
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }


    @Test
    public void NumberFive(){
        diguiNum(12345);
    }

    public void diguiNum(int n){
        if(n==0){
            return;
        }
        System.out.print(n%10+" ");
        diguiNum(n/10);
    }

    @Test
    public void NumberSix(){
        String str = "ad32fsdf12dfdf456fdf^^&&6&*(**(789";
        int sum = 0;
        boolean isLine=false;
        for(int i=1;i<str.length();i++){
            if((str.charAt(i)>='0'&&str.charAt(i)<='9')&&((str.charAt(i)-str.charAt(i-1)==1)||(str.charAt(i-1)-str.charAt(i)==1))){
                System.out.println(2);
                isLine = true;
            }else {
                if(isLine){
                    sum++;
                }
                isLine = false;
            }
        }
        if(isLine){
            sum++;
        }
        System.out.println(sum);
    }

}
