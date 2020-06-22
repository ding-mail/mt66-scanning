package qsoft.com.mt66_scan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun showBar(bar: String) {
        lblBar.text = bar
    }

    /**
     * 恢复界面时注册广播接收器
     */
    override fun onResume() {
        super.onResume()

        Scanning.registerReceiver(this, this::showBar)
    }

    override fun onPause() {
        super.onPause()

        Scanning.unregisterReceiver(this)
    }
}
