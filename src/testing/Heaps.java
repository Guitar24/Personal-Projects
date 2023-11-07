package testing;

import java.util.Arrays;

public class Heaps {
	// Member variables of this class
	private int[] Heap;
	private int size;
	private int maxsize;
	private String type;

	// Initializing front as static with unity
	private static final int FRONT = 1;

	// Constructor of this class
	public Heaps(int maxsize, String type)
	{

		// This keyword refers to current object itself
		this.maxsize = maxsize;
		this.size = 0;

		Heap = new int[this.maxsize + 1];

		if(type.equalsIgnoreCase("min"))
		{
			Heap[0] = Integer.MIN_VALUE;
			this.type = "min";
		}
		else if(type.equalsIgnoreCase("max"))
		{
			Heap[0] = Integer.MAX_VALUE;
			this.type = "max";
		}
	}

	public int parent(int pos) 
	{ 
		return pos / 2; 
	}

	public int leftChild(int pos) 
	{ 
		return (2 * pos); 
	}

	public int rightChild(int pos) 
	{ 
		return (2 * pos) + 1; 
	}

	public boolean isLeaf(int pos)
	{

		if (pos > (size / 2)) {
			return true;
		}

		return false;
	}

	public void swap(int fpos, int spos)
	{

		int tmp;
		tmp = Heap[fpos];

		Heap[fpos] = Heap[spos];
		Heap[spos] = tmp;
	}

	public void heapify(int pos)
	{      

		if(type.equals("min"))
		{
			if(!isLeaf(pos))
			{
				int swapPos= pos;
				// swap with the minimum of the two children
				// to check if right child exists. Otherwise default value will be '0'
				// and that will be swapped with parent node. 
				if(rightChild(pos)<=size)
				{
					swapPos = Heap[leftChild(pos)] < Heap[rightChild(pos)] ? leftChild(pos) : rightChild(pos);
				}
				else
				{
					swapPos = leftChild(pos);
				}

				//System.out.println("swapPos: " + swapPos);


				if(Heap[pos]>Heap[leftChild(pos)] || Heap[pos]> Heap[rightChild(pos)]){
					swap(pos,swapPos);
					heapify(swapPos);
				}

			}       
		}
		else if(type.equals("max"))
		{
			if(!isLeaf(pos))
			{
				int swapPos= pos;
				// swap with the minimum of the two children
				// to check if right child exists. Otherwise default value will be '0'
				// and that will be swapped with parent node. 
				if(rightChild(pos)<=size)
				{
					swapPos = Heap[leftChild(pos)] > Heap[rightChild(pos)] ? leftChild(pos) : rightChild(pos);
				}
				else
				{
					swapPos = leftChild(pos);
				}

				//System.out.println("swapPos: " + swapPos);


				if(Heap[pos]<Heap[leftChild(pos)] || Heap[pos]< Heap[rightChild(pos)]){
					swap(pos,swapPos);
					heapify(swapPos);
				}

			}      
		}
	}

	public void insert(int element)
	{

		if (size >= maxsize) {
			return;
		}

		Heap[++size] = element;
		int current = size;

		if(type.equals("min"))
		{
			while (Heap[current] < Heap[parent(current)]) {
				swap(current, parent(current));
				current = parent(current);
			}
		}
		else if(type.equals("max"))
		{
			while (Heap[current] > Heap[parent(current)]) {
				swap(current, parent(current));
				current = parent(current);
			}
		}
	}

	public void print()
	{
		for (int i = 1; i <= size / 2; i++) {

			// Printing the parent and both childrens
			System.out.print(
					" PARENT : " + Heap[i]
							+ " LEFT CHILD : " + Heap[2 * i]
									+ " RIGHT CHILD :" + Heap[2 * i + 1]);

			// By here new line is required
			System.out.println();
		}
	}

	public void printAsArray()
	{
		System.out.println(Arrays.toString(Heap));
	}

	public int remove()
	{

		int popped = Heap[FRONT];
		Heap[FRONT] = Heap[size--];

		if(type.equals("min")) {heapify(FRONT);}

		else if(type.equals("max")) {heapify(FRONT);}

		return popped;
	}

	public void removeAtIndex(int pos)
	{
		if(!isLeaf(pos)) 
		{
			if(type.equals("min"))
			{
				Heap[pos] = Heap[leftChild(pos)] < Heap[rightChild(pos)] ? leftChild(pos) : rightChild(pos);
			}
			else if(type.equals("max"))
			{
				Heap[pos] = Heap[leftChild(pos)] > Heap[rightChild(pos)] ? leftChild(pos) : rightChild(pos);
			}
		}
		else
		{
			Heap[pos] = 0;
		}

		if(type.equals("min")) {heapify(FRONT);}

		else if(type.equals("max")) {heapify(FRONT);}

	}

	public int findIndex(int value)
	{
		for(int i = 1; i <= size / 2; i++)
		{
			if(Heap[i] == value)
			{
				return i;
			}
		}
		return -1;
	}

}
