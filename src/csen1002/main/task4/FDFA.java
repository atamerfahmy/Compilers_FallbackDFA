package csen1002.main.task4;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Write your info here
 * 
 * @name Ahmed Tamer
 * @id 43-2117
 * @labNumber 11
 */

public class FDFA {
	/**
	 * FDFA constructor
	 * 
	 * @param description is the string describing a FDFA
	 */
	ArrayList<State> DFAStates;
	State currentState;
	Stack<String> stack;
	
	public FDFA(String description) {
		// TODO Write Your Code Here
		String[] parts = description.split("#");
		String statesTransitions = parts[0];
		String acceptStates = parts[1];

		String[] statesData = statesTransitions.split(";");
		String[] acceptStatesData = acceptStates.split(",");
		
		boolean[] isAcceptState = new boolean[statesData.length];

		for (String x : acceptStatesData) {
			isAcceptState[Integer.parseInt(x)] = true;
		}
		
		ArrayList<State> states = new ArrayList<State>();

		for (String x : statesData) {
			String[] stateTransData = x.split(",");
			State state = new State(Integer.parseInt(stateTransData[0]), Integer.parseInt(stateTransData[1]),
					Integer.parseInt(stateTransData[2]), isAcceptState[Integer.parseInt(stateTransData[0])], stateTransData[3]);
			states.add(state);
		}

		this.DFAStates = states;
		this.currentState = states.get(0);
		this.stack = new Stack<String>();
	}

	/**
	 * Returns a string of actions.
	 * 
	 * @param input is the string to simulate by the FDFA.
	 * @return string of actions.
	 */
	public String run(String input) {
		// TODO Write Your Code Here
		
		Stack<State> stack = new Stack<State>();
		stack.push(DFAStates.get(0));
		
		String result = "";
		int r = 0;
		int l = 0;
		for (int i = 0; i < input.length(); i++) {
			int x = Integer.parseInt("" + input.charAt(i));
			int transition;
			
			if (x == 0) {
				transition = this.currentState.getZeroTransition();
			} else {
				transition = this.currentState.getOneTransition();
			}
			
			this.currentState = this.DFAStates.get(transition);
			stack.push(this.DFAStates.get(transition));
			l++;
		}
		
		State stackTop = stack.peek();

		String rest = input;
		
		while(l > r) {
			State popped = stack.pop();
			
			if(popped.isAcceptState()) {
				
				String acceptedString = null;

				if(l == input.length()) {
					acceptedString = input.substring(r);
					rest = "";
				} else {
					acceptedString = input.substring(r, l);
					rest = input.substring(l);
				}
				
				r = l;
				
				result += acceptedString + "," + popped.symbol + ";";				
				
				if(rest.length() == 0) {
					break;
				}else {
					stack = new Stack<State>();
					stack.push(this.DFAStates.get(0));
					
					this.currentState = this.DFAStates.get(0);

					for (int i = 0; i < rest.length(); i++) {
						int x = Integer.parseInt("" + rest.charAt(i));
						int transition;
						
						if (x == 0) {
							transition = this.currentState.getZeroTransition();
						} else {
							transition = this.currentState.getOneTransition();
						}
						
						this.currentState = this.DFAStates.get(transition);
						stack.push(this.DFAStates.get(transition));
						l++;
					}

					stackTop = stack.peek();
					
				}

			}else {
				l--;
			}	
		}
		
		if(l == r && rest.length() != 0) {
			result += rest + "," + stackTop.symbol + ";";
		}
		
		return result;
	}
	
	public static void main(String[] args) {
//		FDFA fdfa1 = new FDFA("0,1,0,N;1,1,2,O;2,3,1,P;3,3,4,Q;4,3,4,A#4");
//		System.out.println(fdfa1.run("101011"));
		
		FDFA fdfa1 = new FDFA("0,1,0,N;1,1,2,O;2,3,1,P;3,3,4,Q;4,3,4,A#4");
		System.out.println(fdfa1.run("10111"));
	}
}

class State {

	int stateNumber;
	int zeroTransition;
	int oneTransition;
	boolean isAcceptState;
	String symbol;

	public State(int stateNumber, int zeroTransition, int oneTransition, boolean isAcceptState, String symbol) {
		this.stateNumber = stateNumber;
		this.zeroTransition = zeroTransition;
		this.oneTransition = oneTransition;
		this.isAcceptState = isAcceptState;
		this.symbol = symbol;
	}

	public int getStateNumber() {
		return stateNumber;
	}

	public int getZeroTransition() {
		return zeroTransition;
	}

	public int getOneTransition() {
		return oneTransition;
	}

	public boolean isAcceptState() {
		return isAcceptState;
	}

}