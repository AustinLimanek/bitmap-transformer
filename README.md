# Bitmap Transformer

A Java application that transforms a provided bitmap image, `name.bmp`, into several variants. It can be run from the command line by providing the name of the file to be transformed (which must be located in the `resources` folder), the name of new bitmap file (name.bmp), plus two additional arguments depending on the transform. There are four available `transform` variants: `grayscale`, `invert`, `random`, and `flip`. The `flip` variant has two `types`: `horizontal` and `vertical`. The type for the other three variants is `none`.

To run the application, clone the repo and (with Gradle) run `./gradlew run --args "<inputname>.bmp <outputname>.bmp <variant> <type>"`. The `Bitmap Transformer` comes preloaded with `baldy-8bit.bmp` and several examples of already completed transforms.

The base bmp file, `baldy-8bit.bmp`, is: 

<img src="./app/src/main/resources/images/base.png" alt="baldy photo" width="200"/>

Using `./gradlew run --args "baldy-8bit.bmp invert.bmp invert none"`

<img src="./app/src/main/resources/images/invert.png" alt="baldy photo" width="200"/>

Using `./gradlew run --args "baldy-8bit.bmp grayscale.bmp grayscale none"`

<img src="./app/src/main/resources/images/grayscale.png" alt="baldy photo" width="200"/>

Using `./gradlew run --args "baldy-8bit.bmp random.bmp random none"`

<img src="./app/src/main/resources/images/random.png" alt="baldy photo" width="200"/>

Using `./gradlew run --args "baldy-8bit.bmp fliphorizontal.bmp flip horizontal"`

<img src="./app/src/main/resources/images/fliphorizontal.png" alt="baldy photo" width="200"/>

Using `./gradlew run --args "baldy-8bit.bmp flipvertical.bmp flip vertical"`

<img src="./app/src/main/resources/images/flipvertical.png" alt="baldy photo" width="200"/>

Using `./gradlew run --args "baldy-8bit.bmp fliphorizontal.bmp flip horizontal"` and then `./gradlew run --args "fliphorizontal.bmp fliphandv.bmp flip vertical"`. Notice that this file required two transforms. The output of the first transform in the input of the second transform.

<img src="./app/src/main/resources/images/fliphandv.png" alt="baldy photo" width="200"/>

You can continue to stack transforms. Try to guess what transforms were required to create these outputs:

<img src="./app/src/main/resources/images/fliphvinvertrandom.png" alt="baldy photo" width="200"/><img src="./app/src/main/resources/images/fliphvandrandom.png" alt="baldy photo" width="200"/>
