package com.tu_dresden.blockchain;
import java.math.BigInteger;

import org.ethereum.core.Block;
import org.ethereum.facade.Ethereum;
import org.ethereum.facade.EthereumFactory;


public class ConnectionEthereumJ {
	private Ethereum ethereum;
	
	public void start() 
	{
		this.ethereum = EthereumFactory.createEthereum();
		this.ethereum.addListener(new EthereumListener(ethereum));
		
	}
	
	public Block getLastBlock() 
	{
		return this.ethereum.getBlockchain().getBestBlock();
	}
	
	public BigInteger getTotalDifficulty()
	{
		return this.ethereum.getBlockchain().getTotalDifficulty();
	}
}
