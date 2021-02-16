import java.util.Random;

@SuppressWarnings("unchecked")
public class Deque<Item> {
	private Item[] deque;
	private int first = 0;
	private int last = 0;
	private int n = 0;
	private int access = 0;

	/***
	 * constructor: create an empty Deque with initial capacity of 10
	 */

	public Deque() {
		// TO BE IMPLEMENTED
		deque = (Item[]) new Object[10];
		
	}

	/***
	 * constructor: create an empty Deque with initial capacity of n
	 */
	public Deque(int n) {
		// TO BE IMPLEMENTED
		deque = (Item[]) new Object[n];
	}
	
	public boolean isFull() {
		return n == deque.length;
	}
	
	public void resize() {
		Item[] resizedDeque = (Item[]) new Object[n*2];
		int j = 0;
		for (int i = first; j < n; i++) {
			resizedDeque[j] = deque[i];
			i = (1+i)%n;
		}
		deque = resizedDeque;
		first = 0;
		last = resizedDeque.length-1;
		access += n;
	}

	/***
	 * add an item to the front of the Deque double the array capacity if Deque is
	 * full
	 */
	public void addToFront(Item item) {
		// TO BE IMPLEMENTED
		if (isFull()) {
			resize();
		}
		
		if (first == 0) {
			first = n-1;
		} else {
			first--;
		}
		
		deque[first] = item;
		n++;
		access++;
		
	}

	/***
	 * add an item to the back of the Deque; double the array capacity if the Deque
	 * is full
	 ***/
	public void addToBack(Item item) {
		// TO BE IMPLEMENTED
		if (isFull()) {
			resize();
		}
		
		if (last == n-1) {
			last = 0;
		} else {
			last++;
		}
		
		deque[last] = item;
		n++;
		access++;
	}

	/***
	 * remove and return the front item from the Deque; throw EmptyDequeException if
	 * the Deque is empty; reduce the array capacity by half if the size of the
	 * Deque size falls below floor(N/4) where N is the array capacity, but do not
	 * resize it to be below the default capacity, which is 10
	 ***/
	public Item getFirst() throws EmptyDequeException {
		// TO BE IMPLEMENTED
		if (!isEmpty()) {
			access++;
			Item value = deque[first];
			if (first == last) {
				first = 0;
				last = 0;
			}
			
			if (first == n-1) {
				first = 0;
			} else {
				first++;
			}
			n--;
			return value;
		} else {
			throw new EmptyDequeException();
		}
	}

	/***
	 * remove and return the back item from the Deque; throw EmptyDequeException if
	 * the Deque is empty; reduce the array capacity by half if the size of the
	 * Deque size falls below floor(N/4) where N is the array capacity, but do not
	 * resize it to be below the default capacity, which is 10
	 ***/
	public Item getLast() throws EmptyDequeException {
		// TO BE IMPLEMENTED
		if (!isEmpty()) {
			access++;
			Item value = deque[last];
			if (first == last) {
				first = 0;
				last = 0;
			}
			
			if (last == 0) {
				last = n-1;
			} else {
				last--;
			}
			n--;
			return value;
		} else {
			throw new EmptyDequeException();
		}
	}

	/***
	 * return true if the Deque is empty; return false if the Deque is not empty
	 ***/
	public boolean isEmpty() {
		// TO BE IMPLEMENTED
		return n == 0;
	}

	/***
	 * return the size of the Deque (i.e. the number of elements currently in the
	 * Deque)
	 ***/
	public int size() {
		// TO BE IMPLEMENTED
		return n;
	}

	/***
	 * return but do not remove the front item in the Deque; throw an
	 * EmptyDequeException if the Deque is empty
	 */
	public Item peekFirst() throws EmptyDequeException {
		// TO BE IMPLEMENTED
		if (!isEmpty()) {
			access++;
			Item value = deque[first];
			return value;
		} else {
			throw new EmptyDequeException();
		}
	}

	/***
	 * return but do not remove the back item in the Deque; throw an
	 * EmptyDequeException if the Deque is empty
	 */
	public Item peekLast() throws EmptyDequeException {
		// TO BE IMPLEMENTED
		if (!isEmpty()) {
			access++;
			Item value = deque[last];
			return value;
		} else {
			throw new EmptyDequeException();
		}
	}

	/***
	 * return the underlying array
	 ***/
	public Item[] getArray() {
		// TO BE IMPLEMENTED
		return deque;
	}

	/***
	 * return the array accesses count
	 ***/
	public int getAccessCount() {
		// TO BE IMPLEMENTED
		return access;
	}

	/***
	 * reset the array access count to 0
	 ***/
	public void resetAccessCount() {
		// TO BE IMPLEMENTED
		access = 0;
	}

	public static void main(String[] args) throws EmptyDequeException {
		// TO BE IMPLEMENTED
		Random random = new Random();
		int n = Integer.parseInt(args[0]);
		int c = Integer.parseInt(args[1]);
		Deque<Integer> queue = new Deque<Integer>(c);
		
		for (int i = 0; i <= n; i++) {
			boolean rand = random.nextBoolean();
			if (rand) {
				queue.addToFront(0);
			} else {
				queue.addToBack(0);
			}
		}
		
		System.out.println("array access for " + n + " adds: " + queue.getAccessCount()/n);
		queue.resetAccessCount();
		
		for (int i = 0; i <= n; i++) {
			boolean rand = random.nextBoolean();
			if (rand) {
				queue.getFirst();
			} else {
				queue.getLast();
			}
		}
		
		System.out.println("array access for " + n + " removes: " + queue.getAccessCount()/n);
		queue.resetAccessCount();
		
	}
}
