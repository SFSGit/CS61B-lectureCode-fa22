package lec5_lists2;


public class IntList {
	public int first;
	public IntList rest;

	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}

	/** Return the size of the list using... recursion! */
	public int size() {
		if (rest == null) {
			return 1;
		}
		return 1 + this.rest.size();
	}

	/** Return the size of the list using no recursion! */
	public int iterativeSize() {
		IntList p = this;
		int totalSize = 0;
		while (p != null) {
			totalSize += 1;
			p = p.rest;
		}
		return totalSize;
	}

	/** Returns the ith item of this IntList. */
	public int get(int i) {
		if (i == 0) {
			return first;
		}
		return rest.get(i - 1);
	}

	public IntList addFirst(int x) {
		IntList L = new IntList(x ,this);
		return L;
	}

	public void addAdjacent() {
		if(this.rest == null){
			return;
		}
		if (this.first == this.rest.first) {
			this.first = this.first * 2;
			this.rest = this.rest.rest;
			this.addAdjacent();
		}
		else {
			this.rest.addAdjacent();
		}
	}


	public static void main(String[] args) {
		IntList L = new IntList(15, null);
		L = new IntList(10, L);
		L = new IntList(5, L);
		L = L.addFirst(3);

		System.out.println(L.get(0));
		System.out.println(L.iterativeSize());
	}
}