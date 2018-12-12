package DynamicConnectivity;

public class QuickUnionTest {

	public static void main(String[] args) {
		QuickUnion qu = new QuickUnion(10);
		System.err.println(qu.connected(1, 2));
		System.err.println(qu.connected(1, 4));
		qu.union(1, 2);
		qu.union(1, 9);
		qu.union(9, 4);
		System.err.println(qu.connected(1, 2));
		System.err.println(qu.connected(1, 4));
		System.err.println(qu.connected(2, 4));
		System.err.println(qu.connected(2, 9));
		System.err.println(qu.connected(2, 8));
	}

}
