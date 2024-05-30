package id.kasrt.model

data class DataItem(
    val Gambar: String,
    val tanggal : String,
    val nama_depan: String,
    val nama_belakang: String,
    val email: String,
    val alamat: String,
    val pemasukan: String?,
    val pemasukan_iuran: String?,
    val pengeluaran: String?,
    val pengeluaran_iuran: String?,
    val type: String

)
