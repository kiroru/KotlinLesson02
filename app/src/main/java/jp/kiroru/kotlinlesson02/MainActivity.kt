package jp.kiroru.kotlinlesson02

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.cell_main.view.*


data class Item(val title: String, val description: String)

interface ItemSelectionListener {
    fun notifyItemSelected(item: Item)
}

class MainActivity : AppCompatActivity(), ItemSelectionListener {

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
            adapter = MyAdapter(items, this@MainActivity)
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

class MyAdapter(private val items: List<Item>, private val listener: ItemSelectionListener): RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cell_main, parent, false)
        return ViewHolder(view).apply {
            view.setOnClickListener {
                listener.notifyItemSelected(items[adapterPosition])
            }
        }
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.cellTitle.text = item.title
        holder.cellDescription.text = item.description
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val cellTitle = view.cellTitle!!
        val cellDescription = view.cellDescription!!
    }

}