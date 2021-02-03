// Generated from Commands.g4 by ANTLR 4.4

package com.tudresden.anltrsources;
import com.tudresden.basicagents.Direction;
import com.tudresden.basicagents.Game;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CommandsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__15=1, T__14=2, T__13=3, T__12=4, T__11=5, T__10=6, T__9=7, T__8=8, 
		T__7=9, T__6=10, T__5=11, T__4=12, T__3=13, T__2=14, T__1=15, T__0=16, 
		Word=17, Whitespace=18;
	public static final String[] tokenNames = {
		"<INVALID>", "'close'", "'unlock'", "'west'", "'inventory'", "'exit'", 
		"'look'", "'drop'", "'north'", "'get'", "'go'", "'open'", "'examine'", 
		"'east'", "'from'", "'lock'", "'south'", "Word", "Whitespace"
	};
	public static final int
		RULE_command = 0;
	public static final String[] ruleNames = {
		"command"
	};

	@Override
	public String getGrammarFileName() { return "Commands.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
	      throw new RuntimeException(e);
	    }

	public CommandsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class CommandContext extends ParserRuleContext {
		public Game game;
		public Token w1;
		public Token w2;
		public List<TerminalNode> Word() { return getTokens(CommandsParser.Word); }
		public TerminalNode EOF() { return getToken(CommandsParser.EOF, 0); }
		public TerminalNode Word(int i) {
			return getToken(CommandsParser.Word, i);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public CommandContext(ParserRuleContext parent, int invokingState, Game game) {
			super(parent, invokingState);
			this.game = game;
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).enterCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).exitCommand(this);
		}
	}

	public final CommandContext command(Game game) throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState(), game);
		enterRule(_localctx, 0, RULE_command);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			switch (_input.LA(1)) {
			case T__7:
				{
				setState(2); match(T__7);
				setState(3); ((CommandContext)_localctx).w1 = match(Word);
				setState(8);
				switch (_input.LA(1)) {
				case T__2:
					{
					setState(4); match(T__2);
					setState(5); ((CommandContext)_localctx).w2 = match(Word);
					game.getFrom((((CommandContext)_localctx).w1!=null?((CommandContext)_localctx).w1.getText():null), (((CommandContext)_localctx).w2!=null?((CommandContext)_localctx).w2.getText():null));
					}
					break;
				case EOF:
					{
					game.get((((CommandContext)_localctx).w1!=null?((CommandContext)_localctx).w1.getText():null));
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case T__4:
				{
				setState(10); match(T__4);
				setState(11); ((CommandContext)_localctx).w1 = match(Word);
				game.examine((((CommandContext)_localctx).w1!=null?((CommandContext)_localctx).w1.getText():null));
				}
				break;
			case T__9:
				{
				setState(13); match(T__9);
				setState(14); ((CommandContext)_localctx).w1 = match(Word);
				game.drop((((CommandContext)_localctx).w1!=null?((CommandContext)_localctx).w1.getText():null));
				}
				break;
			case T__10:
				{
				setState(16); match(T__10);
				game.look();
				}
				break;
			case T__12:
				{
				setState(18); match(T__12);
				game.inventory();
				}
				break;
			case T__5:
				{
				setState(20); match(T__5);
				setState(21); ((CommandContext)_localctx).w1 = match(Word);
				game.open((((CommandContext)_localctx).w1!=null?((CommandContext)_localctx).w1.getText():null));
				}
				break;
			case T__15:
				{
				setState(23); match(T__15);
				setState(24); ((CommandContext)_localctx).w1 = match(Word);
				game.close((((CommandContext)_localctx).w1!=null?((CommandContext)_localctx).w1.getText():null));
				}
				break;
			case T__14:
				{
				setState(26); match(T__14);
				setState(27); ((CommandContext)_localctx).w1 = match(Word);
				game.unlock((((CommandContext)_localctx).w1!=null?((CommandContext)_localctx).w1.getText():null));
				}
				break;
			case T__1:
				{
				setState(29); match(T__1);
				setState(30); ((CommandContext)_localctx).w1 = match(Word);
				game.lock((((CommandContext)_localctx).w1!=null?((CommandContext)_localctx).w1.getText():null));
				}
				break;
			case T__11:
				{
				setState(32); match(T__11);
				System.exit(0);
				}
				break;
			case T__6:
				{
				setState(34); match(T__6);
				setState(43);
				switch (_input.LA(1)) {
				case T__13:
					{
					setState(35); match(T__13);
					game.go(Direction.WEST);
					}
					break;
				case T__3:
					{
					setState(37); match(T__3);
					game.go(Direction.EAST);
					}
					break;
				case T__8:
					{
					setState(39); match(T__8);
					game.go(Direction.NORTH);
					}
					break;
				case T__0:
					{
					setState(41); match(T__0);
					game.go(Direction.SOUTH);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(47); match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\24\64\4\2\t\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\5\2\13\n\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\5\2.\n\2\5\2\60\n\2\3\2\3\2\3\2\2\2\3\2\2\2@"+
		"\2/\3\2\2\2\4\5\7\13\2\2\5\n\7\23\2\2\6\7\7\20\2\2\7\b\7\23\2\2\b\13\b"+
		"\2\1\2\t\13\b\2\1\2\n\6\3\2\2\2\n\t\3\2\2\2\13\60\3\2\2\2\f\r\7\16\2\2"+
		"\r\16\7\23\2\2\16\60\b\2\1\2\17\20\7\t\2\2\20\21\7\23\2\2\21\60\b\2\1"+
		"\2\22\23\7\b\2\2\23\60\b\2\1\2\24\25\7\6\2\2\25\60\b\2\1\2\26\27\7\r\2"+
		"\2\27\30\7\23\2\2\30\60\b\2\1\2\31\32\7\3\2\2\32\33\7\23\2\2\33\60\b\2"+
		"\1\2\34\35\7\4\2\2\35\36\7\23\2\2\36\60\b\2\1\2\37 \7\21\2\2 !\7\23\2"+
		"\2!\60\b\2\1\2\"#\7\7\2\2#\60\b\2\1\2$-\7\f\2\2%&\7\5\2\2&.\b\2\1\2\'"+
		"(\7\17\2\2(.\b\2\1\2)*\7\n\2\2*.\b\2\1\2+,\7\22\2\2,.\b\2\1\2-%\3\2\2"+
		"\2-\'\3\2\2\2-)\3\2\2\2-+\3\2\2\2.\60\3\2\2\2/\4\3\2\2\2/\f\3\2\2\2/\17"+
		"\3\2\2\2/\22\3\2\2\2/\24\3\2\2\2/\26\3\2\2\2/\31\3\2\2\2/\34\3\2\2\2/"+
		"\37\3\2\2\2/\"\3\2\2\2/$\3\2\2\2\60\61\3\2\2\2\61\62\7\2\2\3\62\3\3\2"+
		"\2\2\5\n-/";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}