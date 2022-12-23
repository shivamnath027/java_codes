import java.util.Scanner;
import java.util.Random;
class merge_sort{
    static final int max = 50;
    static int[] a = new int[max];
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Random r = new Random();
        System.out.println("Enter no. of elements: ");
        int n = input.nextInt();
        for(int i=0;i<n;i++){
            a[i] = 5000+r.nextInt(1000);
        }
        System.out.println("Unsorted Array: ");
        for(int i=0;i<n;i++){
            System.out.println(" "+a[i]);
        }
        long starttime = System.nanoTime();
        mergesort(0,n-1);
        long stoptime = System.nanoTime();
        long elapsedtime = stoptime-starttime;
        System.out.println("Time complexity for n= "+n+" is "+(double)elapsedtime/1000000);
        System.out.println("Sorted array is: ");
        for(int i=0;i<n;i++){
            System.out.println(" "+a[i]);
        }
    }
    static void mergesort(int low,int high){
        int mid;
        if(low< high){
            mid = (low+high)/2;
            mergesort(low,mid);
            mergesort(mid+1,high);
            merge(low,mid,high);
        }
    }
    static void merge(int low,int mid,int high){
        int i,j,k,h;
        int[] b = new int[max];
        h = i = low;
        j = mid+1;
        while((h<=mid)&&(j<=high)){
            if(a[h]<a[j])
                b[i++]=a[h++];
            else
                b[i++]=a[j++];
        }
        if(h>mid)
            for(k=j;k<=high;k++){
                b[i++]=a[k];
            }
        else
            for(k=h;k<=mid;k++){
                b[i++]=a[k];
            }
        for(k=low;k<=high;k++){
            a[k]=b[k];
        }
    }
}