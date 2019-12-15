package usefuldatastructure;

public class MinHeap<Item extends Comparable> {
    private Item[] mData;
    private int mCount;
    private int mCapacity;

    // 构造函数, 构造一个空堆, 可容纳capacity个元素
    public MinHeap(int mCapacity) {
        mData = (Item[]) new Comparable[mCapacity + 1];
        mCount = 0;
    }

    // 使用heapify的方法构造堆, 时间复杂度为O(n)
    public MinHeap(Item arr[]) {
        int n = arr.length;
        mData = (Item[]) new Comparable[n + 1];
        mCapacity = n;
        for (int i = 0; i < n; i++) {
            mData[i + 1] = arr[i];
        }
        mCount = n;

        // /2是为了找到第一个有叶子节点的节点
        for (int i = mCount / 2; i >= 1; i--) {
            shiftDown(i);
        }
    }

//    // 普通插入建堆, 时间复杂度为O(lgN)
//    public MaxHeap(Item arr[]) {
//        int n = arr.length;
//        mData = (Item[]) new Comparable[n + 1];
//        mCapacity = n;
//        for (int i = 0; i < n; i++) {
//            insert(arr[i]);
//        }
//        mCount = n;
//    }

    // 从最大堆中取出堆顶元素, 即堆中所存储的最大数据
    public Item extractMax() {
        assert mCount > 0;
        Item ret = mData[1];

        swap(1, mCount);
        mCount--;
        shiftDown(1);

        return ret;
    }

    // 获取最大堆中的堆顶元素
    public Item getMax() {
        assert (mCount > 0);
        return mData[1];
    }


    // 返回堆中的元素个数
    public int size() {
        return mCount;
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty() {
        return mCount == 0;
    }


    // 像最大堆中插入一个新的元素 item
    public void insert(Item item) {
        assert mCount + 1 <= mCapacity;
        mData[mCount + 1] = item;
        mCount++;
        shiftUp(mCount);
    }

    // 上浮
    private void shiftUp(int k) {
        while (k > 1 && mData[k / 2].compareTo(mData[k]) > 0) {
            swap(k, k / 2);
            k /= 2;
        }
    }

    private void shiftDown(int k) {
        while (2 * k <= mCount) {
            int j = 2 * k; // 在此轮循环中,mData[k]和data[j]交换位置
            if (j + 1 <= mCount && mData[j + 1].compareTo(mData[j]) < 0) {
                j++;
            }
            // mData[j] 是 mData[2*k]和data[2*k+1]中的最大值
            if (mData[k].compareTo(mData[j]) <= 0) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    // 交换堆中索引为i和j的两个元素
    private void swap(int i, int j) {
        Item t = mData[i];
        mData[i] = mData[j];
        mData[j] = t;
    }
}
