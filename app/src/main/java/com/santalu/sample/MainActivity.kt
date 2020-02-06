package com.santalu.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.image1
import kotlinx.android.synthetic.main.activity_main.image2

class MainActivity: AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    image1.setOnClickListener { }
    image2.setOnClickListener { }
  }
}
