package edu.softeng.memento.calculator.interfaces;

public interface CalculatorOriginatorInterface {
	CalculatorMementoInterface createMemento();
	double restoreFromMemento(CalculatorMementoInterface memento);
}
