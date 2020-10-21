// Generated from interpreter.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link interpreterParser}.
 */
public interface interpreterListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link interpreterParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(interpreterParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link interpreterParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(interpreterParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link interpreterParser#fun}.
	 * @param ctx the parse tree
	 */
	void enterFun(interpreterParser.FunContext ctx);
	/**
	 * Exit a parse tree produced by {@link interpreterParser#fun}.
	 * @param ctx the parse tree
	 */
	void exitFun(interpreterParser.FunContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Integerdec}
	 * labeled alternative in {@link interpreterParser#typeid}.
	 * @param ctx the parse tree
	 */
	void enterIntegerdec(interpreterParser.IntegerdecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Integerdec}
	 * labeled alternative in {@link interpreterParser#typeid}.
	 * @param ctx the parse tree
	 */
	void exitIntegerdec(interpreterParser.IntegerdecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Booldec}
	 * labeled alternative in {@link interpreterParser#typeid}.
	 * @param ctx the parse tree
	 */
	void enterBooldec(interpreterParser.BooldecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Booldec}
	 * labeled alternative in {@link interpreterParser#typeid}.
	 * @param ctx the parse tree
	 */
	void exitBooldec(interpreterParser.BooldecContext ctx);
	/**
	 * Enter a parse tree produced by {@link interpreterParser#typeids}.
	 * @param ctx the parse tree
	 */
	void enterTypeids(interpreterParser.TypeidsContext ctx);
	/**
	 * Exit a parse tree produced by {@link interpreterParser#typeids}.
	 * @param ctx the parse tree
	 */
	void exitTypeids(interpreterParser.TypeidsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link interpreterParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenthesis(interpreterParser.ParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link interpreterParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenthesis(interpreterParser.ParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link interpreterParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplication(interpreterParser.MultiplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link interpreterParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplication(interpreterParser.MultiplicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link interpreterParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddition(interpreterParser.AdditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link interpreterParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddition(interpreterParser.AdditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link interpreterParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVariable(interpreterParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link interpreterParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVariable(interpreterParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Comparison}
	 * labeled alternative in {@link interpreterParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterComparison(interpreterParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Comparison}
	 * labeled alternative in {@link interpreterParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitComparison(interpreterParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Constant}
	 * labeled alternative in {@link interpreterParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstant(interpreterParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Constant}
	 * labeled alternative in {@link interpreterParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstant(interpreterParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Conditional}
	 * labeled alternative in {@link interpreterParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConditional(interpreterParser.ConditionalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Conditional}
	 * labeled alternative in {@link interpreterParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConditional(interpreterParser.ConditionalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link interpreterParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(interpreterParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link interpreterParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(interpreterParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link interpreterParser#exprs}.
	 * @param ctx the parse tree
	 */
	void enterExprs(interpreterParser.ExprsContext ctx);
	/**
	 * Exit a parse tree produced by {@link interpreterParser#exprs}.
	 * @param ctx the parse tree
	 */
	void exitExprs(interpreterParser.ExprsContext ctx);
}