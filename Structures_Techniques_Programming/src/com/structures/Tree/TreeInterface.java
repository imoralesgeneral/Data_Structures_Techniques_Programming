package com.structures.Tree;

import com.structures.Iterator.IteratorInterface;
import com.structures.List.ListInterface;

public interface TreeInterface<T>
{
	
    public int PREORDER = 0;
    public int POSTORDER = 1;
    public int LRBREADTH = 2;
    public int RLBREADTH = 3;
    
    /**
	* Return the root.
	* @return the root.
	*/
    public T getRoot();
    
    /**
	* Set the root.
	* @param elem.
	*/
    public void setRoot(T elem);
    
    /**
	* Return the children.
	* @return the children.
	*/
    public ListInterface<TreeInterface<T>> getChildren();
    
    /**
	* Add a child.
	* @param Add another tree as a child.
	*/
    public void addChildren(TreeInterface<T> child);
    
    /**
	* Remove a child.
	* @param index of that child.
	*/
    public void removeChild(int index);
    
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
    public IteratorInterface<T> getIterator(int transversalType);

}
