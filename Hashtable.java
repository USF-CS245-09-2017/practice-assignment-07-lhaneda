public class Hashtable<K, V> {
	private HashNode<K, V>[] arr;
	private int size;
	
	//Constructor
	public Hashtable() {
		arr = new HashNode[10];
		size = 0;
	}
	
	//get value at key
	public V get(K key)  {
		int position = Math.abs(key.hashCode()) % arr.length;
		HashNode top = arr[position];
		//iterate
		while (top != null) {
			if (top.key == key)
				return (V)top.value;
			top = top.next;
		}
		return null;
	}
	
	//put value given key and value
	public void put(K key, V value) {
		int position = Math.abs(key.hashCode()) % arr.length;
		HashNode head = arr[position];
		HashNode top = new HashNode<K,V>(key, value);
		top.next = head;
		arr[position] = top;
		size++;
	}
	
	//remove value at key
	public String remove(K key) {
		int position = Math.abs(key.hashCode()) % arr.length;
		HashNode head = arr[position];
		if (head == null)
			return null;
		
		if (head.key == key) {
			arr[position] = head.next;
			size--;
			return (String) head.value;
		} 
		HashNode previous = head;
		while (head != null) {
			if (head.key == null) {
				previous.next = head.next;
				size--;
			}
			previous = head;
			head = head.next;
		}
		return null;
	}
	
	public boolean containsKey(K key) {
		int position = Math.abs(key.hashCode()) % arr.length;
		HashNode top = arr[position];
		//iterate till key is found
		while (top != null) {
			if (top.key.equals(key))
				return true;
			top = top.next;
		}
		return false;
	}
}
