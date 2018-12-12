package DynamicConnectivity;

public class QuickFindTest {

	public static void main(String[] args) {
		QuickFind qf = new QuickFind(10);
		System.err.println(qf.connected(1, 2));
		System.err.println(qf.connected(1, 4));
		qf.union(1, 2);
		qf.union(1, 9);
		qf.union(9, 4);
		System.err.println(qf.connected(1, 2));
		System.err.println(qf.connected(1, 4));
		System.err.println(qf.connected(2, 4));
		System.err.println(qf.connected(2, 9));
		System.err.println(qf.connected(2, 8));
	}

}
