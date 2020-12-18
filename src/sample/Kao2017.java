package sample;

import org.junit.Test;
import java.util.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Kao2017 {

    @Test
    public void Number(){
        int a=12,b=15,c=17;
        int max=0;
        max = a>b?a:b;
        max = max>c?max:c;
        System.out.println(max);
    }

    @Test
    public void Tow(){
        int m=6,n=16,max,gys,gbs;
        max = m>n?m:n;
        for(int i=max;;i++){
            if(i%m==0&&i%n==0){
                gbs = i;
                break;
            }
        }
        gys = (m*n)/gbs;
        System.out.println("gys:"+gys+"  gbs:"+gbs);
    }

    @Test
    public void Three(){
        int a=5,b=19;
        for(int i=a;i<=b;i++){
            int j =2;
            for(;j<=i;j++){
                if(i%j==0){
                    break;
                }
            }
            if(j==i){
                System.out.println("prime number:"+i);
            }
        }
    }

    @Test
    public void Four() {
        int fz = 2, fm = 1, n = 3;
        Double sum = 0.0;
        String s = "sum=";
        for (int i = 1; i <= n; i++) {
            sum = sum + fz * 1.0 / fm * 1.0;
            s = s + fz + "/" + fm + "   ";
            int tmp = fz;
            fz = fz + fm;
            fm = tmp;
        }
        System.out.println(s + "=" + sum);
    }

    @Test
    public void  Five(){
       String s = "sdfsdd655+65+56";
       int count=0;
       for(int i=0;i<s.length();i++){
           if(s.charAt(i)>='A'&&s.charAt(i)<='Z'||s.charAt(i)>='a'&&s.charAt(i)<='z'){
               count++;
           }
       }
       System.out.println(count);
    }

    @Test
    public void Six(){
        PrintChar(".AADFDS.FSDF",".AADFDS.FSDF".length()-1);
    }

    public void PrintChar(String s,int n){
        if(s.charAt(n)=='.'){
            return;
        }
        System.out.print(s.charAt(n));
        PrintChar(s,n-1);
    }


    @Test
    public void Seven(){
        int A=2014,B=1,C=5;
        int X=2023,Y=12,Z=20;
        int countDay=0;
        if(A==X){
            if(B==Y){
                countDay = Z-C+1;
            }else {
                for(int i=B;i<=Y;i++){
                    countDay= countDay+GetDayCountByMonth(X,Y);
                }
                countDay=countDay-C+Z+1;
            }
        }else {
            for(int i=A;i<X;i++){
                if(i%400==0||(i%4==0&&i%100!=0)){
                    countDay=countDay+366;
                }else {
                    countDay=countDay+365;
                }
            }
            for(int i=B;i<=12;i++){
                countDay=countDay+GetDayCountByMonth(A,i);
            }
            for(int i=1;i<Y;i++){
                countDay=countDay+GetDayCountByMonth(Y,i);
            }
            countDay = countDay-C+Z+1;
        }
        System.out.print(countDay);
    }

    public int  GetDayCountByMonth(int year,int month){
        switch (month){
            case 1:return 1;
            case 2:if(year%400==0||(year%4==0&&year%100!=0)){
                return 29;
            }else {
                return 28;
            }
            case 3:return 31;
            case 4:return 30;
            case 5:return 31;
            case 6:return 30;
            case 7:return 31;
            case 8:return 31;
            case 9:return 30;
            case 10:return 31;
            case 11:return 30;
            case 12:return 31;
        }
        return 0;
    }

    @Test
    public void Eight(){
        int a[]={1,3,5,7,9,11};
        int b[]={2,4,6,8,10,12};
        int c[]= new int[a.length+b.length];
        int i=0,j=0,k=0;
        while (i<a.length&&j<b.length){
            if(a[i]<=b[j]){
                c[k] = a[i];
                i++;k++;
            }else {
                c[k] = b[j];
                j++;k++;
            }
        }
        if(i<a.length){
            for(;i<a.length;i++){
                c[k]=a[i];
                k++;
            }
        }else {
            for(;j<b.length;j++){
                c[k]=b[j];
                k++;
            }
        }
        for(i=0;i<c.length;i++){
            System.out.print(c[i]+" ");
        }
    }



    @Test
    public void Nine(){
        String []str = {"A","B","C","D","E","F","G","H","I","J","K"};
        int k=3,i=4;
        int strlen = str.length;
        while (strlen>=0){
            int qn = 0;
            while (qn<k-1){
                if(i>=str.length){
                    i = 0;
                }
                if(str[i]!=""){
                    qn++;
                    i++;
                    System.out.print("s:"+i+"  ");
                }else {
                    i++;
                }
            }
            System.out.print(str[i]+" "+i+"  ");
            str[i] = "";
            strlen--;
        }

    }

    @Test
    public void testHannuota(){
        hannuota(3,"a","b","c");
    }


    public void  hannuota(int n,String a,String b,String c){
        if(n==1){
            System.out.println(a+"------------->"+c);
            return ;
        }else {
             hannuota(n-1,a,c,b);
            System.out.println(a+"----------------->"+c);
            hannuota(n-1,b,a,c);
        }
    }

}
