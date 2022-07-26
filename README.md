# Apache Beam starter for Kotlin

If you want to clone this repository to start your own project,
you can choose the license you prefer and feel free to delete anything related to the license you are dropping.

## Before you begin

Make sure you have a [Java](https://en.wikipedia.org/wiki/Java_%28programming_language%29) development environment ready with
[Gradle](https://gradle.org).
If you don't, an easy way to install it is with [`sdkman`](https://sdkman.io).

```sh
# Install sdkman.
curl -s "https://get.sdkman.io" | bash

# Make sure you have Java 17 and Gradle installed.
sdk install java 17.0.3-tem
sdk install gradle
```

## Source file structure

This is a very basic Apache Beam project to help you get started.

There are only two source files:

* [`app/src/main/kotlin/beam/starter/App.kt`](app/src/main/kotlin/beam/starter/App.kt): the application source file, containing the [`main` function](https://kotlinlang.org/docs/basic-syntax.html#program-entry-point).
* [`app/src/test/kotlin/beam/starter/AppTest.kt`](app/src/test/kotlin/beam/starter/AppTest.kt): tests for the `App.kt` file.

### Running the pipeline

You can run your pipeline with Gradle.

```sh
# To do a simple run.
gradle run

# To run passing command line arguments.
gradle run --args=--inputText="🎉"

# To run the tests.
gradle test --info
```

To build a self-contained jar file, we need to configure the [`jar`](https://docs.gradle.org/current/dsl/org.gradle.api.tasks.bundling.Jar.html) task in the [`build.gradle`](build.gradle) file.

```sh
# Build a self-contained jar.
gradle jar

# Run the jar application.
java -jar app/build/pipeline.jar --inputText="🎉"
```

## GitHub Actions automated testing

This project already comes with automated testing via [GitHub Actions](https://github.com/features/actions).

To configure it, look at the [`.github/workflows/test.yaml`](.github/workflows/test.yaml) file.

## Using other runners

To keep this template small, it only includes the [Direct Runner](https://beam.apache.org/documentation/runners/direct/).

For a comparison of what each runner currently supports, look at the [Beam Capability Matrix](https://beam.apache.org/documentation/runners/capability-matrix/).

To add a new runner, visit the runner's page for instructions on how to include it.

## Contributing

Thank you for your interest in contributing!
All contributions are welcome! 🎉🎊

Please refer to the [`CONTRIBUTING.md`](CONTRIBUTING.md) file for more information.

# License

This software is distributed under the terms of both the MIT license and the
Apache License (Version 2.0).

See [LICENSE](LICENSE) for details.
