# Integer to Roman Number Converter

This is a small vanilla Java app to convert integer numbers to roman ones. This app supports an integer range 
from 1 to 3000.

## Building the app

This App uses Gradle as its build tool. In order to run it locally please open a terminal and execute the
following command:

```bash
./gradlew build
```

## Running the app

Once the app has been built, execute the generated Jar file found in `./build/libs` directory. For instance:
```bash
java -jar ./build/libs/integer-roman-converter-1.0-SNAPSHOT.jar
```

The app will show an interactive menu in the console.

## Running unit tests

To run all the App's unit tests you can execute the following command in a terminal:
```bash
./gradlew test
```

You can also opt for running specific tests. As an example, use the following command:
```bash
./gradlew test --tests "org.example.converter.IntegerToRomanConverterTest.shouldConvertToRomanWhenPassingValidInteger"
```
