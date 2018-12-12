package DynamicConnectivity;

/**
 * 数组每项的值和index相等，若两个数连通，则数组这两项的值相等
 * 优点：查询很快
 * 缺点：当数很多时合并很慢
 * @author leon
 *
 */
public class QuickFind {
	private int[] id;

	public QuickFind(int size) {
		id = new int[size];
		for (int i = 0; i < size; i++) {
			id[i] = i;
		}
	}

	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}

	//连通p、q两项，需要将所有与p连通的项的值设为q项的值
	public void union(int p, int q) {
		int pid = id[p];
		int qid = id[q];
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pid) {
				id[i] = qid;
			}
		}
	}
}
