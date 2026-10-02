# Truffula Notes
As part of Wave 0, please fill out notes for each of the below files. They are in the order I recommend you go through them. A few bullet points for each file is enough. You don't need to have a perfect understanding of everything, but you should work to gain an idea of how the project is structured and what you'll need to implement. Note that there are programming techniques used here that we have not covered in class! You will need to do some light research around things like enums and and `java.io.File`.

PLEASE MAKE FREQUENT COMMITS AS YOU FILL OUT THIS FILE.

## App.java
- For printing a directory tree
- -h (show hidden) -nc (no color)
- Describes how to construct the application, ties everything together

## ConsoleColor.java
- ANSI Escape Codes - "sequences beginning with an escape character that terminals interpret as commands to control text color and style, cursor position, and other display behavior."
- Lists supported colors + how to reset color
- Contains color constructors to create colors via ANSI code
- Has getCode (returns code for color) and toString methods

## ColorPrinter.java / ColorPrinterTest.java
- Sets current color, prints message in that color
- Used in conjunction with ConsoleColor (ex. printer.setCurrentColor(ConsoleColor.RED))
- Contains currentColor, Printstream output will be written to, can getCurrentColor, setCurrentColor and print a message in various ways
- Default color WHITE
- Object that can be constructed
- Tests: tests red and reset. 

## TruffulaOptions.java / TruffulaOptionsTest.java

- Config options for how directory tree is displayed (show hidden, colored output, root directory)
- Throws IllegalArgumentException & FileNotFoundException
- Object contains File root, boolean showHidden, boolean useColor. has toString
- Test: tests if valid directory set, makes a new temp directory to test
## TruffulaPrinter.java / TruffulaPrinterTest.java
- Prints the structure, supports file sorting + directories in case-insensitive way
- options holds config options
- colorSequence holds colors in order (has default)
- has multiple constructors for various options
- Holds wave 4 - 7 instructions
- printTree method will be implemented later, use out.println

## AlphabeticalFileSorter.java