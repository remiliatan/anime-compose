package com.example.animelist.ui.components.materials

import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.res.ResourcesCompat
import androidx.core.text.HtmlCompat
import androidx.core.text.HtmlCompat.FROM_HTML_MODE_LEGACY
import com.example.animelist.R

@Composable
fun HtmlText(
    html: String,
    modifier: Modifier = Modifier
){
    AndroidView(
        factory = { context ->
            TextView(context).apply {
                movementMethod = LinkMovementMethod.getInstance()
                setTextIsSelectable(false)
                typeface = ResourcesCompat.getFont(context, R.font.quicksand_regular)
            }
        },
        modifier = modifier,
        update = { textView ->
            val spend = HtmlCompat.fromHtml(html, FROM_HTML_MODE_LEGACY)
            textView.text = spend
        }
    )
}
