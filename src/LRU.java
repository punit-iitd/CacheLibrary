// A class for Least Recently Used replacement policy
public class LRU<K, V> extends Cache<K, V> {

	public LRU(int capacity, Memory<K, Node<K, V>> memory) {
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
	
	// The recently used or accessed node is detached
	// from its current position and added at last.
	// This ensures that the least recently used node
	// is at the beginning
	@Override
	public void ArrangeRecentlyUsedNode(Node<K, V> used_node) {
		DetachNode(used_node);
        AddAtLast(used_node);
	}
	
	// Since least recently node is always at the
	// beginning we remove from first
	@Override
	public void Replace() {
		RemoveFromFirst();
	}
}
