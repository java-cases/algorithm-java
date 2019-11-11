package com.algorithm.lexer.token;

/*
 * 常数
 */
public class ConstantToken extends Token {
    public final int value;

    public ConstantToken(int val) {
        super(Tag.CONSTANT);
        this.value = val;
        this.word(String.valueOf(val));
        this.name("常数");
    }
}
