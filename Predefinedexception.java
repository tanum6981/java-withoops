import java.util.Scanner;

public class Predefinedexception {
    
    public static void main(String[] args) {
        try{
        int[] arr = {1,2,3,4,5};
        int i, b;
        Scanner sc = new Scanner(System.in);
        i = sc.nextInt();
        b = sc.nextInt();
        System.out.println(arr[i]);
        System.out.println(arr[i]/b);
    }
    catch(ArithmeticException e){
    System.out.println("Exception caught is " + e.getMessage());
}
    catch(ArrayIndexOutOfBoundsException e)
    {
        System.err.println("Exception caught is "+e.getMessage());
    }
    finally{

    }
    }
    }

