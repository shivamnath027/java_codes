import java.util.ArrayList;
class Hello{
    public static void main(String[] args){
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(0);
//        list.add(2);
//        list.add(4);
//        list.add(2);
//        list.add(5);
//        list.add(2);
//        ArrayList<Integer> list1 = new ArrayList<>();
//        list1.add(2);
//        list1.add(5);
//        System.out.println(list.get(2));
//        System.out.println(list.size());
//        list.remove(0);
//        System.out.println(list);
//        list.removeAll(list1);
//        System.out.println(list);
//        list.clear();
//        System.out.println(list);
        int sum=0;
        int[][] table = {{3,4,5,6},{7,8,9,10}};
        for(int x[]:table){
            for(int y:x){
                sum+=y;
            }
        }
        System.out.println(sum);

    }
}