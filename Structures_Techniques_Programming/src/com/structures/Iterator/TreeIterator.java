package com.structures.Iterator;

import com.structures.Queue.QueueDynamic;
import com.structures.Queue.QueueInterface;
import com.structures.Stack.StackDynamic;
import com.structures.Stack.StackInterface;
import com.structures.Tree.TreeInterface;

public class TreeIterator<T> implements IteratorInterface<T> {

	private IteratorInterface<T> iterator;

    /**
     * Constructor for objects of class TreeIterator
     */
    public TreeIterator(TreeInterface<T> handler, int type)
    {
        QueueInterface<T> traverse = null;
        switch(type) {
            case TreeInterface.PREORDER:
            traverse = preorder (handler);
            break;
            case TreeInterface.POSTORDER:
            traverse = postorder (handler);
            break;
            case TreeInterface.LRBREADTH:
            traverse = lrBreadth (handler);
            break;
            case TreeInterface.RLBREADTH:
            traverse = rlBreadth (handler);
            break;
        }
        this.iterator = new QueueIterator<T> (traverse);
    }

    /**
	* Return next iteration element.
	* @return Next iteration element.
	*/
    public T getNext()
    {
        // put your code here
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
    private QueueInterface<T> preorder(TreeInterface<T> tree)
    {
        QueueInterface<T> traverse = new QueueDynamic<T>();
        T elem = tree.getRoot();
        traverse.add(elem);
        IteratorInterface <TreeInterface<T>> childrenIt = tree.getChildren().getIterator();
        while(childrenIt.hasNext()){
            TreeInterface<T> aChild = childrenIt.getNext();
            QueueInterface<T> aTraverse = preorder(aChild);
            addAll(traverse, aTraverse);
        }
        return traverse;
    }

    /**
   	* It iterates in postorder way.
   	* @param tree.
   	*/
    private QueueInterface<T> postorder(TreeInterface<T> tree)
    {
        QueueInterface<T> traverse = new QueueDynamic<T>();
        T elem = tree.getRoot();
        IteratorInterface <TreeInterface<T>> childrenIt = tree.getChildren().getIterator();
        while(childrenIt.hasNext()){
            TreeInterface<T> aChild = childrenIt.getNext();
            QueueInterface<T> aTraverse = postorder(aChild);
            addAll(traverse, aTraverse);
        }
        traverse.add(elem);
        return traverse;
    }

    private QueueInterface<T> lrBreadth(TreeInterface<T> tree)
    {
        QueueInterface<T> traverse = new QueueDynamic<T>();
        QueueInterface<TreeInterface<T>> aux = new QueueDynamic<TreeInterface<T>>();

        aux.add(tree);
        while(!aux.isEmpty()) {
            TreeInterface<T> aTree = aux.getFirst();
            T elem = aTree.getRoot();
            IteratorInterface <TreeInterface<T>> childrenIt = tree.getChildren().getIterator();
            while(childrenIt.hasNext()){
                TreeInterface<T> aChild = childrenIt.getNext();
                aux.add(aChild);
            }
            traverse.add(elem);
            aux.remove();
        }
        return traverse;
    }

    private QueueInterface<T> rlBreadth(TreeInterface<T> tree)
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
