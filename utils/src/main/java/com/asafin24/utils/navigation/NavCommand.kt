package com.asafin24.utils.navigation

import android.os.Bundle

data class NavCommand(
    val target: NavCommands,
    var args: Bundle? = null,
)
