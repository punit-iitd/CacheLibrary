# CacheLibrary
The cache library is implemented in Java. This cache is a doubly linked list of nodes storing key-value pair. In the implementation a memory interface is built which contains functionalities required by a memory struture. Currently this implementation uses a class JavaHashMap (in which inbuilt HashMap is used) as our memory structure. But this implementation is flexible to any memory structure to be used. Using such memory struture (like HashMap in our case) increases the lookup speed for a key. It takes O(1) on average for searching or getting a key. The types of both the key and value are made generic in this implementation.

Replacement policies implemented currently:
1. LRU (Least Recently Used)
2. LIFO (Last In First Out)
3. FIFO (First In First Out)
The implementation has support for other policies as well. It would just require to make use of the existing functionalities. MRU (Most recently used) is also implemented for example.

The main functions of the cache are:
1. Get: It is used to access the value of the queried key
2. PutOrUpdate: Updates the value of the key if already present in the cache otherwise adds it to the cache.

The common functions for all replacement policies are:
1. InsertNewNode: Inserts a new node into the cache list
2. Replace: Replaces a node when cache becomes full. Replacement is done as per the policy used.
3. ArrangeRecentlyUsedNode: It arranges the node which is just used or accessed. For example in LRU such arrangement is necessary to maintain the least recently used property.

Some other functions of Cache class which are commonly used by other functions:
1. AddAtLast: Adds node to the end of the cache list
2. RemoveFromLast: Removes node from the end of the list
3. RemoveFromFirst: Removes node from the beginning of the list
4. DetachNode: Detaches the node from its current position in the list

The cache is also made thread safe by use of locks. 
