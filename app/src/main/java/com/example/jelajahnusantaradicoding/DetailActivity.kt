package com.example.jelajahnusantaradicoding

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jelajahnusantaradicoding.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val EXTRA_WISATA = "extra_wisata"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val wisata = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_WISATA, Wisata::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_WISATA)
        }

        if (wisata != null) {
            binding.imgDetailPhoto.setImageResource(wisata.foto)
            binding.tvDetailName.text = wisata.nama
            binding.tvDetailDescription.text = wisata.deskripsiPanjang
            supportActionBar?.title = wisata.nama
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}