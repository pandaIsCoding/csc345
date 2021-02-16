
public class Part1A {
	
	public static void main(String[] args) {
		int j, k = 0, value = 0;
		int N = Integer.valueOf(args[0]);
		
		for (int i = 1; i <= N; i++) {
			j = i;
			while (j >= 1){
				k = 1;
				while (k <= N) {
					k = k * 2;
					value++;
				}
				j = j - 1;
			}
		}
		System.out.println(value);
	}
	
}
