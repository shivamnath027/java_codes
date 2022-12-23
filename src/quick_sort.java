import java.util.Scanner;
import java.util.Random;
public class quick_sort {
    static final int max = 50;
    static int[] a = new int[max];
    static int n;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter no of elements: ");
        n = input.nextInt();
        Random r = new Random();
        for(int i=0;i<n;i++){
            a[i] = 5000+ r.nextInt(10000);
        }
        System.out.println("Unsorted array: ");
        for(int i=0;i<n;i++){
            System.out.println(" "+a[i]);
        }
        long starttime = System.nanoTime();
        quicksort(0,n-1);
        long stoptime = System.nanoTime();
        long elapsed_time = stoptime-starttime;
        System.out.println("Time complexity for n= "+n+" is "+(double)(elapsed_time)/1000000);
        System.out.println("Sorted array is");
        for(int i=0;i<n;i++){
            System.out.println(" "+a[i]);
        }
    }
    static void quicksort(int p,int r){
        int temp,i,j,pivot;
        if(p<r){
            i =p;
            j=r+1;
            pivot = a[p];
            while(true){
                i++;
                while(a[i]<pivot && i<r)
                    i++;
                j--;
                while (a[j]>pivot)
                    j--;
                if(i<j) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
                else
                    break;
            }
            a[p] = a[j];
            a[j] = pivot;
            quicksort(0,j-1);
            quicksort(j+1,r);
        }
    }
}