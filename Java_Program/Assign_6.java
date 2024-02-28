import java.util.*;

abstract class shape 
{
	int rarea, carea, tarea; 
	abstract void getData();
	abstract void area();
	/*abstract void perimeter();
	abstract void color(); */
	void disp(double rarea)
	{
		System.out.println("Area of Rectangle : " + rarea);
		
	}
	
}

class rectangle extends shape
{
	public int l, b;
	public double area;
	void getData()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Length");
		l= sc.nextInt();
		System.out.println("Enter Breadth");
		b= sc.nextInt();		
	}
	void area()
	{
		area = l*b;
		disp(area);
	}
	
};


class circle extends shape
{
	public int r;
	public double area;
	void getData()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Radius");
		r= sc.nextInt();		
	}
	void area()
	{
		area = 3.14*r*r;
		disp(area);
	}
	
};

class triangle extends shape
{
	public int b, h;
	public double area;
	void getData()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Base");
		b= sc.nextInt();
		System.out.println("Enter Height");
		h= sc.nextInt();			
	}
	void area()
	{
		area = 0.5*b*h;
		disp(area);
	}
	
};

class Assign_6 {
	
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		int ch;
		System.out.println("1]Rectangle\n2]Circle\n3]Triangle");
		System.out.println("Enter Choice : ");
		ch = sc.nextInt();
		switch(ch)
		{
			case 1:
				rectangle r1 = new rectangle();
				r1.getData();
				r1.area();
				//r1.disp();
				break;
		
			case 2: 
				circle c1 = new circle();
				c1.getData();
				c1.area();
				c1.disp();
				break;
			
			case 3: 
				triangle t1 = new triangle();
				t1.getData();
				t1.area();
				t1.disp();
				break;

			default: 
				System.out.println("Not found");
				break;
			
		}
	}
	
}