package sample;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RadixSort {





    @Test
    public void radisSort(){
        int a[] = {191,822,733,62,56,42,32,2,1};
        Queue<Integer> queue_0 = new LinkedList<>();
        Queue<Integer> queue_1 = new LinkedList<>();
        Queue<Integer> queue_2 = new LinkedList<>();
        Queue<Integer> queue_3 = new LinkedList<>();
        Queue<Integer> queue_4 = new LinkedList<>();
        Queue<Integer> queue_5 = new LinkedList<>();
        Queue<Integer> queue_6 = new LinkedList<>();
        Queue<Integer> queue_7 = new LinkedList<>();
        Queue<Integer> queue_8 = new LinkedList<>();
        Queue<Integer> queue_9 = new LinkedList<>();
        int maxDigist=0;
        for(int i=0;i<a.length;i++){
            int count = 0,temp = a[i];
            while (temp!=0){
                count++;
                temp = temp/10;
            }
            if(maxDigist<count){
                maxDigist =count;
            }
        }
        int di = 1;
        for(int i=0;i<maxDigist;i++){
            for(int j=0;j<a.length;j++){
                switch (a[j]/di%10){
                    case 0: queue_0.offer(a[j]);break;
                    case 1: queue_1.offer(a[j]);break;
                    case 2: queue_2.offer(a[j]);break;
                    case 3: queue_3.offer(a[j]);break;
                    case 4: queue_4.offer(a[j]);break;
                    case 5: queue_5.offer(a[j]);break;
                    case 6: queue_6.offer(a[j]);break;
                    case 7: queue_7.offer(a[j]);break;
                    case 8: queue_8.offer(a[j]);break;
                    case 9: queue_9.offer(a[j]);break;
                }
            }
            di = di*10;
            int j=0;
            while (!queue_0.isEmpty()){
                a[j]=queue_0.poll();
                j++;
            }
            while (!queue_1.isEmpty()){
                a[j]=queue_1.poll();
                j++;
            }
            while (!queue_2.isEmpty()){
                a[j]=queue_2.poll();
                j++;
            }
            while (!queue_3.isEmpty()){
                a[j]=queue_3.poll();
                j++;
            }
            while (!queue_4.isEmpty()){
                a[j]=queue_4.poll();
                j++;
            }
            while (!queue_5.isEmpty()){
                a[j]=queue_5.poll();
                j++;
            }
            while (!queue_6.isEmpty()){
                a[j]=queue_6.poll();
                j++;
            }
            while (!queue_7.isEmpty()){
                a[j]=queue_7.poll();
                j++;
            }
            while (!queue_8.isEmpty()){
                a[j]=queue_8.poll();
                j++;
            }
            while (!queue_9.isEmpty()){
                a[j]=queue_9.poll();
                j++;
            }
        }
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+"  ");
        }
        System.out.println();
    }
}
