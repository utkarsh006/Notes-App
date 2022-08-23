package com.utkarsh.mynotes.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.utkarsh.mynotes.R
import com.utkarsh.mynotes.databinding.ActivityMainBinding
import com.utkarsh.mynotes.presentation.home.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        replaceFragment(HomeFragment.newInstance(), true)
        
    }

    fun replaceFragment(fragment: Fragment, istransition: Boolean) {

        val fragmentTransition = supportFragmentManager.beginTransaction()

        if (istransition) {
            fragmentTransition.setCustomAnimations(
                android.R.anim.slide_out_right,
                android.R.anim.slide_in_left
            )
        }
        fragmentTransition.replace(R.id.flFragmenet, fragment).addToBackStack(fragment.javaClass.simpleName)
        fragmentTransition.commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

}
