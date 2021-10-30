package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private Map<Integer, Node> cache;
    private int size;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {//新增
            if (size == capacity) {//需要进行缓存淘汰
                Node del = deleteTail();
                cache.remove(del.key);
                size--;
            }
            node = new Node(key, value);
            cache.put(key, node);
            addToHead(node);
            size++;
        } else {//修改
            node.value = value;
            moveToHead(node);
        }
    }

    public int get(int k) {
        Node node = cache.get(k);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    private Node deleteTail() {
        Node del = tail.pre;
        deleteNode(del);
        return del;
    }

    private void deleteNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addToHead(Node node) {
        node.pre = head;
        node.next = head.next;
        head.next = node;
        node.next.pre = node;
    }

    private void moveToHead(Node node) {
        deleteNode(node);
        addToHead(node);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));        // 返回  3
        System.out.println(cache.get(4));        // 返回  4
    }


    public static class Node {
        public int key;
        public int value;
        public Node pre;
        public Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
