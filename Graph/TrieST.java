import java.util.Collection;
import java.util.Collections;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.PriorityQueue;

public class TrieST<Value> {

    private static final int R = 256;
    private Node root = new Node();
    Hashtable<String, Integer> occurence = new Hashtable<String, Integer>();

    public void put(String key, Value val) {

        root = put(root, key, val, 0);
        // for (int i = 0; i < R; i++)
        // System.out.println("checkpoint! TriesST/put/ root.next[" + i + "] : " +
        // root.next[i]);
        if (!occurence.containsKey(key))
            occurence.put(key, 1);
        else
            occurence.put(key, occurence.get(key) + 1);
    }

    private Node put(Node x, String key, Value val, int d) {

        if (x == null)
            x = new Node();
        if (d == key.length()) {
            x.val = val;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d + 1);
        return x;
    }

    @SuppressWarnings("unchecked")
    public Value get(String key) {
        Node x = get(root, key, 0);
        if (x == null)
            return null;
        return (Value) x.val;
    }

    private Node get(Node x, String key, int d) {
        if (x == null)
            return null;
        if (d == key.length())
            return x;
        char c = key.charAt(d);
        // System.out.println("checkpoint! letter:" + c);
        return get(x.next[c], key, d + 1);
    }

    public Iterable<String> keysWithPrefix(String prefix) {
        Queue<String> q = new LinkedList<String>();
        Node x = get(root, prefix, 0);
        collect(x, prefix, q);
        return q;
    }

    private void collect(Node x, String prefix, Queue<String> q) {
        if (x == null)
            return;
        if (x.val != null)
            q.offer(prefix);
        for (char c = 0; c < R; c++)
            collect(x.next[c], prefix + c, q);
    }

    public Iterable<String> keysWithSuffix(String suffix) {
        Queue<String> q = new LinkedList<String>();
        Node x = root;
        System.out.println("checkpoint! TriesST/collectSuffix suffix : " + suffix);
        collectSuffix(x, suffix, "", q);
        return q;
    }

    private void collectSuffix(Node x, String cSuffix, String suffix,
            Queue<String> q) {
        if (x == null)
            return;

        if (x.val != null && suffix.length() >= cSuffix.length()) {
            String newSuffix = suffix.substring(suffix.length() - cSuffix.length());
            System.out.println("checkpoint! TriesST/collectSuffix/ newSuffix: " + newSuffix);
            if (newSuffix.equals(cSuffix))
                q.offer(suffix);
        }
        for (char c = 0; c < R; c++)
            collectSuffix(x.next[c], cSuffix, suffix + c, q);
    }

    public Iterable<String> keysWithPrefixSuffix(String prefix, String suffix) {
        Queue<String> q = new LinkedList<String>();
        Node x = get(root, prefix, 0);
        // System.out.println(prefix + " " + suffix + "-----------");
        collectPrefixSuffix(x, prefix, suffix, q);
        return q;
    }

    private void collectPrefixSuffix(Node x, String prefix, String suffix,
            Queue<String> q) {
        if (x == null)
            return;

        if (x.val != null && prefix.length() >= suffix.length()) {
            String newSuffix = prefix.substring(prefix.length() - suffix.length());

            if (newSuffix.equals(suffix))
                q.offer(prefix);
        }

        for (char c = 0; c < R; c++)
            collectPrefixSuffix(x.next[c], prefix + c, suffix, q);
    }

    public Iterable<String> getTop(int k) {
        PriorityQueue<String> queue = new PriorityQueue<>();

        for (String key : occurence.keySet()) {
            if (queue.size() < k) {
                queue.add(key);
            } else {
                if (occurence.get(key) > occurence.get(queue.peek())) {
                    queue.poll();
                    queue.add(key);
                }
            }
        }

        return queue;
    }

    public Iterable<String> wildCard(String pat) {
        Queue<String> q = new LinkedList<String>();
        wildCard(root, pat, "", q);
        return q;
    }

    private void wildCard(Node x, String pat, String prefix, Queue<String> q) {
        if (x == null)
            return;
        int d = prefix.length();
        if (pat.length() == d) {
            if (x.val != null)
                q.offer(prefix);
            return;
        }
        char c = pat.charAt(d);

        for (int i = 0; i < R; i++)
            if (c == '.' || c == i)
                wildCard(x.next[i], pat, prefix + i, q);

    }

    public String longestPrefixOf(String query) {
        int length = lPOSearch(root, query, 0, 0);
        return query.substring(0, length);
    }

    private int lPOSearch(Node x, String query, int d, int length) {
        if (x == null)
            return length;

        if (x.val != null)
            length = d;

        if (d == query.length())
            return length;

        char c = query.charAt(d);
        return lPOSearch(x.next[c], query, d + 1, length);
    }

    public void printAll() {
        printAll(root, "");
    }

    private void printAll(Node x, String key) {
        // System.out.println("checkpoint! TriesST/x: " + x);
        if (x == null)
            return;
        if (x.val != null)
            System.out.println(key);
        for (char c = 0; c < R; c++)
            printAll(x.next[c], key + c);

    }

    private static class Node {
        private Object val;
        private Node[] next = new Node[R];
    }
}
