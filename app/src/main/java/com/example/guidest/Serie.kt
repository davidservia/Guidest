package com.example.guidest

import java.io.Serializable
import java.util.UUID

data class Serie(var id: String = UUID.randomUUID().toString(),
                 var titulo: String,
                 var desc: String): Serializable {
}
