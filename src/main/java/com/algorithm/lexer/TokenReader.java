package com.algorithm.lexer;

public interface TokenReader {

    TokenReader getParent();
    void previous(TokenReader parent);
    TokenReader successor(TokenReader next);

    void read(ReaderContext context);
}
