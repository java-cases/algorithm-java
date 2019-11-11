package com.algorithm.lexer.token;

/**
 * 运算符
 */
public class CalcWordToken extends Token {
    public String word = "";

    public CalcWordToken(String word, int tag) {
        super(tag);
        this.word(word);
        this.name("运算符");
    }

    public static final CalcWordToken add = new CalcWordToken("+", Tag.ADD);
    public static final CalcWordToken sub = new CalcWordToken("-", Tag.SUB);
    public static final CalcWordToken mul = new CalcWordToken("*", Tag.MUL);
    public static final CalcWordToken div = new CalcWordToken("/", Tag.DIV);
    public static final CalcWordToken le = new CalcWordToken("<=", Tag.LE);
    public static final CalcWordToken ge = new CalcWordToken(">=", Tag.GE);
    public static final CalcWordToken ne = new CalcWordToken("!=", Tag.NE);
    public static final CalcWordToken assign = new CalcWordToken(":=", Tag.ASSIGN);
}
