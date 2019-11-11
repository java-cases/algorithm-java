package com.algorithm.lexer.token;

/**
 * 界符
 */
public class DelimiterToken extends Token {

    public DelimiterToken(String word, int tag) {
        super(tag);
        this.word(word);
        this.name("界符");
    }

    public static final DelimiterToken lpar = new DelimiterToken("(", Tag.LPAR);
    public static final DelimiterToken rpar = new DelimiterToken(")", Tag.RPAR);
    public static final DelimiterToken sem = new DelimiterToken(";", Tag.SEM);
}
