package com.algorithm.lexer;

import com.algorithm.lexer.token.Token;
import org.junit.Test;

import java.util.List;

public class WordAnalyzerTest {

    @Test
    public void analyze() {
        String text = "public class SignReaderTest {\n" +
                "\n" + "    private List<Token> tokens=new ArrayList<>();\n" +
                "    private TokenReader tokenReader=new SignReader(tokens);";

        List<Token> tokens=WordAnalyzer.analyze(text);

        System.out.println(tokens);
    }
}