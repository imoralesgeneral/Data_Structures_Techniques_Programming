package com.structures.Tree;

import com.structures.Iterator.BTreeIterator;
import com.structures.Iterator.IteratorInterface;

public class BTreeDynamic<T> implements BTreeInterface<T>
{
    private T root;
    private BTreeInterface<T> left;
    private BTreeInterface<T> right;

    /**
     * Constructor for objects of class BTreeDynamic
     */
    public BTreeDynamic()
    {
        this.root = null;
        this.left = null;
        this.right = null;
    }
    
    /**
	* Constructor for StackDynamic.
	* @param elem
	*/
    public BTreeDynamic(T element)
    {
        this();
        this.setRoot(element);
    }
    
    /**
	* Constructor for StackDynamic.
	* @param tree
	*/
    public BTreeDynamic(BTreeInterface<T> tree)
    {
        this();
        T tRoot = tree.getRoot();
        BTreeInterface<T> tLeft = tree.getLeftChild();
        BTreeInterface<T> tRight = tree.getRightChild();
        this.setRoot(tRoot);
        //this.setLeftChild(new BTreeDynamic<T>(tLeft));
        this.left = tLeft;
        //this.setRightChild(new BTreeDynamic<T>(tRight));
        this.right = tRight;
    }

   @Override 
   public T getRoot()
   {
       return this.root;
    }
    @Override  
    public BTreeInterface<T> getLeftChild()
    {
        return this.left;
    }
    
    @Override 
    public BTreeInterface<T> getRightChild()
    {
        return this.right;
    }
    
    @Override 
    public void setRoot(T elem)
    { 
        if(elem != null) {
            this.root = elem;
        }
    }
    
    @Override 
    public void setLeftChild(BTreeInterface<T> tree)
    { 
        this.left = tree;
    }
    
    @Override 
    public void setRightChild(BTreeInterface<T> tree)
    { 
        this.right = tree;
    }
    
    @Override 
    public void removeLeftChild()
    {
        this.left = null;
    }
    
    @Override 
    public void removeRightChild()
    {
        this.right = null;
    }
    
    @Override 
    public boolean isLeaf()
    {
        return this.root != null && this.left == null && this.right == null;
    }
    
    @Override 
    public boolean isEmpty()
    {
        return this.root == null;
    }
    
    @Override 
    public boolean contains(T elem)
    {
    	boolean sol = false;
    	BTreeIterator<T> it = (BTreeIterator<T>) this.getIterator(0);
		while(it.hasNext() && !sol) {
			if(it.getNext().equals(elem)) sol = true;
		}
    	return sol;
        //return this.root.equals(elem) || this.left.contains(elem) || this.right.contains(elem);
    }
    
    @Override 
    public IteratorInterface<T> getIterator(int traversalType)
    {
        BTreeInterface<T> handler = new BTreeDynamic<T>(this);
        return new BTreeIterator<T>(handler, traversalType);
    }
    
}