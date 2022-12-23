import java.util.Scanner;
class TravSalesPerson{
    static final int max =20;
    static final int infinity = 999;
    static int cost = infinity;
    static int[][] c = new int[max][max];
    static int[] tour = new int[max];
    static int n;
    public static void main(String[] args){
        int i,j;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter no of cities: ");
        n = input.nextInt();
        System.out.println("Enter Graph in matrix form: ");
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                c[i][j] = input.nextInt();
                if(c[i][j]==0){
                    c[i][j]=999;
                }
            }
        }
        for(i=0;i<n;i++)
            tour[i]=i;
        cost = tspdp(c,tour,0,n);
        System.out.println("MinCost: "+cost);
        System.out.println("Mintour");
        for(i=0;i<n;i++){
            System.out.print(tour[i]+"->");
        }
        System.out.print(tour[0]+" ");
        input.close();
    }
    static int tspdp(int c[][],int tour[],int start,int n){
        int[] temp = new int[max];
        int i,j,k;
        int[] mintour = new int[max];
        int mincost,cost;
        if(start==n-2)
            return c[tour[n-2]][tour[n-1]]+c[tour[n-1]][0];
        mincost = infinity;
        for(i=start+1;i<n;i++){
            for(j=0;j<n;j++)
                temp[j]= tour[j];
            temp[start+1]=tour[i];
            temp[i]= tour[start+1];
            if((c[tour[start]][tour[i]]+ (cost = tspdp(c,temp,start+1,n)))<mincost){
                mincost = c[tour[start]][tour[i]]+cost;
                for(k=0;k<n;k++){
                    mintour[k]=temp[k];
                }
            }
        }
        for(i=0;i<n;i++){
            tour[i]=mintour[i];
        }
        return mincost;
    }
}