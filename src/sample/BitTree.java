package sample;

import org.junit.Test;

import java.util.LinkedList;

public class BitTree {

    class TreeNode{
        private int data;
        private TreeNode right,left;
        public TreeNode(int data) {
            this.data = data;
        }
    }


    public TreeNode CreateTreeNode(int a[],int i){
        if(i>=a.length){
            return null;
        }
        TreeNode treeNode = new TreeNode(a[i]);
        treeNode.left = CreateTreeNode(a,i*2);
        treeNode.right = CreateTreeNode(a,i*2+1);
        return treeNode;
    }

    @Test
    public void Test(){
       /*  int a[] = {0,1,2,3,4,5};
         TreeNode node =CreateTreeNode(a,1);
         LNR(node);*/
        //LRN(node);
        //NLR(node);
        //ClassSearch(node);
       /* int b = SearchBitSort(node,5);
        System.out.println(b);*/
       int b[] = {0,5,8,9,3,6};
       TreeNode ba= CreateSearchBitSort(b,1);
       LNR(ba);
    }

    public void LNR(TreeNode node){
        if(node==null){
            return;
        }
        LNR(node.left);
        System.out.println(node.data);
        LNR(node.right);
    }

    public void LRN(TreeNode node){
        if(node == null){
            return;
        }
        LNR(node.left);
        LNR(node.right);
        System.out.println(node.data);
    }

    public void NLR(TreeNode node){
        if(node==null){
            return;
        }
        System.out.println(node.data);
        NLR(node.left);
        NLR(node.right);
    }

    public void ClassSearch(TreeNode node){
        if (node==null){
            return;
        }
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.offer(node);
        while (!list.isEmpty()){
            TreeNode root = list.poll();
            System.out.println(root.data);
            if(root.left!=null){
                list.offer(root.left);
            }
            if(root.right!=null){
                list.offer(root.right);
            }
        }
    }



    public int SearchBitSort(TreeNode treeNode,int v){
        if(treeNode==null){
            return 0;
        }
        if(treeNode.data==v){
            return treeNode.data;
        }else if (treeNode.data>v){
            return SearchBitSort(treeNode.right,v);
        }else {
            return SearchBitSort(treeNode.left,v);
        }
    }












    public TreeNode CreateSearchBitSort(int a[],int i){
        if(i>a.length){
            return null;
        }
        TreeNode treeNode =  new TreeNode(a[i]);
        if(a[i+1]>=treeNode.data){
            treeNode.right = CreateSearchBitSort(a,i+1);
        }else {
            treeNode.left = CreateTreeNode(a,i+1);
        }
        return treeNode;
    }

}
