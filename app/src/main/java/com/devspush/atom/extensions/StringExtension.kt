package com.devspush.atom.extensions

import java.util.regex.Pattern

fun String.isValidEmail(): Boolean {
    val emailPattern =
        "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$"
    return Pattern.compile(emailPattern).matcher(this).matches()
}