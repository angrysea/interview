import java.util.HashSet;
import java.util.Set;

public class HappyNumbers {

    boolean isHappy(int in){
        int num = in;
        boolean bIsHappy = false;
        Set<Integer> foundNumbers = new HashSet<>();
        while(!foundNumbers.contains(num)){
            foundNumbers.add(num);
            int squareSum = 0;
            while(num != 0){
                squareSum += Math.pow(num%10, 2);
                num = num/10;
            }
            num = squareSum;
            if(num == 1){// If found the square sum to be 1
                System.out.println("Is a happy number: " + in + " result: " + num);
                bIsHappy = true;
                break;
            }
        }
        if(!bIsHappy) {
            System.out.println("Is a unHappy number: " + in + " result: " + num);
        }

        return bIsHappy;
    }

    public static void main(String[] args) {
        new HappyNumbers().isHappy(32);
    }
}
