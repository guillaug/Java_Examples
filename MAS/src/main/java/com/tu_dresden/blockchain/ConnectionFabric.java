package com.tu_dresden.blockchain;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeoutException;

import org.hyperledger.fabric.gateway.Contract;
import org.hyperledger.fabric.gateway.ContractException;
import org.hyperledger.fabric.gateway.Gateway;
import org.hyperledger.fabric.gateway.Network;
import org.hyperledger.fabric.gateway.Wallet;
import org.hyperledger.fabric.gateway.Wallets;


public class ConnectionFabric {
	
	public static boolean ConnectFabric() throws IOException, ContractException, TimeoutException, InterruptedException {
		Path walletDirectory = Paths.get("wallet");
		Wallet wallet = Wallets.newFileSystemWallet(walletDirectory);
		
		//Path to a common connection profile describing the network
		Path networkConfigFile = Paths.get("connection.json");
		
		//Configure the gateway connection used to access the network.
		Gateway.Builder builder = Gateway.createBuilder();
		
		//Create a gateway connection
		try (Gateway gateway = builder.connect()) {
			//Obtain a smart contract deployed on the network
			Network network = gateway.getNetwork("mychannel");
			Contract contract = network.getContract("fabcar");
			
			//Submit transactions that store state to the ledger
			byte[] createCarResult = contract.createTransaction("createCar")
					.submit("CAR10", "VW", "Polo", "Grey", "Mary");
			System.out.println(new String(createCarResult, StandardCharsets.UTF_8));
			
			//Evaluate transactions that query state from the ledger.
			byte[] queryAllCarsResult = contract.evaluateTransaction("queryAllCars");
			System.out.println(new String(queryAllCarsResult, StandardCharsets.UTF_8));
			return true;
		} catch(ContractException | TimeoutException | InterruptedException e) {
			e.printStackTrace();
			return false;
		}
	}
}
