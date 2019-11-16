package com.sailfish.interview.dataStructure.unionfind;

/**
 * @author sailfish
 * @create 2019-11-16-4:26 下午
 */
public class QuickUnion implements UF {

    // 链式结构
    private int[] parent;

    public QuickUnion(int n) {
        parent = new int[n];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {

        final int pRoot = find(p);
        final int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        parent[p] = qRoot;
    }

    private int find(int index) {

        while (parent[index] != index) {
            index = parent[index];
        }
        return index;
    }
}
