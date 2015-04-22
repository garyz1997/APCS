import java.io.*;
import java.util.*;

public class BSTree <T extends Comparable> {

    public BSTreeNode<T> root;

    public BSTree() {
	root = null;
    }

    public boolean isEmpty() {
	return root == null;
    }
    public boolean isLeaf( BSTreeNode<T> t ) {
	return (t.getLeft() == null && t.getRight() == null);
    }

    /*======== public void add() ==========
      Inputs:   T c  
      Returns: 

      Wrapper for the recursive add method
      ====================*/
    public void add( T c ) {
	root = add( root, new BSTreeNode<T>(c) );
    }

    /*======== public BSTreeNode<T> add() ==========
      Inputs:  BSTreeNode<T> curr
               BSTreeNode<T> t 
      Returns: 

      Add t to the correct place in the tree rooted at curr.
      ====================*/
    public BSTreeNode<T> add(BSTreeNode<T> curr, BSTreeNode<T> t) {
	return null;
    }

    /*======== public void remove() ==========
      Inputs:   T c  
      Returns: 
      
      Wrapper for the recursive remove method
      ====================*/
    public void remove( T c ) {
	root = remove( root, c );
    }

    /*======== public BSTreeNode<T> remove() ==========
      Inputs:   BSTreeNode<T> curr
		T c
      Returns: 

      Should remove the value c from the tree rooted at
      curr, if it exists.
      ====================*/
    public BSTreeNode<T> remove( BSTreeNode<T> curr, T c ) {
	return null;
    }


    /*======== public void inOrder()) ==========
      Inputs:   
      Returns: 

      Wrapper for the recursive inOrder method
      ====================*/
    public void inOrder() {
	inOrderHelper( root );
	System.out.println();
    }

    /*======== public void inOrderHelper() ==========
      Inputs:   BSTreeNode<T> t  
      Returns: 
      
      Performs an in-order traversal for the tree with 
      root t.
      ====================*/
    public void inOrderHelper( BSTreeNode<T> t ) {
	if (t == null) 
	    return;
	inOrderHelper( t.getLeft() );
	System.out.print( t.getData() + " ");
	inOrderHelper( t.getRight() );
    }

    /*======== public void traverse() ==========
      Inputs: 
      Returns: 
      
      Performs a traversal of the tree formatted for use
      with the "dot" program to create an image of the tree.

      To create the image:
      1. modify main so that it only prints out the result
      of this method.
      2. in the shell, do the following:
           $ java BSTree > tree.dot
	     this will put the output of the program into a 
	     file called tree.dot
	   $ dot -Tpng tree.dot -o tree.png
	     this will create the image file tree.png
	   $ display tree.png
      ====================*/
    public void traverse() {
	System.out.println("digraph T {");
	traverse(root);
	System.out.println("}");
    }
    public void traverse( BSTreeNode<T> t ) {

	if ( t == null )
	    return;
	if ( t.getLeft() != null ) {
	    System.out.println("edge [color=red]");
	    System.out.println( t.getData() + " -> " + t.getLeft().getData() + ";" );
	}
	if ( t.getRight() != null ) {
	    System.out.println("edge [color=blue]");
	    System.out.println( t.getData() + " -> " + t.getRight().getData() + ";" );
	}

	traverse( t.getLeft() );
	traverse( t.getRight() );
    }

    
    public static void main( String[] args ) {

    }

}
