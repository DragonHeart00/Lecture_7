grammar interpreter;

// Implementing the interpreter from chapter 4 of Mogensen's book (see Grammar 4.1)

start   : fun* expr EOF ;
// A program is a list of function definitions;
// in contrast to the book we assume to have one main expression

fun     : typeid '(' typeids ')' '=' expr ;

typeid  : 'int' ID     # Integerdec
        | 'bool' ID    # Booldec
	;

typeids : typeid (',' typeid)* ;

expr	: expr '*' expr                            # Multiplication
    	| expr '+' expr                            # Addition
    	| expr '==' expr                           # Comparison
       	| NUM  	                                   # Constant
    	| ID                                       # Variable
    	| '(' expr ')'                             # Parenthesis
    	| ID '(' exprs ')'                         # FunctionCall
    	| 'if' expr 'then' expr 'else' expr        # Conditional
    	;

exprs   : expr (',' expr)* ;

NUM 	: '-'?('0'..'9')+ ;
ID	: ('A'..'Z'|'a'..'z'|'_')+ ;
WHITESPACE : [ \n\t\r]+ -> skip;
COMMENT : '//' ~('\n')* -> skip;
