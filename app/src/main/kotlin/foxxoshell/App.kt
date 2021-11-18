package foxxoshell

import java.util.*
import java.util.regex.Pattern
import kotlin.system.exitProcess


class App {
    val greeting: String
        get() {
            return "Welcome to FoxxoShell!\n"
        }
}

object User {
    val name = System.getProperty("user.name")
    val homeDir = System.getProperty("user.home")
}

fun command(text: String) {
    if(text == "") {
        println("Type something!")
        return
    }

    val prefix = text.first()

    if(prefix == "/".single()) {
        var arguments = ArrayList<String>()
        var argsMatcher = Pattern.compile("([^\"]\\S*|\".+?\")\\s*").matcher(text.drop(1))
        while (argsMatcher.find())
            arguments.add(argsMatcher.group(1))
        println(arguments)
        var args = arguments.toList()
        val cmd = args[0]
        args = args.drop(1)

        when(cmd) {
            "test" ->
                println(args)
            "home" ->
                println(User.homeDir)
            "whoami" ->
                println(User.name)
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
        print("${User.name}>> ")
        val scanner = Scanner(System.`in`)
        val scanner_text = scanner.nextLine()

        command(scanner_text)
    }
}