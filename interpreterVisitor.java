// Generated from interpreter.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link interpreterParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface interpreterVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link interpreterParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(interpreterParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link interpreterParser#fun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFun(interpreterParser.FunContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Integerdec}
	 * labeled alternative in {@link interpreterParser#typeid}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerdec(interpreterParser.IntegerdecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Booldec}
	 * labeled alternative in {@link interpreterParser#typeid}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooldec(interpreterParser.BooldecContext ctx);
	/**
	 * Visit a parse tree produced by {@link interpreterParser#typeids}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeids(interpreterParser.TypeidsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link interpreterParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesis(interpreterParser.ParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link interpreterParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplication(interpreterParser.MultiplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link interpreterParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddition(interpreterParser.AdditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link interpreterParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(interpreterParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Comparison}
	 * labeled alternative in {@link interpreterParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(interpreterParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Constant}
	 * labeled alternative in {@link interpreterParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(interpreterParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Conditional}
	 * labeled alternative in {@link interpreterParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditional(interpreterParser.ConditionalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link interpreterParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(interpreterParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link interpreterParser#exprs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprs(interpreterParser.ExprsContext ctx);
}