import java.util.*;
import java.math.BigInteger;

class Assign_3_1 {
    
    static void temp(BigInteger m) {
        int addition = 0;

        String str = m.toString();
        int[] add = new int[str.length()];

        for (int i = 0; i < str.length(); i++) 
		{
            add[i] = Character.getNumericValue(str.charAt(i));
        }
        
        for (int k = 0; k < str.length(); k++) 
		{
            addition += add[k];
        }
        System.out.println("Addition is : " + addition);
		
        if(addition < 10) 
		{
            System.out.println("Actual Addition is " + addition);
        } 
		else 
		{
            temp(BigInteger.valueOf(addition));
        }
    }
    
    
    public static void main(String[] args) {
        int a, b;
        BigInteger mul = BigInteger.ONE;
         

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter value of a : ");
        a = sc.nextInt();
        System.out.println("Enter value of b : ");
        b = sc.nextInt();
        
        for (int i = a; i <= b; i++) 
		{
            mul = mul.multiply(BigInteger.valueOf(i));
        }
        System.out.println(mul);
        temp(mul);       
    }
}
