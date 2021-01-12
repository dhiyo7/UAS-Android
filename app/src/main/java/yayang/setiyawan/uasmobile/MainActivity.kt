package yayang.setiyawan.uasmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import yayang.setiyawan.uasmobile.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_wisata.setOnClickListener {
            startActivity(Intent(this, WisataActivity::class.java))
        }
    }
}