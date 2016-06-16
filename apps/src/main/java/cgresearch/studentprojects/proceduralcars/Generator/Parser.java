package cgresearch.studentprojects.proceduralcars.Generator;


import cgresearch.core.assets.ResourcesLocator;
import cgresearch.studentprojects.proceduralcars.Generator.Functions.Function;
import cgresearch.studentprojects.proceduralcars.dsl.ShapeGrammarBaseListener;
import cgresearch.studentprojects.proceduralcars.dsl.ShapeGrammarLexer;
import cgresearch.studentprojects.proceduralcars.dsl.ShapeGrammarParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Parser extends ShapeGrammarBaseListener {

    private String ruleFile;

    private CarGenerator gen;

    /**
     * Used during parse to collect all functions for a rule
     */
    private List<Function> currentFunctions = new ArrayList<>();

    public Parser(String ruleFile) {
        this.ruleFile = ruleFile;
    }

    public CarGenerator parse() throws IOException {
        //Reading the DSL script
        String ruleFile = ResourcesLocator.getInstance().getPathToResource(this.ruleFile);

        //Loading the DSL script into the ANTLR stream.
        CharStream cs = new ANTLRInputStream(readFile(ruleFile, StandardCharsets.UTF_8));

        //Passing the input to the lexer to create tokens
        ShapeGrammarLexer lexer = new ShapeGrammarLexer(cs);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        //Passing the tokens to the parser to create the parse tree.
        ShapeGrammarParser parser = new ShapeGrammarParser(tokens);

        ShapeGrammarParser.Shape_grammarContext context = parser.shape_grammar();

        // Create the CarGenerator
        gen = new CarGenerator();

        // Walk it
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(this, context);

        return gen;
    }

    @Override
    public void enterAttr(ShapeGrammarParser.AttrContext ctx) {
        //System.out.println(ctx.NUMBER(0));

        switch (ctx.ATTR_TYPE().toString()) {
            case "int" :
                gen.addIntAttribute(
                        new Attribute<>(
                                ctx.IDENTIFIER().toString(),
                                Integer.parseInt(ctx.NUMBER(0).toString()),
                                Integer.parseInt(ctx.NUMBER(1).toString())
                        )
                );
                break;
            case "float" :
                gen.addFloatAttribute(
                        new Attribute<>(
                                ctx.IDENTIFIER().toString(),
                                Float.parseFloat(ctx.NUMBER(0).toString()),
                                Float.parseFloat(ctx.NUMBER(1).toString())
                        )
                );
                break;
            case "bool" :
                gen.addBoolAttribute(
                        new Attribute<>(
                                ctx.IDENTIFIER().toString(),
                                Boolean.parseBoolean(ctx.NUMBER(0).toString()),
                                Boolean.parseBoolean(ctx.NUMBER(1).toString())
                        )
                );
                break;
        }


    }

    @Override
    public void enterResource(ShapeGrammarParser.ResourceContext ctx){
        //System.out.println(ctx.PATH().toString().replaceAll("\"", ""));

        switch (ctx.RESOURCE_TYPE().toString()) {
            case "model":
                gen.addModelRessource(
                        ctx.IDENTIFIER().toString(),
                        ctx.PATH().toString().replaceAll("\"", "")
                );
        }

    }

    @Override
    public void enterStart_entry(ShapeGrammarParser.Start_entryContext ctx) {
        //System.out.println(ctx.IDENTIFIER().toString());

        gen.setStartRule(ctx.IDENTIFIER().toString());
    }



    @Override
    public void enterInclude_statement(ShapeGrammarParser.Include_statementContext ctx) {
        // System.out.println("include is: " +ctx.getText());
        // TODO: Do includes
    }

    @Override
    public void exitShape_rule(ShapeGrammarParser.Shape_ruleContext ctx) {
        //System.out.println(ctx.IDENTIFIER().toString() + " has " + ctx.func().size());

        List<Function> functions = new ArrayList<>(currentFunctions);
        gen.setRule(new Rule(gen, ctx.IDENTIFIER().toString(), functions));

        // Clear the functions cache when leaving a rule
        currentFunctions.clear();
    }

    @Override
    public void enterFunc(ShapeGrammarParser.FuncContext ctx) {
        switch (ctx.IDENTIFIER().toString()) {
            case "container":
                
        }
    }


    private String readFile(String path, Charset encoding) throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }


}
