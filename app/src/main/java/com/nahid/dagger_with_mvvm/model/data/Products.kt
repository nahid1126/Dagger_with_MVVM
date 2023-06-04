package com.nahid.dagger_with_mvvm.model.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Products(
    val category: String,
    val description: String,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val image: String,
    val price: Double,
    val title: String
)