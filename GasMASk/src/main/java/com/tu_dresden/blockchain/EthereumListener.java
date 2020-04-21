package com.tu_dresden.blockchain;

import java.math.BigInteger;
import java.util.List;

import org.ethereum.core.Block;
import org.ethereum.core.TransactionReceipt;
import org.ethereum.facade.Ethereum;
import org.ethereum.listener.EthereumListenerAdapter;
import org.ethereum.util.BIUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EthereumListener extends EthereumListenerAdapter {

	private Logger logger = LoggerFactory.getLogger(EthereumListener.class.getName());
	private Ethereum ethereum;
	private boolean syncStatus = false;
	private static final int unknownVariable = 100;
	
	private String calculateHashRate(Block block) 
	{
		String response = "Net hash rate not available";
		long timeDelta = 0;

		if(block.getNumber() > unknownVariable)
		{
			for(int i = 0; i < unknownVariable; i++)
			{
				Block parent = ethereum.getBlockchain().getBlockByHash(block.getParentHash());
				timeDelta += Math.abs(block.getTimestamp() - parent.getTimestamp());
			}
		}
		// We might have a problem here.
        response = String.valueOf(block
                .getDifficultyBI()
                .divide(BIUtil.toBI(timeDelta / unknownVariable))
                .divide(new BigInteger("1000000000"))
                .doubleValue()) + " GH/s";
        
        return response;
	}
	
	public EthereumListener(Ethereum ethereum)
	{
		this.ethereum = ethereum;
	}
	
	public void onBlock(Block block, List<TransactionReceipt> receipts)
	{
		if(syncStatus)
		{
			logger.info("Net hash rate: " + calculateHashRate(block));
			logger.info("Block Difficulty: " + block.getDifficultyBI().toString());
			logger.info("Block Transactions: " + block.getTransactionsList().toString());
			logger.info("Last Block of the chain: " + ethereum.getBlockchain().getTotalDifficulty());
			
		}
	}
	
	public void onSyncStatus(SyncState state)
	{
		logger.info("This function gives information regarding synchronization process of the blockchain");
		if(!syncStatus)
		{
			logger.info("Sync DONE");
			syncStatus = true;
		}
	}
	
	
}
