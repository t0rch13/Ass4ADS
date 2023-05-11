public class BST<K extends Comparable<K>, V> {
    private Node root;
    private int size;
    private class Node{
        private K key;
        private V val;
        private Node left, right;
        public Node(K key, V val){
            this.key = key;
            this.val = val;
        }
    }

    public BST(){
        root = null;
        size = 0;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void put(K key, V val) {
        if(isEmpty()) {
            root = new Node(key, val);
            size++;
            return;
        }

        Node iter = root;
        Node iterRoot = null;

        while(iter != null){ //iterate through BST and find parent for new node
            if(key.compareTo(iter.key) < 0){
                iterRoot = iter;
                iter = iter.left;
            }
            else if(key.compareTo(iter.key) > 0){
                iterRoot = iter;
                iter = iter.right;
            }
            else{ //if the key is already exists in the nodes
                iter.val = val; //new value for node
                size++;
                return;
            }
        }

        if(key.compareTo(iterRoot.key) < 0){ // comparing key to parent key and creating relation to parent node
            iterRoot.left = new Node(key, val);
        }
        else {
            iterRoot.right = new Node(key, val);
        }

    }

    public V get(K key) {
        Node iter = root;

    }

    public void delete(K key) {

    }

    public Iterable<K> iterator() {

    }


}
