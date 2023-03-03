# Tutorial 7 (Postfix Calculator)

## 1. How to compile
```
javac PostfixTester.java
```

### 2. Usage
```
Usage: java PostfixTester <input file path>
eg. java PostfixTester input1.txt
```

>**Attention!**
>You need to seperate between each operand and operator with space!
>It is hard to implement complete detection without proper formatting.

### 3. Expected output

```
456 4 6 4 + + - + is a invalid postfix expression, hint: you need to separate operands and operators with a space!.
46 5 4 5 6 + + + + is a valid postfix expression. Result is: 66.0
4 6 5 4 5 6 2 3 4 0 0 - / - + + is a invalid postfix expression, hint: you need to separate operands and operators with a space!.
4 6 5 4 5 6 + + + + is a invalid postfix expression, hint: you need to separate operands and operators with a space!.
4 6 54 5 6 + + + + is a valid postfix expression. Result is: 75.0
Program terminated gracefully.
```