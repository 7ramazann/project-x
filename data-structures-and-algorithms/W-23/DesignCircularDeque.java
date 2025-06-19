class MyCircularDeque {
    Deque<Integer> deque;
    int capacity;
    public MyCircularDeque(int k) {
        deque = new ArrayDeque<>();
        capacity = k;
    }
    
    public boolean insertFront(int value) {
        if (deque.size() == capacity) return false;
        deque.addFirst(value);
        return true;
    }
    
    public boolean insertLast(int value) {
        if (deque.size() == capacity) return false;
        deque.addLast(value);
        return true;
    }
    
    public boolean deleteFront() {
        if (deque.isEmpty()) return false;
        deque.removeFirst();
        return true;
    }
    
    public boolean deleteLast() {
        if (deque.isEmpty()) return false;
        deque.removeLast();
        return true;
    }
    
    public int getFront() {
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }
    
    public int getRear() {
        return deque.isEmpty() ? -1 : deque.peekLast();
    }
    
    public boolean isEmpty() {
        return deque.isEmpty();
    }
    
    public boolean isFull() {
        return deque.size() == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
