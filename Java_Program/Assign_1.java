import java.util.Scanner;  


class Assign_1 
{
	public static void main(String[] args) 
	{
		int a=1;
		int stone=0;
		int cost=0;
		int tmp=0;
		int prec_stone=0;
		Scanner sc = new Scanner(System.in); 
		System.out.println("Enter `n` number : ");

		int n = sc.nextInt();  
		System.out.println("nth Number is: " + n);  
		
		if(n>0 && n<100000)
		{
					
			System.out.println("Putting Stone * on Divisible By 8"); 
			for(int i=a;i<n;i++)
			{
				if(i%8==0)
				{
					System.out.println(i+"*");  
					stone++;
					tmp=i;
				}
			}
		
		
		

			System.out.println("Putting Precious Stone $ where unit th digit is 6 and 8 are present!!");
			for(int i=a;i<n;i++)
			{
				if(i%8==0)
				{				
					if(i%10==6 || i%10==8 || (i%100)/10==6 || (i%100)/10==8)
					{
						System.out.println(i+"$");
						cost+=i;
						prec_stone++;
					}
				}
			}	
			
		
			System.out.println("Putting Precious Stone $$ where tenth and unit th both digits are 6 and 8 are present!!");
			for(int i=a;i<n;i++)
			{
				if(i%8==0)
				{				
					if((i%100)/10==6 && i%10==8 || (i%100)/10==8 && i%10==6 || (i%100)/10==6 && i%10==6 || (i%100)/10==8 && i%10==8)
					{
						System.out.println(i+"$$");
						prec_stone+=2;
					}
				}
			
			}
		
			if(tmp<n)
			{
				stone++;
			}
		
	
		
			System.out.println("Height of Terraced fields is : " + stone);
			System.out.println("Cost of  Tour : " + cost);
		}
		else{
			System.out.println("Invalid!!");
			
		}
			
	};
}

