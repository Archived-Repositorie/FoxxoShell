package foxxoshell

import java.util.*
import kotlin.system.exitProcess

fun command(text: String) {
    val prefix = text.first()

    if(prefix == "/".single()) {
        var args = text.drop(1).split(" ")
        val cmd = args[0]
        args = args.drop(1)
        when(cmd) {
            "test" ->
                println(args)
            "exit" ->
            {
                println("Exited program.")
                exitProcess(0)
            }
            else ->
                println("Invalid command.")
        }
    } else {
        println(text)
    }
}

fun main() {
    println("Welcome to FoxxoShell!\n")
    while (true) {
        print("${System.getProperty("user.name")}>> ")
        val scanner = Scanner(System.`in`)
        val scanner_text = scanner.nextLine()

        command(scanner_text)
    }
}