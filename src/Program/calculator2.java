#include <iostream>
#include <stack>
#include <string>
#include <cctype>
#include <sstream>

using namespace std;

// Function to check if the character is an operator
bool isOperator(char c) {
    return c == '+' || c == '-' || c == '*' || c == '/';
}

// Function to return the precedence of the operator
int precedence(char op) {
    if (op == '+' || op == '-') return 1;
    if (op == '*' || op == '/') return 2;
    return 0;
}

// Function to perform arithmetic operations
int applyOperation(int a, int b, char op) {
    switch (op) {
        case '+': return a + b;
        case '-': return a - b;
        case '*': return a * b;
        case '/': return a / b;
    }
    return 0;
}

// Function to evaluate the expression
int evaluateExpression(const string& expression) {
    stack<int> values; // Stack to store integer values
    stack<char> ops;   // Stack to store operators

    for (size_t i = 0; i < expression.length(); i++) {
        // Skip whitespace
        if (expression[i] == ' ') continue;

        // Current character is a number
        if (isdigit(expression[i])) {
            int value = 0;
            while (i < expression.length() && isdigit(expression[i])) {
                value = (value * 10) + (expression[i] - '0');
                i++;
            }
            values.push(value);
            i--; // Adjust for the for loop increment
        }
        // Current character is an operator
        else if (isOperator(expression[i])) {
            // While top of 'ops' has the same or greater precedence, apply the operator
            while (!ops.empty() && precedence(ops.top()) >= precedence(expression[i])) {
                int val2 = values.top();
                values.pop();

                int val1 = values.top();
                values.pop();

                char op = ops.top();
                ops.pop();

                values.push(applyOperation(val1, val2, op));
            }
            // Push current operator to 'ops'
            ops.push(expression[i]);
        }
    }

    // Apply the remaining operators
    while (!ops.empty()) {
        int val2 = values.top();
        values.pop();

        int val1 = values.top();
        values.pop();

        char op = ops.top();
        ops.pop();

        values.push(applyOperation(val1, val2, op));
    }

    // The top of 'values' contains the result
    return values.top();
}

int main() {
    string expression;
    cout << "Enter an expression (e.g., 2 + 3 * 4 / 2): ";
    getline(cin, expression);

    int result = evaluateExpression(expression);
    cout << "Result: " << result << endl;

    return 0;
}
