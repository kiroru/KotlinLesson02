package jp.kiroru.kotlinlesson02

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent
import android.os.Bundle

data class Item(val title: String, val description: String)

class MainActivity : AppCompatActivity(), CustomAdapter.ItemSelectionListener {

    private val items = mutableListOf<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ダミーデータ作成
        for (index in 1..20) {
            items.add(Item("${resources.getString(R.string.cell_title)}$index",
                "${resources.getString(R.string.cell_description)}$index"))
        }

        val view = findViewById<RecyclerView>(R.id.recyclerView)
        with(view) {
            layoutManager = LinearLayoutManager(context)
            adapter = CustomAdapter(items, this@MainActivity)
        }
    }

    // アイテムが選択された時の動作
    override fun notifyItemSelected(item: Item) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("title", item.title)
        intent.putExtra("description", item.description)
        startActivity(intent)
    }

}