import java.util.*;

//-----------------------------------------------------
// Title: TST class
// Author: Sarp ARSLAN - 11458145526 - Section03
// Burak SAĞLAM – 13760307838 - Section02
// Description: TST Class for using TST
//-----------------------------------------------------
public class TST {
    private Node root;

    private static class Node {
        private Object val;
        private char c;
        private Node left, mid, right;
    }

    /**
     * Inserts a key-value pair into the TST.
     *
     * @param key The key to insert.
     * @param val The value to associate with the key.
     */
    public void put(String key, Object val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Object val, int d) {
        char c = key.charAt(d);
        if (x == null) {
            x = new Node();
            x.c = c;
        }
        if (c < x.c) {
            x.left = put(x.left, key, val, d);
        } else if (c > x.c) {
            x.right = put(x.right, key, val, d);
        } else if (d < key.length() - 1) {
            x.mid = put(x.mid, key, val, d + 1);
        } else {
            x.val = val;
        }
        return x;
    }

    /**
     * Searches for a key in the TST.
     *
     * @param key The key to search for.
     * @return true if the key exists in the TST, false otherwise.
     */
    public boolean search(String key) {
        return get(key) != null;
    }

    /**
     * Retrieves the value associated with a key in the TST.
     *
     * @param key The key to search for.
     * @return The value associated with the key, or null if the key doesn't exist.
     */
    public Object get(String key) {
        Node x = get(root, key, 0);
        if (x == null) {
            return null;
        }
        return x.val;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) {
            return null;
        }
        char c = key.charAt(d);
        if (c < x.c) {
            return get(x.left, key, d);
        } else if (c > x.c) {
            return get(x.right, key, d);
        } else if (d < key.length() - 1) {
            return get(x.mid, key, d + 1);
        } else {
            return x;
        }
    }

    /**
     * Counts the number of keys in the TST that have a given prefix.
     * Prints the count for each prefix.
     */
    public void countPrefix() {
        List<String> words = new ArrayList<>();
        collectWords(root, "", words);
        Collections.sort(words);

        int[] counts = new int[words.size()];
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            for (int j = 0; j < words.size(); j++) {
                if (j != i && words.get(j).startsWith(word)) {
                    counts[i]++;
                }
            }
        }

        for (int count : counts) {
            System.out.print(count + " ");
        }
        System.out.println();
    }

    private void collectWords(Node x, String prefix, List<String> words) {
        if (x == null) return;
        if (x.val != null) words.add(prefix);
        collectWords(x.left, prefix, words);
        collectWords(x.mid, prefix + x.c, words);
        collectWords(x.right, prefix, words);
    }
}
