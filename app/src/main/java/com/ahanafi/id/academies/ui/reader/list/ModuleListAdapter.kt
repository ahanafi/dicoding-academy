package com.ahanafi.id.academies.ui.reader.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ahanafi.id.academies.data.ModuleEntity
import com.ahanafi.id.academies.ui.detail.DetailCourseAdapter
import com.ahanafi.id.academy.R

class ModuleListAdapter internal constructor(private val listener : MyAdapterClickListener) : RecyclerView.Adapter<ModuleListAdapter.ModuleViewHolder>(){
    class ModuleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textTitle : TextView = itemView.findViewById(R.id.text_module_title)
        fun bind(module: ModuleEntity) {
            textTitle.text = module.title
        }
    }

    private val listModules = ArrayList<ModuleEntity>()

    internal fun setModules(modules: List<ModuleEntity>?){
        if (modules == null) return
        listModules.clear()
        listModules.addAll(modules)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ModuleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_module_list_custom, parent, false)
        return ModuleViewHolder(view)
    }

    override fun getItemCount(): Int = listModules.size

    override fun onBindViewHolder(holder: ModuleViewHolder, position: Int) {
        val module = listModules[position]
        holder.bind(module)
        holder.itemView.setOnClickListener {
            listener.onItemClicked(holder.adapterPosition, listModules[holder.adapterPosition].moduleId)
        }
    }
}

interface MyAdapterClickListener {
    fun onItemClicked(position: Int, moduleId: String)
}
