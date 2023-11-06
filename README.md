# Trie-Implementation
# Trie Data Structure and String Operations in Java

This Java project contains an implementation of the Trie data structure along with several functions for string operations. The Trie data structure is a tree-like data structure used for efficient storage and retrieval of a dynamic set of strings.


## Introduction

In this project, we implement a Trie data structure in Java and provide the following functions:

1. **Boolean Search**: Checks if a given argument is present in the Trie.

2. **Count Prefix**: Counts the occurrences of each string that is a prefix of other strings in the Trie.

3. **Reverse Find**: Prints all strings that end with a given suffix in lexicographical order.

<img width="619" alt="Screenshot 2023-11-06 at 23 03 25" src="https://github.com/sarparslan/Trie-Implementation/assets/96438389/857b5871-e572-47d7-96dc-f5f1a3fb4a21">

## Features

- Implementation of a Trie data structure in Java.
- Efficient string searching and manipulation operations.
- Support for Boolean search, prefix counting, and reverse string finding.
- Clear and extensible Java codebase.

## Getting Started

1. Clone this repository to your local machine.

2. Compile and run the Java Trie implementation using your preferred Java development environment.

3. Use the provided functions for various string operations.

## Usage

Here's how you can use the Trie data structure and the associated functions in Java:

```java
// Sample Java code snippet
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();

        // Insert words into the Trie
        trie.insert("apple");
        trie.insert("banana");
        trie.insert("cherry");

        // Perform Boolean search
        boolean result = trie.booleanSearch("apple");
        System.out.println(result);  // true

        // Count prefixes
        trie.countPrefixes();

        // Reverse find strings with a given suffix
        List<String> reverseResults = trie.reverseFind("e");
        for (String word : reverseResults) {
            System.out.println(word);
        }
    }
}
