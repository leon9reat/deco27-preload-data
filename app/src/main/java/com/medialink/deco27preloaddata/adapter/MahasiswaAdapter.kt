package com.medialink.deco27preloaddata.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.medialink.deco27preloaddata.R
import com.medialink.deco27preloaddata.model.MahasiswaModel
import kotlinx.android.synthetic.main.item_mahasiswa_row.view.*

class MahasiswaAdapter: RecyclerView.Adapter<MahasiswaAdapter.MyViewHolder>() {

    private val listMahasiswa = arrayListOf<MahasiswaModel>()

    fun setData(listMahasiswa: ArrayList<MahasiswaModel>) {
        if (listMahasiswa.size > 0) {
            this.listMahasiswa.clear()
        }
        this.listMahasiswa.addAll(listMahasiswa)
        notifyDataSetChanged()
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(mahasiswa: MahasiswaModel) {
            with(itemView) {
                tv_nim.text = mahasiswa.nim
                tv_nama.text = mahasiswa.nama
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mahasiswa_row, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = listMahasiswa.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.d("debug", "onBindViewHolder : $position")
        holder.bind(listMahasiswa[position])
    }

    override fun getItemViewType(position: Int): Int = position

    override fun getItemId(position: Int): Long = position.toLong()

}