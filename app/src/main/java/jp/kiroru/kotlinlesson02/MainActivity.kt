package jp.kiroru.kotlinlesson02

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import android.content.Intent
import android.os.Bundle
import jp.kiroru.kotlinlesson02.databinding.ActivityMainBinding

data class Item(val title: String, val description: String)

class MainActivity : AppCompatActivity(), CustomAdapter.ItemSelectionListener {

    private val items = mutableListOf<Item>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val activityMainView = binding.root
        setContentView(activityMainView)

        // ダミーデータ作成
        for (index in 1..20) {
            items.add(Item("${resources.getString(R.string.cell_title)}$index",
                "${resources.getString(R.string.cell_description)}$index"))
        }

        val view = binding.recyclerView
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