// A class for First In First Out replacement strategy
public class FIFO<K, V> extends Cache<K, V> {
	
	public FIFO(int capacity, Memory<K, Node<K, V>> memory) {
		super(capacity, memory);
	}
	
	// New node is always added at the end of the
	// list of nodes. Also this node is added in
	// the memory structure
	@Override
	protected void InsertNewNode(Node<K, V> new_node) {
		AddAtLast(new_node);
		memory.Put(new_node.key, new_node);
	}
	
	// Since new node is always added at the end
	// the first entered node is always at the
	// start. So in FIFO we remove from first.
	@Override
	protected void Replace() {
		RemoveFromFirst();
	}
	
	@Override
	protected void ArrangeRecentlyUsedNode(Node<K, V> node) {}
}
