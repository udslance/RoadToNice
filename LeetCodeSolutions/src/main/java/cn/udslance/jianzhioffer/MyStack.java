package cn.udslance.jianzhioffer;

import java.util.LinkedList;

/**
 * @author H
 * @create 2021-06-10 21:46
 */
class MyStack {
    LinkedList<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.addLast(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (empty()) {
            return -1;
        }
        return queue.removeLast();
    }

    /** Get the top element. */
    public int top() {
        return queue.getLast();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.size() == 0;
    }
}
