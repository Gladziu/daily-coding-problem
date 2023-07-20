// #11 Problem
package org.example;

import java.util.*;

public class AutocompleteSystem {
    /* Implement an autocomplete system. That is, given a query string s and a set of all possible query strings,
     return all strings in the set that have s as a prefix.

     For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].

     Hint: Try preprocessing the dictionary into a more efficient data structure to speed up queries. */

    /* Without Trie
    public static void main(String[] args) {
        Set<String> words = new HashSet<>();
        words.add("deer");
        words.add("dog");
        words.add("deal");
        String prefix = "de";
        System.out.println(autocomplete(words, prefix));
    }

    static Set<String> autocomplete(Set<String> words, String prefix) {
        Set<String> correctWords = new HashSet<>();
        for (String word : words){
            if(word.startsWith(prefix)){
                correctWords.add(word);
            }
        }
        return correctWords;
    } */

    private final Trie trie;

    public AutocompleteSystem(String[] words) {
        trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
    }

    public List<String> autocomplete(String query) {
        return trie.searchPrefix(query);
    }

    public static void main(String[] args) {
        String[] words = {"dog", "deer", "deal", "cat", "car", "cab"};

        AutocompleteSystem autocompleteSystem = new AutocompleteSystem(words);
        List<String> results = autocompleteSystem.autocomplete("d");

        System.out.println(results);
    }
}

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the trie
    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            current.children.putIfAbsent(c, new TrieNode());
            current = current.children.get(c);
        }
        current.isEndOfWord = true;
    }

    // Search for all strings with the given prefix
    public List<String> searchPrefix(String prefix) {
        List<String> results = new ArrayList<>();
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            if (!current.children.containsKey(c)) {
                return results; // No words with the given prefix found
            }
            current = current.children.get(c);
        }

        findAllWordsWithPrefix(current, new StringBuilder(prefix), results);
        return results;
    }

    // Recursive method to find all words with a given prefix
    private void findAllWordsWithPrefix(TrieNode node, StringBuilder currentWord, List<String> results) {
        if (node.isEndOfWord) {
            results.add(currentWord.toString());
        }

        for (char c : node.children.keySet()) {
            currentWord.append(c);
            findAllWordsWithPrefix(node.children.get(c), currentWord, results);
            currentWord.deleteCharAt(currentWord.length() - 1);
        }
    }
}