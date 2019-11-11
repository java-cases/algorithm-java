package com.algorithm.lexer.token;

/*
 * 标识符
 */
public class SymbolToken extends Token {

    public SymbolToken(String word) {
        super(Tag.SYMBOL);
        this.word(word);
        this.name("标识符");
    }

}
