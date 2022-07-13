package java_programs;

public class individual_Number_add {

	public static void main(String[] args) {
		
		int num=121, rem, sum=0;
		
		while(num!=0) {
			
			rem = num % 10;
			
			sum = rem+sum;
			
			num = num/10;
			
		}
		
			System.out.println(sum);
	
	}

}
