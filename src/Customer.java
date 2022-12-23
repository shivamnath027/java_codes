import java.util.Scanner;
import java.util.StringTokenizer;
public class Customer {
    public static void main(String[] args){
        String name;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Name and DOB in format <Name,DD/MM/YYYY>: ");
        name = input.nextLine();
        StringTokenizer st = new StringTokenizer(name,",/");
        int count = st.countTokens();
        for(int i=1;i<=count && st.hasMoreTokens();i++){
            System.out.print(st.nextToken());
            if(i<count){
                System.out.print(",");
            }
        }
    }
}