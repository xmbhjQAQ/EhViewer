package com.hippo.ehviewer.ui

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.ComposeView
import com.google.accompanist.themeadapter.material3.Mdc3Theme
import com.hippo.ehviewer.ui.tools.DialogState
import com.hippo.ehviewer.ui.tools.LocalDialogState

// To make sure compose theme and legacy view theme are in sync, we only use Mdc3Theme

inline fun ComposeView.setMD3Content(crossinline content: @Composable () -> Unit) = setContent {
    Mdc3Theme {
        val dialogState = remember { DialogState() }
        dialogState.Intercept()
        CompositionLocalProvider(LocalDialogState provides dialogState) {
            content()
        }
    }
}

inline fun ComponentActivity.setMD3Content(crossinline content: @Composable () -> Unit) = setContent {
    Mdc3Theme {
        val dialogState = remember { DialogState() }
        dialogState.Intercept()
        CompositionLocalProvider(LocalDialogState provides dialogState) {
            content()
        }
    }
}
