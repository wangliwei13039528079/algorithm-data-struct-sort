package sample;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class K2017New {

    @Test
    public void TestOne(){
        int a=1,b=2,c=3,max=0;
        if(max<a){
            max = a;
        }
        if(max<b){
            max = b;
        }
        if(max<c){
            max= c;
        }
        System.out.println(max);
    }


    @Test
    public void TestTwo(){
        int m=-6,n=-5,gys,gbs;
        if(m<0){
            m=m*-1;
        }
        if(n<0){
            n=n*-1;
        }
        int i = m>n?m:n;
        while (true){
            if(i%m==0&&i%n==0){
                gbs = i;
                break;
            }
            i++;
        }
        gys = (m*n)/gbs;
        System.out.println("gys:"+gys+"  gbs:"+gbs);
    }

    @Test
    public void TestThree(){
        int a=9,b=36;
        for(int i=a;i<=b;i++){
            int j=2;
            for(;j<i/2;j++){
                if(i%j==0){
                    break;
                }
            }
            if(j==i/2){
                System.out.println("sushu:"+i);
            }
        }
    }

    @Test
    public void TestFour(){
        int n=3;
        double fz1 = 2.0,fm1=1.0,sum=0;
        for(int i=1;i<=n;i++){
            sum = sum + fz1/fm1;
            double t = fz1+fm1;
            fm1 = fz1;
            fz1 = t;
        }
        System.out.println(sum);
    }

    @Test
    public void test(){
        System.out.println(2.0/1.0+3.0/2.0+5.0/3.0);
    }


    @Test
    public void TestFive(){
        String a="sdfffffdf45465655656";
        int count =0;
        for(int i=0;i<a.length();i++){
            if((a.charAt(i)>='a'&&a.charAt(i)<='z')||((a.charAt(i)>='A'&&a.charAt(i)<='Z'))){
               count++;
            }
        }
        System.out.println(count);
    }

    @Test
    public void TestSix(){
       String abc = "sdffffffffffffffff.";
       digui(abc,abc.length()-1);
    }

    public void digui(String a,int i){
        if(i==-1){
            return;
        }
        System.out.println(a.charAt(i));
        digui(a,--i);
    }


    @Test
    public void TestEight(){
        int a[] = {1,9,10,12,15},b[] ={2,3,4,6,16,17},i=0,j=0, c[] = new int[a.length+b.length],n=0;
        while (i<a.length&&j<b.length){
            if(a[i]<b[j]){
                c[n] = a[i];
                i++;n++;
            }else {
                c[n] = b[j];
                j++;n++;
            }
        }
        if(i<a.length){
            while (i<a.length){
                c[n] = a[i];
                i++;n++;
            }
        }
        if(j<b.length){
            while (j<b.length){
                c[n] = b[j];
                j++;n++;
            }
        }
        for(i=0;i<c.length;i++){
            System.out.println(c[i]);
        }
    }


    @Test
    public void TestSenven(){
        int A=2015,B=02,C=03;
        int X=2030,Y=12,Z=13;
        int count=0;
        int montyDay[] = {31,28,31,30,31,30,31,31,30,31,30,31};
        for(int i=A+1;i<=X-1;i++){
            if((i%400==0)||(i%4==0&&i%100!=0)){
                count = count + 366;
            }else {
                count = count + 365;
            }
        }
        System.out.println(count);
        // count leave day
        for(int i=B;i<=12;i++){
            if(i==2&&((A%400==0)||(A%4==0&&A%100!=0))){
                count = count + 29;
            }else {
                count = count + montyDay[i-1];
            }
        }
        count = count - C;
        // count come back day
        for(int i=1;i<Y;i++){
            if(i==2&&((X%400==0)||(X%4==0&&X%100!=0))){
                count = count + 29;
            }else {
                count = count + montyDay[i-1];
            }
        }
        count = count + Z;
        System.out.println(count);
    }

    @Test
    public void test222() throws Exception{

        String dateStr ="2015-02-3";
        String dateStr2 = "2030-12-13";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        try
        {
            Date date2 = format.parse(dateStr2);
            Date date = format.parse(dateStr);

            System.out.println("两个日期的差距：" + differentDays(date,date2));
            System.out.println("两个日期的差距：" + differentDaysByMillisecond(date,date2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public static int differentDays(Date date1,Date date2)
    {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if(year1 != year2) //同一年
        {
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++)
            {
                if(i%4==0 && i%100!=0 || i%400==0) //闰年
                {
                    timeDistance += 366;
                }
                else //不是闰年
                {
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2-day1) ;
        }
        else //不同年
        {
            System.out.println("判断day2 - day1 : " + (day2-day1));
            return day2-day1;
        }
    }
    public static int differentDaysByMillisecond(Date date1,Date date2)
    {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
        return days;
    }
    public static int daysBetween(Date smdate,Date bdate) throws ParseException
    {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        smdate=sdf.parse(sdf.format(smdate));
        bdate=sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    public static int daysBetween(String smdate,String bdate) throws ParseException{
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(smdate));
        long time1 = cal.getTimeInMillis();
        cal.setTime(sdf.parse(bdate));
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    @Test
    public void nine(){
        String a[] = {"a","b","c","d","e","f","g","h"};
        int i = 1,k=3;
        int n = a.length;
        while (n>0){
            int bs=0;
            while (bs<k-1){
                if(a[i-1]!=""){
                    if((i+1)>a.length){
                        i=1;
                    }else {
                        i++;
                    }
                    bs++;
                }else {
                    if((i+1)>a.length){
                        i=1;
                    }else {
                        i++;
                    }
                }
            }
            while (a[i-1]==""){
                if(i+1>a.length){
                    i=1;
                }else {
                    i++;
                }
            }
            a[i-1] = "";
            for(int j=0;j<a.length;j++){
                if(a[j]==""){
                    System.out.print(" "+" ");
                }else {
                    System.out.print(a[j]+" ");
                }
            }
            System.out.println();
            n--;
        }
    }
}
