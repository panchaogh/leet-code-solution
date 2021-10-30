package com.leetcode;


public class Test1 {

    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
        System.out.println(circularQueue.enQueue(1)); // 返回 true
        System.out.println(circularQueue.enQueue(2)); // 返回 true
        System.out.println(circularQueue.enQueue(3)); // 返回 true
        System.out.println(circularQueue.enQueue(4)); // 返回 false，队列已满
        System.out.println(circularQueue.Rear()); // 返回 3
        System.out.println(circularQueue.isFull()); // 返回 true
        System.out.println(circularQueue.deQueue()); // 返回 true
        System.out.println(circularQueue.enQueue(4)); // 返回 true
        System.out.println(circularQueue.Rear()); // 返回 4
    }

    public static class MyCircularQueue {

        int[] data;
        int head;
        int tail;

        public MyCircularQueue(int k) {
            data = new int[k];
            head = -1;
            tail = -1;
        }

        public boolean enQueue(int value) {
            if (isFull()) return false;
            if (isEmpty()) head = 0;
            tail = (tail + 1) % data.length;
            data[tail] = value;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) return false;
            if (head == tail) {
                head = -1;
                tail = -1;
                return true;
            }
            head = (head + 1) % data.length;
            return true;
        }

        public int Front() {
            if (isEmpty()) return -1;
            return data[head];
        }

        public int Rear() {
            if (isEmpty()) return -1;
            return data[tail];
        }

        public boolean isEmpty() {
            return head == -1;
        }

        public boolean isFull() {
            return (tail + 1) % data.length == head;
        }
    }
}
