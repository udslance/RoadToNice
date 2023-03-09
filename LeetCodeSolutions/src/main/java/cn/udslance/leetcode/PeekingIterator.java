package cn.udslance.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @title: 顶端迭代器
 * @description: 请你在设计一个迭代器，在集成现有迭代器拥有的 hasNext 和 next 操作的基础上，还额外支持 peek 操作。
 * @difficulty: Medium
 * @Link: <a href="https://leetcode.cn/problems/peeking-iterator/">link</a>
 * @author: Udslance
 * @create: 2023-02-19 16:40
 **/
class PeekingIterator implements Iterator<Integer> {
    private int index = 0;

    private List<Integer> nums;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        nums = new ArrayList<>();
        while (iterator.hasNext()) {
            nums.add(iterator.next());
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return nums.get(index);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        return nums.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index != nums.size();
    }
}
