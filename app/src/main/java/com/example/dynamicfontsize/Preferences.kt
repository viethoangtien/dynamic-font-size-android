package com.example.dynamicfontsize

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor

class Preferences constructor(val context: Context) {
    companion object {
        const val FONT_STYLE = "FONT_STYLE"
    }

    private fun open(): SharedPreferences {
        return context.getSharedPreferences("prefs", Context.MODE_PRIVATE)
    }

    private fun edit(): Editor {
        return open().edit()
    }

    fun getFontStyle(): FontStyle? {
        return FontStyle.valueOf(open().getString(FONT_STYLE, FontStyle.Medium.name)!!)
    }

    fun setFontStyle(style: FontStyle) {
        edit().putString(FONT_STYLE, style.name).commit()
    }
}