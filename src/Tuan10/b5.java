package Tuan10;

public class b5 {

    public static int[] a = new int [10000005];
    public static int sz =0;
    void inorder(Node root){
        if(root ==null) return;
        inorder (root.left);
        a[sz++] = root.data;
        inorder(root.right);
    }
    boolean checkBST(Node root) {
        inorder(root);
        for(int i=1;i<sz;++i){
            if(a[i] <= a[i-1]) return false;
        }
        return true;

    }
}
