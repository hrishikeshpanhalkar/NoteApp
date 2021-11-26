package com.example.noteapp.features.domain.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}
