/*
 * GrandPriest Originals
*/
package com.nabh.test;

import java.io.File;


public class Trie{
	public Trie[] children = new Trie[256];
	public boolean isEndOfWord;
	public File filePresent;
	public Trie(){ 
        isEndOfWord = false; 
        for (int i = 0; i < 256; i++) 
            children[i] = null;
        filePresent=null;
    } 
	
}