// Generated from /Users/chauncy/Downloads/code/algorithm-datasturct/agori/src/main/java/antlr/LabeleExpr.g4 by ANTLR 4.8
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LabeleExprParser}.
 */
public interface LabeleExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LabeleExprParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(LabeleExprParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeleExprParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(LabeleExprParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeleExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(LabeleExprParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeleExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(LabeleExprParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeleExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(LabeleExprParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeleExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(LabeleExprParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeleExprParser#multExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultExpr(LabeleExprParser.MultExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeleExprParser#multExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultExpr(LabeleExprParser.MultExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeleExprParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(LabeleExprParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeleExprParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(LabeleExprParser.AtomContext ctx);
}