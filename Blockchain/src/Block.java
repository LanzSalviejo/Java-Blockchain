// Program for creating blocks that make up the blockchain

import java.util.Date;

public class Block {

	public String hash; // Digital footprint of the block
	public String previousHash;
	private String data; // Contains message of the block
	private long timeStamp; // Contains timestamp for the block
	private int nonce;
	
	public Block(String data,String previousHash ) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		
		this.hash = calculateHash(); //Making sure we do this after we set the other values.
	}//Block constructor
	
	//Calculate new hash based on blocks contents
		public String calculateHash() {
			String calculatedhash = StringUtility.applySHA256( 
					previousHash +
					Long.toString(timeStamp) +
					Integer.toString(nonce) + 
					data 
					);
			return calculatedhash;
	}//calculateHash
	
	// Increases nonce value until hash target is reached
	public void mineBlock(int difficulty) {
		String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0" 
		while(!hash.substring( 0, difficulty).equals(target)) {
			nonce ++;
			hash = calculateHash();
		}//while
		System.out.println("Block Mined!!! : " + hash);
	}//mineBlock
	
}//Block
