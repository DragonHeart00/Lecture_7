antlr4 = java -jar /usr/local/lib/antlr-4.9-complete.jar
SRCFILES = main.java AST.java
GENERATED = interpreterListener.java interpreterBaseListener.java interpreterParser.java interpreterBaseVisitor.java interpreterVisitor.java interpreterLexer.java

all:	
	make main.class

main.class:	$(SRCFILES) $(GENERATED) interpreter.g4
	javac -Xlint:unchecked $(SRCFILES) $(GENERATED)

interpreterListener.java:	interpreter.g4
	$(antlr4) -visitor interpreter.g4

test:	main.class
	java main interpreter_input.txt
