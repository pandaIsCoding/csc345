import java.util.Random;

public class Part1E {
	
	private static int value;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = Integer.valueOf(args[0]);
		int[] A_best = new int[N]; // {1, 2, 3, 4, 5, ..., N}
		int[] A_worst = new int[N];  // {N, ..., 5, 4, 3, 2, 1}
		int[] A_random = new int[N];	
		
		Random rand = new Random();
		
		for (int i = 0; i < N; i++) {
			A_best[i] = 0;
			A_worst[i] = i;
			A_random[i] = rand.nextInt(N);		
		}
		
		
		System.out.println("N = " + N);
		System.out.println("best case count = " + doSomething(A_best));
		System.out.println("worst case count = " + doSomething(A_worst));
		System.out.println("random case count = " + doSomething(A_random));
	}
	
	public static int doSomething(int[] A){
		value = 0;
		for (int i = A.length/2; i >= 0; i--) {
			foo(A, i);
		}
		return value;
	}

	
	
	
	private static void foo(int[] a, int i) {
		int l = (2*i)+1;
		int r = (2*i)+2;
		
		if (l >= a.length && r >= a.length) {
			return;
		}
		
		if (r >= a.length) {
			value += 2;
		} else  {
			value += 4;
		}
		
		
		if (r >= a.length) {
			if (a[i] < a[l]) {
				value+=swapFunction(a, i, l);
			}
			return;
		}
		
		if (a[r] > a[l] && a[r] > a[i]) {
			value += swapFunction(a, i, r);
			foo(a, r);
			return;
		}
		if (a[l] > a[i]) {
			value += swapFunction(a, i, l);
			foo(a, l);
		}
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
