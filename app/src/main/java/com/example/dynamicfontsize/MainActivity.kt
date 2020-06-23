package com.example.dynamicfontsize

import android.os.Bundle
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var preferences = Preferences(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        theme.applyStyle(preferences.getFontStyle()!!.resId, true)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListener()
    }

    private fun initListener() {
        btn_font.setOnClickListener {
            val popupMenu = PopupMenu(this, btn_font)
            popupMenu.inflate(R.menu.poupup_menu)
            popupMenu.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.menu_small -> {
                        preferences.setFontStyle(FontStyle.Small)
                    }
                    R.id.menu_medium -> {
                        preferences.setFontStyle(FontStyle.Medium)
                    }
                    R.id.menu_large -> {
                        preferences.setFontStyle(FontStyle.Large)
                    }
                }
                recreate()
//                startActivity(Intent(this, MainActivity::class.java).apply {
//                    flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
//                })
                true
            }
            popupMenu.show()
        }
    }
}