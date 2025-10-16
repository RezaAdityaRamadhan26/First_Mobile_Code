package com.example.jelajahnusantaradicoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jelajahnusantaradicoding.databinding.ActivityMainBinding
import com.example.jelajahnusantaradicoding.AboutActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Wisata>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvWisata.setHasFixedSize(true)

        list.addAll(getWisataList())
        showRecyclerList()
    }

    private fun getWisataList(): ArrayList<Wisata> {
        val dataNama = resources.getStringArray(R.array.data_nama_wisata)
        val dataDeskripsiSingkat = resources.getStringArray(R.array.data_deskripsi_singkat)
        val dataDeskripsiPanjang = resources.getStringArray(R.array.data_deskripsi_panjang)
        val dataFoto = resources.obtainTypedArray(R.array.data_foto_wisata)

        val listWisata = ArrayList<Wisata>()
        for (i in dataNama.indices) {
            val wisata = Wisata(
                dataNama[i],
                dataDeskripsiSingkat[i],
                dataDeskripsiPanjang[i],
                dataFoto.getResourceId(i, -1)
            )
            listWisata.add(wisata)
        }
        dataFoto.recycle()
        return listWisata
    }

    private fun showRecyclerList() {
        binding.rvWisata.layoutManager = LinearLayoutManager(this)
        val listWisataAdapter = ListWisataAdapter(list)
        binding.rvWisata.adapter = listWisataAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.about_page) {
            val moveIntent = Intent(this@MainActivity, AboutActivity::class.java)
            startActivity(moveIntent)
        }
        return super.onOptionsItemSelected(item)
    }
}