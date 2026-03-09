/*
Nama  : Bagas
NIM   : F1D02310115
Mata Kuliah : Pemrograman Bergerak
Tugas : Manajemen Data Mahasiswa dengan Collections
*/

data class NilaiMahasiswa(
    val nim: String,
    val nama: String,
    val mataKuliah: String,
    val nilai: Int
)

// fungsi menentukan grade
fun getGrade(nilai: Int): String {
    return when (nilai) {
        in 85..100 -> "A"
        in 70..84 -> "B"
        in 60..69 -> "C"
        in 50..59 -> "D"
        else -> "E"
    }
}

fun main() {

    // list data mahasiswa
    val daftarMahasiswa = listOf(
        NilaiMahasiswa("F1D02310102", "Aditiya Rahmat Maulana", "Pemrograman", 85),
        NilaiMahasiswa("F1D02310115", "Lalu Ahmad Purwadi", "Pemrograman", 92),
        NilaiMahasiswa("F1D02310103", "Didy Ardianto", "Pemrograman", 68),
        NilaiMahasiswa("F1D02310104", "Yudhi Fajar Pratama", "Pemrograman", 45),
        NilaiMahasiswa("F1D02310105", "Eka Saputra", "Pemrograman", 74),
        NilaiMahasiswa("2024006", "Fajar Nugraha", "Pemrograman", 81),
        NilaiMahasiswa("2024007", "Gita Permata", "Pemrograman", 59),
        NilaiMahasiswa("2024008", "Hadi Wijaya", "Pemrograman", 90),
        NilaiMahasiswa("2024009", "Intan Sari", "Pemrograman", 72),
        NilaiMahasiswa("2024010", "Joko Susilo", "Pemrograman", 65)
    )

    println("===== DATA NILAI MAHASISWA =====")
    println("No  NIM       Nama              MataKuliah       Nilai")

    daftarMahasiswa.forEachIndexed { index, mhs ->
        println("${index + 1}   ${mhs.nim}   ${mhs.nama}      ${mhs.mataKuliah}      ${mhs.nilai}")
    }

    // statistik
    val rataRata = daftarMahasiswa.map { it.nilai }.average()

    val tertinggi = daftarMahasiswa.maxByOrNull { it.nilai }
    val terendah = daftarMahasiswa.minByOrNull { it.nilai }

    println("\n===== STATISTIK =====")
    println("Total Mahasiswa : ${daftarMahasiswa.size}")
    println("Rata-rata Nilai : $rataRata")
    println("Nilai Tertinggi : ${tertinggi?.nilai} (${tertinggi?.nama})")
    println("Nilai Terendah  : ${terendah?.nilai} (${terendah?.nama})")

    // mahasiswa lulus
    val lulus = daftarMahasiswa.filter { it.nilai >= 70 }

    println("\n===== MAHASISWA LULUS =====")
    lulus.forEachIndexed { index, mhs ->
        println("${index + 1}. ${mhs.nama} - ${mhs.nilai} (${getGrade(mhs.nilai)})")
    }

    // mahasiswa tidak lulus
    val tidakLulus = daftarMahasiswa.filter { it.nilai < 70 }

    println("\n===== MAHASISWA TIDAK LULUS =====")
    tidakLulus.forEach {
        println("${it.nama} - ${it.nilai}")
    }

    // sorting ascending
    val ascending = daftarMahasiswa.sortedBy { it.nilai }

    println("\n===== URUT NILAI ASCENDING =====")
    ascending.forEach {
        println("${it.nama} - ${it.nilai}")
    }

    // sorting descending
    val descending = daftarMahasiswa.sortedByDescending { it.nilai }

    println("\n===== URUT NILAI DESCENDING =====")
    descending.forEach {
        println("${it.nama} - ${it.nilai}")
    }

    // grouping berdasarkan grade
    val groupGrade = daftarMahasiswa.groupBy { getGrade(it.nilai) }

    println("\n===== JUMLAH PER GRADE =====")
    groupGrade.forEach { (grade, mahasiswa) ->
        println("Grade $grade : ${mahasiswa.size} mahasiswa")
    }

    // pencarian nama
    val keyword = "ani"

    val hasilCari = daftarMahasiswa.filter {
        it.nama.contains(keyword, ignoreCase = true)
    }

    println("\n===== HASIL PENCARIAN NAMA '$keyword' =====")
    hasilCari.forEach {
        println("${it.nama} - ${it.nilai}")
    }
}