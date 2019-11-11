package com.algorithm.lexer;

import com.algorithm.lexer.token.*;

import javax.xml.stream.events.Characters;

public class SignReader extends AbstractTokenReader implements TokenReader {

    public SignReader() {
    }

    /*数字的识别*/
    @Override
    public Token readToken(ReaderContext context) {
        char currentChar = context.current();
        if (currentChar == Characters.SPACE) {
            return Token.empty();
        }

        Token token = Token.empty();

        switch (currentChar) {
            case '#':
                context.saveToken(AllEndToken.allEnd);
                break;
            case '\r':
                if (context.next() == ('\n')) {
                    context.saveToken(LineEndToken.lineEnd);
                } else {
                    context.previous();
                }
                break;
            case '(':
                context.saveToken(DelimiterToken.lpar);
                break;
            case ')':
                context.saveToken(DelimiterToken.rpar);
                break;
            case ';':
                context.saveToken(DelimiterToken.sem);
                break;
            case '+':
                context.saveToken(CalcWordToken.add);
                break;
            case '-':
                context.saveToken(CalcWordToken.sub);
                break;
            case '*':
                context.saveToken(CalcWordToken.mul);
                break;
            case '/':
                context.saveToken(CalcWordToken.div);
                break;
            case ':':
                if (context.next() == ('=')) {
                    context.saveToken(CalcWordToken.assign);
                } else {
                    context.previous();
                }
                break;
            case '>':
                if (context.next() == ('=')) {
                    context.saveToken(CalcWordToken.ge);
                } else {
                    context.previous();
                }
                break;
            case '<':
                if (context.next() == ('=')) {
                    context.saveToken(CalcWordToken.le);
                } else {
                    context.previous();
                }
                break;
            case '!':
                if (context.next() == ('=')) {
                    context.saveToken(CalcWordToken.ne);
                } else {
                    context.previous();
                }
                break;
        }

        context.next();

        return token;
    }

}
