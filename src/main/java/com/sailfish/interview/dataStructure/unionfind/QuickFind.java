package com.sailfish.interview.dataStructure.unionfind;

/**
 * @author sailfish
 * @create 2019-11-16-4:03 下午
 */
public class QuickFind implements UF{

    private int[] data;

    public QuickFind(int n) {
        data = new int[n];

        for (int i = 0; i < data.length; i++) {
            data[i] = i;
        }
    }


    @Override
    public int getSize() {
        return data.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {

        final int pID = find(p);
        final int qID = find(q);

        if (pID == qID) {
            return;
        } else {
            for (int i = 0; i < data.length; i++) {
                if (data[i] == pID) {
                    data[i] = qID;
                }
            }
        }

    }

    private int find(int index) {
        return data[index];
    }
}
