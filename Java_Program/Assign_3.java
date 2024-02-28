import java.util.*;

class Assign_3 {
	
	static void temp(long m)
	{
		int addition = 0;

        String str = Long.toString(m);
        int[] add = new int[str.length()];

        for (int i = 0; i < str.length(); i++) 
		{
            add[i] = Character.getNumericValue(str.charAt(i));
			//System.out.println(add[i]);
        }
        
		for (int k = 0; k < str.length(); k++) 
		{
			//System.out.println(add[k]);
			addition+=add[k];
        }
		System.out.println("Addition is : " + addition);
		if(addition<10)
		{
			System.out.println("Actual Addition is "+addition);
		}
		else
		{
			temp(addition);
		}
		
	}
	
	
    public static void main(String[] args) {
        int a, b;
        long mul = 1;
		 

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter value of a : ");
        a = sc.nextInt();
		System.out.println("Enter value of b : ");
        b = sc.nextInt();
		
		for (int i = a; i <= b; i++) 
		{
            mul *= i;
        }
        System.out.println(mul);
		temp(mul);       
		
		
    }
}
