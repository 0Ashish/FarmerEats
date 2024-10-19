package com.example.farmereats

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.farmereats.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Edge-to-edge layout and system bars configuration
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        WindowCompat.setDecorFitsSystemWindows(window, false)
        val controller = WindowInsetsControllerCompat(window, binding.root)
        controller.hide(WindowInsetsCompat.Type.systemBars())
        controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

        // NavHostFragment and NavController setup for navigation
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        setupActionBarWithNavController(navController)

        // Onboarding logic
        var currentImageIndex = 0
        binding.joinButton.setOnClickListener {
            currentImageIndex += 1
            when (currentImageIndex % 3) {
                0 -> updateOnboardingScreen(
                    R.drawable.on_boarding,
                    R.drawable.toggle1,
                    R.string.onBoarding2,
                    "#5EA25F"
                )
                1 -> updateOnboardingScreen(
                    R.drawable.on_boarding2,
                    R.drawable.toggle2,
                    R.string.onBoarding3,
                    "#D5715B"
                )
                2 -> updateOnboardingScreen(
                    R.drawable.on_boarding3,
                    R.drawable.toggle3,
                    R.string.onBoarding1,
                    "#F8C569"
                )
            }
        }

        binding.loginText.setOnClickListener {
            Log.d("MainActivity", "Navigating to login screen")
            navController.navigate(R.id.login)
        }
    }

    private fun updateOnboardingScreen(
        imageResId: Int,
        toggleResId: Int,
        descriptionResId: Int,
        backgroundColor: String
    ) {
        binding.onBoardingImg.setImageResource(imageResId)
        binding.toggle.setImageResource(toggleResId)
        binding.OnBoardingDescription.setText(descriptionResId)
        binding.root.setBackgroundColor(Color.parseColor(backgroundColor))
        binding.joinButton.setBackgroundColor(Color.parseColor(backgroundColor))
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}
