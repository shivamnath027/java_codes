import java.util.Scanner;
class Staff{
    String StaffID,Name,Phone,Salary;
    Scanner input = new Scanner(System.in);
    void read(){
        System.out.println("Enter StaffID: ");
        StaffID = input.nextLine();
        System.out.println("Enter Name: ");
        Name = input.nextLine();
        System.out.println("Enter Phone: ");
        Phone = input.nextLine();
        System.out.println("Enter Salary: ");
        Salary = input.nextLine();
    }
    void display(){
        System.out.printf("%-20s%-20s%-20s%-20s",StaffID,Name,Phone,Salary);
    }
}
class Teaching extends Staff{
    String Domain,Publication;
    void read_Teaching()
    {
        super.read();
        System.out.println("Enter Domain: ");
        Domain = input.nextLine();
        System.out.println("Enter Publication: ");
        Publication = input.nextLine();
    }
    void display(){
        super.display();
        System.out.printf("%-20s%-20s",Domain,Publication);
    }
}
class Technical extends Staff{
    String Skill;
    void read_Technical(){
        super.read();
        System.out.println("Enter Skill: ");
        Skill = input.nextLine();
    }
    void display(){
        super.display();
        System.out.printf("%-20s",Skill);
    }
}
class Contract extends Staff{
    String Period;
    void read_Contract(){
        super.read();
        System.out.println("Enter Period: ");
        Period = input.nextLine();
    }
    void display(){
        super.display();
        System.out.printf("%-20s",Period);
    }
}
class Staffdetails{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n,i;
        System.out.println("Enter no. of StaffDetails to create: ");
        n = input.nextInt();
        Teaching[] teach = new Teaching[n];
        Technical[] tech = new Technical[n];
        Contract[] con = new Contract[n];
        System.out.println("ENTER STAFF DETAILS: \n");
        System.out.println("Enter Teaching staff Information: ");
        for(i=0;i<n;i++){
            teach[i] = new Teaching();
            teach[i].read_Teaching();
        }
        System.out.println("Enter Technical staff Information: ");
        for(i=0;i<n;i++){
            tech[i] = new Technical();
            tech[i].read_Technical();
        }
        System.out.println("Enter Contract staff Details: ");
        for(i=0;i<n;i++){
            con[i] = new Contract();
            con[i].read_Contract();
        }
        System.out.println("-------------TEACHING STAFF DETAILS---------------");
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s\n","STAFFID","NAME","BRANCH","PHONE","DOMAIN","PUBLICATION");
        for(i=0;i<n;i++){
            teach[i].display();
        }
        System.out.println("\n-------------TECHNICAL STAFF DETAILS---------------");
        System.out.printf("%-20s%-20s%-20s%-20s%-20s\n","STAFFID","NAME","BRANCH","PHONE","SKILL");
        for(i=0;i<n;i++){
            tech[i].display();
        }
        System.out.println("\n-------------CONTRACT STAFF DETAILS---------------");
        System.out.printf("%-20s%-20s%-20s%-20s%-20s\n","STAFFID","NAME","BRANCH","PHONE","PERIOD");
        for(i=0;i<n;i++){
            con[i].display();
        }
    }
}