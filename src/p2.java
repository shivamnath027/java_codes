import java.util.Scanner;
class p2{
    private int[] d;
    public static final int maxval = 999;
    private int num_ver;
    public p2(int num_ver){
        this.num_ver = num_ver;
        d = new int[num_ver+1];
    }
    public void bellmanfordevaluation(int source,int[][] a){
        for(int node=1;node<=num_ver;node++){
            d[node] = maxval;
        }
        d[source] =0;
        for(int node=1;node<=num_ver-1;node++){
            for(int sn=1;sn<=num_ver;sn++){
                for(int dn=1;dn<=num_ver;dn++){
                    if(a[sn][dn]!=maxval){
                        if(d[dn]>d[sn]+a[sn][dn])
                            d[dn]=d[sn]+a[sn][dn];
                    }
                }
            }
        }
        for(int sn=1;sn<=num_ver;sn++){
            for(int dn=1;dn<=num_ver;dn++){
                if(a[sn][dn]!=maxval){
                    if(d[dn]>d[sn]+a[sn][dn])
                        System.out.println("Graph contains negative edge cycle");
                }
            }
        }
        for(int vertex=1;vertex<=num_ver;vertex++){
            System.out.println("distance from "+vertex+" is " + d[vertex]);
        }
    }
    public static void main(String[] args){
        Scanner ip = new Scanner(System.in);
        int num_ver=0,source;
        System.out.println("Enter no of vertices: ");
        num_ver = ip.nextInt();
        int[][] a = new int[num_ver+1][num_ver+1];
        System.out.println("Enter graph: ");
        for(int sn=1;sn<=num_ver;sn++){
            for(int dn=1;dn<=num_ver;dn++){
                a[sn][dn] = ip.nextInt();
                if(sn==dn){
                    a[sn][dn]=1;
                    continue;
                }
                if(a[sn][dn]==0){
                    a[sn][dn]=maxval;
                }
            }
        }
        System.out.println("Enter source vertex: ");
        source = ip.nextInt();
        p2 b = new p2(num_ver);
        b.bellmanfordevaluation(source,a);
    }
}