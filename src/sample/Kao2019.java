package sample;

import org.junit.Test;

import java.util.*;

import java.util.Scanner;

public class Kao2019 {


    @Test
    public void TestNumberOne(){
        int n = 123;
        if(n>100||n<0){
            System.out.println("illegal score");
        }else if(n<=100&&n>=90){
            System.out.println("A");
        }else if(n<=89&&n>=80){
            System.out.println("B");
        }else if(n<=79&&n>=70){
            System.out.println("C");
        }else if(n<=69&&n>=60){
            System.out.println("D");
        }else {
            System.out.println("E");
        }
    }

    @Test
    public void TestNumberTwo(){
        int n = 100;
        System.out.println(sum(n));
    }

    public int sum(int n){
        if(n == 1){
            return 1;
        }
        return n+sum(--n);
    }

    @Test
    public void TestNumberThree(){
        int a[] = {7,89,120,4};
        for(int i=0;i<a.length-1;i++){
            boolean isChange = false;
            for(int j=0;j<a.length-i-1;j++){
                if(a[j]>a[j+1]){
                    int tem = a[j+1];
                    a[j+1]=a[j];
                    a[j] = tem;
                    isChange = true;
                }
            }
            if(!isChange){
                break;
            }
        }
        for(int i=0;i<a.length;i++){
            System.out.print(" "+a[i]);
        }
    }


    @Test
    public void TestNumberFour(){
        String abc = "sdfdsf1dsfd2dsfd3sdfd456";
        String res = "";
        int j = 0;
        for(int i=0;i<abc.length();i++){
            if(abc.charAt(i)>='0'&&abc.charAt(i)<='9'){
                if(j==0){
                    res = res + abc.charAt(i);
                    j++;
                }else {
                    int c = abc.charAt(i)-res.charAt(j-1);
                    if(c==1||c==-1){
                        res = res + abc.charAt(i);
                        j++;
                    }
                }
            }
        }
        System.out.print(res);
    }


    @Test
    public void TestNumberFive(){
        int a[] = {12,13,65,89,99,112,123,78,56,23,66};
        int n = a.length;
        int score[][] = new int[n][2];
        for(int i=0;i<score.length;i++){
            score[i][0] = i+1;
            score[i][1] = a[i];
        }
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(score[j][1]<score[j+1][1]){
                    int temS = score[j][1];
                    score[j][1] = score[j+1][1];
                    score[j+1][1] = temS;
                    int temN = score[j][0];
                    score[j][0] = score[j+1][0];
                    score[j+1][0] = temN;
                }
            }
        }
        int cs = n>10?10:n;
        for(int i=0;i<cs;i++){
            System.out.println(score[i][0]+"号 "+score[i][1]+"分");
        }
    }


    public void TestSix(){
        Scanner scanner = new Scanner(System.in);
        Double n = scanner.nextDouble();
        while (n<0||n>1000){
            System.out.println("重新输入:");
            n = scanner.nextDouble();
        }
        double e = 0.00001;
        double high = n;
        double low = 0;
        double mid = (low+high)/2;
        while ((high-low)>e){
            if(mid*mid>n){
                high = mid;
            }else {
                low = mid;
            }
            mid = (low+high)/2;
        }
        System.out.println(high);
    }

   /* //test six
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        Double n = scanner.nextDouble();
        while (n<0||n>1000){
            System.out.println("重新输入:");
            n = scanner.nextDouble();
        }
        double e = 0.00001;
        double high = n;
        double low = 0;
        double mid = (low+high)/2;
        while ((high-low)>e){
            if(mid*mid>n){
                high = mid;
            }else {
                low = mid;
            }
            mid = (low+high)/2;
        }
        System.out.println(high);
    }
*/

    @Test
    public void TestSeven(){
        int m = 12,n=56;
        int max = m>n?m:n;
        int maxGb,minGy;
        for(int i=max;;i++){
            if(i%m==0&&i%n==0){
                maxGb = i;
                break;
            }
        }
        minGy = m*n/maxGb;
        System.out.println("最大公倍数"+maxGb+" 最小公约数"+minGy);
    }


    @Test
    public void TestEight(){
        for(int i=1;i<=1000;i++){
            int sum = 0;
            for(int j=1;j<i;j++){
                if(i%j==0){
                    sum = sum+j;
                }
            }
            if(sum == i){
                System.out.print(i+" factors are ");
                for(int j=1;j<i;j++){
                    if(i%j==0){
                        System.out.print(j+" ");
                    }
                }
                System.out.println();
            }
        }
    }

    @Test
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入A:");
        int a = scanner.nextInt();
        System.out.println("请输入运算符号");
        String sign = scanner.next();
        System.out.println("请输入B");
        int b = scanner.nextInt();
        System.out.println("请输入其他符号");
        String r = scanner.next();
        while (!"*".equals(r)){
            switch (sign){
                case "+" :System.out.println("="+(a+b));break;
                case "-" :System.out.println("="+(a-b));break;
                case "x" :System.out.println("="+(a*b));break;
                case "/" :System.out.println("="+(a/b));break;
            }
            System.out.println("请输入A:");
            a = scanner.nextInt();
            System.out.println("请输入运算符号");
            sign = scanner.next();
            System.out.println("请输入B");
            b = scanner.nextInt();
            System.out.println("请输入其他符号");
            r = scanner.next();
        }
        System.out.println("退出计算器");
    }

}


