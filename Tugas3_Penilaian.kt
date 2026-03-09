/*
Nama  : Bagas
NIM   : F1D02310115
Mata Kuliah : Pemrograman Bergerak
Tugas : Sistem Penilaian Mahasiswa
*/

fun main() {

    // Menampilkan judul program
    println("===== SISTEM PENILAIAN =====")

    // Input nama mahasiswa
    print("Masukkan Nama Mahasiswa: ")
    val nama = readLine()

    // Input nilai UTS
    print("Masukkan Nilai UTS (0-100): ")
    val uts = readLine()!!.toDouble()

    // Input nilai UAS
    print("Masukkan Nilai UAS (0-100): ")
    val uas = readLine()!!.toDouble()

    // Input nilai tugas
    print("Masukkan Nilai Tugas (0-100): ")
    val tugas = readLine()!!.toDouble()

    // Validasi nilai harus berada pada range 0 - 100
    if (uts !in 0.0..100.0 || uas !in 0.0..100.0 || tugas !in 0.0..100.0) {
        println("Error: Nilai harus berada di antara 0 sampai 100")
        return
    }

    // Menghitung nilai akhir dengan bobot
    val nilaiAkhir = (uts * 0.3) + (uas * 0.4) + (tugas * 0.3)

    // Mengkonversi nilai akhir ke grade huruf menggunakan when dan range
    val grade = when (nilaiAkhir.toInt()) {
        in 85..100 -> "A"
        in 70..84 -> "B"
        in 60..69 -> "C"
        in 50..59 -> "D"
        else -> "E"
    }

    // Menentukan keterangan berdasarkan grade
    val keterangan = when (grade) {
        "A" -> "Sangat Baik"
        "B" -> "Baik"
        "C" -> "Cukup"
        "D" -> "Kurang"
        else -> "Sangat Kurang"
    }

    // Menentukan status kelulusan
    val status = if (nilaiAkhir >= 60) "LULUS" else "TIDAK LULUS"

    // Menampilkan hasil penilaian
    println("\n===== HASIL PENILAIAN =====")
    println("Nama        : $nama")
    println("Nilai UTS   : $uts (Bobot 30%)")
    println("Nilai UAS   : $uas (Bobot 40%)")
    println("Nilai Tugas : $tugas (Bobot 30%)")
    println("-----------------------------")
    println("Nilai Akhir : $nilaiAkhir")
    println("Grade       : $grade")
    println("Keterangan  : $keterangan")
    println("Status      : $status")

    // Menampilkan pesan berdasarkan status kelulusan
    if (status == "LULUS") {
        println("\nSelamat! Anda dinyatakan LULUS.")
    } else {
        println("\nMaaf, Anda belum lulus.")
    }
}