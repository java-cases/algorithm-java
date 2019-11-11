package com.algorithm.lexer;

import com.algorithm.lexer.token.KeyWordToken;
import com.algorithm.lexer.token.SymbolToken;
import com.algorithm.lexer.token.Token;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LetterReader extends AbstractTokenReader implements TokenReader {

    /*保留字*/
    private Map<String, Token> keywords = new HashMap<>();

    /*符号表*/
    private ArrayList<Token> symbolTokens = new ArrayList<>();

    public LetterReader() {

        /*添加保留字*/
        reserve();
    }

    /*添加保留字*/
    private void reserve() {
        this.reserve(KeyWordToken.begin);
        this.reserve(KeyWordToken.end);
        this.reserve(KeyWordToken.integer);
        this.reserve(KeyWordToken.function);
        this.reserve(KeyWordToken.read);
        this.reserve(KeyWordToken.write);
        this.reserve(KeyWordToken.aIf);
        this.reserve(KeyWordToken.aThen);
        this.reserve(KeyWordToken.aElse);
        this.reserve(KeyWordToken.PUBLIC);
    }

    /*添加保留字*/
    private void reserve(KeyWordToken token) {
        keywords.put(token.getWord(), token);
    }

    /*数字的识别*/
    @Override
    public Token readToken(ReaderContext context) {

        if (!Character.isLetter(context.current())) {
            return Token.empty();
        }

        StringBuffer word = new StringBuffer();
        int startIndex=context.currentIndex();
        int toIndex = startIndex;

        for (int i = startIndex; i < context.length(); i++) {
            toIndex = i;
            char currentChar =context.current();

            if (Character.isLetterOrDigit(currentChar)) {
                word.append(currentChar);
            } else {
                break;
            }

            context.next();
        }

        /*判断是保留字还是标识符*/
        Token token = keywords.get(word.toString());

        /*如果是保留字的话，w不应该是空的*/
        if (token != null) {
            token = token.fromIndex(startIndex)
                    .toIndex(toIndex);
            context.saveToken(token);
            return token;
        }

        /*否则就是标识符，此处多出记录标识符编号的语句*/
        SymbolToken symbolToken = new SymbolToken(word.toString());
        Boolean contains = this.symbolTokens.stream().anyMatch(x -> x.equals(symbolToken));

        symbolToken.fromIndex(startIndex).toIndex(toIndex);

        if (!contains) {
            symbolTokens.add(symbolToken);
        }

        context.saveToken(symbolToken);
        return symbolToken;
    }
}
