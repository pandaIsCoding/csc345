
public class Part1B {

	public static void main(String[] args) {
		int j, k;
		int sum = 0;
		int value = 0;
		int N = Integer.valueOf(args[0]);
		
		while (N > 0) {
			for (j = 1; j <= N; j++) {
				for (k = 1; k <= j; k++) {
					sum += j + k;	
					value++;
				}
			}
			N = N/3;
		}
		System.out.println(value);
	}

}
