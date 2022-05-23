package eapli.base.surveymanagement.application.eapli.base.surveymanagement.application;

import java.io.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
public class ReadData {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(new File("teste.txt"));
        SurveyLexer lexer = new SurveyLexer(new ANTLRInputStream(fis));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SurveyParser parser = new SurveyParser(tokens);
        ParseTree tree = parser.prog(); // parse
        SurvVisitor surv = new SurvVisitor();
        surv.visit(tree);
    }
}
