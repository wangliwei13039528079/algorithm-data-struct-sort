package sample;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class Kao2018 {

    @Test
    public void TestNumberOne(){
        int a = 5,b=100;
        for(int i=a;i<=b;i++){
            int j=2;
            for(;j<i;j++){
                if(i%j==0){
                    break;
                }
            }
            if(j==i){
                System.out.println("Prime Number:"+j);
            }
        }
    }

    @Test
    public void TestNumberTwo(){
        int n = 123;
        int t = n,result = 0;
        while (t!=0){
            result = result*10+t%10;
            t = t/10;
        }
        if(result==n){
            System.out.println("Yes");
        }else {
            System.out.println("NO");
        }
    }

    /****
     * 三、输入一个正整数n(n<=30)，输出n所对应的蛇形矩阵。举两个例子：
     *
     * n=10时，蛇形矩阵为： 
     * 10 9 5 4 
     * 8 6 3 
     * 7 2 
     * 1
     * n=9时，蛇形矩阵为： 
     * 9 8 4 3 
     * 7 5 2 
     * 6 1
     *
     *
     */


    @Test
    public void TestNumberThree(){
        int n=9;
        int matrix[][] = new int[30][30];
        int direction [][] = {{0,1},{1,-1},{1,0},{-1,1}};
        int row=0,col=0,i=n-1;
        int sumRow=0,sumCol=0;
        matrix[row][col] = n;
        while (i>=1){
            if(i>=1){
                col = col + direction[0][1];
                matrix[0][col] = i;
                i--;
                if(col>sumCol){
                    sumCol = col;
                }
            }
            while (col!=0&&i!=0){
                row = row + direction[1][0];
                col = col + direction[1][1];
                matrix[row][col] = i;
                i--;
            }
            if(i>=1){
                row = row + direction[2][0];
                matrix[row][col] = i;
                i--;
                if(row>sumRow){
                    sumRow = row;
                }
            }
            while (row!=0&&i!=0){
                row = row + direction[3][0];
                col = col + direction[3][1];
                matrix[row][col] = i;
                i--;
            }
        }
        for(int f=0;f<=sumRow;f++){
            for(int j=0;j<=sumCol-f;j++){
                System.out.print(matrix[f][j]+" ");
            }
            System.out.println();
        }
    }

    /****
     * 把一个9进制的数转化为19进制的数，并输出。（用a~i表示10~18）
     */
    @Test
    public void TestFour(){
        int jjznum =  1234;
        int sjznum = 0,i=1;
        String sjjznum = "";
        while (jjznum!=0){
            sjznum = sjznum+ (jjznum%10)*i;
            i = i*9;
            jjznum = jjznum/10;
        }
        System.out.println(sjznum);
        while (sjznum!=0){
           int j = sjznum%19;
           if(j>=10&&j<=18){
               System.out.println(j);
               char a = (char) ('a'+(j-10));
               sjjznum = a+sjjznum;
           }else {
               sjjznum = j+sjjznum;
           }
           sjznum = sjznum/19;
        }
        System.out.println(sjjznum);
    }

    /****
     * 给定一串字符，要求统计其中“the”出现的次数。
     */
    @Test
    public void TestFive(){
        String abc = "dsfsddddddthedddddhtdsfsdfthe";
        int pd = 0,count =0;
        for(int i=0;i<abc.length();i++){
            if(pd==0){
                if(abc.charAt(i)=='t'){
                    pd++;
                    continue;
                }else {
                    pd =0;
                }
            }
            if(pd==1) {
                System.out.println(abc.charAt(i));
                if(abc.charAt(i)=='h'){
                    pd++;
                    continue;
                }else {
                    pd = 0;
                }
            }
            if(pd==2){
                if(abc.charAt(i)=='e'){
                    pd++;
                }else {
                    pd = 0;
                }
            }
            System.out.println(pd);
            if(pd==3){
                count++;
                pd = 0;
            }
        }
        if(pd == 3){
            count++;
        }
        System.out.println("count:="+count);
    }

    /****
     * 六、输入小李的出生年月日，并打印输出截至到今天他经历了几个2月29日
     */
    @Test
    public void TestSix(){
        int birthYear=2000,birthMonth = 5,birthDay = 6;
        Date date = new Date();
        Calendar now = Calendar.getInstance();
        int TodayYear = now.get(Calendar.YEAR),TodayMonth = now.get(Calendar.MONTH),TodayDay =now.get(Calendar.DATE);
        int count = 0;
        for(int i=birthYear+1;i<=TodayYear-1;i++){
            System.out.println(i);
            if((i%400==0)||(i%4==0&&i%100!=0)){
                count++;
            }
        }
        //count birthYear
        if(birthMonth < 2 || (birthMonth ==2 && (birthDay==29||birthDay<29)) ){
            if((birthYear%400==0)||(birthYear%4==0&&birthYear%100!=0)){
                count++;
            }
        }
        //count todayYear
        if(TodayMonth>2||(TodayMonth==2&&TodayDay==29)){
            if((birthYear%400==0)||(birthYear%4==0&&birthYear%100!=0)){
                count++;
            }
        }
        System.out.println(count);
    }

    /****
     * 七、用编程语言描述汉诺塔问题并解决。
     */
    @Test
    public void TestSeven(){
        hannuota(4,"a","b","c");
    }


    public void hannuota(int n,String a,String b,String c){
        if(n==1){
            System.out.println(a+"->"+c);
        }else {
            hannuota(n-1,a,c,b);
            System.out.println(a+"-->"+c);
            hannuota(n-1,b,a,c);
        }
    }

    /***
     * 八、输入一个N阶矩阵，并打印输出每一列的最大值的和。
     */
    @Test
    public void TestEight(){
       int N[][] = {{1,2,3},{4,5,6},{7,8,9}};
       int sum = 0,n = N.length;
       for(int i=0;i<n;i++){
           int max = 0;
           for(int j=0;j<n;j++){
               if(max<N[j][i]){
                   max = N[j][i];
               }
           }
           sum = sum+ max;
       }
       System.out.println(sum);
    }

    /****
     * 九、依次输入50名同学的出生年月日，并按照他们的出生日期依次打印输出他们的名字。
     */

    @Test
    public void TestNine(){
        String a[][] = {{"bob","2019-12-02"},{"alice","1993-12-03"},{"xiaoli","2015-02-03"},{"xiaomiing","2016-02-03"}};
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length-i-1;j++){
                if(a[j][1].compareTo(a[j+1][1])>0){
                     String name = a[j+1][0];
                     a[j+1][0] = a[j][0];
                     a[j][0] = name;
                     String date = a[j+1][1];
                     a[j+1][1] = a[j][1];
                     a[j][1] = date;
                }
            }
        }
        for(int i=0;i<a.length;i++){
            System.out.println(a[i][0]+"  date:  "+a[i][1]);
        }
    }
}
