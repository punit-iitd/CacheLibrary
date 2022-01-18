import java.util.HashMap;
// A class which implements Memory Interface and make use
// of inbuilt Java HashMap to implement all the functionalities
// required by a memory structure. Similar classes can also
// be build like this to support using flexible data structures
// for storing Nodes (like in memory data structure can also
// be used)
public class JavaHashMap<K, V> implements Memory<K, V> {
	// Inbuilt Java Hashmap is used as one of the
	// memory structure
	private HashMap<K, V> map;
	
	public JavaHashMap() {
		map = new HashMap<>();
	}

	@Override
	public void Put(K key, V value) {
		map.put(key, value);
	}

	@Override
	public boolean ContainsKey(K key) {
		return map.containsKey(key);
	}

	@Override
	public V Get(K key) {
		return map.get(key);
	}

	@Override
	public void Remove(K key) {
		map.remove(key);
	}

	@Override
	public int Size() {
		return map.size();
	}

}
