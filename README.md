# Reverse Polish Notation (RPN) Calculator

## High-Level Description

This project is an implementation of a Reverse Polish Notation (RPN) calculator built using **Jetpack Compose** and the **MVVM (Model-View-ViewModel)** architectural pattern. The calculator supports:
- Basic arithmetic operations (`+`, `-`, `*`, `/`).
- Input of numbers using a clean and interactive UI.
- A stack-based calculation mechanism.
- Real-time display updates based on user actions.
- Error handling for cases like division by zero or insufficient operands.

The calculator provides a clear and user-friendly interface with buttons for digits `0-9`, arithmetic operators, and functional buttons such as `Enter` and `Clear`.

---

## Technical Choices and Reasoning

1. **Jetpack Compose**: 
   - Chosen for its modern declarative UI toolkit, which simplifies the UI development process and aligns with Android's future direction.
   
2. **MVVM Architecture**:
   - Ensures a clean separation of concerns:
     - `ViewModel`: Handles the business logic and state management.
     - `Composable`: Reactively displays the UI based on the state provided by the `ViewModel`.

3. **MutableState and State Management**:
   - Used `MutableState` for dynamic UI updates without requiring manual triggers.
   - This ensures that the UI remains in sync with the state of the calculator's stack and current input.

4. **Stack Implementation**:
   - The calculator's logic is built around a stack data structure (`MutableList<Double>`) to represent RPN behavior.
   - Ensures efficient handling of operands and results.

5. **Error Handling**:
   - Division by zero and invalid operations are gracefully handled, displaying error messages without crashing the app.

### Future Enhancements

  - Add support for more advanced mathematical operations (e.g., square root, exponents).
  - Implement undo/redo functionality.
  - Introduce persistent storage for maintaining the state of the stack across sessions.
  - Optimize the app for larger screens or tablets.

---

## Setup and Running the App

### Prerequisites

- Android Studio Flamingo or later.
- Kotlin 1.9 or later.
- An Android Emulator or physical device with API level 21+.

## How to Use

1. **Number Input**  
   - Press the numeric buttons (`0-9`) to enter a number.

2. **Enter**  
   - Press the `Enter` button to push the current number to the stack.

3. **Operators**  
   - Use the following buttons to perform operations on the top two elements of the stack:
     - `+` for addition.
     - `-` for subtraction.
     - `*` for multiplication.
     - `/` for division (displays an error if dividing by zero).

4. **Clear**  
   - Press the `Clear` button to reset the calculator. This will clear the stack and reset the display to `0`.
