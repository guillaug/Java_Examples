package com.tudresden.springapp.JEthereumSamples;

import com.u7.jthereum.types.*;
import static com.u7.jthereum.Jthereum.*;

import com.u7.jthereum.annotations.View;
//import com.u7.jthereum.annotations.Constant;

import static com.u7.jthereum.ContractStaticImports.*; //@deprecated SolidityStaticImport


public class SelfDestruct {
	// The selfdestruct functions is provided by Ethereum smart contracts to deploy
	// a contract
	// on the blockchain system. Using selfdestruct function enables developers to
	// remove smart contracts(SC)
	// from Ethereum and transfers Ethers when emergency situation happen, e.g.
	// being attacked.

	AddressPayable creator; //For Ethereum transfer
	
	Uint iteration; 

	public static void main(String[] args) {
		compileAndDeploy();
		final SelfDestruct varSelf = createProxy(SelfDestruct.class);
		varSelf.incrementValue();
		
	}
	
	public SelfDestruct() {
		creator = msg.sender;
		iteration = Uint.ZERO;
	}
	
	public void incrementValue()
	{
		iteration.increment();
	}
	
	@View
//	@Constant
	public Uint getIteration() {
		return iteration; 
	}
	
	//Standard kill function for recovery
	public void kill()
	{
		if(msg.sender.equals(creator)) {
			selfdestruct(creator);
		}
	}

}
