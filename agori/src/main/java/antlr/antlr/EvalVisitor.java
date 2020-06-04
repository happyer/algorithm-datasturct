package antlr.antlr;

import antlr.LabeleExprBaseVisitor;
import antlr.LabeleExprParser;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : chengxu@corp.netease.com
 * @since : 2020/5/30
 */
public class EvalVisitor extends LabeleExprBaseVisitor<Integer> {


    Map<String, Integer> memory = new HashMap<>();


    public Integer visitAtom(LabeleExprParser.AtomContext ctx) {
        int left = visit(ctx.children.get(0));
        int right = visit(ctx.children.get(1));
        return left + right;
    }
}
