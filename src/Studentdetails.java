import java.util.Scanner;
class Student{
    Scanner scan = new Scanner(System.in);
    String USN,Name,Branch,Phone;
    void read(){
        System.out.println("Enter USN: ");
        USN = scan.nextLine();
        System.out.println("Enter Name: ");
        Name = scan.nextLine();
        System.out.println("Enter Branch: ");
        Branch = scan.nextLine();
        System.out.println("Enter Phone: ");
        Phone = scan.nextLine();
    }
    void display()
    {
        System.out.printf("%-20s%-20s%-20s%-20s\n",USN,Name,Branch,Phone);
    }
}
class Studentdetails {
    public static void main(String[] args) {
        int i,n;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter no. of Student details to create: ");
        n = input.nextInt();
        Student[] s = new Student[n];
        for(i = 0; i < n; i++) {
                s[i] = new Student();
                s[i].read();
        }
        System.out.printf("%-20s%-20s%-20s%-20s\n","USN","NAME","BRANCH","PHONE");
        for(i=0;i<n;i++){
            s[i].display();
        }
    }
}