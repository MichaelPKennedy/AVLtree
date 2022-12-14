
public class AVLtree {
	public static void main(String[] args) throws Exception {

		int n, x;

		Tree avl = new Tree();


		for (n=1; n<=1000000; n++) {
			x = (int)(Math.random()*10000);
			avl.insert(x);
		}

		System.out.println("Height of tree: "+avl.avlHeight());

	}
}


