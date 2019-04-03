package lab5;

//Taylor Palm and Tyler Harring

import java.util.Stack;

public class StackExercise {

	/*
	 * Given an expression string exp,
	 *  write a program to examine whether the pairs and 
	 *  the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp. 
	 *  For example, the program should print true for exp = “[()]{}{[()()]()}” 
	 *  and false for exp = “[(])” 
	 */
	/**
	 * 
	 * @param str 
	 * @return  true if balanced
	 */
	public static boolean isBalancedParentheses(String str)
	{
		Stack<Character> stk= new Stack<>();
		
		for(int i=0; i<str.length(); i++) {
			
			if(str.charAt(i)=='(') {
				if(stk.peek()==')') {
					stk.pop();
					
				}
				else
				{stk.push(str.charAt(i));}}
				
			
			else if(str.charAt(i)==')'){
					if(stk.peek()=='(') {
						stk.pop();
					}
					else
					{stk.push(str.charAt(i));}}
					
		}
			
			/*if(stk.isEmpty()) {
				stk.push(str.charAt(i));
			}
			
			else if((str.charAt(i)=='[' && stk.peek()==']')||
					(str.charAt(i)==']' && stk.peek()=='[')||
					(str.charAt(i)=='{' && stk.peek()=='}')||
					(str.charAt(i)=='}' && stk.peek()=='{')||
					(str.charAt(i)=='(' && stk.peek()==')')||
					(str.charAt(i)==')' && stk.peek()=='(')){
				
						stk.pop();}
			else
				{stk.push(str.charAt(i));}}*/
			
		
		return stk.isEmpty(); 
	}
	
	
	
	/* This function evaluates "postfix" expressions (also called "Reverse Polish 
	 * Notation"), which are mathematical expressions but with the operators placed
	 * after operands instead of between.
	 * For example: 1 + 2 * 3 + 4  is written as 1 2 3 * + 4 + 
	 */
	/**
	 * 
	 * @param str
	 * @return the result of postfix expression
	 */
	
	public static int postfixEvaluate(String exp) {

		int value1, value2;
		Stack<Integer> stk = new Stack<>();
		
		for(int i=0; i<exp.length(); i++) {
			
			if(StackExercise.isANumber(exp.charAt(i))) {
				stk.push(Character.getNumericValue(exp.charAt(i)));}
			
			else {
				switch(exp.charAt(i)) {
				
					case '*': stk.push(stk.pop() * stk.pop());
						break;
						
					case '/': 
						value1=stk.pop();
						value2=stk.pop();
						stk.push(value2/value1);
						break;
					case '+': stk.push(stk.pop() + stk.pop());
						break;
						
					case '-': stk.push(-stk.pop() + stk.pop());
						break;
				}}}

		return stk.pop();
		
}
	
	
	/* =========================== The following exercises for 5% extra credits ================== */
	
	/*
	 *  Reads in an infix expression and outputs an equivalent postfix
	 *  expression.
	 *  % java Infix
	 *  A + B * C + D
	 *   ==> ToPostfix
	 *  A B C * + D +
	 *
	 *  % java Infix
	 *  (A + B) * (C + D)
	 *  ==> ToPostfix 
	 *  A B + C D + *
	 */
	
	/**
	 * This function converts given infix expression to postfix expression. You can assume
	 * the operands are single digits and possible operators are +, -, *, /
	 * @param str - infix
	 * @return postfix  
	 */
	public static String infixToPostfix(String str) 
	{
		StringBuilder postFix= new StringBuilder();
		
		Stack<Character> operatorStack= new Stack<>();
		
		char lastOperator, peekForParantheses;
		
		for(int i=0; i<str.length(); i++){
			
			//Add all numbers to stringbuilder
			
			if(StackExercise.isANumber(str.charAt(i))){
				postFix.append(str.charAt(i));}
			
			else  {
				
				//If the stack of operators is empty, add it to the stack
				if(operatorStack.isEmpty()) {
					operatorStack.push(str.charAt(i));		
					}
					
				else {
					//Look at the top of the stack
					lastOperator= operatorStack.peek();
						
					//If the current operator is not a closing parantheses and if 
					//it should be calculated before the last, push it on the stack
					if(StackExercise.PEMDAS(str.charAt(i))>StackExercise.PEMDAS(lastOperator)
					   && str.charAt(i)!=')') {
							operatorStack.push(str.charAt(i));}
						
					else {
						
						//If the last operator was (, push the current operator on the stack
						if(lastOperator=='(') {
							operatorStack.push(str.charAt(i));}
							
						//If the current operator is ), pop off all operators to postfix until ( is reached
						else if(str.charAt(i)==')') {
							peekForParantheses=operatorStack.peek();
								
							while(peekForParantheses!='(') {
								
								postFix.append(operatorStack.pop());
								peekForParantheses=operatorStack.peek();}
								
								operatorStack.pop();}
							
						//Otherwise, add the top of the stack to post fix, 
						//and add the current operator to the stack	
						else {
							postFix.append(operatorStack.pop());
							postFix.append(str.charAt(i));}
												
						}}}}
			//Finally, append any remaining operators in the stack to postfix
			while(!operatorStack.isEmpty()) {
				postFix.append(operatorStack.pop());
			}
			
		return postFix.toString();
	}

public static boolean isANumber(char character) {

	Character [] numbers= {'0','1','2','3','4','5','6','7','8','9'};
	
	for(int i=0; i<numbers.length; i++)
	{
			if(character==numbers[i]) {
				return true;}
	}
	
		return false;}


public static int PEMDAS(char character) {

	if(character=='(' || character==')') {
		return 3;}
	
	else if(character=='*' || character=='/') {
		return 2;}
	
	else// if character=='+' or '-'
		return 1;
}

}