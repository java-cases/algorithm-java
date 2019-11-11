package com.algorithm.lexer.token;

public class Token {

    private final int tag;
    private String name = "";
    private String word = "";
    private int fromIndex = 0;
    private int toIndex = 0;

    public int getTag() {
        return tag;
    }

    public String getName() {
        return name;
    }

    public Token name(String name) {
        this.name = name;
        return this;
    }

    public String getWord() {
        return word;
    }

    public Token word(String word) {
        this.word = word;
        return this;
    }

    public int getFromIndex() {
        return fromIndex;
    }

    public Token fromIndex(int fromIndex) {
        this.fromIndex = fromIndex;
        return this;
    }

    public int getToIndex() {
        return toIndex;
    }

    public Token toIndex(int toIndex) {
        this.toIndex = toIndex;
        return this;
    }

    public Token increaseIndex() {
        this.toIndex = this.toIndex + 1;
        return this;
    }

    public Token(int tag) {
        this.tag = tag;
    }

    public static Token empty() {
        return new Token(0).fromIndex(-1).toIndex(-1);
    }

    public boolean isPresent() {
        if (this.tag <= 0) {
            return false;
        }

        return (this.fromIndex >= 0 && this.toIndex >= 0) && (this.fromIndex < this.toIndex);
    }

    @Override
    public String toString() {
        return "Token{" +
                "word=" + word +
                ", tag='" + tag + '\'' +
                '}';
    }
}
