package com.xavier.krill.base

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.dylanc.viewbinding.base.ViewBindingUtil

open class ViewBindingActivity<VB : ViewBinding> : AppCompatActivity() {

    lateinit var binding: VB
    protected val activity: AppCompatActivity by lazy { this }
    protected val context: Context by lazy { this }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ViewBindingUtil.inflateWithGeneric(this, layoutInflater)
        setContentView(binding.root)
    }
}