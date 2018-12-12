package DynamicConnectivity;

public class UnionFindTest {

	public static void main(String[] args) {
		UnionFind uf = new UnionFind(10);
		System.err.println(uf.connected(1, 2));
		System.err.println(uf.connected(1, 4));
		uf.union(1, 2);
		uf.union(1, 9);
		uf.union(9, 4);
		System.err.println(uf.connected(1, 2));
		System.err.println(uf.connected(1, 4));
		System.err.println(uf.connected(2, 4));
		System.err.println(uf.connected(2, 9));
		System.err.println(uf.connected(2, 8));
	}

}
