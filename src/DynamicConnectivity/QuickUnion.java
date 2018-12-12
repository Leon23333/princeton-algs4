package DynamicConnectivity;

/**
 * 将整个数组看做一组树，即一片森林，数组中的每一项为它在树中的父节点，若数组的某项和该项值相等，则该项为一棵树的根节点
 * 优点：合并很快
 * 缺点：可能会生成很高的树，导致查询效率低
 * @author leon
 *
 */
public class QuickUnion {
	private int[] id;

	public QuickUnion(int size) {
		id = new int[size];
		for (int i = 0; i < size; i++) {
			id[i] = i;
		}
	}

	//向上搜索，直到根节点
	private int root(int i) {
		while (i != id[i]) {
			i = id[i];
		}
		return i;
	}

	//根节点相同表示是连通的
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	//合并只需要将其中一棵树的根节点的父节点 （id[proot]）设为另一棵数的根节点（qroot）
	public void union(int p, int q) {
		int proot = root(p);
		int qroot = root(q);
		id[proot] = qroot;
	}
}
