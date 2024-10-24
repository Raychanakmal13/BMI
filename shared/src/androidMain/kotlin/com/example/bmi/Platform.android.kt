package com.example.bmi

actual fun getPlatform(): Platform = object : Platform {
    override val name: String ="Android";
    }