package com.sailfish.interview.dataStructure.unionfind;

/**
 * @author sailfish
 * @create 2019-11-16-4:38 下午
 */
public class QuickUnionOptimized implements UF{

    // 链式结构
    private int[] parent;
    private int[] sc;   // sc[i]表示以i为根的集合的元素个数

    public QuickUnionOptimized(int n) {
        parent = new int[n];
        sc = new int[n];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            sc[i] = 1;
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

        // 根据两个元素所在树的元素个数不同判断合并方向
        // 将元素个数少的集合合并到元素个数多的集合上
        if (sc[pRoot] < sc[qRoot]) {
            parent[pRoot] = qRoot;
            sc[qRoot] += sc[pRoot];
        } else {
            parent[qRoot] = pRoot;
            sc[pRoot] += sc[qRoot];
        }
    }

    private int find(int index) {

        while (parent[index] != index) {
            index = parent[index];
        }
        return index;
    }
}
