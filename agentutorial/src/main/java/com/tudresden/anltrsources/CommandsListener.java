// Generated from Commands.g4 by ANTLR 4.4

  package com.tudresden.anltrsources;
  import com.tudresden.basicagents.Direction;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CommandsParser}.
 */
public interface CommandsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CommandsParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(@NotNull CommandsParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link CommandsParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(@NotNull CommandsParser.CommandContext ctx);
}