package com.structures.Tree;

import com.structures.Iterator.IteratorInterface;
import com.structures.Iterator.TreeIterator;
import com.structures.List.ListDynamic;
import com.structures.List.ListInterface;
import com.structures.Queue.QueueDynamic;
import com.structures.Queue.QueueInterface;
import com.structures.Stack.StackDynamic;
import com.structures.Stack.StackInterface;

public class TreeDynamic<T> implements TreeInterface<T>
{
    private T root;
    private QueueInterface<TreeInterface<T>> children;

    /**
     * Constructor for objects of class TreeDynamic
     */
    public TreeDynamic()
    {
        this.root = null;
        this.children = new QueueDynamic<TreeInterface<T>>();
    }

    /**
	* Constructor for StackDynamic.
	* @param elem
	*/
    public TreeDynamic (T elem)
    {
        this();
        this.root = elem;
    }

    /**
	* Constructor for StackDynamic.
	* @param tree
	*/
    public TreeDynamic (TreeInterface<T> tree)
    {
        this.root = tree.getRoot();
        this.children = new QueueDynamic<TreeInterface<T>>();

        ListInterface<TreeInterface<T>> tChildren = tree.getChildren();
        while(!tChildren.isEmpty()) {
            TreeInterface<T> aChild = tChildren.getFirst();
            TreeInterface<T> cChild = new TreeDynamic<T> (aChild);
            children.add(cChild);
            tChildren = tChildren.getTail();
        }
    }

    @Override 
    public T getRoot()
    {
        return this.root;
    }

    @Override 
    public ListInterface<TreeInterface<T>> getChildren()
    {
        ListInterface <TreeInterface<T>> lChildren = new ListDynamic<TreeInterface<T>>();
        StackInterface<TreeInterface<T>> sChildren = new StackDynamic<TreeInterface<T>>();
        IteratorInterface<TreeInterface<T>> childrenIt = children.getIterator();
        while(childrenIt.hasNext()) {
            TreeInterface<T> aChild = childrenIt.getNext();
            sChildren.push(aChild);
        }
        while(!sChildren.isEmpty()) {
            TreeInterface<T> aChild = sChildren.getTop();
            lChildren.insert(aChild);
            sChildren.pop();
        }
        return lChildren;
    }

    @Override 
    public void setRoot(T elem)
    {
        if(elem != null) {
            this.root = elem;
        }
    }

    @Override 
    public void addChildren(TreeInterface<T> child)
    {
        if(this.root != null) {
            children.add(child);
        }
    }

    @Override 
    public void removeChild(int index)
    {
        QueueInterface<TreeInterface<T>> aux = new QueueDynamic<TreeInterface<T>>();
        for(int i=0; i<children.getLength(); i++){
            TreeInterface<T> aChild = children.getFirst();
            if(i != index) {
                aux.add(aChild);
            }
            children.remove();
        }
        children = aux;        
    }
    
    @Override 
    public boolean isLeaf()
    {
        return children.isEmpty();
    }
    
    @Override 
    public boolean isEmpty()
    {
        return this.root == null && children.isEmpty();
    }
    
    @Override 
    public boolean contains(T elem)
    {
        if(this.root.equals(elem)){
            return true;
        } else {
            IteratorInterface <TreeInterface<T>> childrenIt = children.getIterator();
            boolean found = false;
            while(!found && childrenIt.hasNext()) {
                TreeInterface<T> aChild = childrenIt.getNext();
                found = aChild.contains(elem);
            }
            return found;
        }
    }
    
    @Override 
    public IteratorInterface<T> getIterator(int type)
    {
        TreeInterface<T> handler = new TreeDynamic<T>(this);
        return new TreeIterator<T>(handler, type);
    }

}