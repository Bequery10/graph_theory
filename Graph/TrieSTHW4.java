// public class TrieSTHW4<Value> {

// private static final int R = 256;
// private Node root = new Node();

// public void put(String key, Value val) {
// root = put(root, key, val, 0);
// }

// private Node put(Node x, String key, Value val, int d) {

// if (root == null)
// x = new Node();
// if (d == key.length()) {
// x.val = val;
// return x;
// }
// char c = key.charAt(d);
// put(x.next[c], key, val, d + 1);
// return x;
// }

// public Value get(String key) {
// Node x = get(root, key, 0);
// if (x == null)
// return null;
// return (Value) x.val;
// }

// private Node get(Node x, String key, int d) {
// if (x == null)
// return null;
// if (d == key.length())
// return x;
// char c = key.charAt(d);
// return get(x.next[c], key, d + 1);
// }

// private static class Node {
// private Object val;
// private Node[] next = new Node[R];
// }
// }
