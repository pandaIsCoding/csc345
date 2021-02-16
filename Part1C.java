import java.util.Random;

public class Part1C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = Integer.valueOf(args[0]);
		int[] A_best = new int[N]; // {1, 2, 3, 4, 5, ..., N}
		int[] A_worst = new int[N];  // {N, ..., 5, 4, 3, 2, 1}
		int[] A_random = new int[N];
		
		Random rand = new Random();
		
		for (int i = 0; i < N; i++) {
			A_best[i] = i;
			A_worst[i] = N-i;
			A_random[i] = rand.nextInt(N);		
		}
		
		
		System.out.println("N = " + N);
		System.out.println("best case count = " + doSomething(A_best));
		System.out.println("worst case count = " + doSomething(A_worst));
		System.out.println("random case count = " + doSomething(A_random));
	}
	
	public static int doSomething(int[] A){
		int x = A[0];
		int p = 0; 
		int f = 1;
		int value = 0;
		
		for (int i = 1; i < A.length; i++) {
			int temp = A[i];
			value++;
			
			if (temp < x) {
				value += swapFunction(A, i, f);
				value += swapFunction(A, p, f);
				p++;
				f++;
			} else if (temp == x) {
				value += swapFunction(A, f, i);
				f++;
			}
		}
		return value;
	}

	private static int swapFunction(int[] a, int i, int f) {
		if (i == f) {
			return 0;
		}
		int temp = a[i];
		a[i] = a[f];
		a[f] = temp;
		return 4;
	}

}
