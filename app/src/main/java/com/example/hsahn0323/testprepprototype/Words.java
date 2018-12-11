package com.example.hsahn0323.testprepprototype;

public class Words {
    private String wordInput;
    private String definition;

    public Words(String wordInput, String definition) {
        this.wordInput = wordInput;
        this.definition = definition;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getWordInput() {
        return wordInput;
    }

    public void setWordInput(String wordInput) {
        this.wordInput = wordInput;
    }
}
