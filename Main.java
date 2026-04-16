import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Mahasiswa[] mhs = {
            new Mahasiswa("22001", "Andi", "Teknik Informatika"),
            new Mahasiswa("22002", "Budi", "Teknik Informatika"),
            new Mahasiswa("22003", "Citra", "Sistem Informasi Bisnis")
        };

        Buku[] buku = {
            new Buku("B001", "Algoritma", 2020),
            new Buku("B002", "Basis Data", 2019),
            new Buku("B003", "Pemrograman", 2021),
            new Buku("B004", "Fisika", 2024)
        };

        Peminjaman[] pinjam = {
            new Peminjaman(mhs[0], buku[0], 7),
            new Peminjaman(mhs[1], buku[1], 3),
            new Peminjaman(mhs[2], buku[2], 10),
            new Peminjaman(mhs[2], buku[3], 6),
            new Peminjaman(mhs[0], buku[1], 4)
        };

        int pilih;

        do {
            System.out.println("\n=== SISTEM PEMINJAMAN RUANG BACA JTI ===");
            System.out.println("1. Tampilkan Mahasiswa");
            System.out.println("2. Tampilkan Buku");
            System.out.println("3. Tampilkan Peminjaman");
            System.out.println("4. Urutkan Berdasarkan Denda");
            System.out.println("5. Cari Berdasarkan NIM");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilih = sc.nextInt();

        if (pilih == 1) {
        System.out.println("\n=== DATA MAHASISWA ===");
        for (Mahasiswa m : mhs) {
            m.tampilMahasiswa();
        }

        } else if (pilih == 2) {
        System.out.println("\n=== DATA BUKU ===");
        for (Buku b : buku) {
            b.tampilBuku();
        }

        } else if (pilih == 3) {
        System.out.println("\n=== DATA PEMINJAMAN ===");
        for (Peminjaman p : pinjam) {
            p.tampilPeminjaman();
        }

        } else if (pilih == 4) {
            for (int i = 0; i < pinjam.length - 1; i++) {
                for (int j = 0; j < pinjam.length - i - 1; j++) {
                    if (pinjam[j].denda < pinjam[j + 1].denda) {
                        Peminjaman temp = pinjam[j];
                        pinjam[j] = pinjam[j + 1];
                        pinjam[j + 1] = temp;
                    }
                }
            }

            System.out.println("\n=== SETELAH DIURUTKAN ===");
            for (Peminjaman p : pinjam) {
                p.tampilPeminjaman();
            }

        } else if (pilih == 5) {
            System.out.print("Masukkan NIM: ");
            String cari = sc.next();

            boolean ketemu = false;

            for (Peminjaman p : pinjam) {
                if (p.mhs.nim.equals(cari)) {
                    p.tampilPeminjaman();
                    ketemu = true;
                }
            }

            if (!ketemu) {
                System.out.println("Data tidak ditemukan!");
            }
        }

        else if (pilih == 0) {
            System.out.println("Program selesai.");

        } else {
            System.out.println("Pilihan tidak valid!");
        }
            }
            while (pilih != 0);
            sc.close();
        }
    }