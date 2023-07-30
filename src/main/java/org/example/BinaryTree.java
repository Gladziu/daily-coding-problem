// #3 Problem
package org.example;

import java.util.*;

class Tree{
    int val;
    Tree left;
    Tree right;

    //Tree class constructor
    Tree(int val){
        this.val=val;
        left=null;
        right=null;
    }
}

public class BinaryTree{

    /* Given the root to a binary tree, implement serialize(root), which serializes the tree into a string,
    and deserialize(s), which deserializes the string back into the tree. */
    public void PreorderSerialize(Tree root, ArrayList<Integer> series){
        if(root == null){ //base case
            series.add(Integer.MIN_VALUE);
            return;
        }

        //push the current value
        series.add(root.val);
        //traverse to the left child
        PreorderSerialize(root.left, series);
        //traverse to the right child
        PreorderSerialize(root.right, series);
    }

    public static void main(String[] args) {
        //create a new binary tree
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.right.left = new Tree(5);
        root.left.left.left = new Tree(7);

        BinaryTree m = new BinaryTree();
        ArrayList<Integer> Preorderseries = new ArrayList<>();

        m.PreorderSerialize(root, Preorderseries);

        System.out.println("Preorderseries follows as");
        for (Integer preordersery : Preorderseries) {
            System.out.print(preordersery + " ");
        }

    }
}

