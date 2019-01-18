import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        goToLink("a");
        goToLink("b");
        goToLink("c");
        goToLink("d");
        goToLink("e");
        goToLink("f");
        goToLink("g");
        goToLink("h");
        System.out.println("start link array is: ");
        print();
        System.out.println("cur index is "+ index + " " + getCurrentPage());
        System.out.println("*****************************************************");
        goBack();
        goBack();
        goBack();
        goBack();
        goBack();
        goBack();
        System.out.println("back 5 index " + index + " " + getCurrentPage());
        goForward();
        goForward();
        System.out.println("forward 2 index " + index + " " + getCurrentPage());
        jumpForward(3);
        System.out.println("jump forward 3 index " + index + " " + getCurrentPage());
        jumpBack(2);
        System.out.println("jump back 2 index " + index + " " + getCurrentPage());
        goToLink("z");
        System.out.println("go to link index " + index + " " + getCurrentPage());
        goToLink("x");
        goToLink("y");
        System.out.println("final index " + index + " " + getCurrentPage());
        print();

    }

    private static List<String> list = new ArrayList<String>();
    private static int index = -1;


    private static void goToLink(String s){
        // 当 index !=(<) list.size() 的时候， 删掉后面的link
        if(index + 1 < list.size()){
            int i = list.size() - 1;
            while(i > index){
                list.remove(i);
                i--;
            }
            list.add(s);
            index++;
        }else{
            // don't need remove
            list.add(s);
            index++;
        }
    }

    private static String getCurrentPage(){
        // cur page is null
        if(index == -1){
            return "current page is none";
        }
        return list.get(index);
    }

    private static boolean goForward(){
        if(index + 1 > list.size()){
           return false;
        }else{
            index++;
            return true;
        }
    }

    private static boolean goBack(){
        if(index - 1 < 0){
            return false;
        }else {
            index--;
            return true;
        }
    }


    private static boolean jumpForward(int n){
        if(index + n >= list.size()){
            System.out.println("jump forward out of bound");////////////////
            return false;
        }else {
            index = index + n;
            return true;
        }
    }

    private static boolean jumpBack(int n){
        if(index - n < 0){
            System.out.println("jump back out of bound");/////////////////////
            return false;
        }else{
            index = index - n;
            return true;
        }
    }

    //test/////////////////////////
    private static void print(){
        for(String e : list){
            System.out.print(e + " ");
        }
        System.out.println();
    }


}
