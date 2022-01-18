// A class for Last In First Out replacement policy
public class LIFO<K, V> extends Cache<K, V>{
	
	public LIFO(int capacity, Memory<K, Node<K, V>> memory) {
		super(capacity, memory);
	}
	
	// New node is always added at the end of the
	// list of nodes. Also this node is added in
	// the memory structure
	@Override
	public void InsertNewNode(Node<K, V> new_node) {
		AddAtLast(new_node);
	    memory.Put(new_node.key, new_node);
	}
	
	// Since new node is always added at the end
	// the last entered node is always at the
	// end. So in LIFO we remove from last.
	@Override
	public void Replace() {
		RemoveFromLast();
	}

	@Override
	public void ArrangeRecentlyUsedNode(Node<K, V> node) {}
}
