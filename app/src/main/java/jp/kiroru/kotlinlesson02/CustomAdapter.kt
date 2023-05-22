package jp.kiroru.kotlinlesson02

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jp.kiroru.kotlinlesson02.databinding.CellMainBinding

class CustomAdapter(private val items: List<Item>, private val listener: ItemSelectionListener): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = CellMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding).apply {
            binding.root.setOnClickListener {
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

    class ViewHolder(binding: CellMainBinding) : RecyclerView.ViewHolder(binding.root) {
        val cellTitle = binding.cellTitle
        val cellDescription = binding.cellDescription
    }

    interface ItemSelectionListener {
        fun notifyItemSelected(item: Item)
    }

}