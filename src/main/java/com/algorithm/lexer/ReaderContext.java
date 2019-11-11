package com.algorithm.lexer;

import com.algorithm.lexer.token.Token;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReaderContext {

    private CharSequence chars;
    private int cursorIndex = 0;
    private List<Token> tokens = new ArrayList<>();

    public ReaderContext(CharSequence chars) {
        Objects.requireNonNull(chars);

        if (chars.length() == 0) {
            throw new IllegalArgumentException("chars is empty.");
        }

        this.chars = chars;
    }

    public CharSequence getChars() {
        return chars;
    }

    public int currentIndex() {
        return cursorIndex;
    }

    private void setCursorIndex(int cursorIndex) {
        if (cursorIndex < 0) {
            throw new IllegalArgumentException("cursorIndex is illegal.");
        }
        this.cursorIndex = cursorIndex;
    }

    public Boolean isEnd() {
        return this.currentIndex() + 1 >= this.getChars().length();
    }

    public int length() {
        return this.getChars().length();
    }

    public char current() {
        return this.getChars().charAt(this.currentIndex());
    }

    public char next() {
        if (this.isEnd()) {
            return 0;
        }

        this.setCursorIndex(this.currentIndex() + 1);
        return this.getChars().charAt(this.currentIndex());
    }

    public char previous() {
        if (this.currentIndex() - 1 < 0) {
            return 0;
        }

        this.setCursorIndex(this.currentIndex() - 1);
        return this.getChars().charAt(this.currentIndex());
    }

    public Token saveToken(Token token) {
        Objects.requireNonNull(token);
        this.tokens.add(token);
        return token;
    }

    public List<Token> getTokens() {
        return tokens;
    }
}
