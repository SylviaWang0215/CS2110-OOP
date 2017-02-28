/* Time spent on a3:  2 hours and 00 minutes.
 * Name: Shuyu Wang
 * Netid: sw883
 * What I thought about this assignment:
 *
 *
 */

package LinkedList;

/** An instance is a circular doubly linked list. */
public class CLL<E> {
    /*package*/ Node head; // a node of linked list (null if the list is empty)
    /*package*/ int size;  // Number of nodes in linked list.

    /** Constructor: an empty linked list. */
    public CLL() {
        //TODO #1.  Figure out IF you have to do anything here
    	this.size = 0;
    }

    /** Return the number of values in this list. */
    public int size() {
        return size;
    }

    /** Return the first node of the list (null if the list is empty). */
    public Node getFirst() {
        return head;
    }

    /** Return the last node of the list (null if the list is empty). */
    public Node getLast() {
        if (head == null) return null;
        return head.pred;
    }

    /** If this circular list is empty, return null.
     *  Otherwise, move down the list in circular fashion, so that the
     *  first node becomes the last node, the second becomes the first, etc.
     *  Then return the new head node.
     *  This operation should take constant time.
     *  Example: if toString() returned "[3, 5, 7]", after this it will
     *           return "[5, 7, 3]" */
    public Node moveDown() {
        if (head != null) {
            head= head.succ;
        }
        return head;
    }

    /** Return the value of node e of this list.
     *  Precondition: e must be a node of this list.
     *  This operation should take constant time. */
    public E valueOf(Node e) {
        return e.value;
    }

    /** Return a representation of this list: its values, with adjacent
     * ones separated by ", ", "[" at the beginning, and "]" at the end. <br>
     *
     * E.g. if the list contains 6 3 8 in that order, the result it "[6, 3, 8]". */
    public String toString() {
        if (head == null) return "[]";

        String res= "[" + head.value;
        // inv: res contains "[" together with all values in nodes before node
        //      n, with ", " between them.
        for (Node n= head.succ; n != head; n= n.succ) {
            res= res + ", " + n.value;
        }
        return res + "]";
    }

    /** Return a representation of this list: its values in reverse, with adjacent
     * ones separated by ", ", "[" at the beginning, and "]" at the end. <br>
     *
     * E.g. for the list containing 6 3 8 in that order, the result it "[8, 3, 6]".*/
    public String toStringRev() {
        /*TODO #2. This method should NOT use field size or the succ fields.
         * It should use field head and all the pred fields. Reason: It allows
         * toStringReverse to be used in testing head and all the pred fields.
         * You will test this along with append. */
    	int len = this.size;
    	StringBuilder s = new StringBuilder();
    	if (len == 0)
    		return "[]";
    	Node lastOne = this.head;
    	s.append("[");
    	for (int i = 0; i < len - 1; i = i + 1){
    		lastOne = lastOne.pred;
    		s.append(lastOne.value);	
    		s.append(", ");
    	}
    	
    	lastOne = lastOne.pred;
    	s.append(lastOne.value);
    	s.append(']');
    	String str = s.toString();
    	return str;
    }

    /** Append value v to the list.
     * This operation should take constant time.
     * Example. If the toString view of the list is [3, 5, 7], after
     * appending 2, the toString view is [3, 5, 7, 2]. */
    public void append(E v) {
        //TODO #3 Note: Test append and toStringReverse together
    	Node new_node = new Node(null, v, null);
    	if (head == null) {
    		head = new_node;
    		head.succ = head;
    		head.pred = head;
    	}
    	else {    		
    		Node old_tail = this.getLast();
    		Node old_head = this.getFirst();
    		old_tail.succ = new_node;
    		new_node.succ = old_head;
    		new_node.pred = old_tail;
    		old_head.pred = new_node;   			
    	}
    		this.size ++;
    }

    /** Prepend value v to the list.
     * This operation should take constant time.
     * Example. If the toString view of the list is [3, 5, 7], after
     * prepending 2, the toString view is [2, 3, 5, 7]. */
    public void prepend(E v) {
        //TODO #4. There are at least two totally different ways to do this one.
    	Node new_node = new Node(null, v, null);
    	if (head == null) {
    		head = new_node;
    		head.succ = head;
    		head.pred = head;
    	}
    	else {    		
    		Node old_tail = this.getLast();
    		Node old_head = this.getFirst();
    		head = new_node;
    		old_head.pred = new_node;
    		new_node.pred = old_tail;
    		new_node.succ = old_head;
    		old_tail.succ = new_node;
    	}
    	this.size ++;
    }

    /** Return Node number h of the linked list. Note: the first one is number 0.
     * Throw an IndexOutOfBoundsException if h < 0 or h >= size of the list.
     * This method must take time proportional to min(h, size - h). */
    /* package */ Node getNode(int h) {
        // TODO item #5
        // There are two ways to get to an element: forward from the head, using
        // succ fields, or backward using the pred fields.
        // This method must use the fastest way for h.
        // (If h is exactly the middle, then either way is ok.)
    	if (h < 0 || h >= this.size)
    		throw new IndexOutOfBoundsException();
    	
    	Node temp;
    	if (h < this.size/2){
    		temp = this.getFirst();
    		for(int i = 0; i < h; i ++){
    			temp = temp.succ;
    		}
    	}
    	else {
    		temp = this.getLast();
    		for (int i = 0; i < size - h - 1; i++){
    			temp = temp.pred;
    		}
    	}
    	return temp;
    }

    /** Insert value v in a new node after node n of this circular list.
     * This operation should take constant time.
     * Precondition: n must be a node of this list. */
    public void insertAfter(E v, Node n) {
        /*TODO #6. This method views the list as a circular list, so it doesn't
         * really matter which node head points to when the method is done.
         * However, WE REQUIRE THAT HEAD NOT BE CHANGED. */
    	Node new_node = new Node(null, v, null);
    	Node n_after = n.succ;
    	new_node.pred = n;
    	n.succ = new_node;
    	n_after.pred = new_node;
    	new_node.succ = n_after;
    	this.size ++;
    }

    /** Remove node n from this list.
     * This operation should take constant time.
     *  Precondition: n must be a node of this list. */
    public void remove(Node n) {
        assert size != 0  &&  n != null;
        /*TODO #7. If the head (first) node is being removed and size >= 2, head
         * should end up pointing at head's successor. */
        Node old_after = n.succ;
        Node old_before = n.pred;
        if (n == this.getFirst()) {
        	head = old_after;
        }
        
        if (this.size == 1){
        	this.head = null;
        }
        old_after.pred = old_before;
        old_before.succ = old_after;
        this.size --;
    }



    /*********************/

    /** An instance is a node of this circular list. */
    public class Node {
        /*package*/ Node pred; // Predecessor of this node in the circular list

        /*package*/ E value; // value in this node. */

        /*package*/ Node succ; // Predecessor of this node in the circular list

        /** Constructor: an instance with predecessor p (p can be null),
         * value v, and successor s (s can be null). */
        /* package */ Node(Node p, E v, Node s) {
            pred= p;
            value= v;
            succ= s;
        }

        /** Return the value of this node. */
        public E getValue() {
            return value;
        }

        /** Return the predecessor of this node in the list. */
        public Node predecessor() {
            return pred;
        }

        /** Return the successor of this node in this list. */
        public Node successor() {
            return succ;
        }
    }

}

