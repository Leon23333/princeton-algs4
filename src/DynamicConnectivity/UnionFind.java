package DynamicConnectivity;

/**
 * 在QuickUnion上改进，采用加权的方法避免生成太高的树（再维护一个数组来记录每个节点所属树的节点个数，合并时把小的树的根节点作为大的树的根节点的子节点）
 * 
 * @author xzy
 *
 */
public class UnionFind {
	private int[] id;
	// sz[N]记录的是已N做为根节点的树的节点个数
	private int[] sz;

	public UnionFind(int size) {
		id = new int[size];
		sz = new int[size];
		for (int i = 0; i < size; i++) {
			id[i] = i;
		}
		
		for (int i = 0; i < size; i++) {
			sz[i] = 1;
		}
	}

	// 向上搜索，直到根节点
	private int root(int i) {
		while (i != id[i]) {
			i = id[i];
			//进一步改进是向上搜索祖父节点
			//i = id[id[i]];
		}
		return i;
	}

	// 根节点相同表示是连通的
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	// 合并只需要将其中一棵树的根节点的父节点 （id[proot]）设为另一棵数的根节点（qroot）
	// 合并时判断树的大小，把小的树的根节点作为大的树的根节点的子节点，并且将大树的权重加上小树的权重
	public void union(int p, int q) {
		int proot = root(p);
		int qroot = root(q);
		// 把p树的根节点作为q树的根节点的子节点
		if (sz[proot] < sz[qroot]) {
			id[proot] = qroot;
			sz[qroot] += sz[proot];
		} else {
			id[qroot] = proot;
			sz[proot] += sz[qroot];
		}

	}
}
