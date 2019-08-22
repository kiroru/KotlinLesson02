package jp.kiroru.kotlinlesson02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")

        val detailTitle = findViewById<TextView>(R.id.detailTitle)
        detailTitle.text = title

        val detailDescription = findViewById<TextView>(R.id.detailDescription)
        detailDescription.text = description

        val closeButton = findViewById<Button>(R.id.closeButton)
        closeButton.setOnClickListener {
            finish()
        }
    }

}
