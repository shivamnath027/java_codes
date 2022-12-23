import java.util.Scanner;
class Hamiltonian {
    int n;
    int[][] G;
    int[] x;
    boolean found = false;

    public static void main(String[] args) {
        Hamiltonian hamiltonian = new Hamiltonian();
        hamiltonian.getdata();
        hamiltonian.HamiltonianMethod(2);
        hamiltonian.Noslnpossible();
    }
    void getdata() {
        Scanner ip = new Scanner(System.in);
        System.out.println("Enter no of elements: ");
        n = ip.nextInt();
        G = new int[n + 1][n + 1];
        x = new int[n + 1];
        System.out.println("Enter matrix: ");
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                G[i][j]= ip.nextInt();
            }
        }
        for (int i = 1; i <= n; i++) {
            x[i] = 0;
        }
        x[1] = 1;
    }
    void Noslnpossible() {
        if (found == false) {
            System.out.println("No Solution Possible");
        }
    }
    void HamiltonianMethod(int k) {
        while (true) {
            Nextvalue(k, G, x, n);
            if (x[k] == 0)
                return;
            if (k == n) {
                for (int i=1;i<=k;i++)
                    System.out.print(x[i] + " ");
                System.out.print(x[1]);
                System.out.println();
                found = true;
                return;
            } else {
                HamiltonianMethod(k + 1);
            }
        }
    }
    void Nextvalue(int k, int G[][], int x[], int n) {
        while (true) {
            x[k] = (x[k] + 1) % (n + 1);
            if(x[k]==0)
                return;
            if(G[x[k-1]][x[k]]!=0){
                int j;
                for(j=0;j<k;j++)
                    if(x[k]==x[j])
                        break;
                if(j==k){
                    if((k<n)||((k==n)&&G[x[n]][x[1]]!=0))
                        return;
                }
            }
        }
    }
}