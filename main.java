import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.CharStreams;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.List;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) throws IOException{

	// we expect exactly one argument: the name of the input file
	if (args.length!=1) {
	    System.err.println("\n");
	    System.err.println("Simple calculator\n");
	    System.err.println("=================\n\n");
	    System.err.println("Please give as input argument a filename\n");
	    System.exit(-1);
	}
	String filename=args[0];

	// open the input file
	CharStream input = CharStreams.fromFileName(filename);
	    //new ANTLRFileStream (filename); // depricated
	
	// create a lexer/scanner
	interpreterLexer lex = new interpreterLexer(input);
	
	// get the stream of tokens from the scanner
	CommonTokenStream tokens = new CommonTokenStream(lex);
	
	// create a parser
	interpreterParser parser = new interpreterParser(tokens);
	
	// and parse anything from the grammar for "start"
	ParseTree parseTree = parser.start();

	// A maker for an Abstract Syntax Tree (AST) 
	ASTMaker astmaker = new ASTMaker();
	AST ast=astmaker.visit(parseTree);

	System.out.println("\nThe result is: "+ast.eval(new Environment(), new FunEnvironment()));
    }
}



class ASTMaker extends AbstractParseTreeVisitor<AST> implements interpreterVisitor<AST> {

    public AST visitStart(interpreterParser.StartContext ctx){
	List<Fun> fs=new ArrayList<Fun>();
	for( interpreterParser.FunContext fc : ctx.fun()){
	    fs.add((Fun)visit(fc));
	}
	return new Start(fs,(Expr)visit(ctx.expr()));
    };
    
    public AST visitFun(interpreterParser.FunContext ctx){
	List<TypedIdent> tids=new ArrayList<TypedIdent>();
	for(interpreterParser.TypeidContext tc : ctx.typeids().typeid()){
	    tids.add((TypedIdent)visit(tc));
	}
	return new Fun((TypedIdent)visit(ctx.typeid()), tids,
		       (Expr)visit(ctx.expr() ));
    };
    public AST visitIntegerdec(interpreterParser.IntegerdecContext ctx){
	return new TypedIdent(Type.INTTYPE,ctx.ID().getText());
    };
    public AST visitBooldec(interpreterParser.BooldecContext ctx){
	return new TypedIdent(Type.BOOLTYPE,ctx.ID().getText());
    };
    public AST visitTypeids(interpreterParser.TypeidsContext ctx){
	faux.error("This function should not be called.");
	return null;
    };
    
    public AST visitParenthesis(interpreterParser.ParenthesisContext ctx){
	return (Expr) visit(ctx.expr());
    };
    public AST visitMultiplication(interpreterParser.MultiplicationContext ctx){
	return new Multiplication((Expr) visit(ctx.expr(0)), (Expr) visit(ctx.expr(1)));
    };
    public AST visitAddition(interpreterParser.AdditionContext ctx){
	return new Addition((Expr) visit(ctx.expr(0)), (Expr) visit(ctx.expr(1)));
    };
    public AST visitVariable(interpreterParser.VariableContext ctx){ 
	return new Variable(ctx.getText());
    };
    public AST visitComparison(interpreterParser.ComparisonContext ctx){
	return new Comparison((Expr) visit(ctx.expr(0)), (Expr) visit(ctx.expr(1)));
    };
    public AST visitConstant(interpreterParser.ConstantContext ctx){
	return new Constant(new IntValue(Integer.parseInt(ctx.getText()))); 
    };
    public AST visitConditional(interpreterParser.ConditionalContext ctx){
	return new Conditional((Expr) visit(ctx.expr(0)), (Expr) visit(ctx.expr(1)),(Expr) visit(ctx.expr(2)) );
    };
    public AST visitFunctionCall(interpreterParser.FunctionCallContext ctx){
	List<Expr> es=new ArrayList<Expr>();
	for (interpreterParser.ExprContext ec : ctx.exprs().expr())
	    es.add((Expr) visit(ec));
	return new FunctionCall(ctx.ID().getText(),es);
    };
    public AST visitExprs(interpreterParser.ExprsContext ctx){
	faux.error("This function should not be called actually");
	return null;
    };
}

