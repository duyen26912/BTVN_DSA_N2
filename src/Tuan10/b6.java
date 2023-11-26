package Tuan10;

public class b6 {
    /* Class node is defined as :
class Node
    int val;	//Value
    int ht;		//Height
    Node left;	//Left child
    Node right;	//Right child

*/
    static int get_height(Node x){
        if(x==null) return -1;
        else return x.ht;

    }
    static void update_height(Node x){
        if(x == null)return;
        x.ht = Math.max(get_height(x.left), get_height(x.right)) + 1;

    }
    static Node rotate_with_left(Node root){
        Node temp = root.left;
        root.left = temp.right;
        temp.right = root;
        update_height(root);
        update_height(temp);
        return  temp;
    }
    static Node rotate_with_right(Node root) {
        Node temp = root.right;
        root.right = temp.left;
        temp.left = root;
        update_height(root);
        update_height(temp);
        return temp;
    }

    static Node insert(Node root,int val)
    {
        if(root==null){
            root = newNode(val);
            root.ht = 0;
            root.left = root.right=null;
        }else{
            if(val<root.val){
                root.left = insert(root.left,val);
                if(get_height(root.left)-get_height(root.right)==2){
                    if(val >root.left.val){
                        root.left =rotate_with_right(root.left);
                    }
                    root= rotate_with_left(root);
                }
            }else{
                root.right = insert(root.right,val);
                if(get_height(root.right)-get_height(root.left)==2){
                    if(val<root.right.val){
                        root.left = rotate_with_left(root.right);
                    }
                    root = rotate_with_right(root);
                }

            }
            if((root.left == null)&&(root.right !=null))
                root.ht = root.right.ht+1;
            else if ((root.right == null) && (root.left != null))
                root.ht = root.left.ht + 1;
            else
                update_height(root);
        }
        return root;

    }


}
