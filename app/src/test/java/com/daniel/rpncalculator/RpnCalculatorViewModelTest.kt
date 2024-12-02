package com.daniel.rpncalculator

import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class RpnCalculatorViewModelTest {
    private lateinit var viewModel: RpnCalculatorViewModel

    @Before
    fun setup() {
        viewModel = RpnCalculatorViewModel()
    }

    @Test
    fun `test simple addition`() {
        viewModel.onNumberInput("3")
        viewModel.onEnterPressed()
        viewModel.onNumberInput("4")
        viewModel.onEnterPressed()
        viewModel.onOperatorInput("+")
        viewModel.onEnterPressed()
        assertEquals("7.0", viewModel.display.value)
    }

    @Test
    fun `test complex expression`() {
        viewModel.onNumberInput("5")
        viewModel.onEnterPressed()
        viewModel.onNumberInput("1")
        viewModel.onEnterPressed()
        viewModel.onNumberInput("2")
        viewModel.onEnterPressed()
        viewModel.onOperatorInput("+")
        viewModel.onEnterPressed()
        viewModel.onNumberInput("4")
        viewModel.onEnterPressed()
        viewModel.onOperatorInput("*")
        viewModel.onEnterPressed()
        viewModel.onOperatorInput("+")
        viewModel.onEnterPressed()
        viewModel.onNumberInput("3")
        viewModel.onEnterPressed()
        viewModel.onOperatorInput("-")
        viewModel.onEnterPressed()

        assertEquals("14.0", viewModel.display.value)
    }

    @Test
    fun `test division by zero`() {
        viewModel.onNumberInput("4")
        viewModel.onEnterPressed()
        viewModel.onNumberInput("0")
        viewModel.onEnterPressed()
        viewModel.onOperatorInput("/")
        viewModel.onEnterPressed()
        assertEquals("Error: Division by zero", viewModel.display.value)
    }

    @Test
    fun `test invalid expression`() {
        viewModel.onNumberInput("3")
        viewModel.onEnterPressed()
        viewModel.onOperatorInput("+")
        viewModel.onEnterPressed()
        assertEquals("Error: Not enough operands", viewModel.display.value)
    }

    @Test
    fun `test invalid token`() {
        viewModel.onNumberInput("3")
        viewModel.onEnterPressed()
        viewModel.onNumberInput("a")
        viewModel.onEnterPressed()
        viewModel.onOperatorInput("+")
        viewModel.onEnterPressed()
        assertEquals("Error: Illegal character", viewModel.display.value)
    }
}