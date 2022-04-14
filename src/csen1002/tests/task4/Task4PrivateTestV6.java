package csen1002.tests.task4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import csen1002.main.task4.FDFA;

public class Task4PrivateTestV6 {

	////////// 1st FDFA///////////////
	@Test
	@Timeout(5)
	public void testFDFA1T1() {
		FDFA fdfa1 = new FDFA("0,1,3,N;1,2,3,O;2,5,2,P;3,6,4,A;4,4,3,Q;5,6,4,B;6,6,6,R#3,5");
		assertEquals(fdfa1.run("000000000000"), "000,B;000,B;000,B;000,B;");
	}

	@Test
	@Timeout(5)
	public void testFDFA1T2() {
		FDFA fdfa1 = new FDFA("0,1,3,N;1,2,3,O;2,5,2,P;3,6,4,A;4,4,3,Q;5,6,4,B;6,6,6,R#3,5");
		assertEquals(fdfa1.run("100111"), "1,A;00111,P;");
	}

	@Test
	@Timeout(5)
	public void testFDFA1T3() {
		FDFA fdfa1 = new FDFA("0,1,3,N;1,2,3,O;2,5,2,P;3,6,4,A;4,4,3,Q;5,6,4,B;6,6,6,R#3,5");
		assertEquals(fdfa1.run("0"), "0,O;");
	}

	@Test
	@Timeout(5)
	public void testFDFA1T4() {
		FDFA fdfa1 = new FDFA("0,1,3,N;1,2,3,O;2,5,2,P;3,6,4,A;4,4,3,Q;5,6,4,B;6,6,6,R#3,5");
		assertEquals(fdfa1.run("1111000"), "111,A;1,A;000,B;");
	}

	@Test
	@Timeout(5)
	public void testFDFA1T5() {
		FDFA fdfa1 = new FDFA("0,1,3,N;1,2,3,O;2,5,2,P;3,6,4,A;4,4,3,Q;5,6,4,B;6,6,6,R#3,5");
		assertEquals(fdfa1.run("001111"), "001111,P;");

	}

	////////// 2nd FDFA///////////////
	@Test
	@Timeout(5)
	public void testFDFA2T1() {
		FDFA fdfa2 = new FDFA("0,3,1,N;1,2,1,O;2,5,2,A;3,3,4,P;4,4,5,Q;5,1,2,R#2");
		assertEquals(fdfa2.run("1110111010"), "111011101,A;0,P;");
	}

	@Test
	@Timeout(5)
	public void testFDFA2T2() {
		FDFA fdfa2 = new FDFA("0,3,1,N;1,2,1,O;2,5,2,A;3,3,4,P;4,4,5,Q;5,1,2,R#2");
		assertEquals(fdfa2.run("001010"), "001010,O;");
	}

	@Test
	@Timeout(5)
	public void testFDFA2T3() {
		FDFA fdfa2 = new FDFA("0,3,1,N;1,2,1,O;2,5,2,A;3,3,4,P;4,4,5,Q;5,1,2,R#2");
		assertEquals(fdfa2.run("001001"), "001001,R;");
	}

	@Test
	@Timeout(5)
	public void testFDFA2T4() {
		FDFA fdfa2 = new FDFA("0,3,1,N;1,2,1,O;2,5,2,A;3,3,4,P;4,4,5,Q;5,1,2,R#2");
		assertEquals(fdfa2.run("001000"), "001000,Q;");
	}

	@Test
	@Timeout(5)
	public void testFDFA2T5() {
		FDFA fdfa2 = new FDFA("0,3,1,N;1,2,1,O;2,5,2,A;3,3,4,P;4,4,5,Q;5,1,2,R#2");
		assertEquals(fdfa2.run("1101010001"), "1101010001,A;");

	}

}