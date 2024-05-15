import java.util.ArrayList;//meng import arrayList pada program
import java.util.Scanner;//meng import Scanner pada program
class buku{//deklarasi class buku
    private ArrayList<String>judulBuku; //membuat atribut privat untuk menympan judul dengan arrayList
    private ArrayList<String>pengarangBuku;//membuat atribut privat untuk menyimpan pengarang dengan arrayList
    private ArrayList<Boolean>ketersediaanBuku;//membuat atribut privat untuk menyimpan ketersediaan dengan arrayList
    
    public buku(){//konstruktor 
        judulBuku = new ArrayList<>();//inisialisasi arrayList judulBuku
        pengarangBuku = new ArrayList<>();//inisialisasi arrayList pengarangBuku
        ketersediaanBuku = new ArrayList<>();//inisialisasi arrayList ketersedianBuku
    }
    
    public void setBuku(String judul,String pengarang,boolean ketersedian){//setter untuk menambahkan buku dengan satu class saja karena semua komponen dari buku dianggap bersifat wajib ada semua
        judulBuku.add(judul);//Menambahkan judul buku kepada arraylist judulBuku dengan isi yang di kembalikan oleh variabel judul
        pengarangBuku.add(pengarang);//Menambahkan pengarang buku kepada arraylist pengarangBuku dengan isi yang di kembalikan oleh variabel pengarang
        ketersediaanBuku.add(ketersedian);//menambahkan keterangan tidak tersedia kepada arraylist ketersediaanBuku        
    }

    public boolean rubahKetersediaan(String judul){//merubah ketersediaan buku jika sudah ada yang meminjam
        int index = judulBuku.indexOf(judul);//mencari indexbuku sesuai dengan judul dan meyimpannya pada variable index 
        if (index != -1) {//kondisi jika index bukan bernilai -1 (Judul Buku yang di cari ada pada arrayList judulBuku)
            return ketersediaanBuku.set(index,false); //mengembalikan false ketersediaan jika kondisi terpenuhi
        }else{//selain kondisi if
            return true;//me return nilai tru jika buku tidak tersedia/tidak di temukan
        }
    }
    public boolean resetKetersediaan(String judul){//method reset ketersediaan buku
        int index = judulBuku.indexOf(judul);//mencari indexbuku sesuai dengan judul dan meyimpannya pada variable index 
        if (index != -1) {//kondisi jika index bukan bernilai -1 (Judul Buku yang di cari ada pada arrayList judulBuku)
            return ketersediaanBuku.set(index,true); //mengembalikan true ketersediaan jika kondisi terpenuhi
        }else{//selain kondisi if
            return false;//me return nilai false jika buku tidak tersedia/tidak di temukan
        }
    }
    
    public String getJudulBuku(int noBuku){//mengambil(menampilkan)isi dari judulBuku
       return judulBuku.get(noBuku); //melakukan pengembalian(mengembalikan) judulBuku
    }
    
    public ArrayList<String> getPengarangBuku(){//mengambil(menampilkan)isi dari pengarangBuku
       return pengarangBuku; //melakukan pengembalian(mengembalikan) pengarangBuku
    }
    
    public boolean getKetersediaanBuku(String judul){//mengambil(menampilkan)isi dari ketersediaanbuku
       int index = judulBuku.indexOf(judul);//mencari indexbuku sesuai dengan judul dan meyimpannya pada variable index 
       if (index != -1) {//kondisi jika index bukan bernilai -1 (Judul Buku yang di cari ada pada arrayList judulBuku)
            return ketersediaanBuku.get(index); //mengembalikan isi ArrayList ketersediaan jika kondisi terpenuhi
       }else{//selain kondisi if
        return false;//me return nilai false jika buku tidak tersedia/tidak di temukan
       }
    }
    public int getIndexBuku(String indBuku){//berfungsi untuk mendapat indexbuku yang di input user untuk nanti di tampilkan/dipinjam/di tambah pada bukuDipinjam
        int index = judulBuku.indexOf(indBuku);//mencari indexbuku sesuai dengan judul dan meyimpannya pada variable index
        if (index != -1) {//kondisi jika index bukan bernilai -1 (Judul Buku yang di cari ada pada arrayList judulBuku)
            return index;//mengembalikan nilai index dari buku yang di cari jika kondisi terpenuhi
        }else{//selain if
        return 2147483647;//mengembalikan nilai terbesar pada type int 
       }
    }
    
    public String daftarBukuAll(){//menampilkan keseluruhan daftar buku
        StringBuilder daftarBuku = new StringBuilder();//membuat objek StringBuilder baru bernama daftarBuku yang akan digunakan untuk membangun string yang berisi daftar semua buku yang tersedia di perpustakaan.
        for (int i = 0; i < judulBuku.size(); i++) {//looping tambah satu sampai besaran isi dari judulBuku
            daftarBuku.append("====================-"+(i+1)+"-====================\n\n");//menambah isi variable i + 1 dengan gaya ke daftarBuku(StringBuilder)
            daftarBuku.append("Judul Buku\t\t|  ").append(judulBuku.get(i)).append("\n");//menambah judul buku dengan index sesuai isi variable i dengan gaya ke daftarBuku(StringBuilder)
            daftarBuku.append("Pengarang Buku\t\t|  ").append(pengarangBuku.get(i)).append("\n\n");//menambah pengarang buku dengan index sesuai isi variable i dengan gaya ke daftarBuku(StringBuilder)
        }
        return daftarBuku.toString();//mengembalikan string yang berisi daftar semua buku yang tersedia di perpustakaan.
    }
    
}
class user{//deklarasi class user
    private ArrayList<String>namaUser;//inisialisasi arrayList
    private ArrayList<Integer>nimUser;//inisialisasi arrayList
    private ArrayList<Boolean>statusUser;//inisialisasi arrayList
    
    public user(){//kontruktor
        namaUser = new ArrayList<>();//inisialisasi ArrayList namaUser
        nimUser = new ArrayList<>();//inisialisasi ArrayLisat nimUser
        statusUser = new ArrayList<>();//inisialisasi ArrayList statusUser
    }
    public void setUser(String nama,int nim){//Setter untuk User
        namaUser.add(nama);//menambah nama user sesuai input
        nimUser.add(nim);//menambah nim user sesuai input
        statusUser.add(true);//menambah status user sesuai devault (true)
    }
    public String getNama(int indexUser){//geter nama user dengan index
        return namaUser.get(indexUser);//mengembalikan nama user sesuai index
    }
    public ArrayList<Integer>getNim(){//mengembalikan isi arrayList nim user  
        return nimUser;//mengembalikan nim user
    }
    public boolean getStatusUser(String nama){//geter status user
        int index = namaUser.indexOf(nama);//mencari index user sesuai nama yang di input dan menampungnya di variable index
        if (index != -1) {//kondisi jika index bukan ber isi -1(user tidak ada)
             return statusUser.get(index);//mengambil status user sesuai index
        }else{//kodisi selain if
         return false;//mengembalikan nilai false
        }
     }
    public int getIndexUser(String indUser){//geter index dari user sesuai nama
        int index = namaUser.indexOf(indUser);//mencari index user sesuai nama yang di input dan menampungnya di variable index
        if (index != -1) {//kondisi jika index bukan ber isi -1(user tidak ada)
            return index;//mengembalikan index user jika kondisi terpenuhi
        }else{//selain if
        return 2147483647;//mengembalikan nilai terbesar pada type int 
       }
    }
}
class peminjaman {//deklarasi class peminjaman
    private ArrayList<String> bukuDipinjam ; // Daftar buku yang dipinjam
    private ArrayList<String> userPeminjam ;   // Daftar user yang meminjam
    private ArrayList<Boolean> statusPeminjaman ; // status peminjaman buku (true == dikembalikan/false = belum dikembalikan)
    buku buku = new buku(); //object buku baru dengan nama buku
    user user = new user();//objek user baru dengan nama user

    public peminjaman(buku buku,user user){//construktor
        bukuDipinjam = new ArrayList<>();//inisialisasi arraylist bukuDipinjam
        userPeminjam = new ArrayList<>();//inisialisasi arraylist userPeminjam
        statusPeminjaman = new ArrayList<>();//inisialisasi arraylist statusPeminjaman
        this.buku = buku;//menetapkan objek buku yang dipass sebagai parameter ke atribut buku pada objek peminjaman yang sedang dibuat.
        this.user = user;//menetapkan objek user yang dipass sebagai parameter ke atribut user pada objek peminjaman yang sedang dibuat.
    }
    
    public void pinjamBuku(String judulBuku , String peminjam) {//menambahkan data peminjaman(meminjam Buku)
        boolean tersedia = buku.getKetersediaanBuku(judulBuku);//mengambil nilai dari class buku(ketersediaan buku) sesuai judulBuku dan di tampung di variable tersedia
        boolean terdaftar = user.getStatusUser(peminjam);//mengambil nilai dari class user(ketersediaan user) sesuai Namauser dan di tampung di variable terdaftar
        int indexBuku = buku.getIndexBuku(judulBuku);//menjadikan indexBuku sebagai penampung output getIndexBuku
        int indexUser = user.getIndexUser(peminjam);//menjadikan indexUser sebagai penampung output getIndexUser
        if(tersedia && terdaftar){//kondisi ketika user sudah terdaftar dan buku tidak sedang di pinjam(tersedia)
            bukuDipinjam.add(buku.getJudulBuku(indexBuku));//menambah judulbuku yang di ambil dari getJudulbuku kepada ArrayList  bukuDipinjam
            userPeminjam.add(user.getNama(indexUser));//menambah nama peminjam buku kepada ArrayList userPeminjam
            statusPeminjaman.add(false);//menambah status di pinjam
            System.out.println(user.getNama(indexUser)+ " Berhasil Meminjam buku "+buku.getJudulBuku(indexBuku));//output untuk memberikan keterangan peminjaman berhasil 
        }else if(tersedia){//jika user belum registrasi
            System.out.println("User Belum Terdaftar");//memberikan output belum terdaftar
        }else if(terdaftar){//jika buku sedang di pinjam atau buku tidak tersedia
            System.out.println("Buku Tidak Tersedia");//memberi output tidak tersedia
        }else {//jika tidak memenuhi salah satu pun kriteria 
            System.out.println("Input Tidak Valid");//memberikan keterangan bahwa input tidak valid
        }
        buku.rubahKetersediaan(judulBuku);//merubah ketersediaan buku
    }
    public void kembalikanBuku(String judulBuku, String peminjam) {//method mengambalikan buku
        int indexBuku = bukuDipinjam.indexOf(judulBuku);//menjadikan indexBuku sebagai penampung output getIndexBuku
        int indexUser = userPeminjam.indexOf(peminjam);//menjadikan indexUser sebagai penampung output getIndexUser

        if (indexBuku != -1 && indexUser != -1) {//kondisi jika buku dan user ada pada bukuDipinjam & userPeminjam
            statusPeminjaman.set(indexBuku,true);
            System.out.println("Buku " + judulBuku + " telah dikembalikan oleh " + peminjam + ".");//pemanis
        } else {//jika if tidak terpenuhi
            System.out.println("Pengembalian gagal. Buku atau user tidak ditemukan.");//pemanis
        }
        buku.resetKetersediaan(judulBuku); // Merubah ketersediaan buku menjadi true dengan cara di reset
    }

    public String riwayatPeminjaman() {//  menampilkan riwayat peminjaman
        StringBuilder riwayat = new StringBuilder();//membuat objek StringBuilder baru bernama riwayat yang akan digunakan untuk membangun string yang berisi daftar semua peminjaman.
        riwayat.append("\n=== Riwayat Peminjaman ===\n\n");//menambah keterangan
        for (int i = 0; i < bukuDipinjam.size(); i++) {//looping dari i sampai besaran isi dari bukuDipinjam
            Boolean status = statusPeminjaman.get(i);
            String strStatus;
            if (status == true ){
                strStatus = "Buku Sudah Di Kembalikan";
            }else{
                strStatus = "Buku Belum Dikembalikan";
            }
            riwayat.append((i + 1) + ". " + userPeminjam.get(i) + " Meminjam Buku "+ bukuDipinjam.get(i)   + "\n  -Status Paminjaman "+ strStatus +"\n");//menambah output isi dari riwayat peminjaman
        }
        return riwayat.toString();//mengembalikan String yang berisi semua riwayat peminjaman
    }
}
public class perpustakaanUstAli {//deklarasi main class
    public static void main(String[]args){//inisialisasi method main
        Scanner as = new Scanner(System.in);//membuat scanner baru
        buku buku = new buku();//membuat objek buku baru
        user user = new user();//membuat objek user baru
        peminjaman pinjam = new peminjaman(buku,user);//membuat objek peminjaman baru
        //menambah buku
        buku.setBuku("Al-jabarLinear", "Al-Jabbar", true);
        buku.setBuku("Kalkulus Lanjut", "Drs. Supriyadi", true);
        buku.setBuku("Pemrograman Java", "Bambang Setyawan", true);
        buku.setBuku("Algoritma dan Struktur Data", "Donny Putra", true);
        buku.setBuku("Fisika Dasar", "Dr. Rini Puspita", true);
        buku.setBuku("Kimia Organik", "Prof. Dr. Ir. Budi Hartono", true);
        buku.setBuku("Biologi Sel", "Dr. Dian Anggraini", true);
        buku.setBuku("Anatomi Manusia", "Prof. Dr. Ir. Agus Salim", true);
        buku.setBuku("Ekonomi Mikro", "Dr. Hendra Gunawan", true);
        buku.setBuku("Ekonomi Makro", "Prof. Dr. Ir. Tuti Wulandari", true);
        buku.setBuku("Manajemen Keuangan", "Dr. Adi Setiawan", true);
        buku.setBuku("Manajemen Pemasaran", "Prof. Dr. Ir. Rini Dwi Astuti", true);
        buku.setBuku("Manajemen Sumber Daya Manusia", "Dr. Agung Prasetyo", true);
        buku.setBuku("Sistem Informasi Manajemen", "Prof. Dr. Ir. Budi Setiawan", true);
        buku.setBuku("Kewirausahaan", "Dr. Dian Puspita", true);
        buku.setBuku("Penelitian Tindakan", "Prof. Dr. Ir. Agus Hartono", true);
        //menambah user
        user.setUser("Ali", 222140079);
        user.setUser("Budi", 222140080);
        user.setUser("Cici", 222140081);
        user.setUser("Dedi", 222140082);
        user.setUser("Evi", 222140083);
        user.setUser("Fani", 222140084);
        user.setUser("Gita", 222140085);

        //menambah peminjaman
        pinjam.pinjamBuku("Al-jabarLinear", "Ali");
        pinjam.pinjamBuku("Algoritma dan Struktur Data", "Ali"); //
        pinjam.pinjamBuku("Manajemen Pemasaran", "Budi"); 
        pinjam.pinjamBuku("Pemrograman Java", "Cici"); 
        pinjam.pinjamBuku("Biologi Sel", "Dedi"); 
        pinjam.pinjamBuku("Fisika Dasar", "Evi"); 
        pinjam.pinjamBuku("Kimia Organik", "Fani"); 
        pinjam.pinjamBuku("Ekonomi Mikro", "Gita"); 

        int pilihan;//membuat variable baru
        System.out.println("\n=== SelamatDatang Di Perpustakaan Ali ===");//pemanis
        do {//looping do-while
            System.out.println("\nMenu Perpustakaan:\n------------------\n1. Lihat Daftar Buku\n2. Pinjam Buku\n3. Tampilkan Riwayat Peminjaman\n4. Register\n5. Kembalikan Buku \n6. Keluar");//intervace user untuk melihat isi menu
            System.out.print("Pilih opsi: ");//pemanis
            pilihan = as.nextInt();//menerima input pilihan (opsi menu) yang di berikan user
            as.nextLine(); // Konsumsi baris baru agar input tidak ter skip

            switch (pilihan) {//membuat switch
                case 1://deklarasi case 1
                    System.out.println(buku.daftarBukuAll());//mengambil dan menampilkan isi method daftarBukuAll
                    break;//break case1
                case 2://deklarasi case 2
                    System.out.print("Masukkan judul buku yang ingin dipinjam: ");//pemanis
                    String judulBuku = as.nextLine();//menampung inpu judulBuku yang di berikan user
                    System.out.print("Masukkan nama peminjam: ");//pemanis
                    String namaUser = as.nextLine();//menampung inpu judulBuku yang di berikan user
                    pinjam.pinjamBuku(judulBuku,namaUser);//mengambil dan menampilkan method pinjam buku
                    break;//break case2
                case 3://deklarasi case 3
                    System.out.println(pinjam.riwayatPeminjaman());//mengambil & menampilkan method riwayat peminjaman
                    break;//break case3
                case 4://deklarasi case 4
                    System.out.println("Silahkan Lengkapi Data Diri Anda");//pemanis
                    System.out.print("Masukkan Nama : ");//pemanis
                    String newName = as.nextLine();//menerima input nama baru yang di berikan user
                    System.out.print("Masukkan NIM : ");//pemanis
                    int newNim = as.nextInt();//manerima input nim baru yang di berikan oleh user
                    if (newNim < 0) {//validasi input nim
                        System.out.println("NIM tidak valid. Silakan masukkan NIM yang positif.");//nim tidak valid
                    } else {//selain if
                        user.setUser(newName, newNim);//tambah user ke setUser
                        System.out.println("User degan Nama "+newName+" Dengan Nim "+newNim+" Telah Berhasil Registrasi");
                    }
                    break;//break case4
                case 5:
                    System.out.print("Masukkan Judul buku yang ingin di kembalikan : ");//pemanis
                    String bukuKembali = as.nextLine();//menerima input judul buku yang ingin di kembalikan
                    System.out.print("Masukkan nama peminjam buku : ");//pemanis
                    String userPengembali = as.nextLine();//menerima input nama user yang mengembalikan buku
                    pinjam.kembalikanBuku(bukuKembali, userPengembali);//menambah pengembalian
                case 6://deklarasi case 6
                    System.out.println("=== Terima kasih telah menggunakan Perpustakaan Kami ===");//closing
                    break;//break case6
                default://deklarasi default
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.!!!");//input tidak valid
            }
        } while (pilihan != 6);//while jika pilihan 5 looping di stop 

        as.close();//closing scanner
    }
}