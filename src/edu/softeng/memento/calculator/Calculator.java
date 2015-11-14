package edu.softeng.memento.calculator;

import edu.softeng.memento.calculator.enums.CalculatorOperation;
import edu.softeng.memento.calculator.interfaces.CalculatorMementoInterface;
import edu.softeng.memento.calculator.interfaces.CalculatorOriginatorInterface;

public class Calculator implements CalculatorOriginatorInterface {
	public double performOperation(double operand, CalculatorOperation operation) {
		switch (operation) {
			case ADDITION:
				this.result += operand;
				break;
			case SUBTRACTION:
				this.result -= operand;
				break;
			case MULTIPLICATION:
				this.result *= operand;
				break;
			case DIVISION:
				this.result /= operand;
				break;
		}
		
		return this.result;
	}
	
	private double result;
	public double getResult() {
		return this.result;
	}
	
	@Override
	public CalculatorMementoInterface createMemento() {
		return new CalculatorMemento(this.result);
	}
	
	@Override
	public double restoreFromMemento(CalculatorMementoInterface memento) {
		this.result = memento.getResult();

		return this.result;
	}
	
	public Calculator(double initialValue) {
		this.result = initialValue;
	}
}
