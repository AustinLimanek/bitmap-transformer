# bitmap-transformer

A Java application that transforms a provided bitmap image into a grayscale or dark variant. It can be run from the command line by providing the absolute paths of the input and output files and the name of the transform desired. At this time the only supported values for `transform` are `grayscale` and `invert`.

To run the application, clone the repo and (with Gradle) run `./gradlew run --args in out transform`. 
