

# Example application written in Scala.js

This is another to-do list application. This time written in [Scala.js](https://www.scala-js.org/).

## Get started

To get started, open `sbt` in this example project, and execute the task
`fastOptJS`. This creates the file `target/scala-2.11/example-fastopt.js`.
You can now open `index-fastopt.html` in your favorite Web browser!

During development, it is useful to use `~fastOptJS` in sbt, so that each
time you save a source file, a compilation of the project is triggered.
Hence only a refresh of your Web page is needed to see the effects of your
changes.

## Run the tests

TODO: Write how to use phantom.js

To run the test suite, execute the task `test`. If you have installed
[Node.js](http://nodejs.org/), you can use

    > set scalaJSStage := FastOptStage

which will cause `test` to run the result of `fastOptJS` with Node.js,
which is faster.


## The fully optimized version

For ultimate code size reduction, use `fullOptJS`. This will take several
seconds to execute, so typically you only use this for the final, production
version of your application. While `index-fastopt.html` refers to the
JavaScript emitted by `fastOptJS`, `index.html` refers to the optimized
JavaScript emitted by `fullOptJS`.
