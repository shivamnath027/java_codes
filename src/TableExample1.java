import javax.swing.*;
public class TableExample1
{
    public static void main(String[] args)
    {
// TODO Auto-generated method stub 
        JFrame f=new JFrame("Table Demo");
        String[][] data={
                {"100","CSE","VTU"}
                ,
                {"101","ISE","VTU"}
                ,
                {"102","CSE","VTU"}
                ,
                {"103","ISE","VTU"}
                ,
                {"105","ISE","VTU"}
                ,
                {"106","ISE","VTU"}
        };
        String[] column={"courseID","Branch","University"};
        JTable jt=new JTable(data,column);
        JScrollPane js=new JScrollPane(jt);
        js.setBounds(30,100,300,100);
        f.add(js);
        f.setSize(300,400);
        f.setLayout(null);
        f.setVisible(true);
    }
}