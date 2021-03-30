package com.tudresden.springapp.JEthereumSamples;

import com.u7.jthereum.annotations.*;
import com.u7.jthereum.types.*;

import static com.u7.jthereum.Jthereum.*;
import static com.u7.jthereum.ContractStaticImports.*; //@deprecated SolidityStaticImport

/**
 * Hello world!
 *
 */
public class App {

	String greeting = "Role1";
	Address owner;

	public App() {
		owner = msg.sender;
	}

	@View
	public void onlyOwner() {
		require(isOwner(), "Only owner role can change this!");
	}

	@View
	public boolean isOwner() {
		return msg.sender.equals(owner);
	}

	public void setGreeting(String _newGreeting) {
		onlyOwner();

		greeting = _newGreeting;
	}

	@View
	public String sayHello() {
		if (isOwner()) {
			return "Hey";
		} else {
			return greeting;

		}
	}

	int value;

	public void setValue(final int newValue) {
		value = newValue;
	}

	@View
	public int getValue() {
		return value;
	}

	public static void main(String[] args) {
		System.out.println("Hello World!");
		greetingContract();

	}

	public static void greetingContract() {
		compileAndDeploy();

		final App app = createProxy(App.class); // Class loader

		p("message: " + app.sayHello());

		app.setGreeting("Here generated Contract");

		p("message: " + app.sayHello());

	}

	public static void initialContract() {
		compileAndDeploy();

		final App a = (App) createProxy();

		a.setValue(7);

		final int valueSecond = a.value;

		p("This is the second value: " + valueSecond);

	}

}
