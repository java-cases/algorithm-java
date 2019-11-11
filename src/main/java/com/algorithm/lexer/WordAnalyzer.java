package com.algorithm.lexer;

import com.algorithm.lexer.token.Token;

import java.util.List;

public class WordAnalyzer {

    public static List<Token> analyze(CharSequence chars){

        ReaderContext context=new ReaderContext(chars);
        TokenReader tokenReader = new SignReader();

        tokenReader.successor(new DigitalReader())
                .successor(new LetterReader());

        tokenReader.read(context);

        return context.getTokens();
    }
}
