package DynamicConnectivity;

/**
 * ���������鿴��һ��������һƬɭ�֣������е�ÿһ��Ϊ�������еĸ��ڵ㣬�������ĳ��͸���ֵ��ȣ������Ϊһ�����ĸ��ڵ�
 * �ŵ㣺�ϲ��ܿ�
 * ȱ�㣺���ܻ����ɺܸߵ��������²�ѯЧ�ʵ�
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

	//����������ֱ�����ڵ�
	private int root(int i) {
		while (i != id[i]) {
			i = id[i];
		}
		return i;
	}

	//���ڵ���ͬ��ʾ����ͨ��
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	//�ϲ�ֻ��Ҫ������һ�����ĸ��ڵ�ĸ��ڵ� ��id[proot]����Ϊ��һ�����ĸ��ڵ㣨qroot��
	public void union(int p, int q) {
		int proot = root(p);
		int qroot = root(q);
		id[proot] = qroot;
	}
}
