# CPU Emulator in Java

## Usage:
```
java Emulator.java program.txt
```

## Instruction Set:

| Instruction | Short description | Description |
| ----------- | ----------------- | ------------ |
START | Start execution | Starts the program execution 
LOAD X | Load immediate value | Load the immediate value X to AC Ex: LOAD 25 means AC=25 
LOADM M[X] | Load a memory value | Load memory value stored at M[X] to AC 
STORE X | Store a value | Store value in AC to memory location M[X] Ex: STORE 140 means M[140]=AC CMPM M[X] | Compare | If the integer value in AC is greater than value in M[X] then set F flag to 1 If the integer value in AC is less than integer value in M[X] then set F flag to -1 If the integer value in AC is equal to integer value in M[X] then set F flag to 0 
CJMP X | Conditional Jump | Update the PC with X if the F flag value is positive 
JMP X | Unconditional Jump | Update the PC value with X Ex: JMP 114 PC=114 
ADD X | Immediate Addition | Add immediate value of X to AC Ex: ADD 67 means AC=AC+67 
ADDM M[X] | Addition with memory | Add Memory value of M[X] to AC Ex: ADDM 180 means AC=AC+M[180] 
SUBM M[X] | Subtraction with memory | Subtract Memory value of M[X] from AC Ex: SUBM 150 means AC=AC-M[150] 
SUB X | Immediate Subtraction | Subtract immediate value of X from AC Ex: SUB 75 means AC=AC-75 MUL N | Immediate Multiplication | Multiply AC with immediate value of N Ex: MUL 4 means AC=AC×N MULM N | Multiplication with memory | Multiply AC with M[N] Ex: MULM 4 means AC=AC×M[4] 
DISP | Display | Display the value in AC on screen 
HALT | Stop execution | Stop Execution

## Example Program:
- Compute the sum of the numbers between 0 and 31
```
0 START
1 LOAD 31
2 STORE 200
3 LOAD 0
4 STORE 201
5 STORE 202
6 CMPM 200
7 CJMP 15
8 LOADM 202
9 ADDM 201
10 STORE 202
11 LOADM 201
12 ADD 1
13 STORE 201
14 JMP 6
15 LOADM 202
16 DISP
17 HALT
```
