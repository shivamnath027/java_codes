import java.util.Scanner;
class dk{
    static final int max =20;
    static final int infinity = 999;
    static int[][] cost= new int[max][max];
    static int[] visited = new int[max];
    static int n,source;
    static int[] dest = new int[max];
    public static void main(String[] args){
        int i,j;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter how many nodes: ");
        n = input.nextInt();
        System.out.println("Enter Cost Matrix: (999 for no edge)");
        for(i=1;i<=n;i++){
            for(j=1;j<=n;j++){
                cost[i][j] = input.nextInt();
            }
        }
        System.out.println("Enter source vertex: ");
        source = input.nextInt();
        dijkstra();
        for(i=1;i<=n;i++){
            System.out.println("SHORTEST DISTANCE FROM SOURCE "+source+" TO "+i+" IS "+dest[i]);;
        }
    }
    static void dijkstra(){
        int[] visited = new int[max];
        int u=0,j,i,min;
        for(i=1;i<=n;i++){
            visited[i]=0;
            dest[i]=cost[source][i];
        }
        visited[source]=1;
        for(i=1;i<=n;i++){
            min = infinity;
            for(j=1;j<=n;j++){
                if(visited[j]==0 && dest[j]<min){
                    min=dest[j];
                    u=j;
                }
            }
            visited[u]=1;
            for(j=1;j<=n;j++){
                if(visited[j]==0 && dest[u]+cost[u][j]<dest[j]){
                    dest[j] = dest[u]+cost[u][j];
                }
            }
        }
    }
}