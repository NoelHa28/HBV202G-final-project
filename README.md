# HBV202G Final project

This is the final project for the course Software Design and Construction. It is a library management system that allows users to manage books, users and lendings. The system might not be complete and can still use some improvements in the future.

## Design infos
[Design](src/site/markdown/design.md)

## Supported Maven Goals

- `mvn clean`: Cleans up after a build by removing build directories.
- `mvn compile`: Compiles source code of the project.
- `mvn exec:java`: Runs the main class of the project as specified in the `pom.xml` file, using the project's dependencies.
- `mvn site`: Generates a website or a report for this project. This includes information from various sources like Javadoc comments and project dependencies.
- `mvn test`: Runs tests for the project.
- `mvn package`: Takes the compiled code and packages it in its distributable format, such as a JAR.

## How to Package the Program

To package the program into a JAR file, run the following command in the terminal:

```bash
mvn package
```

How to Run the Program

## License

[MIT License info](LICENSE)

