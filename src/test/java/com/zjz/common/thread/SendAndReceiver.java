package com.zjz.common.thread;

import java.util.concurrent.Exchanger;

public class SendAndReceiver{
   private final Exchanger<StringBuilder> exchanger = new Exchanger<StringBuilder>();
   private class Sender implements Runnable{
      @Override
	public void run(){
         try{
            StringBuilder content = new StringBuilder("Hello");
            content = exchanger.exchange(content);
         }catch(InterruptedException e){
            Thread.currentThread().interrupt();
         }
      }
   }
   private class Receiver implements Runnable{
      @Override
	public void run(){
         try{
            StringBuilder content = new StringBuilder("World");
            content = exchanger.exchange(content);
         }catch(InterruptedException e){
            Thread.currentThread().interrupt();
         }
      }
   }
   public void exchange(){
      new Thread(new Sender()).start();
      new Thread(new Receiver()).start();
      //System.out.println(exchanger.);
   }
}