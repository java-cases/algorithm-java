package com.algorithm.wordAnalyze;

/**
 * 此程序是通过将文件的字符读取到字符数组中去，然后遍历数组，将读取的字符进行
 * 分类并输出
 *
 * @author
 */
public class WordAnalyze {
    private String keyWord[] = {"break", "include", "begin", "end", "if", "else", "while", "switch"};
    private char ch;

    //判断是否是关键字
    boolean isKey(String str) {
        for (int i = 0; i < keyWord.length; i++) {
            if (keyWord[i].equals(str))
                return true;
        }
        return false;
    }

    //判断是否是字母
    boolean isLetter(char letter) {
        if ((letter >= 'a' && letter <= 'z') || (letter >= 'A' && letter <= 'Z'))
            return true;
        else
            return false;
    }

    //判断是否是数字
    boolean isDigit(char digit) {
        if (digit >= '0' && digit <= '9')
            return true;
        else
            return false;
    }

    //词法分析
    void analyze(char[] chars) {
        String arr = "";
        for (int i = 0; i < chars.length; i++) {
            ch = chars[i];
            arr = "";
            if (ch == ' ' || ch == '\t' || ch == '\n' || ch == '\r') {
            } else if (isLetter(ch)) {
                while (isLetter(ch) || isDigit(ch)) {
                    arr += ch;
                    ch = chars[++i];
                }
                //回退一个字符
                i--;
                if (isKey(arr)) {
                    //关键字
                    System.out.println(arr + "\t4" + "\t关键字");
                } else {
                    //标识符
                    System.out.println(arr + "\t4" + "\t标识符");
                }
            } else if (isDigit(ch) || (ch == '.')) {
                while (isDigit(ch) || (ch == '.' && isDigit(chars[++i]))) {
                    if (ch == '.') i--;
                    arr = arr + ch;
                    ch = chars[++i];
                }
                //属于无符号常数
                System.out.println(arr + "\t5" + "\t常数");
            } else switch (ch) {
                //运算符
                case '+':
                    System.out.println(ch + "\t2" + "\t运算符");
                    break;
                case '-':
                    System.out.println(ch + "\t2" + "\t运算符");
                    break;
                case '*':
                    System.out.println(ch + "\t2" + "\t运算符");
                    break;
                case '/':
                    System.out.println(ch + "\t2" + "\t运算符");
                    break;
                //分界符
                case '(':
                    printToken("\t3", "\t分界符");
                    break;
                case ')':
                    System.out.println(ch + "\t3" + "\t分界符");
                    break;
                case '[':
                    System.out.println(ch + "\t3" + "\t分界符");
                    break;
                case ']':
                    System.out.println(ch + "\t3" + "\t分界符");
                    break;
                case ';':
                    System.out.println(ch + "\t3" + "\t分界符");
                    break;
                case '{':
                    System.out.println(ch + "\t3" + "\t分界符");
                    break;
                case '}':
                    System.out.println(ch + "\t3" + "\t分界符");
                    break;
                //运算符
                case '=': {
                    ch = chars[++i];
                    if (ch == '=') System.out.println("==" + "\t2" + "\t运算符");
                    else {
                        System.out.println("=" + "\t2" + "\t运算符");
                        i--;
                    }
                }
                break;
                case ':': {
                    ch = chars[++i];
                    if (ch == '=') System.out.println(":=" + "\t2" + "\t运算符");
                    else {
                        System.out.println(":" + "\t2" + "\t运算符");
                        i--;
                    }
                }
                break;
                case '>': {
                    ch = chars[++i];
                    if (ch == '=') System.out.println(">=" + "\t2" + "\t运算符");
                    else {
                        System.out.println(">" + "\t2" + "\t运算符");
                        i--;
                    }
                }
                break;
                case '<': {
                    ch = chars[++i];
                    if (ch == '=') System.out.println("<=" + "\t2" + "\t运算符");
                    else {
                        System.out.println("<" + "\t2" + "\t运算符");
                        i--;
                    }
                }
                break;
                //无识别
                default:
                    System.out.println(ch + "\t6" + "\t无识别符");
            }
        }
    }

    private void printToken(String s, String s2) {
        System.out.println(ch + s + s2);
    }
}
