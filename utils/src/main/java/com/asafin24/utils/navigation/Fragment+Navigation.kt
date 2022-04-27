package com.asafin24.utils.navigation

import androidx.fragment.app.Fragment

fun Fragment.navigate(navCommand: NavCommand) {
    (requireActivity() as? NavigationProvider)?.launch(navCommand)
}