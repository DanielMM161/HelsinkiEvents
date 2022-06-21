package com.dmm.helsinkievents.model

data class Offer(
    val description: Description,
    val info_url: InfoUrl,
    val is_free: Boolean,
    val price: Price
)