// Generated from Commands.g4 by ANTLR 4.4

package com.tudresden.anltrsources;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CommandsLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__15=1, T__14=2, T__13=3, T__12=4, T__11=5, T__10=6, T__9=7, T__8=8, 
		T__7=9, T__6=10, T__5=11, T__4=12, T__3=13, T__2=14, T__1=15, T__0=16, 
		Word=17, Whitespace=18;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'"
	};
	public static final String[] ruleNames = {
		"T__15", "T__14", "T__13", "T__12", "T__11", "T__10", "T__9", "T__8", 
		"T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "Word", 
		"Letter", "Whitespace"
	};


	    public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
	      throw new RuntimeException(e);
	    }


	public CommandsLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Commands.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\24\u0093\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22"+
		"\7\22\u0086\n\22\f\22\16\22\u0089\13\22\3\23\3\23\3\24\6\24\u008e\n\24"+
		"\r\24\16\24\u008f\3\24\3\24\2\2\25\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\2\'\24\3\2\4\4\2C\\"+
		"c|\5\2\13\13\16\16\"\"\u0093\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2\'\3\2\2\2\3)\3\2\2\2\5/\3\2\2\2\7\66"+
		"\3\2\2\2\t;\3\2\2\2\13E\3\2\2\2\rJ\3\2\2\2\17O\3\2\2\2\21T\3\2\2\2\23"+
		"Z\3\2\2\2\25^\3\2\2\2\27a\3\2\2\2\31f\3\2\2\2\33n\3\2\2\2\35s\3\2\2\2"+
		"\37x\3\2\2\2!}\3\2\2\2#\u0083\3\2\2\2%\u008a\3\2\2\2\'\u008d\3\2\2\2)"+
		"*\7e\2\2*+\7n\2\2+,\7q\2\2,-\7u\2\2-.\7g\2\2.\4\3\2\2\2/\60\7w\2\2\60"+
		"\61\7p\2\2\61\62\7n\2\2\62\63\7q\2\2\63\64\7e\2\2\64\65\7m\2\2\65\6\3"+
		"\2\2\2\66\67\7y\2\2\678\7g\2\289\7u\2\29:\7v\2\2:\b\3\2\2\2;<\7k\2\2<"+
		"=\7p\2\2=>\7x\2\2>?\7g\2\2?@\7p\2\2@A\7v\2\2AB\7q\2\2BC\7t\2\2CD\7{\2"+
		"\2D\n\3\2\2\2EF\7g\2\2FG\7z\2\2GH\7k\2\2HI\7v\2\2I\f\3\2\2\2JK\7n\2\2"+
		"KL\7q\2\2LM\7q\2\2MN\7m\2\2N\16\3\2\2\2OP\7f\2\2PQ\7t\2\2QR\7q\2\2RS\7"+
		"r\2\2S\20\3\2\2\2TU\7p\2\2UV\7q\2\2VW\7t\2\2WX\7v\2\2XY\7j\2\2Y\22\3\2"+
		"\2\2Z[\7i\2\2[\\\7g\2\2\\]\7v\2\2]\24\3\2\2\2^_\7i\2\2_`\7q\2\2`\26\3"+
		"\2\2\2ab\7q\2\2bc\7r\2\2cd\7g\2\2de\7p\2\2e\30\3\2\2\2fg\7g\2\2gh\7z\2"+
		"\2hi\7c\2\2ij\7o\2\2jk\7k\2\2kl\7p\2\2lm\7g\2\2m\32\3\2\2\2no\7g\2\2o"+
		"p\7c\2\2pq\7u\2\2qr\7v\2\2r\34\3\2\2\2st\7h\2\2tu\7t\2\2uv\7q\2\2vw\7"+
		"o\2\2w\36\3\2\2\2xy\7n\2\2yz\7q\2\2z{\7e\2\2{|\7m\2\2| \3\2\2\2}~\7u\2"+
		"\2~\177\7q\2\2\177\u0080\7w\2\2\u0080\u0081\7v\2\2\u0081\u0082\7j\2\2"+
		"\u0082\"\3\2\2\2\u0083\u0087\5%\23\2\u0084\u0086\5%\23\2\u0085\u0084\3"+
		"\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088"+
		"$\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008b\t\2\2\2\u008b&\3\2\2\2\u008c"+
		"\u008e\t\3\2\2\u008d\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u008d\3\2"+
		"\2\2\u008f\u0090\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\b\24\2\2\u0092"+
		"(\3\2\2\2\5\2\u0087\u008f\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}