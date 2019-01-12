import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    private static List<Integer> list = new ArrayList<Integer>();

    private static void store(int input){
        list.add(input);
    }

    private static boolean twoSum(int target){
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < list.size(); i++ ){
            int n = target - list.get(i);
            if(set.contains(n)){
                return true;
            }else{
                set.add(n);
            }
        }
        return false;
    }
}
