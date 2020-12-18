package sample;

import org.junit.Test;

import java.util.Scanner;
import java.util.Stack;

public class Kao2020 {

    @Test
    public void TestNumberOne(){
        int []a= {1,2,3,9,8,3,2,9,20,5};
        int n = a.length;
        int max = 0;
        double avg,sum =0.0;
        for(int i=0;i<n;i++){
            sum = sum + a[i];
            if(max<a[i]){
                max = a[i];
            }
        }
        avg = sum / n*1.0;
        System.out.println("avg:"+avg+" max:"+max);
    }

    @Test
    public void TestNumberTwo(){
        int a=0,b=1000;
        for(int i=a;i<=b;i++){
            int j = 2;
            for(;j<i;j++){
                if(i%j==0){
                    break;
                }
            }
            if(j == i){
                j=i;
                int t = 0;
                while (j!=0){
                    t = t*10+j%10;
                    j = j/10;
                }
                if(t==i){
                    System.out.println(i);
                }
            }
        }
    }


    @Test
    public void TestNumberThree(){
        int n = 123456;
        print(n);
    }

    public void print(int n){
        if(n==0){
            return;
        }
        System.out.print(n%10);
        print(n/10);
    }

    @Test
    public void TestNumberFour(){
        String abc[] = {"fdsssssss dsffdf    sdfd dsfdsfdfdfffffffff","aaaa aaaaaaaaaaaaaaaaaaaaaaaa dfdfdfdfdf","dfsdffffff d dfdf","dfffffdfdf dfd df","dfdf dfdffffffffffffff"};
        int num[] = new int[abc.length];
        for(int i=0;i<abc.length;i++){
            int count = 0,max = 0;
            for(int j=0;j<abc[i].length();j++){
                if(abc[i].charAt(j)==' '){
                    if(max<count){
                        max = count;
                    }
                    count = 0;
                }else {
                    count++;
                }
            }
            if(max<count){
                max = count;
            }
            num[i] = max;
        }
        for(int i=0;i<abc.length;i++){
            System.out.println(num[i]);
        }
    }


    @Test
    public void TestNumberFive(){
           int n = 10;
           int a[][] = new int[n][n];
           for(int i=0;i<n;i++){
               for(int j=0;j<=i;j++){
                   if(j==0||j==i){
                       a[i][j]=1;
                   }else {
                       a[i][j] = a[i-1][j]+a[i-1][j-1];
                   }
               }
           }
           for(int i=0;i<n;i++){
              for(int j=0;j<=i;j++){
                  System.out.print(a[i][j]+"    ");
               }
              System.out.println();
           }
    }

    @Test
    public void TestNumberSix(){
        int a[] = {13,588,79,56,23,46,47,52,99,128,129,123};
        int num = 0;
        for(int i=0;i<a.length;i++){
            if(a[i]%2!=0){
                num++;
            }
        }
        int []wz = new int[num];
        for(int i=0,j=0;i<a.length;i++){
            if(a[i]%2!=0){
                wz[j] = i;
                j++;
            }
        }
        for(int i=0;i<num;i++){
            for(int j=0;j<num-i-1;j++){
                if(a[wz[j]]>a[wz[j+1]]){
                    int tem  =  a[wz[j]];
                    a[wz[j]] = a[wz[j+1]];
                    a[wz[j+1]] = tem;
                }
            }
        }
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }

    @Test
    public void TestNumberSeven(){
        int f1 = 1,f2 = 1,fn=0;
        int n = 4,sum = 0;
        for(int i=1;i<=n;i++){
            if(i<=2){
                fn = f1;
            }else {
                fn = f1 + f2;
                f1 = f2;
                f2 = fn;
            }
            sum = sum + fn;
        }
        System.out.println(sum);
    }



    public static  void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n =  scanner.nextInt();
        for(int i=1;i<=n;i++){
            double a = scanner.nextDouble();
            String c = scanner.next();
            double b = scanner.nextDouble();
            switch (c){
                case "+": System.out.println(a+b);break;
                case "-": System.out.println(a-b);break;
                case "/": System.out.println(a/b);break;
                case "*": System.out.println(a*b);break;
            }
        }
    }


    @Test
    public void Calculator(){
        System.out.println(suffix("9+(3-1)*3+1/2"));
    }


    public String  suffix(String s){
         String js = "";
         Stack<String> stack = new Stack<String>();
         for(int i=0;i<s.length();i++){
             if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                 js = js+s.charAt(i)+"";
             }else {
                 if(s.charAt(i)=='('){
                     stack.push(s.charAt(i)+"");
                 }else if(s.charAt(i)==')'){
                     while (!stack.isEmpty()){
                        String  a = stack.pop()+"";
                        if(a!="("){
                            js = js+a;
                        }else {
                            break;
                        }
                     }
                 }else if(s.charAt(i)!='*'||s.charAt(i)!='/'){
                     stack.push(s.charAt(i)+"");
                 }else if(s.charAt(i)=='/'||s.charAt(i)=='*'&&(stack.peek()=="+")||stack.peek()=="-"){
                     stack.push(s.charAt(i)+"");
                 }else {
                     js = js+stack.pop();
                 }
             }
         }
         while (!stack.isEmpty()){
             js = js+stack.pop();
         }
         return js;
    }
}
