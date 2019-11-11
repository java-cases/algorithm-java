package com.algorithm.lexer.token;

/*
 * 单词类别
 */
public class Tag {
    public final static int BEGIN = 1;    //保留字
    public final static int END = 2;      //保留字
    public final static int INTEGER = 3;  //保留字
    public final static int FUNCTION = 4; //保留字
    public final static int READ = 5;     //保留字
    public final static int WRITE = 6;    //保留字
    public final static int IF = 7;       //保留字
    public final static int THEN = 8;     //保留字
    public final static int ELSE = 9;     //保留字

    public final static int SYMBOL = 11;    //标识符
    public final static int CONSTANT = 12;  //常数

    public final static int ADD = 13;    //运算符 "+"
    public final static int SUB = 14;    //运算符 "-"
    public final static int MUL = 15;    //运算符 "*"
    public final static int DIV = 16;    //运算符 "/"
    public final static int LE = 18;     //运算符 "<="
    public final static int GE = 19;     //运算符 ">="
    public final static int NE = 20;     //运算符 "!="
    public final static int ASSIGN = 23; //运算符 ":="

    public final static int LPAR = 24;   //界符 "("
    public final static int RPAR = 25;   //界符 ")"
    public final static int SEM = 26;    //界符 ";"

    public final static int LINE_END = 27;   //行尾符
    public final static int ALL_END = 28;    //结尾符 "#"

    public final static int PUBLIC = 29;    //关键字
    public final static int PRIVATE = 30;    //关键字
    public final static int CLASS = 31;    //关键字
}
