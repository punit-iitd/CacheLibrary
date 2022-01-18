// A class for the Most Recently Used replacement policy
// This is also an example of how other replacement
// policies can be added in the library by using the
// common functionalities.
public class MRU<K, V> extends Cache<K, V> {

	public MRU(int capacity, Memory<K, Node<K, V>> memory) {
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
	// This ensures that the most recently used node
	// is at the end
	@Override
	public void ArrangeRecentlyUsedNode(Node<K, V> used_node) {
		DetachNode(used_node);
        AddAtLast(used_node);
	}
	
	// Since least recently node is always at the
	// beginning we remove from first
	@Override
	public void Replace() {
		RemoveFromLast();
	}
}
