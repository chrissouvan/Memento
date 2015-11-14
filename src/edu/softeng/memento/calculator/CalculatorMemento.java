package edu.softeng.memento.calculator;

import edu.softeng.memento.calculator.interfaces.CalculatorMementoInterface;

public class CalculatorMemento implements CalculatorMementoInterface {
	private double result;

	@Override
	public double getResult() {
		return this.result;
	}
	
	public CalculatorMemento(double currentResult) {
		this.result = currentResult;
	}
}
