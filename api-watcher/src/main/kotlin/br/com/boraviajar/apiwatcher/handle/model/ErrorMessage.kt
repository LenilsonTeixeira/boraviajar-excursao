package br.com.boraviajar.apiwatcher.handle.model

import com.fasterxml.jackson.annotation.JsonProperty

class ErrorMessage(
        @JsonProperty("mensagem")
        val message: String?,

        @JsonProperty("status")
        val status: Int?,

        @JsonProperty("erro")
        val error: String?,

        @JsonProperty("timestamp")
        val timestamp: Long?,

        @JsonProperty("path")
        val path: String?
) {
    data class Builder(
        var message: String? = null,
        var status: Int? = null,
        var error: String? = null,
        var timestamp: Long? = null,
        var path: String? = null
    ){
        fun status(status: Int) = apply { this.status = status };

        fun error(error: String) = apply { this.error = error };

        fun timestamp(timestamp: Long) = apply { this.timestamp = timestamp };

        fun message(message: String?) = apply { this.message = message };

        fun path(path: String) = apply { this.path = path };

        fun build() = ErrorMessage(message, status, error, timestamp, path);
    }

}