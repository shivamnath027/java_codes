import java.util.Scanner;
public class PrimsClass{
    static final int max =20;
    static int[][] cost = new int[max][max];
    static int[] visited = new int[max];
    static int n;
    public static void main(String[] args){
        ReadMatrix();
        Prims();
    }
    static void ReadMatrix(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter no of nodes: ");
        n = input.nextInt();
        System.out.println("Enter Cost Matrix: ");
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                cost[i][j] = input.nextInt();
                if(cost[i][j]==0){
                    cost[i][j]=999;
                }
            }
        }
    }
    static void Prims(){
        int ne=1,i,j,u=0,v=0,a=0,b=0,min,mincost=0;
        visited[1]=1;
        while(ne<n){
            for(i=1,min=999;i<=n;i++){
                for(j=1;j<=n;j++){
                    if(cost[i][j]<min){
                        if(visited[i]!=0){
                            min = cost[i][j];
                            a=u=i;
                            b=v=j;
                        }
                    }
                }
            }
            if(visited[u]==0 || visited[v]==0){
                System.out.println("Edge "+ ne++ +"("+a+","+b+") :"+min);
                mincost+=min;
                visited[b]=1;
            }
            cost[a][b]=cost[b][a]=999;
        }
        System.out.println("Minimum cost is: "+mincost);
    }
}