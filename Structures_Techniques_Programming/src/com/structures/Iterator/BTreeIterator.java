package com.structures.Iterator;

import com.structures.Tree.BTreeInterface;

public class BTreeIterator<T> implements IteratorInterface<T>{
	
	// instance variables
    private IteratorInterface<T> iterator;

    /**
     * Constructor for objects of class BTreeIterator
     */
    public BTreeIterator(BTreeInterface<T> handler, int type)
    {
        // initialise instance variables
        QueueInterface<T> traverse = null;
        switch(type) {
            case BTreeInterface.PREORDER : 
            traverse = preorder(handler);
            break;
            case BTreeInterface.INORDER : 
            traverse = inorder(handler);
            break;
            case BTreeInterface.POSTORDER : 
            traverse = postorder(handler);
            break;
            case BTreeInterface.LRBREADTH : 
            traverse = lrBreadth(handler);
            break;
            case BTreeInterface.RLBREADTH : 
            traverse = rlBreadth(handler);
            break;
        }
        this.iterator = new QueueIterator<T>(traverse);
    }

    /**
	* Return next iteration element.
	* @return Next iteration element.
	*/
    public T getNext()
    {
        return iterator.getNext();
    }

    /**
	* Check if there are more elements.
	* @return true or false.
	*/
    public boolean hasNext()
    {
        return iterator.hasNext();
    }

    /**
	* Reset the iterator.
	*/
    public void reset()
    {
        iterator.reset();
    }

    /**
	* It iterates in preorder way.
	* @param tree.
	*/
    private QueueInterface<T> preorder(BTreeInterface<T> tree)
    {
    	QueueInterface<T> traverse = new QueueDynamic<T>();
        if(tree == null) {
            return traverse;
        }
        T element = tree.getRoot();
        BTreeInterface<T> lTree = tree.getLeftChild();
        BTreeInterface<T> rTree = tree.getRightChild();
        QueueInterface<T> lTraverse = preorder(lTree);
        QueueInterface<T> rTraverse = preorder(rTree);
        traverse.add(element);
        addAll(traverse, lTraverse);
        addAll(traverse, rTraverse);
        return traverse;
    }
    
    /**
   	* It iterates in inorder way.
   	* @param tree.
   	*/
    private QueueInterface<T> inorder(BTreeInterface<T> tree)
    {
    	QueueInterface<T> traverse = new QueueDynamic<T>();
        if(tree == null) {
            return traverse;
        }
        T element = tree.getRoot();
        BTreeInterface<T> lTree = tree.getLeftChild();
        BTreeInterface<T> rTree = tree.getRightChild();
        QueueInterface<T> lTraverse = inorder(lTree);
        QueueInterface<T> rTraverse = inorder(rTree);
        addAll(traverse, lTraverse);
        traverse.add(element);
        addAll(traverse, rTraverse);
        return traverse;
    }

    /**
   	* It iterates in postorder way.
   	* @param tree.
   	*/
    private QueueInterface<T> postorder(BTreeInterface<T> tree)
    {
    	QueueInterface<T> traverse = new QueueDynamic<T>();
        if(tree == null) {
            return traverse;
        }
        T element = tree.getRoot();
        BTreeInterface<T> lTree = tree.getLeftChild();
        BTreeInterface<T> rTree = tree.getRightChild();
        QueueInterface<T> lTraverse = preorder(lTree);
        QueueInterface<T> rTraverse = preorder(rTree);
        addAll(traverse, lTraverse);
        addAll(traverse, rTraverse);
        traverse.add(element);
        return traverse;
    }

    private QueueInterface<T> lrBreadth(BTreeInterface<T> tree)
    {
    	QueueInterface<T> traverse = new QueueDynamic<T>();
    	QueueInterface<BTreeInterface<T>> aux = new QueueDynamic<BTreeInterface<T>>();

        aux.add(tree);
        while(!aux.isEmpty()) {
            BTreeInterface<T> aTree = aux.getFirst();
            T elem = tree.getRoot();
            BTreeInterface<T> lTree = aTree.getLeftChild();
            BTreeInterface<T> rTree = aTree.getRightChild();
            if(lTree != null) aux.add(lTree);
            if(rTree != null) aux.add(rTree);
            traverse.add(elem);
            aux.remove();
        }
        return traverse;
    }

    private QueueInterface<T> rlBreadth(BTreeInterface<T> tree)
    {
    	QueueInterface<T> traverse = lrBreadth(tree);
        StackInterface<T> aux = new StackDynamic<T>();
        while(!traverse.isEmpty()) {
            T elem = traverse.getFirst();
            aux.push(elem);
            traverse.remove();
        }
        while(!aux.isEmpty()) {
            T elem = aux.getTop();
            traverse.add(elem);
            aux.pop();
        }
        return traverse;
    }
    
    /**
   	* Add all elements of p in q.
   	* @param q; p.
   	*/
    private void addAll(QueueInterface<T> q, QueueInterface<T> p)
    {
        while(!p.isEmpty()) {
            T elem = p.getFirst();
            q.add(elem);
            p.remove();
        }
    }
}
