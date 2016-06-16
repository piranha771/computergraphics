// Generated from C:/Users/Piranha/Source/computergraphics/apps/src/main/java/cgresearch/studentprojects/proceduralcars/dsl\ShapeGrammar.g4 by ANTLR 4.5.1
package cgresearch.studentprojects.proceduralcars.dsl;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ShapeGrammarParser}.
 */
public interface ShapeGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ShapeGrammarParser#shape_grammar}.
	 * @param ctx the parse tree
	 */
	void enterShape_grammar(ShapeGrammarParser.Shape_grammarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShapeGrammarParser#shape_grammar}.
	 * @param ctx the parse tree
	 */
	void exitShape_grammar(ShapeGrammarParser.Shape_grammarContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShapeGrammarParser#decoration}.
	 * @param ctx the parse tree
	 */
	void enterDecoration(ShapeGrammarParser.DecorationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShapeGrammarParser#decoration}.
	 * @param ctx the parse tree
	 */
	void exitDecoration(ShapeGrammarParser.DecorationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShapeGrammarParser#include_statement}.
	 * @param ctx the parse tree
	 */
	void enterInclude_statement(ShapeGrammarParser.Include_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShapeGrammarParser#include_statement}.
	 * @param ctx the parse tree
	 */
	void exitInclude_statement(ShapeGrammarParser.Include_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShapeGrammarParser#attr}.
	 * @param ctx the parse tree
	 */
	void enterAttr(ShapeGrammarParser.AttrContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShapeGrammarParser#attr}.
	 * @param ctx the parse tree
	 */
	void exitAttr(ShapeGrammarParser.AttrContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShapeGrammarParser#resource}.
	 * @param ctx the parse tree
	 */
	void enterResource(ShapeGrammarParser.ResourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShapeGrammarParser#resource}.
	 * @param ctx the parse tree
	 */
	void exitResource(ShapeGrammarParser.ResourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShapeGrammarParser#start_entry}.
	 * @param ctx the parse tree
	 */
	void enterStart_entry(ShapeGrammarParser.Start_entryContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShapeGrammarParser#start_entry}.
	 * @param ctx the parse tree
	 */
	void exitStart_entry(ShapeGrammarParser.Start_entryContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShapeGrammarParser#shape_rule}.
	 * @param ctx the parse tree
	 */
	void enterShape_rule(ShapeGrammarParser.Shape_ruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShapeGrammarParser#shape_rule}.
	 * @param ctx the parse tree
	 */
	void exitShape_rule(ShapeGrammarParser.Shape_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShapeGrammarParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunc(ShapeGrammarParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShapeGrammarParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunc(ShapeGrammarParser.FuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShapeGrammarParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(ShapeGrammarParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShapeGrammarParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(ShapeGrammarParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShapeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ShapeGrammarParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShapeGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ShapeGrammarParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShapeGrammarParser#addition_exp}.
	 * @param ctx the parse tree
	 */
	void enterAddition_exp(ShapeGrammarParser.Addition_expContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShapeGrammarParser#addition_exp}.
	 * @param ctx the parse tree
	 */
	void exitAddition_exp(ShapeGrammarParser.Addition_expContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShapeGrammarParser#multiply_exp}.
	 * @param ctx the parse tree
	 */
	void enterMultiply_exp(ShapeGrammarParser.Multiply_expContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShapeGrammarParser#multiply_exp}.
	 * @param ctx the parse tree
	 */
	void exitMultiply_exp(ShapeGrammarParser.Multiply_expContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShapeGrammarParser#atom_exp}.
	 * @param ctx the parse tree
	 */
	void enterAtom_exp(ShapeGrammarParser.Atom_expContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShapeGrammarParser#atom_exp}.
	 * @param ctx the parse tree
	 */
	void exitAtom_exp(ShapeGrammarParser.Atom_expContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShapeGrammarParser#object_identifier}.
	 * @param ctx the parse tree
	 */
	void enterObject_identifier(ShapeGrammarParser.Object_identifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShapeGrammarParser#object_identifier}.
	 * @param ctx the parse tree
	 */
	void exitObject_identifier(ShapeGrammarParser.Object_identifierContext ctx);
}