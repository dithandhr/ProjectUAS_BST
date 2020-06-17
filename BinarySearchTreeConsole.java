/*

    Created By : Ditha Nadhira Jasmine 
    NIM : 1910512030 
    Email : dithaandhr@gmail.com

*/

package binarysearchtreeconsole;

import java.util.Scanner;

public class BinarySearchTreeConsole {
        
    class Node { 
        int key; 
        Node left, right; 
  
        public Node(int item) { 
            key = item; 
            left = right = null; 
        } 
    } 
  
    Node root; 
  
    BinarySearchTreeConsole() {  
        root = null;  
    } 
  
    void insert(int key) { 
       root = insertRec(root, key); 
        System.out.println("Berhasil menambahkan bilangan pada Binary Search Tree.\n");
    } 
      
    Node insertRec(Node root, int key) { 
  
        if (root == null) { 
            root = new Node(key); 
            return root; 
        } 
  
        if (key < root.key) 
            root.left = insertRec(root.left, key); 
        else if (key > root.key) 
            root.right = insertRec(root.right, key); 
  
        return root; 
    } 
    
    void deleteKey(int key) 
    { 
        boolean checkDelete = iterativeSearch(root, key);
        if (checkDelete) {
            System.out.println("Bilangan " + key + " berhasil dihapus.");
        }else{
            System.out.println("Bilangan " + key + " tidak ditemukan.");
        }
        root = deleteRec(root, key);
    } 
  
    Node deleteRec(Node root, int key) 
    {  
        if (root == null)  return root; 
  
        if (key < root.key) 
            root.left = deleteRec(root.left, key); 
        else if (key > root.key) 
            root.right = deleteRec(root.right, key); 
        else
        { 
            if (root.left == null) 
                return root.right; 
            else if (root.right == null) 
                return root.left; 
  
            root.key = minValue(root.right); 
            
            root.right = deleteRec(root.right, root.key);
        } 
  
        return root; 
    } 
    
    boolean deleteRecCheckData(Node root, int key) 
    {  
        Node check;
        check = root;
        if (check == null)  return false; 
  
        if (key < check.key) 
            deleteRecCheckData(check.left, key); 
        else if (key > check.key) 
            deleteRecCheckData(check.right, key);
        else
        { 
            check.key = minValue(check.right); 
            check.right = deleteRec(check.right, check.key); 
            return true;
        } 
        
        return false; 
    }
  
    int minValue(Node root) 
    { 
        int minv = root.key; 
        while (root.left != null) 
        { 
            minv = root.left.key; 
            root = root.left; 
        } 
        return minv; 
    }
    
    int maxValue(Node root) 
    { 
        int minv = root.key; 
        while (root.right != null) 
        { 
            minv = root.right.key; 
            root = root.right; 
        } 
        return minv; 
    }
    
    int getMinimumValue(){
        return minValue(root);
    }
    
    int getMaximumValue(){
        if (root == null) 
            return Integer.MIN_VALUE; 
        
        int data = root.key;
        
        int maxLeft = minValue(root);
        int maxRight = maxValue(root);
        if (maxLeft > data) 
            data = maxLeft; 
        if (maxRight > data) 
            data = maxRight; 
        
        return maxValue(root);
    }
    
    void searchBilangan(int key){
        //root = search(root, key);
        boolean check = iterativeSearch(root, key);
        if (check) {
            System.out.println("Bilangan " + key + " ditemukan.");
        }else{
            System.out.println("Bilangan " + key + " tidak ditemukan.");
        }
    }
    
    static boolean iterativeSearch(Node root, int key) 
    {
        while (root != null) {
            if (key > root.key){
                System.out.println("Mengarah ke kanan melewati bilangan " + root.key);
                root = root.right;
            }else if (key < root.key){
                System.out.println("Mengarah ke kiri melewati bilangan " + root.key);
                root = root.left;
            }else{
                return true;
            }
        } 
        return false; 
    } 
    
    public Node search(Node root, int key) 
    { 
        if (root==null || root.key==key){
            return root;
        }

        if (root.key > key){
            System.out.println("Melewati bilangan " + root.key);
            return search(root.left, key);
        }
        
        return search(root.right, key);
    }
    
    void printPostorder(Node node) 
    { 
        if (node == null) 
            return; 
  
        printPostorder(node.left); 
  
        printPostorder(node.right); 
  
        System.out.print(node.key + " "); 
    } 
  
    void printInorder(Node node) 
    { 
        if (node == null) 
            return; 
  
        printInorder(node.left); 
  
        System.out.print(node.key + " "); 
  
        printInorder(node.right); 
    } 
  
    void printPreorder(Node node) 
    { 
        if (node == null) 
            return; 
  
        System.out.print(node.key + " "); 
  
        printPreorder(node.left); 
  
        printPreorder(node.right); 
    }
  
    void printPostorder()  {     if(root != null){ printPostorder(root); }else{ System.out.println("Data Kosong."); } } 
    void printInorder()    {     if(root != null){ printInorder(root); }else{ System.out.println("Data Kosong."); } } 
    void printPreorder()   {     if(root != null){ printPreorder(root); }else{ System.out.println("Data Kosong."); } } 
    
    void resetBST(){
        root = null;
    }
  
    public static void main(String[] args) { 
        BinarySearchTreeConsole tree = new BinarySearchTreeConsole(); 
        
        Scanner keyboard = new Scanner(System.in);
        
        int loop = 1; 
        while(loop == 1){
            System.out.println("============ Binary Search Tree Program ============");
            System.out.println("1. Insert Bilangan");
            System.out.println("2. Show Data menggunakan PreOrder");
            System.out.println("3. Show Data menggunakan PostOrder");
            System.out.println("4. Show Data menggunakan InOrder");
            System.out.println("5. Search Bilangan");
            System.out.println("6. Delete Bilangan");
            System.out.println("7. Show Bilangan Terbesar dan Terkecil");
            System.out.println("8. Reset Data Binary Search Tree");
            System.out.println("9. EXIT");
            System.out.println("");
            System.out.print("Choice : ");
            String inputan_pilihan = keyboard.nextLine();
            System.out.println("");
            if (inputan_pilihan.equals("1")) {
                System.out.print("Masukkan Bilangan : ");
                String bilangan = keyboard.nextLine();
                tree.insert(Integer.parseInt(bilangan));
            }else if (inputan_pilihan.equals("2")) {
                System.out.println("Data PreOrder");
                tree.printPreorder();
            }else if (inputan_pilihan.equals("3")) {
                System.out.println("Data PostOrder");
                tree.printPostorder();
            }else if (inputan_pilihan.equals("4")) {
                System.out.println("Data InOrder");
                tree.printInorder();
            }else if (inputan_pilihan.equals("5")) {
                System.out.print("Masukkan Bilangan yang ingin dicari : ");
                String bilangan = keyboard.nextLine();
                tree.searchBilangan(Integer.parseInt(bilangan));
            }else if (inputan_pilihan.equals("6")) {
                System.out.print("Masukkan Bilangan yang ingin dihapus : ");
                String bilangan = keyboard.nextLine();
                tree.deleteKey(Integer.parseInt(bilangan));
            }else if (inputan_pilihan.equals("7")) {
                System.out.println("Bilangan terkecil : " + tree.getMinimumValue());
                System.out.println("Bilangan terbesar : " + tree.getMaximumValue());
            }else if (inputan_pilihan.equals("8")) {
                tree.resetBST();
            }else if (inputan_pilihan.equals("9")) {
                System.exit(0);
            }
            System.out.println("");
        }
    }
}
