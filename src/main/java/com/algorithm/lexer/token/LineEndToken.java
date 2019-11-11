package com.algorithm.lexer.token;

/**
 * 行尾符
 */
public class LineEndToken extends Token {

    public LineEndToken(String word) {
        super(Tag.LINE_END);
        this.word(word);
        this.name("行尾符");
    }

    public static final LineEndToken lineEnd = new LineEndToken("\r\n");
}
