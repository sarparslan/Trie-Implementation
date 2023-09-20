//-----------------------------------------------------
// Title: Value class
// Author: Sarp ARSLAN - 11458145526 - Section03
// Burak SAĞLAM – 13760307838 - Section02
// Description: Value Class for implementing tries.
//-----------------------------------------------------
public class Value {
    private String key;
    private int value;

    /**
     * Constructs a Value object with the specified key and value.
     *
     * @param key   The key of the value.
     * @param value The value associated with the key.
     */
    public Value(String key, int value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Returns the key of the Value object.
     *
     * @return The key.
     */
    public String getKey() {
        return key;
    }

    /**
     * Returns the value associated with the key.
     *
     * @return The value.
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the value associated with the key.
     *
     * @param value The value to set.
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Returns a string representation of the Value object.
     *
     * @return The string representation.
     */
    public String toString() {
        return key + " -> " + value;
    }
}
