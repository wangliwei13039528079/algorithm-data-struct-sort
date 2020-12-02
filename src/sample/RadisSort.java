package sample;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RadisSort {

    @Test
    public void Test(){
        int a[] = {191,822,733,62,56,42,32,2,1};
        int b[] =sort(a);
        for(int i=0;i<b.length;i++){
            System.out.println(b[i]);
        }
    }

    public int[] sort(int[] sourceArray) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        int maxDigit = getMaxDigit(arr);
        System.out.println("max digit:"+maxDigit);
        return radixSort(arr, maxDigit);
    }

    /**
     * 获取最高位数
     */
    private int getMaxDigit(int[] arr) {
        int maxValue = getMaxValue(arr);
        return getNumLenght(maxValue);
    }

    private int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    protected int getNumLenght(long num) {
        if (num == 0) {
            return 1;
        }
        int lenght = 0;
        for (long temp = num; temp != 0; temp /= 10) {
            lenght++;
        }
        return lenght;
    }

    private int[] radixSort(int[] arr, int maxDigit) {
        int mod = 10;
        int dev = 1;

        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            // 考虑负数的情况，这里扩展一倍队列数，其中 [0-9]对应负数，[10-19]对应正数 (bucket + 10)
            int[][] counter = new int[mod * 2][0];

            for (int j = 0; j < arr.length; j++) {
                int bucket = ((arr[j] % mod) / dev) + mod;
                counter[bucket] = arrayAppend(counter[bucket], arr[j]);
            }

            int pos = 0;
            for (int[] bucket : counter) {
                for (int value : bucket) {
                    arr[pos++] = value;
                }
            }
        }

        return arr;
    }

    /***
     *
     * @param arr
     * @param value
     * @return
     */
    private int[] arrayAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }




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
        System.out.println(maxDigist);
        int di = 1;
        for(int i=0;i<maxDigist;i++){
            System.out.println("di-------------"+di);
            for(int j=0;j<a.length;j++){
                System.out.println("di-------------"+a[j]%di);
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
                System.out.println(a[j]);

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
            for(int f=0;f<a.length;f++){
                System.out.print(a[f]+"  ");
            }
            System.out.println();
        }
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+"  ");
        }
        System.out.println();
    }
}
