package jp.kiroru.kotlinlesson02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jp.kiroru.kotlinlesson02.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")

        binding.detailTitle.text = title
        binding.detailDescription.text = description
        binding.closeButton.setOnClickListener {
            finish()
        }
    }

}