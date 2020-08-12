package br.com.boraviajar.apiwatcher.listener.sink

import org.springframework.cloud.stream.annotation.Input
import org.springframework.messaging.MessageChannel

interface DeleteTravelSink {

    @Input("delete-travel")
    fun input(): MessageChannel
}