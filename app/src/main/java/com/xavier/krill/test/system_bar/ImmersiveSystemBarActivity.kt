package com.xavier.krill.test.system_bar

import android.os.Bundle
import androidx.core.view.*
import androidx.lifecycle.*
import com.xavier.krill.base.ViewBindingActivity
import com.xavier.krill.databinding.ActivityFullScreenExperienceBinding
import com.xavier.system_bar.kts.fullScreen
import com.xavier.system_bar.kts.hideNavigationBar
import com.xavier.system_bar.kts.systemBarTransparent
import timber.log.Timber

class ImmersiveSystemBarActivity : ViewBindingActivity<ActivityFullScreenExperienceBinding>() {

    private val viewModel by lazy { ViewModelProvider(this).get(ImmersiveSystemBarViewModel::class.java) }

    private var runnable = Runnable {
        Timber.d("Runnable")
        hideNavigationBar()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.boolNavigationBarIsVisible.observe(this) {
            Timber.d("observe $it")
            binding.root.removeCallbacks(runnable)
            if (it) {
                binding.root.postDelayed(runnable, 2000)
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { _, windowInsets ->
            val visible = windowInsets.isVisible(WindowInsetsCompat.Type.navigationBars())
            Timber.d("visible $visible")
            viewModel.postChangeBoolNavigationBarIsVisible(visible)
            WindowInsetsCompat.CONSUMED
        }
        fullScreen()
        systemBarTransparent()
        hideNavigationBar()
    }
}

class ImmersiveSystemBarViewModel : ViewModel() {
    private val _boolNavigationBarIsVisible = MutableLiveData<Boolean>()
    val boolNavigationBarIsVisible: LiveData<Boolean> get() = _boolNavigationBarIsVisible
    fun changeBoolNavigationBarIsVisible(value: Boolean) {
        _boolNavigationBarIsVisible.value = value
    }

    fun postChangeBoolNavigationBarIsVisible(value: Boolean) {
        _boolNavigationBarIsVisible.postValue(value)
    }
}