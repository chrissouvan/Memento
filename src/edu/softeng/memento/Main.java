package edu.softeng.memento;

import java.util.Stack;

import edu.softeng.memento.calculator.Calculator;
import edu.softeng.memento.calculator.enums.CalculatorOperation;
import edu.softeng.memento.calculator.interfaces.CalculatorMementoInterface;

public class Main { //Caretaker
	public static void main(String[] args) {
		System.out.println("Basic computations...");
		basicComputations();
		
		System.out.println();
		System.out.println();
		
		System.out.println("Computations with undo...");
		computationsWithUndo();
	}
	
	private static void basicComputations() {
		System.out.println("Starting calculator with value 2.");
		Calculator calculator = new Calculator(2D);
		
		System.out.printf("Multiplying by 8 for value %.1f%n", calculator.performOperation(8D, CalculatorOperation.MULTIPLICATION));

		System.out.printf("Dividing by 4 for value %.1f%n", calculator.performOperation(4D, CalculatorOperation.DIVISION));

		System.out.printf("Adding 6 for value %.1f%n", calculator.performOperation(6D, CalculatorOperation.ADDITION));

		System.out.printf("Subtracting 3 for value %.1f%n", calculator.performOperation(3D, CalculatorOperation.SUBTRACTION));

		System.out.printf("Multiplying by 7 for value %.1f%n", calculator.performOperation(7D, CalculatorOperation.MULTIPLICATION));

		System.out.printf("Adding 1 for value %.1f%n", calculator.performOperation(1D, CalculatorOperation.ADDITION));

		System.out.printf("Dividing by 2 for value %.1f%n", calculator.performOperation(2D, CalculatorOperation.DIVISION));

		System.out.printf("Subtracting 5 for value %.1f%n", calculator.performOperation(5D, CalculatorOperation.SUBTRACTION));
	}
	
	private static void computationsWithUndo() {
		Stack<CalculatorMementoInterface> mementos = new Stack<CalculatorMementoInterface>();
		System.out.println("Starting calculator with value 2.");
		Calculator calculator = new Calculator(2D);
		
		System.out.printf("Multiplying by 8 for value %.1f%n", calculator.performOperation(8D, CalculatorOperation.MULTIPLICATION));
		mementos.push(calculator.createMemento());

		System.out.printf("Dividing by 4 for value %.1f%n", calculator.performOperation(4D, CalculatorOperation.DIVISION));
		mementos.push(calculator.createMemento());

		System.out.printf("Adding 6 for value %.1f%n", calculator.performOperation(6D, CalculatorOperation.ADDITION));
		
		System.out.printf("Undoing operation. Current result is %.1f%n", calculator.restoreFromMemento(mementos.pop()));
		mementos.push(calculator.createMemento());

		System.out.printf("Subtracting 3 for value %.1f%n", calculator.performOperation(3D, CalculatorOperation.SUBTRACTION));
		mementos.push(calculator.createMemento());

		System.out.printf("Multiplying by 7 for value %.1f%n", calculator.performOperation(7D, CalculatorOperation.MULTIPLICATION));
		mementos.push(calculator.createMemento());

		System.out.printf("Adding 1 for value %.1f%n", calculator.performOperation(1D, CalculatorOperation.ADDITION));
		mementos.push(calculator.createMemento());

		System.out.printf("Dividing by 2 for value %.1f%n", calculator.performOperation(2D, CalculatorOperation.DIVISION));

		System.out.printf("Undoing operation. Current result is %.1f%n", calculator.restoreFromMemento(mementos.pop()));
		mementos.push(calculator.createMemento());

		System.out.printf("Subtracting 5 for value %.1f%n", calculator.performOperation(5D, CalculatorOperation.SUBTRACTION));
	}
}
