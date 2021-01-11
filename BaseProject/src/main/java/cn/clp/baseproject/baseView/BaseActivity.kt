package cn.clp.baseproject.baseView

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cn.clp.baseproject.R

class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }
}