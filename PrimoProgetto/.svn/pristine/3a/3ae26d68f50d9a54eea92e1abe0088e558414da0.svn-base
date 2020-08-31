package threads;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class EsempiThread {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		Runnable codiceDaEseguire = () -> {
			System.out.println(Thread.currentThread().getName() + ": nuovo thread!");
		};
		
		Thread t = new Thread( codiceDaEseguire );  // creo un thread in stato iniziale
		
		
		t.start(); // avvia l'esecuzione del thread
		
		Thread mainThread = Thread.currentThread();
		System.out.println(mainThread.getName() + " : hello!");

		System.out.println("Sono disponibili " + 
		Runtime.getRuntime().availableProcessors() + " core");
		//---------
		int x = 1;
		Runnable conteggio = () -> {
			String name = Thread.currentThread().getName();
			for(int i=0; i<20; ++i) {
				System.out.println(name + " : " + i);
			}
		};
		
		Thread t1 = new Thread(conteggio, "T1");
		Thread t2 = new Thread(conteggio, "\tT2");
		
		t1.start(); t2.start();
		
		// --------- Executors -----------
		
		ExecutorService e = Executors.newFixedThreadPool(4);
		
		e.submit(conteggio);
		e.submit(conteggio);
		e.submit(conteggio);
		
		
		Callable<Integer> somma = ()->{
			int sum=0;
			for(int i=0; i<100; ++i) {
				sum+=i;
			}
			return sum;
		};
		
		e.shutdown();
		
		e = Executors.newCachedThreadPool();
		
		Future<Integer> risultato = e.submit(somma);
		
		while( ! risultato.isDone() ) {
			System.out.println("In attesa....");
		}
		
		System.out.println("Risultato: " + risultato.get() );
		
		e.shutdown();
		
		e = Executors.newCachedThreadPool();

		LinkedList<Integer> esempio=new LinkedList<>();
		esempio.add(1);
		
		List<Integer> l = Collections.synchronizedList( new LinkedList<>() );
		Runnable aggiungiAList = () -> {
			for(int i=0; i<100; ++i) {
				l.add(i);
			}
		};
		// Race Condition
		
		e.submit(aggiungiAList);
		e.submit(aggiungiAList);
		e.submit(aggiungiAList);
		e.submit(aggiungiAList);
		
		e.shutdown();  // termina il servizio di esecuzione non appena
						// i task sono terminati
		e.awaitTermination(1, TimeUnit.MINUTES); // si blocca e aspetta che il servizio
												// sia terminato
		
		System.out.println("Lista size : " + l.size());
		System.out.println("Lista : " + l);
		
		// LinkedList non è "thread - safe"
		
	}

}
