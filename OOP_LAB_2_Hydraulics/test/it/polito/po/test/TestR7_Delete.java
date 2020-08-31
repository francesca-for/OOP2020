package it.polito.po.test;

import hydraulic.*;
import static org.junit.Assert.*;
import org.junit.Test;


public class TestR7_Delete {

	@Test
	public void testSimpleElementRemove(){
		HSystemExt s = new HSystemExt();
		Source src = new Source("Src");		
		Tap tap = new Tap("Tap");		
		Sink sink = new Sink("Sink");		
		s.addElement(src);
		s.addElement(tap);
		s.addElement(sink);
		
		src.connect(tap);
		tap.connect(sink);
		
		s.deleteElement("Tap");
		
		assertEquals("Wrong number of elements after delete",2,s.getElements().length);
	}
	
	@Test
	public void testSimpleElementsRelink(){
		HSystemExt s = new HSystemExt();
		Source src = new Source("Src");		
		Tap tap = new Tap("Tap");		
		Sink sink = new Sink("Sink");		
		s.addElement(src);
		s.addElement(tap);
		s.addElement(sink);
		
		src.connect(tap);
		tap.connect(sink);
		
		s.deleteElement("Tap");
		
		assertSame("Output not fixed after delete",sink,src.getOutput());
	}
	
	@Test
	public void testWithSplit(){
		HSystemExt s = new HSystemExt();
		Source src = new Source("Src");
		Tap tap = new Tap("Tap");
		Split t = new Split("T");
		Element sink1 = new Sink("Sink 1");		
		Element sink2 = new Sink("Sink 2");		
		s.addElement(src);
		s.addElement(tap);
		s.addElement(t);
		s.addElement(sink1);
		s.addElement(sink2);
		
		src.connect(tap);
		tap.connect(t);
		t.connect(sink1,0);
		t.connect(sink2,1);
		
		s.deleteElement("Tap");
		
		assertEquals("Wrong number of elements after delete",4,s.getElements().length);
		assertSame("Output not fixed after delete",t,src.getOutput());

	}
}
