package Enum;

public class EnumRunner {
	
	public static void main(String[] args) {
		
		
		//Java Complier by default adds a to string
		
		System.out.println(Sevirity.CRITICAL);
		
		Sevirity sev = Sevirity.CRITICAL;
		
		switch (sev) {
		case CRITICAL:
			System.out.println("critical");
			break;
		case MEDIUM:
			System.out.println("Medium");
			break;
		}
		
		
		
		
	}

}
