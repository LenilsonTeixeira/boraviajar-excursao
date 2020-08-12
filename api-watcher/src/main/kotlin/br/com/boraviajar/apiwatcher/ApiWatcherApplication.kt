package br.com.boraviajar.apiwatcher

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ApiWatcherApplication

fun main(args: Array<String>) {
	runApplication<ApiWatcherApplication>(*args)
}
