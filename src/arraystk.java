import java.util.Scanner;
class arraystk{
    Scanner input = new Scanner(System.in);
    int maxstk;
    int s[];
    int top = -1;
    arraystk(int n)
    {
        maxstk = n;
        s = new int[maxstk];
        top = -1;
    }
    void push()
    {
        if(top==maxstk-1)
        {
            System.out.println("Stack is full");
            return;
        }
        System.out.println("Enter Element to Push: ");
        int ele = input.nextInt();
        top++;
        s[top] = ele;
    }
    void pop()
    {
        if(top==-1)
        {
            System.out.println("Stack is empty");
            return;
        }
        System.out.printf("Element"+s[top]+" is popped");
        top--;
    }
    void display()
    {
        if(top==-1)
        {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Elements are: ");
        for(int i=top;i>=0;i--)
        {
            System.out.print(""+s[i]);
        }
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Size of Stack :");
        int n = input.nextInt();
        arraystk stk = new arraystk(n);
        char ch;
        do {
            System.out.println("1:Push 2:Pop 3:Display");
            int choice = input.nextInt();
            switch(choice)
            {
                case 1:stk.push();
                        break;
                case 2: stk.pop();
                        break;
                case 3: stk.display();
                        break;
                default: System.out.println("WRONG INPUT");
            }
            System.out.println("Do you want to continue? (Y/N): ");
            ch = input.next().charAt(0);
        }while(ch=='Y' || ch=='y');
    }
}