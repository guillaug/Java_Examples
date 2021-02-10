package com.tudresden.basicagents;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

import com.tudresden.anltrsources.*;

public class UI {
	private static JTextField commandField = new JTextField();
	private static JTextArea display = new JTextArea();
//	private static Game game = new Game((message, text) -> {
//		display.setText(message + "\n\n" + text);
////		display.setText(text);
//	});
	
	@SuppressWarnings("serial")
	public static void main(String[] args) {
		new JFrame() {{
			setLayout(new BorderLayout(5,5));
			add(new JPanel(new BorderLayout(5,5)) {{
				add(new JLabel("Command: "), BorderLayout.WEST);
				add(commandField, BorderLayout.CENTER);
			}}, BorderLayout.NORTH);
			add(display, BorderLayout.CENTER);
			setSize(600, 300);
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			setVisible(true);
			commandField.addActionListener(event -> {
				parseCommand(commandField.getText());
				commandField.setText("");
			});
		}};
	}
	
	
	private static ANTLRErrorListener listener = new ANTLRErrorListener() {
		@Override
		public void syntaxError(Recognizer<?, ?> arg0, Object arg1, int arg2, int arg3, String arg4, RecognitionException arg5) {
			throw new RuntimeException("I don't know what " + arg4 + " means");
		}
		
		@Override
		public void reportContextSensitivity(Parser arg0, DFA arg1, int arg2, int arg3, int arg4, ATNConfigSet arg5) {
			throw new RuntimeException();
		}
		
		@Override
		public void reportAttemptingFullContext(Parser arg0, DFA arg1, int arg2, int arg3, java.util.BitSet arg4, ATNConfigSet arg5) {
			throw new RuntimeException();
		}
		
		@Override
		public void reportAmbiguity(Parser arg0, DFA arg1, int arg2, int arg3, boolean arg4, java.util.BitSet arg5, ATNConfigSet arg6) {
			throw new RuntimeException();
		}
	};

	private static void parseCommand(String command) {
		CodePointCharStream inputStream = CharStreams.fromString(command);
		CommandsLexer lexer = new CommandsLexer(inputStream);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		CommandsParser parser = new CommandsParser(tokenStream);
		try {
			lexer.addErrorListener(listener);
			parser.addErrorListener(listener);
			parser.command(game);
		} catch (RecognitionException e) {
			game.report(command, "Command not recognized; try again");
		} catch (RuntimeException e) {
			game.report(command, "Command " + command + " not recognized; try again");
		}

	}
}
