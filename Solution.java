import java.util.*;

public class Solution<Key extends Comparable<Key>, Value>  {
    private Node root;
    int size = 0;             // root of BST

    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees

        public Node(Key key, Value val) {
            this.key = key; //Initialized 
            this.val = val;
        }
    }
    public boolean isEmpty() {
        if(size == 0){ //check whether the list is empty or not.
            return true;
        }
        return false;
    }
    public int size() {
      return size; //it will return size;
    }
    public boolean contains(Key key) {
        Node curNode = root; //root is assigned to curNode.
       if(key == null){
            throw new IllegalArgumentException("There is not key conatin in the root");
       }
       else{
            while(curNode.key != key){
                int cmp = key.compareTo(curNode.key);
                if(cmp < 0){ //if the key is less than root it will move to left of the root.
                    curNode = curNode.left;
                }
                else{ //vice versa
                    curNode = curNode.right;
                }
            }
            return true; //return true if it contains the desired value;
       }
    }
    public Value get(Key key) {
        if(key == null){
            throw new IllegalArgumentException("argument to get value() is null");
        }
        Node curNode = root; // root is assigned to curNode;
        while(curNode.key != key){
            int cmp = key.compareTo(curNode.key);//compare whether the key is lass than or greater than root/curNode.
            if(cmp < 0){ 
                curNode = curNode.left; //if the key is less than root it will move to left of the root.
            }
            else if(cmp > 0){
                curNode = curNode.right;//vice versa.
            }
        }
        if(curNode.key == key){ 
            System.out.println(curNode.val); 
        }
        return curNode.val;// if key is equal to root it will return the value.
    }
    public void put(Key key, Value val) {
        Node newNode = new Node(key,val); //new node called newNode is created.
        if(root == null){
            root = newNode;//if the list is empty, newNode will be root.
        }
        else{
            Node curNode = root;//root is assign to curNode.
            Node parent; //curNode is parent node.
            while(true){
                parent = curNode;
                int cmp = key.compareTo(curNode.key);//compare whether the key is less than or greater than cuNode.
                if(cmp < 0){
                    curNode = curNode.left;//if key is less than root move to left of curNode.
                    if(curNode == null){
                        //it traverse from root and entered in left of root, if curNoed is null then parent node is newNode.
                        parent.left = newNode;
                        size = size + 1;//size will increase by 1.
                        return;
                    }
                    //if key is equal to curNode it will replace it.
                    else if(curNode.key == key){
                        curNode.val = val;
                        return;
                    }
                }
                else if(cmp > 0){
                    curNode = curNode.right;//if key is greater than root move to right of curNode.
                    if(curNode == null){
                        //it traverse from root and entered in left of root, if curNoed is null then parent node is newNode.
                        parent.right = newNode;
                        size = size + 1;//size will increase by 1.
                        return;
                    }
                    //if key is equal to curNode it will replace it.
                    else if(curNode.key == key){
                        curNode.val = val;
                        return;
                    }
                }
            }
        }
        size = size + 1;
    }
    public Key min() {
       if(isEmpty()){
        throw new NoSuchElementException("There is no element in the tree");
       }
       else{
            Node curNode = root;
            while(curNode.left != null){
                curNode = curNode.left;//while the left curNode is not null, curNode is pointed to left side.
            }
            return curNode.key;// it will return the key of the node.
       }
    } 
    public Key floor(Key key) {
        if(isEmpty()){
            throw new NoSuchElementException("calls floor() with empty symbol table");
        }
        Node curNode = root;
        Node parent = null;//declare parents as null
        while(curNode != null){
            parent = curNode;//curNode is assign to parent
            int cmp = key.compareTo(parent.key);
            if(key == null){
                throw new IllegalArgumentException("argument to get value() is null");
            }
            if(cmp == 0){
                return parent.key;
            }
            if(cmp < 0){
                curNode = parent.left;
            }
            else if(cmp > 0){// check whether of given key in right.
                curNode = parent.right;//this condition returns previous parent as floor of given key as it is 
                int vmp = key.compareTo(curNode.key);
                if(vmp < 0){
                    return parent.key;
                }
                else{//This is for if the key is still greater then it is right parent.
                    curNode = parent.right;
                }
            }
        }
        return parent.key;
    } 
    public static void main(String[] args) { 
        Solution <String,Integer> bst = new Solution <String,Integer>();
        bst.put("ABDUL",1);
        bst.get("ABDUL");
        bst.put("HRITHIK",2);
        bst.put("SAI",3);
        bst.put("SAMAL",6);
        bst.get("SAI");  
        bst.put("TASHI",4);
        System.out.println(bst.size());
        System.out.println(bst.min());
        System.out.println(bst.floor("HRITHIK"));
        System.out.println(bst.floor("HAHA"));
        bst.put("CHIMI",5);
        bst.put("SAMAL",4);
        bst.get("SAMAL");
        bst.put("NIMA",7);
        System.out.println(bst.size());
        bst.get("CHIMI");
        System.out.println(bst.floor("CHIMI"));
        bst.put("SONAM",8);
        System.out.println("ABDUL CHIMI HRITHIK NIMA SAI SAMAL SONAM TASHI");
    }
}