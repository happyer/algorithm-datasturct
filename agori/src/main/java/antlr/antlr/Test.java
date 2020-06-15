package antlr.antlr;

import antlr.LabeleExprLexer;
import antlr.LabeleExprParser;
import antlr.LabeleExprParser.ProgContext;
import java.io.IOException;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;


/**
 * @author : chengxu@corp.netease.com
 * @since : 2020/5/30
 */
public class Test {


    public static void main(String[] args) throws IOException {

        String[] testStr={
            "2",
            "a+b+3",
            "(a-b)+3",
            "a+(b*3"
        };

        for (String s:testStr){
            System.out.println("Input expr:"+s);
            run(s);
        }


    }


    public static void run(String expr) {
        ANTLRInputStream in = new ANTLRInputStream(expr);
        LabeleExprLexer labeleExprLexer = new LabeleExprLexer(in);
        CommonTokenStream commonToken = new CommonTokenStream(labeleExprLexer);
        LabeleExprParser labeleExprParser = new LabeleExprParser(commonToken);
        ProgContext progContext =  labeleExprParser.prog();
        progContext.accept(new EvalVisitor());


    }

}
