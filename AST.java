import java.util.HashMap;
import java.util.Map.Entry;
import java.util.List;
import java.util.ArrayList;

class faux{ // collection of non-OO auxiliary functions (currently just error)
    public static void error(String msg){
	System.err.println("Interpreter error: "+msg);
	System.exit(-1);
    }
}

abstract class AST{
    abstract public Value eval(Environment env, FunEnvironment fenv);
    abstract public Type check(Environment env, FunEnvironment fenv);
}

enum Type{
    INTTYPE, BOOLTYPE  
}

abstract class Value{
    abstract public Type valuetype();
    abstract public int intvalue(); // will error unless valuetype()==INTTYPE!
    abstract public boolean boolvalue(); // will error unless valuetype()==BOOLTYPE!
    abstract public String toString();
}

class IntValue extends Value{
    public int v;
    IntValue(int v){this.v=v;}
    public Type valuetype(){return Type.INTTYPE;}
    public int intvalue(){return v;}
    public boolean boolvalue(){faux.error("This is not a bool!"); return false;}
    public String toString(){ return ""+v;}
}

class BoolValue extends Value{
    public boolean b;
    BoolValue(boolean b){this.b=b;}
    public Type valuetype(){return Type.BOOLTYPE;}
    public int intvalue(){faux.error("This is not an int!"); return 0;}
    public boolean boolvalue(){return b;}
    public String toString(){ return ""+b;}
}

class TypedIdent extends AST{
    public Type valuetype;
    public String ident;
    TypedIdent(Type valuetype, String ident){this.valuetype=valuetype; this.ident=ident;}
    public Value eval(Environment env, FunEnvironment fenv){
	faux.error("TypedIdent.eval should not be called!");
	return null;
    }
    public Type check(Environment env, FunEnvironment fenv){
	faux.error("TypedIdent.eval should not be called!");
	return null;
    }
}

class Fun extends AST{
    public TypedIdent typeid; // function name and return type 
    public List<TypedIdent> parameters;
    public Expr e; // the body of the function
    Fun(TypedIdent typeid, List<TypedIdent> parameters, Expr e){
	this.typeid=typeid; this.parameters=parameters; this.e=e; }
    public Value eval(Environment env, FunEnvironment fenv){
	faux.error("Fun.eval should not be called!");
	return null;
    }
    public Type check(Environment env, FunEnvironment fenv){
	faux.error("Fun.eval should not be called!");
	return null;
    }
}


// Implementing the vtable of Mogensen's book

class Environment {
    private HashMap<String,Value> variableValues = new HashMap<String,Value>();
    public Environment() { }	
    public void setVariable(String name, Value value) {
	variableValues.put(name, value);
    }
    
    public Value getVariable(String name){
	Value value = variableValues.get(name); 
	if (value == null) faux.error("Variable not defined: "+name); 
	return value;
    }
}

// Implementing the ftable of Mogensen's book

class FunEnvironment{
    private HashMap<String,Fun> funDefs = new HashMap<String,Fun>();
    public FunEnvironment() { }	
    public void setFunction(String name, Fun f) {
	funDefs.put(name, f);
    }    
    public Fun getFunction(String name){
	Fun f = funDefs.get(name); 
	if (f == null) faux.error("Function not defined: "+name); 
	return f;
    }
}

class Start extends AST{
    public List<Fun> funs;
    public Expr e;

    Start(List<Fun> funs, Expr e){ this.funs=funs; this.e=e; }
    
    public Value eval(Environment env, FunEnvironment fenv){
	for (Fun f:funs)
	    fenv.setFunction(f.typeid.ident,f);
        return e.eval(env,fenv);

    }
    public Type check(Environment env, FunEnvironment fenv){
	return null;
    }
}

abstract class Expr extends AST{
    // Abstract superclass of the different kinds of expressions
}


class Constant extends Expr{

    public Value v;
    Constant(Value v){ this.v=v; }
    public Value eval(Environment env, FunEnvironment fenv){
        //return value v
        return v;
    }
    public Type check(Environment env, FunEnvironment fenv){

        return null;
    }
}

class Variable extends Expr{
    public String varname;
    Variable(String varname){ this.varname=varname; }
    public Value eval(Environment env, FunEnvironment fenv){

        return env.getVariable(varname);
    }
    public Type check(Environment env, FunEnvironment fenv){
	return null;
    }
}

class Addition extends Expr{
    public Expr e1,e2;
    Addition(Expr e1, Expr e2){ this.e1=e1; this.e2=e2; }
    public Value eval(Environment env, FunEnvironment fenv){

        Value v1= e1.eval(env,fenv);
        Value v2= e2.eval(env,fenv);

        if (v1.valuetype()!=Type.INTTYPE || v2.valuetype()!=Type.INTTYPE)
            faux.error("Addition must be of integers");

        return new IntValue(v1.intvalue() + v2.intvalue());
    }

    public Type check(Environment env, FunEnvironment fenv){
	return null;
    }
}

class Multiplication extends Expr{
    public Expr e1,e2;
    Multiplication(Expr e1, Expr e2){ this.e1=e1; this.e2=e2; }
    public Value eval(Environment env, FunEnvironment fenv){
        Value v1= e1.eval(env,fenv);
        Value v2= e2.eval(env,fenv);

        if (v1.valuetype()!=Type.INTTYPE || v2.valuetype()!=Type.INTTYPE)
            faux.error("Multiplication must be of integers");

        return new IntValue(v1.intvalue() * v2.intvalue());
    }
    public Type check(Environment env, FunEnvironment fenv){
	return null;
    }
}

class Comparison extends Expr{
    public Expr e1,e2;
    Comparison(Expr e1, Expr e2){ this.e1=e1; this.e2=e2; }
    public Value eval(Environment env, FunEnvironment fenv){
        Value v1= e1.eval(env,fenv);
        Value v2= e2.eval(env,fenv);
        Type t1 = v1.valuetype();
        Type t2 = v2.valuetype();

        if (t1!=t2)
            faux.error("Comparison must be of same type");

        if (t1==Type.INTTYPE)
            return new BoolValue(v1.intvalue() == v2.intvalue());

        else
            return new BoolValue(v1.boolvalue() == v2.boolvalue());
    }

    public Type check(Environment env, FunEnvironment fenv){
	return null;
    }
}

class Conditional extends Expr{
    public Expr cond, e1, e2;
    Conditional(Expr cond, Expr e1, Expr e2){ this.cond=cond; this.e1=e1; this.e2=e2; }
    public Value eval(Environment env, FunEnvironment fenv){
        Value c = cond.eval(env,fenv);

        if (c.valuetype()!=Type.BOOLTYPE)
            faux.error("Condition is not a boolean");
        if (c.boolvalue())
            return e1.eval(env,fenv);
        else
            return e2.eval(env,fenv);
    }
    public Type check(Environment env, FunEnvironment fenv){
	return null;
    }
}

class FunctionCall extends Expr{
    public String fname;
    public List<Expr> parameters;
    FunctionCall(String fname, List<Expr> parameters){
        this.fname=fname;
        this.parameters=parameters;
    }
    public Value eval(Environment env, FunEnvironment fenv){
        Fun fdef=fenv.getFunction(fname);

        if(fdef.parameters.size()!=parameters.size())
            faux.error("Wrong number of parameters");

        Environment newenv = new Environment();
        for(int i=0; i<parameters.size(); i++){
            Value v=parameters.get(i).eval(env,fenv);
            if (v.valuetype()!=fdef.parameters.get(i).valuetype)
                faux.error("Wrong type of parameter");
            newenv.setVariable(fdef.parameters.get(i).ident,v);
        }
        return fdef.e.eval(newenv,fenv);

    }
    public Type check(Environment env, FunEnvironment fenv){
	return null;
    }
}

