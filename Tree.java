

public class Tree {
	

	private Node root = null;

	
	public void insert(int keyvalue) {
		Node p = new Node(keyvalue);
		root = InsertNode(root,p);
	}
	
	private Node InsertNode(Node root, Node t) {
		if (root ==null) return t;
		if (t.key< root.key) {
			root.left = InsertNode(root.left, t);
			root.lh = Math.max(root.left.lh, root.left.rh)+1;
			if(root.lh-1>root.rh) {
				//rotate to the right
				//test to see if double rotation is needed
				if(root.left.rh>root.left.lh) {
					root.left = rotateLeft(root.left);
					root.lh = Math.max(root.left.lh, root.left.rh)+1; //this just makes sure that the height is corrected during the double rotation 
				}
				root = rotateRight(root);
			}
		}else {
			root.right = InsertNode(root.right, t);
			root.rh = Math.max(root.right.lh, root.right.rh)+1;
			if (root.rh-1>root.lh) {
				//rotate to the left 
				if(root.right.lh>root.right.rh) {
					root.right = rotateRight(root.right);
					root.rh = Math.max(root.right.lh, root.right.rh)+1;
				}
				root = rotateLeft(root);
			}
		}

		return root;
	}

	private Node rotateRight(Node root) {
		Node newroot = root.left;
		root.left = newroot.right;
		root.lh = newroot.rh;//this is for height, dont worry about this part for the test
		newroot.right = root;
		newroot.rh = Math.max(root.rh, root.lh)+1; //this is for height, dont worry about this part for the test
		return newroot;
	}

	private Node rotateLeft(Node root) {
		Node newroot = root.right;
		root.right = newroot.left;
		root.rh = newroot.lh;
		newroot.left = root;
		newroot.lh = Math.max(root.lh, root.rh)+1;
		return newroot;
	}
	
	public int avlHeight() {
		if(root.lh>root.rh) {
			return root.lh+1;
		}else
			return root.rh+1;
	}


	public int height() {
		return height(root);
	}
	public int height(Node root) {
		int lh, rh;
		if (root==null) return 0;
		lh = height(root.left);
		rh = height(root.right);
		if (lh>rh)
			return lh+1;
		else
			return rh+1;
	}


	private static class Node{
		int key;
		Node left=null, right=null;
		int lh=0, rh=0;
		public Node(int n) {
			key= n;
		}
	}
}
