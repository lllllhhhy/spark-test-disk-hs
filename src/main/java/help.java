import scala.concurrent.Channel;

import java.util.ArrayList;
import java.util.LinkedList;

public class help {
    public static void main(String[] args) {
        node head=new node(20);
        head.left=new node(-9);
        head.right=new node(7);
        head.left.left=new node(13);
        head.right.left=new node(20);
        head.right.right=new node(12);
        node newHead=deleteSome(head,12,0);
        ArrayList<ArrayList<Integer>>res=printHelp(newHead);
        System.out.println(res);

    }

    public static node deleteSome(node head,int target,int sum){
        if(head==null)return null;
        int value=head.val;
        sum+=value;
        node lleft=deleteSome(head.left,target,sum);
        node rright=deleteSome(head.right,target,sum);
        head.left=lleft;
        head.right= rright;
        if(head.left==null&&head.right==null&&sum>target){
            return null;
        }
        return head;
    }
    public static ArrayList<ArrayList<Integer>> printHelp(node head){
        if(head==null)return new ArrayList<>();
        LinkedList<node>queue=new LinkedList<>();
        queue.add(head);
        ArrayList<ArrayList<Integer>> res= new ArrayList<>();
        while(!queue.isEmpty()){
            int size=queue.size();
            ArrayList<Integer> inner=new ArrayList<Integer>();
            for(int i=0;i<size;i++){
                node ele=queue.pollFirst();
                if(ele.left!=null)queue.addLast(ele.left);
                if(ele.right!=null)queue.addLast(ele.right);
                inner.add(ele.val);
            }
            res.add(new ArrayList<Integer>(inner));
        }
        return res;
    }

    static class node{
        node left;
        node right;
        int val;
        node(int val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }

    static class tree{

    }
}

