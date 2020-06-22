package qsoft.com.mt66_scan

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter


object Scanning {

    private var cb: ((String) -> Unit)? = null

    private val receiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val barcode = intent!!.getStringExtra("SCAN_BARCODE1")
            cb?.invoke(barcode)
        }
    }

    fun registerReceiver(context: Context, cb: (String) -> Unit) {
        val filter = IntentFilter("nlscan.action.SCANNER_RESULT")
        context.registerReceiver(receiver, filter)
        this.cb = cb
    }

    fun unregisterReceiver(context: Context) {
        context.unregisterReceiver(receiver)
    }
}
