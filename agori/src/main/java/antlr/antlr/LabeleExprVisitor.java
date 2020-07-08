// Generated from /Users/chauncy/Downloads/code/algorithm-datasturct/agori/src/main/java/antlr/LabeleExpr.g4 by ANTLR 4.8
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LabeleExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LabeleExprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LabeleExprParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(LabeleExprParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeleExprParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(LabeleExprParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeleExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(LabeleExprParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeleExprParser#multExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultExpr(LabeleExprParser.MultExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeleExprParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(LabeleExprParser.AtomContext ctx);
}