package me.ibrahimsn.lib.internal.ext

import android.view.View
import android.widget.EditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import me.ibrahimsn.lib.State
import me.ibrahimsn.lib.api.Country
import me.ibrahimsn.lib.internal.Constants.CHAR_PLUS

internal fun CharSequence?.prependPlus(): String {
    return StringBuilder()
        .append(CHAR_PLUS)
        .append(this)
        .toString()
}

internal fun Int.prependPlus(): String {
    return StringBuilder()
        .append(CHAR_PLUS)
        .append(this)
        .toString()
}

internal fun CharSequence?.startsWithPlus(): Boolean {
    return this?.startsWith(CHAR_PLUS) == true
}

internal fun String?.clearSpaces(): String? {
    return this?.replace("\\s+", "")
}

internal fun <T> Collection<T>.toRawString(): String {
    return this.joinToString("")
}

internal fun CharArray.toRawString(): String {
    return this.joinToString("")
}

internal fun EditText.clear() {
    this.setText("")
}

internal fun View.showIf(statement: Boolean) {
    visibility = if (statement) View.VISIBLE else View.GONE
}

internal suspend fun <T> CoroutineScope.default(
    block: suspend () -> T
) = withContext(Dispatchers.Default) {
    block.invoke()
}

internal suspend fun <T> Any.io(
    block: suspend () -> T
) = withContext(Dispatchers.IO) {
    block.invoke()
}

internal fun <T> State.doIfAttached(block: State.Attached.() -> T): T? {
    if (this is State.Attached) return block.invoke(this)
    return null
}
