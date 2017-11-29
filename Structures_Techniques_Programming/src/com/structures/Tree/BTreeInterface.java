package com.structures.Tree;

import com.structures.Iterator.IteratorInterface;

public interface BTreeInterface<T>
{
	
    public int PREORDER = 0;
    public int INORDER = 1;
    public int POSTORDER = 2;
    public int LRBREADTH = 3;
    public int RLBREADTH = 4;
    
    /**
	* Return the root.
	* @return the root.
	*/
    public T getRoot();
    
    /**
	* Return the child placed on the left side.
	* @return the child placed on the left side.
	*/
    public BTreeInterface<T> getLeftChild();
    
    /**
	* Return the child placed on the right side.
	* @return the child placed on the right side.
	*/
    public BTreeInterface<T> getRightChild();
    
    /**
	* Set the root.
	* @param elem.
	*/
    public void setRoot(T elem);
    
    /**
	* Add a child on the left side.
	* @param Add another tree as a child.
	*/
    public void setLeftChild(BTreeInterface<T> tree);
    
    /**
	* Add a child on the right side.
	* @param Add another tree as a child.
	*/
    public void setRightChild(BTreeInterface<T> tree);
    
    /**
	* Remove a child on the left side.
	*/
    public void removeLeftChild();
    
    /**
	* Remove a child on the right side.
	*/
    public void removeRightChild();
    
    /**
	* Check if it is a leaf.
	* @return true or false.
	*/
    public boolean isLeaf();
    
    /**
	* Check if the tree is empty.
	* @return true if the tree is empty.
	*/
    public boolean isEmpty();
    
    /**
	* Check if the tree contains the element.
	* @param element.
	* @return true if the tree contains it.
	*/
    public boolean contains(T elem);
    
    /**
	* Return an iterator.
	* @return An iterator for the tree.
	*/
    public IteratorInterface<T> getIterator(int traversalType);
    
}