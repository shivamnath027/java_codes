import java.util.Scanner;
public class Prim{
    final static int MAX = 20;
    static int cost[][];
    //static int visited[];
    static int n;
    public static void main(String[] args){
        ReadMatrix();
        Prims();
    }
    static void ReadMatrix(){
        int i,j;
        cost = new int[MAX][MAX];
        Scanner input = new Scanner(System.in);
        System.out.println("Enter size of Matrix: ");
        n = input.nextInt();
        System.out.println("Enter Matrix elements: ");
        for(i=1;i<=n;i++)
            for(j=1;j<=n;j++){
                cost[i][j]=input.nextInt();
                if(cost[i][j]==0)
                {
                    cost[i][j]=999;
                }
            }
    }
    static void Prims(){
        int ne=1,i,j,a=0,b=0,u=0,v=0,min;
        int visited[] = new int[10];
        int mincost = 0;
        visited[1]=1;
        while(ne<n)
        {
            min = 999;
            for(i=1;i<=n;i++)
            {
                for(j=1;j<=n;j++)
                {
                    if(cost[i][j]<min)
                        if(visited[i]!=0)
                        {
                            min = cost[i][j];
                            a = u = i;
                            b = v = j;
                        }
                }
            }
            if(visited[u]==0 || visited[v]==0)
            {
                System.out.println("Edge "+ ne++ +":("+a+ ","+b+")"+"cost:"+min);
                mincost+=min;
                visited[b]=1;
            }
            cost[a][b]=cost[b][a]=999;
        }
        System.out.println("Minimum cost: "+mincost);
    }
}