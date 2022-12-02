package com.samm.cryptoapp.util

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry

object TestContext {
    var appContext: Context = InstrumentationRegistry.getInstrumentation().context
}