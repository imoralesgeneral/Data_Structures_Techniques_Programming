package com.structures.Iterator;

public class TreeIterator<T> implements IteratorInterface<T> {

	private IteratorIF<T> iterator;

    /**
     * Constructor for objects of class TreeIterator
     */
    public TreeIterator(TreeIF<T> handler, int type)
    {
        QueueIF<T> traverse = null;
        switch(type) {
            case TreeIF.PREORDER:
            traverse = preorder (handler);
            break;
            case TreeIF.POSTORDER:
            traverse = postorder (handler);
            break;
            case TreeIF.LRBREADTH:
            traverse = lrBreadth (handler);
            break;
            case TreeIF.RLBREADTH:
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
    private QueueIF<T> preorder(TreeIF<T> tree)
    {
        QueueIF<T> traverse = new QueueDynamic<T>();
        T elem = tree.getRoot();
        traverse.add(elem);
        IteratorIF <TreeIF<T>> childrenIt = tree.getChildren().getIterator();
        while(childrenIt.hasNext()){
            TreeIF<T> aChild = childrenIt.getNext();
            QueueIF<T> aTraverse = preorder(aChild);
            addAll(traverse, aTraverse);
        }
        return traverse;
    }

    /**
   	* It iterates in postorder way.
   	* @param tree.
   	*/
    private QueueIF<T> postorder(TreeIF<T> tree)
    {
        QueueIF<T> traverse = new QueueDynamic<T>();
        T elem = tree.getRoot();
        IteratorIF <TreeIF<T>> childrenIt = tree.getChildren().getIterator();
        while(childrenIt.hasNext()){
            TreeIF<T> aChild = childrenIt.getNext();
            QueueIF<T> aTraverse = postorder(aChild);
            addAll(traverse, aTraverse);
        }
        traverse.add(elem);
        return traverse;
    }

    private QueueIF<T> lrBreadth(TreeIF<T> tree)
    {
        QueueIF<T> traverse = new QueueDynamic<T>();
        QueueIF<TreeIF<T>> aux = new QueueDynamic<TreeIF<T>>();

        aux.add(tree);
        while(!aux.isEmpty()) {
            TreeIF<T> aTree = aux.getFirst();
            T elem = aTree.getRoot();
            IteratorIF <TreeIF<T>> childrenIt = tree.getChildren().getIterator();
            while(childrenIt.hasNext()){
                TreeIF<T> aChild = childrenIt.getNext();
                aux.add(aChild);
            }
            traverse.add(elem);
            aux.remove();
        }
        return traverse;
    }

    private QueueIF<T> rlBreadth(TreeIF<T> tree)
    {
        QueueIF<T> traverse = lrBreadth(tree);
        StackIF<T> aux = new StackDynamic<T>();
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
    private void addAll(QueueIF<T> q, QueueIF<T> p)
    {
        while(!p.isEmpty()) {
            T elem = p.getFirst();
            q.add(elem);
            p.remove();
        }
    }
    
}
