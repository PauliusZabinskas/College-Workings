package nestedclasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArraySequences {
	
	private int [] sequence;
	private int size;

	public ArraySequences(int size) {
		sequence = new int[size];
		for(int i = 0; i < size; i++) {
			sequence[i] = i;
		}
		this.size = size;
	}

	public void printEven() {
		List<Integer> sequenceList = new ArrayList<Integer>(size);
		for(int i = 0; i < size; i++)
			sequenceList.add(i, sequence[i]);
		
		for(ArrayIterator evenIt = new ArrayIterator(2,0); evenIt.hasNext();) {
			System.out.print(evenIt.next() + " ");
		}
	}
	
	public void printOdd() {
		List<Integer> sequenceList = new ArrayList<Integer>(size);
		for(int i = 0; i < size; i++)
			sequenceList.add(i, sequence[i]);
		
		for(ArrayIterator oddIt = new ArrayIterator(2,1); oddIt.hasNext();) {
			System.out.print(oddIt.next() + " ");
		}
	}
	
	class ArrayIterator implements Iterator<Integer> {
		
		private int nextInt;
		private int skip;
		
		ArrayIterator(int skip, int start) {
			nextInt = start;
			this.skip = skip;
		}

		@Override
		public boolean hasNext() {
			if(nextInt < size - 1)
				return true;
			return false;
		}

		@Override
		public Integer next() {
			Integer result =  sequence[nextInt];
			nextInt += skip;
			return result;
			
		}

		
	}
	
	public static void main (String [] args) {
		new ArraySequences(10).printEven();
	}

}
