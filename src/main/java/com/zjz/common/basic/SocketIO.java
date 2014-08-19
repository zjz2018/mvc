package com.zjz.common.basic;

import java.io.IOException;
import java.nio.channels.SocketChannel;

public class SocketIO {
	public static void main(String[] args) throws IOException {
		SocketChannel channel = SocketChannel.open();
		channel.configureBlocking(false);//设置非阻塞方式
		System.out.println(Integer.MAX_VALUE+100);//-2147483549
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MAX_VALUE>2147483647);
		
	}
	
}
