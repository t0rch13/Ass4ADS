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

        size++;

    }

    public V get(K key) {
        Node iter = root;
        while (iter != null){
            if(key.compareTo(iter.key) < 0){
                iter = iter.left;
            }
            else if(key.compareTo(iter.key) > 0){
                iter = iter.right;
            }
            else if(key.compareTo(iter.key) == 0){ //if the key is found
                return iter.val;
            }
        }
        return null; //if there is no such key in the tree
    }

    public void delete(K key) {
        if(isEmpty()) return;

        Node iter = root;
        Node iterRoot = null;

        while(key.compareTo(iter.key) == 0){ //find node to delete and its parent
            if(key.compareTo(iter.key) < 0){
                iterRoot = iter;
                iter = iter.left;
            }
            else if(key.compareTo(iter.key) > 0){
                iterRoot = iter;
                iter = iter.right;
            }
        }

        if(iter.left == null && iter.right == null){ //node to be deleted has no child
            if(iterRoot.left == iter) iterRoot.left = null; //if the node to be deleted is on the left
            else iterRoot.right = null;
        }

        if(iter.left != null && iter.right == null){ //node to be deleted has left child only
            if(iterRoot.left == iter) iterRoot.left = iter.left;
            if(iterRoot.right == iter) iterRoot.right = iter.left;
        }

        if(iter.left == null && iter.right != null){ //node to be deleted has left right only
            if(iterRoot.left == iter) iterRoot.left = iter.right;
            if(iterRoot.right == iter) iterRoot.right = iter.right;
        }

        if(iter.left != null && iter.right != null){ //node to be deleted has two child nodes
            while (iter.right != null){ //copying the key and value of right child to parent
                iter.key = iter.right.key;
                iter.val = iter.right.val;
                iter = iter.right;
            }
            if(iter.left != null){ //if the ending node has child
                iter = iter.left;
            }
            else iter = null;
        }
        size--;
    }

    public Iterable<K> iterator() {

    }


}
