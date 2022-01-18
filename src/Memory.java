// This is an interface which contains functionalities
// of a memory structure used for storing the nodes
// corresponding to a key.
public interface Memory<K, V> {
	// Puts key-value pair in the memory structure
	public void Put(K key, V value);
	
	// Check whether key is present in the memory
	// or not
	public boolean ContainsKey(K key);
	
	// Returns the value of the corresponding key
	public V Get(K key);
	
	// Removes the key and its associated value
	// from the memory structure
	public void Remove(K key);
	
	// Return the size of the memory structure
	public int Size();
}
