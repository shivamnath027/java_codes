import java.util.Scanner;
class kobject{
    float p,w,r;
}
class KnapsackGreedy{
    static int n;
    static float M;
    static int max = 10;
    public static void main(String[] args){
        Scanner ip = new Scanner(System.in);
        System.out.println("Enter no of objects: ");
        n = ip.nextInt();
        kobject[] obj = new kobject[n];
        for(int i=0;i<n;i++){
            obj[i] = new kobject();
        }
        Readobject(obj);
        knapsack(obj);
    }
    static void Readobject(kobject[] obj){
        Scanner ip = new Scanner(System.in);
        int i,j;
        kobject temp = new kobject();
        System.out.println("Enter max capacity of knapsack: ");
        M = ip.nextFloat();
        System.out.println("Enter weights: ");
        for(i=0;i<n;i++){
            obj[i].w = ip.nextFloat();
        }
        System.out.println("Enter profits: ");
        for(i=0;i<n;i++){
            obj[i].p = ip.nextFloat();
        }
        for(i=0;i<n;i++){
            obj[i].r = obj[i].p/obj[i].w;
        }
        for(i=0;i<n-1;i++){
            for(j=0;j<n-1-i;j++){
                if(obj[j].r<obj[j+1].r)
                {
                    temp = obj[j];
                    obj[j]=obj[j+1];
                    obj[j+1]=temp;
                }
            }
        }
    }
    static void knapsack(kobject[] kobj) {
        float[] x = new float[max];
        float U = M;
        float totalprofit = 0;
        int i;
        for (i = 0; i < n; i++) {
            x[i]=0;
        }
        for(i=0;i<n;i++){
            if(kobj[i].w>U)
                break;
            else{
                x[i]=1;
                totalprofit+=kobj[i].p;
                U = U-kobj[i].w;
            }
        }
        if(i<n){
            x[i] = U/kobj[i].w;
            totalprofit+=(x[i]*kobj[i].p);
        }
        System.out.println("Solution vector: ");
        for(i=0;i<n;i++){
            System.out.print(x[i]+" ");
        }
        System.out.println("Total profit is: "+totalprofit);
    }
}