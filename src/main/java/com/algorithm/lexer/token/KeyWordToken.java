package com.algorithm.lexer.token;

/**
 * 保留字
 */
public class KeyWordToken extends Token {

    public KeyWordToken(String word, int tag) {
        super(tag);
        this.word(word);
        this.name("保留字");
    }

    public static final KeyWordToken begin = new KeyWordToken("begin", Tag.BEGIN);
    public static final KeyWordToken end = new KeyWordToken("end", Tag.END);
    public static final KeyWordToken integer = new KeyWordToken("integer", Tag.INTEGER);
    public static final KeyWordToken function = new KeyWordToken("function", Tag.FUNCTION);
    public static final KeyWordToken read = new KeyWordToken("read", Tag.READ);
    public static final KeyWordToken write = new KeyWordToken("write", Tag.WRITE);
    public static final KeyWordToken aIf = new KeyWordToken("if", Tag.IF);
    public static final KeyWordToken aThen = new KeyWordToken("then", Tag.THEN);
    public static final KeyWordToken aElse = new KeyWordToken("else", Tag.ELSE);

    public static final KeyWordToken PUBLIC = new KeyWordToken("public", Tag.PUBLIC);
    public static final KeyWordToken PRIVATE = new KeyWordToken("private", Tag.PRIVATE);
    public static final KeyWordToken CLASS = new KeyWordToken("class", Tag.CLASS);
}
