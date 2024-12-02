package com.daniel.rpncalculator

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel

class RpnCalculatorViewModel: ViewModel() {

    // State for display
    private val _display = mutableStateOf("0")
    val display: State<String> = _display

    // Stack to store operands
    private val stack = mutableListOf<Double>()

    // Current input being typed
    private var currentInput = ""

    /**
     * Handles number input and updates the display.
     */
    fun onNumberInput(number: String) {
        currentInput += number
        updateDisplay(currentInput)
    }

    /**
     * Handles the "Enter" button press. Adds the current input to the stack.
     */
    fun onEnterPressed() {
        if (currentInput.isNotEmpty()) {
            if (currentInput.all { it.isDigit() }) {
                pushToStack(currentInput.toDouble())
                currentInput = ""
                updateDisplay(stackToString())
            } else {
                showError("Illegal character")
            }
        }
    }

    /**
     * Handles operator input (+, -, *, /).
     */
    fun onOperatorInput(operator: String) {
        if (stack.size >= 2) {
            val b = popFromStack()
            val a = popFromStack()

            val result = when (operator) {
                "+" -> a + b
                "-" -> a - b
                "*" -> a * b
                "/" -> if (b == 0.0) {
                    showError("Division by zero")
                    pushToStack(a)
                    pushToStack(b)
                    return
                } else a / b
                else -> {
                    showError("Unknown operator")
                    pushToStack(a)
                    pushToStack(b)
                    return
                }
            }

            pushToStack(result)
            updateDisplay(stackToString())
        } else {
            showError("Not enough operands")
        }
    }

    /**
     * Clears the stack and resets the display.
     */
    fun onClear() {
        currentInput = ""
        stack.clear()
        updateDisplay("0")
    }

    // Private Helpers

    private fun pushToStack(value: Double) {
        stack.add(value)
    }

    private fun popFromStack(): Double {
        return stack.removeAt(stack.size - 1)
    }

    private fun updateDisplay(value: String) {
        _display.value = value
    }

    private fun showError(message: String) {
        _display.value = "Error: $message"
    }

    private fun stackToString(): String {
        return stack.joinToString(" ")
    }
}
