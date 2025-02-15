# Kotlin Puzzles 
Having fun and learning Kotlin by solving small puzzles from Advent of Code.

I'm using this project to learn some tools from kotlin, like coroutines, ktor, okio, etc.

The files are organized by packages from each year and day, example: `yearX.dayY`.

To each day puzzle, exist some unit tests and a function that uses the input from Advent of Code site.

## Download input text

To download an input from advent of code site, I don't find an API to do this.

So, I wrote a simple function to help download the files, but the auth needs to be done manually, copying the session cookie from the browser.

After this create an environment variable named `AOC_SESSION_TOKEN` with the value of the cookie:

```bash
export AOC_SESSION_TOKEN=<your cookie>
```


After building the project, run the function:

```bash
./build/bin/macosArm64/debugExecutable/advent-of-code.kexe 3
```
