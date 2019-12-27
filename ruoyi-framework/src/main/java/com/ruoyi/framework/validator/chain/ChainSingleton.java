package com.ruoyi.framework.validator.chain;

import java.util.Arrays;
import java.util.List;

public class ChainSingleton {
	
	private static ChainSingleton instance;
	
	private final static List<BaseChain> chainList = Arrays.asList(
			new ObjectChain(),
			new ArrayChain(),
			new CollectionChain(),
			new MapChain(),
			new FiledChain()
			);
	
	private ChainSingleton(){
		
	}
	
	static {
		instance  = new ChainSingleton();
	}
	
	public static ChainSingleton getInstance(){
		return instance;
	}
	
	public static List<BaseChain> getChainList(){
		return chainList;
	}
}

