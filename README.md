# HBV202G Final project

This is the final project for the course Software Design and Construction. It is a library management system that allows users to manage books, users and lendings. The system might not be complete and can still use some improvements in the future.

## Design Info

More detailed information about the design can be found over here:

[Design](src/site/markdown/design.md)

## Supported Maven Goals

- `mvn clean`: Cleans up after a build by removing build directories.
- `mvn compile`: Compiles source code of the project.
- `mvn exec:java`: Runs the main class of the project as specified in the `pom.xml` file, using the project's dependencies.
- `mvn site`: Generates a website or a report for this project. This includes information from various sources like Javadoc comments and project dependencies.
- `mvn test`: Runs tests for the project.
- `mvn package`: Takes the compiled code and packages it in its distributable format, such as a JAR.

## How to Package and Run the Program

To package the program into a JAR file, run one of the two following commands in the terminal:

```bash
mvn package
```
```bash
cmd /c createjar.cmd
```

After creating the jar file, use the following script:

```bash
cmd /c runjar
```

There already exsists a jar file in this directory, you can run this by using the following command:

```bash
java -jar FinalProject-1.0-SNAPSHOT.jar
```

## License

[MIT License info](LICENSE)

