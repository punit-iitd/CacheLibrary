import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
// A class which support main functionalities of a
// cache namely Get and PutOrUpdate. This class also
// consist of some abstract methods which are
// implemented by its subclasses respectively. Some
// common functionalities for adding and deleting
// nodes are also present in this class.
public abstract class Cache<K, V> {
	// Capacity of the cache
	int capacity;
	// Head Node of the list of nodes in cache
	protected Node<K, V> head;
	// Tail Node of the list of nodes in cache
	protected Node<K, V> tail;
	// Memory data structure storing nodes
	// corresponding to a key
	protected Memory<K, Node<K, V>> memory;
	// Lock for making cache operations thread safe
	private Lock lock;
	// Perform replacement of the node according to
	// the replacement policy when cache becomes full
	protected abstract void Replace();
	// Inserts new element (node) into the cache
	protected abstract void InsertNewNode(Node<K, V> new_node);
	// Arranges (detaches and adds at last) the recently
	// used node. This function is implemented by LRU
	// and MRU
	protected abstract void ArrangeRecentlyUsedNode(Node<K, V> used);
	
	public Cache(int capacity, Memory<K, Node<K, V>> memory) {
		this.capacity = capacity;
		head = new Node<K, V>(null, null);
		tail = head;
		this.memory = memory;
		lock = new ReentrantLock();
	}
	// Adds the provided node at the end of the list of nodes
	protected void AddAtLast(Node<K, V> node) {
		tail.next = node;
        node.prev = tail;
        node.next = null;
        tail = node;
	}
	// Removes node from the beginning of the list (cache)
	protected void RemoveFromFirst() {
		memory.Remove(head.next.key);
		if(head.next == tail)
            tail = head;
        if(head.next.next != null)
            head.next.next.prev = head;
        head.next = head.next.next;
	}
	// Removes node from the end of the list (cache)
	protected void RemoveFromLast() {
		memory.Remove(tail.key);
		tail = tail.prev;
		tail.next = null;
	}
	// Detaches node from its current position
	protected void DetachNode(Node<K, V> node) {
		node.prev.next = node.next;
		if(node.next != null)
			node.next.prev = node.prev;
		else
			tail = node.prev;
	}
	// This functions answers the query i.e it
	// return the value of the queried key. If
	// key is present is cache then its value
	// is returned otherwise null is returned
	public V Get(K key) {
		lock.lock();
		try {
			if(!memory.ContainsKey(key))
				return null;
			ArrangeRecentlyUsedNode(memory.Get(key));
			V val = memory.Get(key).value;
			return val;
		} finally {
			lock.unlock();
		}
	}
	// This function updates the node if already
	// present otherwise adds this new node to
	// the cache
	public void PutOrUpdate(K key, V value) {
		lock.lock();
		try {
			if(memory.ContainsKey(key)) {
				memory.Get(key).value = value;
				DetachNode(memory.Get(key));
				InsertNewNode(memory.Get(key));
			} else {
				if(memory.Size() == capacity)
					Replace();
				Node<K, V> new_node = new Node<>(key, value);
				InsertNewNode(new_node);
			}
		} finally {
			lock.unlock();
		}
	}
}
