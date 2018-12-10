package com.example.hsahn0323.testprepprototype;

public class WordListElement {
    private String word;
    private String definition;

    public WordListElement(String newWord, String newDefinition) {
        this.word = newWord;
        this.definition = newDefinition;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String newWord) {
        this.word = newWord;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String newDefinition) {
        this.definition = newDefinition;
    }
}
