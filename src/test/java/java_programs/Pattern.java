package java_programs;

public class Pattern {

	public static void main(String[] args) {
		
		int  count=1;
		
		for(int i=1; i<=5; i++) {
			
			
			for(int j=1; j<=i; j++) {
				
				System.out.print(count+" ");
				
				if(count>=9) {
					count=0;
				}
				count++;
				
					
			}
			
			System.out.println("");
		} 
		

	}

}
