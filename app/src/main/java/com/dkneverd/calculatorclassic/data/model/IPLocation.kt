// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json       = Json { allowStructuredMapKeys = true }
// val iPLocation = json.parse(IPLocation.serializer(), jsonString)

package com.dkneverd.calculatorclassic.data.model

import kotlinx.serialization.*

@Serializable
data class IPLocation (
    @SerialName("country_code")
    val countryCode: String? = null,
)
