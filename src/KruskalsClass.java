import java.util.Scanner;
class KruskalsClass{
    static final int max =20;
    static int[][] cost = new int[max][max];
    static int n;
    static int[] visited = new int[max];
    public static void main(String[] args){
        Scanner ip = new Scanner(System.in);
        System.out.println("Enter no of elements: ");
        n =ip.nextInt();
        System.out.println("Enter matrix: ");
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                cost[i][j]=ip.nextInt();
            }
        }
        kruskals();
    }
    static void kruskals(){
        int[] parent = new int[max];
        int ne=1,mincost=0,min,i,j,u=0,v=0,a=0,b=0;
        while(ne<n){
            for(i=1,min=999;i<=n;i++){
                for(j=1;j<=n;j++){
                    if(cost[i][j]<min){
                        min = cost[i][j];
                        a=u=i;
                        b = v = j;
                    }
                }
            }
            u = find(u,parent);
            v = find(v,parent);
            if(uni(u,v,parent)!=0){
                System.out.println(ne++ +"Edge: ("+a+","+b+")="+min);
                mincost+=min;
                parent[v]=u;
            }
            cost[a][b]=cost[b][a]=999;
        }
        System.out.println("Mincost is: "+mincost);
    }
    static int find(int i,int[] parent){
        while(parent[i]!=0)
            i = parent[i];
        return i;
    }
    static int uni(int i,int j,int[] parent){
        if(i!=j){
            parent[j]=i;
            return 1;
        }
        else
            return 0;
    }
}