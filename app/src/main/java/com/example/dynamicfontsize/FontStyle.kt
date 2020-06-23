package com.example.dynamicfontsize

enum class FontStyle(var resId: Int, var title: String) {
    Small(R.style.FontStyle_Small, "Small"),
    Medium(R.style.FontStyle_Medium, "Medium"),
    Large(R.style.FontStyle_Large, "Large")
}