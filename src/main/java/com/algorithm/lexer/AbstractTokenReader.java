package com.algorithm.lexer;

import com.algorithm.lexer.token.Token;

public abstract class AbstractTokenReader implements TokenReader {

    private TokenReader parent;
    private TokenReader next;

    @Override
    public TokenReader getParent() {
        return parent;
    }

    public TokenReader getNext() {
        return next;
    }

    public AbstractTokenReader() {
    }

    @Override
    public void previous(TokenReader parent) {
        this.parent = parent;
    }

    @Override
    public TokenReader successor(TokenReader next) {
        next.previous(this);
        this.next = next;
        return next;
    }

    @Override
    public void read(ReaderContext context) {
        if (context.isEnd()) {
            return;
        }

        this.readToken(context);

        if (this.next != null) {
            this.next.read(context);
        } else {
            findRoot(this).read(context);
        }
    }

    private TokenReader findRoot(TokenReader reader) {
        TokenReader parent = reader.getParent();
        if (parent == null) {
            return reader;
        } else {
            return findRoot(parent);
        }
    }

    public abstract Token readToken(ReaderContext context);


}
