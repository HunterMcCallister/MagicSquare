****************
* MagicSquare Project
* CS221 - Comp Sci 2
* 27 Aug 24
* Hunter McCallister
****************

OVERVIEW:
The MagicSquare Program checks if a matrix stored in a file forms a magic square and can also generate a magic square of a specific size. It uses the command line as its interface

INCLUDED FILES:
* MagicSquare.java - source file
* MagicSquareInterface.java - source file
* MagicSquareDriver.java - source file
* README.md - this file.

COMPILING AND RUNNING:
From the directory containing all source files, compile the code using 
$ javac MagicSquareDriver.java

Run the code using:
$ java MagicSquareDriver -check filename.txt
or
$ java MagicSquareDriver -create filename.txt size

filename is the path to the file and size is the size you want the matrix to be.

PROGRAM DESIGN AND IMPORTANT CONCEPTS:
MagicSquare class implements the MagicSquareInterface. the interface outlines the methods for the class. The methods include checking if the matrix is a magic square and generating a new magic square.
the interface makes sure that everything that is required is met.

The MagicSquareDriver class is the entry point for the program. It is the one that handles the interaction with the user through the command line. It checks to make sure the arguments are valid and gives a message on what it should look like.
It will verify the matrix from a file or agenerate a new one.

The program uses several methods in the MagicSquare class to work together. The program uses files for most of its input and output. The logic behind it is checking if the sum of the rows columns and diagnols eqaul the same sum.
It uses a given algorythm that steps through the matrix and places the numbers to create a magic Square.

TESTING:
I mostly used the provided tester. I would basically work on some code and run the tester to see what would happen. A lot of the times I was only passing 1 of the tests. 

DISCUSSION:
