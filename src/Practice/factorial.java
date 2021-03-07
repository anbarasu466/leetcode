package Practice;

public class factorial {
    public static void main(String args[]){
        System.out.println(" 3 Factorial is = " + factorialFunction(5));
    }

    public static int factorialFunction(int num){

        if(num == 0){
            return 1;
        }

       num = num * factorialFunction(num-1);


        return num;

        //return 4;
    }
}
