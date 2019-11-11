package com.algorithm.lexer.token;

/**
 * 结尾符
 */
public class AllEndToken extends Token {

    public AllEndToken(String word) {
        super(Tag.ALL_END);
        this.word(word);
        this.name("结尾符");
    }

    public static final AllEndToken allEnd = new AllEndToken("#");
}
