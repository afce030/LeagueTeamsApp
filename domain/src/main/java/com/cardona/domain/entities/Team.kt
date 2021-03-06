package com.cardona.domain.entities

data class Team(
    val name: Name,
    val description: String?,
    val foundationYear: Year,
    val badge: Badge,
    val events: List<Event>,
    val link: String?,
    val country: String?
){
    data class Name(val name: String?)
    data class Year(val year: String?)
    data class Badge(val badge: String?, val jersey: String?)
    data class Event(val eventName: String?)
}