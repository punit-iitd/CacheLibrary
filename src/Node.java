// This is a Node class where Node is the entity that makes up
// the list(cache). It consists of key, corresponding value
// and next and previous pointers
public class Node<K, V> {
	Node<K, V> next;
	Node<K, V> prev;
	K key;
	V value;
	public Node(K key, V value) {
		this.key = key;
		this.value = value;
	}
}
