package jp.kiroru.kotlinlesson02

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.cell_main.view.*

class CustomAdapter(private val items: List<Item>, private val listener: ItemSelectionListener): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

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

    interface ItemSelectionListener {
        fun notifyItemSelected(item: Item)
    }

}