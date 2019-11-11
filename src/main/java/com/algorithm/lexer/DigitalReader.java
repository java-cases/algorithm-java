package com.algorithm.lexer;

import com.algorithm.lexer.token.ConstantToken;
import com.algorithm.lexer.token.Token;

public class DigitalReader extends AbstractTokenReader implements TokenReader {

    public DigitalReader() {

    }

    /*数字的识别*/
    @Override
    public Token readToken(ReaderContext context) {

        if (!Character.isDigit(context.current())) {
            return Token.empty();
        }

        int value = 0;
        int startIndex = context.currentIndex();
        int toIndex;

        for (int i = startIndex; i < context.length(); i++) {
            char currentChar = context.current();

            if (Character.isDigit(currentChar)) {
                value = 10 * value + Character.digit(currentChar, 10);
            } else {
                toIndex = i - 1;
                Token token = new ConstantToken(value).fromIndex(startIndex).toIndex(toIndex);
                context.saveToken(token);
                return token;
            }

            context.next();
        }

        return Token.empty();
    }
}
