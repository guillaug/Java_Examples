package com.tu_dresden.blockchain;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;
import org.web3j.utils.Convert.Unit;
import org.web3j.utils.Numeric;
//Logger library
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ConnectionWeb3 {
	
	private static final Logger logger = LoggerFactory.getLogger(ConnectionWeb3.class.getName());
	private static Web3j web3_instance = null;
	
	public static Web3j getInstance() {
		if(web3_instance == null) {
			web3_instance = Web3j.build(new HttpService("http://localhost:8545"));
		}
		return web3_instance;
	}
    public static boolean connectionWeb3js() throws InterruptedException, ExecutionException {
    	try {
    		  
        	  Web3j web3 = ConnectionWeb3.getInstance(); 
        	  if(web3 == null) throw new IllegalArgumentException();
        	  System.out.println("Successfuly connected to Ethereum local node");

    	      // web3_clientVersion returns the current client version.
    	      Web3ClientVersion clientVersion = web3.web3ClientVersion().send();
    	      
    	      // for async call, you can use the following
    	      Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().sendAsync().get();


    	      // eth_blockNumber returns the number of most recent block.
    	      EthBlockNumber blockNumber = web3.ethBlockNumber().send();

    	      // eth_gasPrice, returns the current price per gas in wei.
    	      EthGasPrice gasPrice = web3.ethGasPrice().send();    	
    	      
    	      logger.info("Client version: " + clientVersion.getWeb3ClientVersion());
    	      logger.info("Block number: " + blockNumber.getBlockNumber());
    	      logger.info("Gas price: " + gasPrice.getGasPrice());
    	    } 
    	catch(IOException ex) {
    		throw new RuntimeException("Error whilst sending json-rpc requests", ex);
    	}
	   return true;
    }
    
    public static boolean makeTransaction() throws IOException, InterruptedException {
    	try {
        	Web3j web3 = ConnectionWeb3.getInstance();
        	String privateKey = "0x7e6e330c8ed14842de16eb5d7e248f7161875aa78770c38b8f686e2152dac51e";
        	Credentials credentials = Credentials.create(privateKey);
        	logger.info("Account address: " + credentials.getAddress() );
        	logger.info("Balance: " + Convert.fromWei(web3.ethGetBalance(credentials.getAddress(), 
        										DefaultBlockParameterName.LATEST).send().getBalance().toString(), 
        										Unit.ETHER));
        	
        	// Get the latest nonce
        	EthGetTransactionCount ethGetTransactionCount = web3.ethGetTransactionCount(credentials.getAddress(), DefaultBlockParameterName.LATEST)
        																				.send();
            BigInteger nonce =  ethGetTransactionCount.getTransactionCount();

            // Recipient address
            // Find a way to convert automatically
            String recipientAddress = "0x010765d1541A6dB273ef8Ee0f6351e1a9530d04C";

            // Value to transfer (in wei)
            BigInteger value = Convert.toWei("1", Unit.ETHER).toBigInteger();

            // Gas Parameters
            BigInteger gasLimit = BigInteger.valueOf(21000);
            BigInteger gasPrice = Convert.toWei("1", Unit.GWEI).toBigInteger();
            // Use whole big integer values
            RawTransaction rawTransaction  = RawTransaction.createEtherTransaction(
                    nonce,
                    gasPrice,
                    gasLimit,
                    recipientAddress,
                    value);
            byte[] signedMessage = TransactionEncoder.signMessage(rawTransaction, credentials);
            String hexValue = Numeric.toHexString(signedMessage);
            
            EthSendTransaction ethSendTransaction = web3.ethSendRawTransaction(hexValue).send();
            String transactionHash = ethSendTransaction.getTransactionHash();
            logger.info("transactionHash: " + transactionHash);
            
            //Waiting for a transaction has been mined
            Optional<TransactionReceipt> transactionReceipt = null;
            do {
            	logger.info("This transaction hash has been mined: " + transactionHash);
                EthGetTransactionReceipt ethGetTransactionReceiptResp = web3.ethGetTransactionReceipt(transactionHash).send();
            	transactionReceipt = ethGetTransactionReceiptResp.getTransactionReceipt();
                Thread.sleep(3000); // Put a sleeping thread
            } while(!transactionReceipt.isPresent());
    	}
    	catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
    	return true;
    }
}
