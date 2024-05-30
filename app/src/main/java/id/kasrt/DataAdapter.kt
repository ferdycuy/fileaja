package id.kasrt

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.kasrt.model.DataItem

class DataAdapter(private val dataItems: MutableList<DataItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // ViewHolder untuk pemasukan
    class PemasukanViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTanggal: TextView = itemView.findViewById(R.id.itemTanggal)
        val tvDeskripsi: TextView = itemView.findViewById(R.id.itemPemanfaatan)
        val tvPemasukanIuran: TextView = itemView.findViewById(R.id.itemPemasukanIuran)
    }

    // ViewHolder untuk pengeluaran
    class PengeluaranViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTanggal: TextView = itemView.findViewById(R.id.itemTanggal2)
        val tvDeskripsi: TextView = itemView.findViewById(R.id.itemPemanfaatan2)
        val tvPengeluaranIuran: TextView = itemView.findViewById(R.id.itemPengeluaranIuran2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 1) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pemasukan, parent, false)
            PemasukanViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pengeluaran, parent, false)
            PengeluaranViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = dataItems[position]
        if (holder is PemasukanViewHolder) {
            holder.tvTanggal.text = item.tanggal
            holder.tvDeskripsi.text = item.pemasukan_iuran
            holder.tvPemasukanIuran.text = "+Rp${item.pemasukan}"
            holder.tvPemasukanIuran.setTextColor(Color.GREEN)
        } else if (holder is PengeluaranViewHolder) {
            holder.tvTanggal.text = item.tanggal
            holder.tvDeskripsi.text = item.pengeluaran_iuran
            holder.tvPengeluaranIuran.text = "-Rp${item.pengeluaran}"
            holder.tvPengeluaranIuran.setTextColor(Color.RED)
        }
    }

    override fun getItemCount(): Int = dataItems.size

    override fun getItemViewType(position: Int): Int {
        return if (dataItems[position].type == "pemasukan") 1 else 2
    }

    fun setPemanfaatan(data: List<DataItem>) {
        dataItems.clear()
        dataItems.addAll(data)
        notifyDataSetChanged()
    }
}
