import java.util.*;

//-----------------------------------------------------
// Title: RWT class
// Author: Sarp ARSLAN - 11458145526 - Section03
// Burak SAĞLAM – 13760307838 - Section02
// Description: RWT class for using RWT
//-----------------------------------------------------
public class RWT {
    private static final int R = 256;
    private Node root = new Node();

    private static class Node {
        private Object value;
        private Node[] next = new Node[R];
    }

    /**
     * Inserts a key-value pair into the RWT.
     *
     * @param key The key to insert.
     * @param val The value to associate with the key.
     */
    public void put(String key, Object val) {
        root = put(root, new StringBuilder(key).reverse().toString(), val, 0);
    }

    private Node put(Node x, String key, Object val, int d) {
        if (x == null) {
            x = new Node();
        }
        if (d == key.length()) {
            x.value = val;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d + 1);
        return x;
    }

    /**
     * Returns a list of all keys in the RWT that have the given prefix.
     *
     * @param prefix The prefix to search for.
     * @return A list of keys with the given prefix.
     */
    public List<String> keysWithPrefix(String prefix) {
        List<String> results = new ArrayList<>();
        Node x = get(root, new StringBuilder(prefix).reverse().toString(), 0);
        collect(x, new StringBuilder(prefix).reverse().toString(), results);
        Collections.sort(results, Comparator.reverseOrder());
        return results;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d);
        return get(x.next[c], key, d + 1);
    }

    private void collect(Node x, String prefix, List<String> results) {
        if (x == null) return;
        if (x.value != null) results.add(new StringBuilder(prefix).reverse().toString());
        for (char c = 0; c < R; c++) {
            collect(x.next[c], prefix + c, results);
        }
    }
}
