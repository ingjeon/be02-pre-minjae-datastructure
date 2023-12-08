package btree.bbbbb;

public class Tree
{
	Node root = new Node();
	
	public void insert(int value)
	{
		Data temp = new Data(value);
		Node currentNode = root;

		while(true)
		{
			if(currentNode.isFull())
			{
				split(currentNode);
				currentNode = currentNode.getParent();
				currentNode = getNextChild(currentNode, value);
			}
			else if(currentNode.isLeaf())
				break;
			else
				currentNode = getNextChild(currentNode, value);
		}
		currentNode.insertData(temp);
	}
	public void split(Node node)
	{
		Node parent;
		Node childOne;
		Node childTwo;
		Data a;
		Data b;
		int index;

		b = node.removeItem();
		a = node.removeItem();
		
		childOne = node.disconnect(2);
		childTwo = node.disconnect(3);

		Node newNode = new Node();
		if(node != root)
		{
			parent = node.getParent();
		}
		else
		{
			root = new Node();
			parent = root;
			root.connect(0, node);
		}

		index = parent.insertData(a);
		int n = parent.getNumOfItems();

		for(int i = n - 1; i > index; i--)
		{
			Node temp = parent.disconnect(i);
			parent.connect(i + 1, temp);
		}
		parent.connect(index + 1, newNode);
		newNode.insertData(b);
		newNode.connect(0, childOne);
		newNode.connect(1, childTwo);
	}  
	public Node getNextChild(Node node, int value)
	{
		int i;
		int numItems = node.getNumOfItems();
		for(i = 0; i < numItems; i++)
		{
			if(value < node.getItem(i).data)
				return node.getChild(i);
		}
		return node.getChild(i);
	}
	public void getTree()
	{
		displayTree(root, 0, 0);
	}
	private void displayTree(Node node, int level, int number)
	{
		System.out.print("level = " + level + " child = " + number + " ");
		node.displayNode();
		int numItems = node.getNumOfItems();
		for(int i = 0; i < numItems + 1; i++)
		{
			Node nextNode = node.getChild(i);
			if(nextNode != null)
				displayTree(nextNode, level + 1, i);
		}
	}  
}  
