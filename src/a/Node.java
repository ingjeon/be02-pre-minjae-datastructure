package a;

public class Node
{
	private Node children[] = new Node[4];
	private Data items[] = new Data[3];
	
	private int numOfItems;
	private Node parent;
	
	public Node getParent()
	{
		return parent;
	}
	
	public Node getChild(int childNum)
	{
		return children[childNum];
	}
	public int getNumOfItems()
	{
		return numOfItems;
	}
	public Data getItem(int index)
	{
		return items[index];
	}
	public boolean isLeaf()
	{
		if(children[0] != null)
			return false;
		else
			return true;
	}
	public boolean isFull()
	{
		if(numOfItems != 3)
			return false;
		else
			return true;
	}
	public void displayNode()
	{
		for(int i = 0; i < numOfItems; i++)
			items[i].displayItem();
		System.out.println("|");
	}
	
	public void connect(int childNum, Node child)
	{
		children[childNum] = child;
		if(child != null)
			child.parent = this;
	}
	
	public Node disconnect(int child)
	{
		Node temp = children[child];
		children[child] = null;
		return temp;
	}

	public int insertData(Data item)
	{
		numOfItems++;
		int newKey = item.data;
		for(int i = 2; i >= 0; i--)
		{
			if(items[i] == null)
				continue;
			else
			{
				int itsKey = items[i].data;
				if(newKey < itsKey)
					items[i + 1] = items[i];
				else
				{
					items[i + 1] = item;
					return i + 1;
				}
			}
		}
		items[0] = item;
		return 0;
	}
	
	public Data removeItem()
	{
		Data temp = items[numOfItems - 1];
		items[numOfItems - 1] = null;
		numOfItems--;
		return temp;
	}
} 
