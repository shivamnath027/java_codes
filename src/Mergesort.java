import java.util.Scanner;
import java.util.Random;
public class Mergesort{
    static final int MAX = 10005;
    static int[] a = new int[200];
    public static void main(String[] args){
        int i;
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Enter no. of elements: ");
        int n = input.nextInt();
        for(i=0;i<n;i++){
            a[i] = 5000+ random.nextInt(1000);
        }
        long starttime = System.nanoTime();
        MergesortAlgorithm(0,n-1);
        long stoptime = System.nanoTime();
        long elapsedtime = stoptime - starttime;
        System.out.println("Time Complexity is: "+(double)elapsedtime/1000000);
        System.out.println("Sorted Array is: ");
        for(i=0;i<n;i++){
            System.out.println(""+a[i]);
        }
    }
    public static void MergesortAlgorithm(int low,int high){
        if(low<high){
            int mid = (low+high)/2;
            MergesortAlgorithm(low,mid);
            MergesortAlgorithm(mid+1,high);
            Merge(low,mid,high);
        }
    }
    public static void Merge(int low,int mid,int high){
        int[] b = new int[200];
        int i,j,k,h;
        i = h = low;
        j = mid+1;
        while((h<=mid)&&(j<=high)){
            if(a[h]<a[j])
            {
                b[i++]=a[h++];
            }
            else
            {
                b[i++]=a[j++];
            }
        }
        if(h>mid)
        {
            for(k=j;k<=high;k++)
            {
                b[i++]=a[k];
            }
        }
        else
        {
            for(k=h;k<=mid;k++)
            {
                b[i++] = a[k];
            }
        }
        for(k=low;k<=high;k++)
        {
            a[k] = b[k];
        }
    }
}