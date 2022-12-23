//import javax.swing.*;
//public class SimpleSwingProg {
//    JFrame f = new JFrame("This is Title");
//    f.setSize(400,500);
//    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    JLabel l = new JLabel("Welcome",JLabel.CENTER);
//    f.add(l);
//    f.setVisible(true);
//}
import javax.swing.*;
public class SimpleSwingProg
{
    public static void main(String[] args)
    {
        JFrame f =  new JFrame("MyApp");
//creating instance of JFrame and title of the frame is MyApp.
        JButton b=new JButton("click");
//creating instance of JButton and name of the button is click.
        b.setBounds(130,100,100, 40); //x axis, y axis, width, height
        f.add(b); //addin g butto n in JFrame
        f.setSize(400,500); //400 width and 500 height
        f.setLayout(null); //using no layout manage rs
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true); //making the frame visible
    }
}