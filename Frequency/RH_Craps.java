public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static String craps(String s){
        // "|" regular expression
        String[] input = s.split("//|");
        int firstRound = Integer.getInteger(input[0])  + Integer.getInteger(input[1]);
        if(firstRound == 7 || firstRound == 11){
            return "nature";
        }else if(firstRound == 2 || firstRound == 3 || firstRound == 12){
            return "craps";
        }

        for(int i = 4; i < input.length ; i += 2){
            int curSum = Integer.getInteger(input[i - 1]) + Integer.getInteger(input[i]);
            if(curSum == firstRound){
                return "get cover";
            }else if(curSum == 7){
                return "get over seven";
            }
        }
        return "";
    }
}
