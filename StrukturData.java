import java.util.*;

public class StrukturData {

    String[] barang;
    int[] jumlahBarang;
    int[] hargaBarang;
    int kapasitas;
    int totalKapasitas;

    StrukturData(int kapasitas) {

        this.kapasitas = kapasitas;
        this.totalKapasitas = 0;
        this.hargaBarang = new int[kapasitas];
        this.barang = new String[kapasitas];
        this.jumlahBarang = new int[kapasitas];
    }

    public void tambahBarang(String namaBarang, int harga, int jumlah) {

        if (totalKapasitas >= kapasitas) {
            System.out.println("Kapasitas barang penuh");
            System.out.println();
            return;
        }

        barang[totalKapasitas] = namaBarang;
        hargaBarang[totalKapasitas] = harga;
        jumlahBarang[totalKapasitas] = jumlah;
        totalKapasitas++;
        System.out.println("Barang berhasil ditambahkan");
        System.out.println();
    }

    public int cariBarang(String namaBarang) {
        for (int i = 0; i < totalKapasitas; i++) {
            if (barang[i].equalsIgnoreCase(namaBarang)) {
                return i;
            }
        }
        return -1;
    }

    public void hapusBarang(String namaBarang) {
        int index = cariBarang(namaBarang);

        if (index == -1) {
            System.out.println("Barang tidak ditemukan");
            System.out.println();
            return;
        }

        for (int i = index; i < totalKapasitas - 1; i++) {
            barang[i] = barang[i + 1];
            jumlahBarang[i] = jumlahBarang[i + 1];
        }

        totalKapasitas--;
        System.out.println("Barang berhasil dihapus");
        System.out.println();
    }

    public void tampilkanBarang() {
        if (totalKapasitas == 0) {
            System.out.println("Tidak ada barang yang tersedia");
            System.out.println();
            return;
        }

        System.out.println("----------------------------");
        System.out.println("        Daftar Barang     ");
        System.out.println("----------------------------");
        for (int i = 0; i < totalKapasitas; i++) {
            System.out.println("Nama Sparepart     : " + barang[i]);
            System.out.println("Harga Sparepart    : " + hargaBarang[i]);
            System.out.println("Jumlah Sparepart   : " + jumlahBarang[i]);
            System.out.println("----------------------------");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("========================");
        System.out.println("    TOKO PAK AGUNG     ");
        System.out.println("========================");
        System.out.println();

        System.out.print("Masukkan kapasitas    : ");
        int kapasitas = input.nextInt();
        System.out.println();

        StrukturData barang = new StrukturData(kapasitas);

        boolean lanjut = true;
        while (lanjut) {
            System.out.println("Daftar Menu:");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Hapus Barang");
            System.out.println("3. Cari Barang");
            System.out.println("4. Tampilkan Barang");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            int menu = input.nextInt();
            System.out.println();

            switch (menu) {
                case 1:
                    System.out.print("Masukkan nama barang: ");
                    String namaBarang = input.next();
                    System.out.print("Masukkan harga barang: ");
                    int harga = input.nextInt();
                    System.out.print("Masukkan jumlah barang: ");
                    int jumlah = input.nextInt();
                    System.out.println();
                    barang.tambahBarang(namaBarang, harga, jumlah);
                    break;
                case 2:
                    System.out.print("Masukkan nama barang yang akan dihapus: ");
                    namaBarang = input.next();
                    System.out.println();
                    barang.hapusBarang(namaBarang);
                    break;
                case 3:
                    System.out.print("Masukkan nama barang yang akan dicari: ");
                    namaBarang = input.next();
                    System.out.println();
                    int index = barang.cariBarang(namaBarang);
                    if (index == -1) {
                        System.out.println("Barang tidak ditemukan");
                        System.out.println();
                    } else {
                        System.out.println("Barang ditemukan pada indeks: " + index);
                        System.out.println();
                    }
                    break;
                case 4:
                    barang.tampilkanBarang();
                    break;
                case 5:
                    lanjut = false;
                    break;
                default:
                    System.out.println("Menu tidak valid");
                    System.out.println();
                    break;
            }
        }

        System.out.println("Anda telah keluar!");

        input.close();

    }
}
