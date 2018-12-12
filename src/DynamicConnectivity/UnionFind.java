package DynamicConnectivity;

/**
 * ��QuickUnion�ϸĽ������ü�Ȩ�ķ�����������̫�ߵ�������ά��һ����������¼ÿ���ڵ��������Ľڵ�������ϲ�ʱ��С�����ĸ��ڵ���Ϊ������ĸ��ڵ���ӽڵ㣩
 * 
 * @author xzy
 *
 */
public class UnionFind {
	private int[] id;
	// sz[N]��¼������N��Ϊ���ڵ�����Ľڵ����
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

	// ����������ֱ�����ڵ�
	private int root(int i) {
		while (i != id[i]) {
			i = id[i];
			//��һ���Ľ������������游�ڵ�
			//i = id[id[i]];
		}
		return i;
	}

	// ���ڵ���ͬ��ʾ����ͨ��
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	// �ϲ�ֻ��Ҫ������һ�����ĸ��ڵ�ĸ��ڵ� ��id[proot]����Ϊ��һ�����ĸ��ڵ㣨qroot��
	// �ϲ�ʱ�ж����Ĵ�С����С�����ĸ��ڵ���Ϊ������ĸ��ڵ���ӽڵ㣬���ҽ�������Ȩ�ؼ���С����Ȩ��
	public void union(int p, int q) {
		int proot = root(p);
		int qroot = root(q);
		// ��p���ĸ��ڵ���Ϊq���ĸ��ڵ���ӽڵ�
		if (sz[proot] < sz[qroot]) {
			id[proot] = qroot;
			sz[qroot] += sz[proot];
		} else {
			id[qroot] = proot;
			sz[proot] += sz[qroot];
		}

	}
}
