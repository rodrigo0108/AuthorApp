package com.heyoh.authorapp.helper

import android.content.Intent

private const val PACKAGE_NAME = "com.heyoh"

fun intentTo(intent: IntentActivity): Intent? = Intent(Intent.ACTION_VIEW).setClassName("com.heyoh.authorapp", intent.className)

interface IntentActivity{
    val className:String
}

object Activity{
    object Home : IntentActivity{
        override val className = "$PACKAGE_NAME.home.HomeActivity"
    }
}