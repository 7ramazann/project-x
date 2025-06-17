class BrowserHistory {
    public class Node {
        String url;
        Node next, prev;

        public Node(String url) {
            this.url = url;
            this.next = null;
            this.prev = null;
        }
    }

    private Node current;

    public BrowserHistory(String homepage) {
        current = new Node(homepage);
    }
    
    public void visit(String url) {
        Node newUrl = new Node(url);
        current.next = newUrl;
        newUrl.prev = current;
        current = newUrl;
    }
    
    public String back(int steps) {
        while(current.prev != null && steps > 0) {
            current = current.prev;
            steps--;
        }
        return current.url;
    }
    
    public String forward(int steps) {
        while(current.next != null && steps > 0) {
            current = current.next;
            steps--;
        }
        return current.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
