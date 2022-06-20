import java.util.ArrayList;
import java.util.Scanner;

public class SoalString {
    public static void main(String[] args) {
        
        ArrayList<String> nama = new ArrayList<String>();
        nama.add("Farel");
        nama.add("Vito");
        nama.add("Harris");
        nama.add("Revyn");

        String param = "y";
        String param2 = "y";
        while(param.equalsIgnoreCase(param2)){
            Scanner inputan = new Scanner(System.in);  
            System.out.print("\nPilih menu :\n1.Tambah Data\n2.Tampilkan data\n3.Ubah data\nMasukan pilihan : ");
            String pilihan = inputan.nextLine();

            switch(pilihan){
                case "1":
                    //lakukan tambah data
                    System.out.println("\nMasukan nama baru : ");
                    String namaBaru = inputan.nextLine().toLowerCase();
                    String namaBaruHurufDepan = namaBaru.substring(0,1).toUpperCase();
                    String namaBaruHurufBelakang = namaBaru.substring(1);
                    String namaAkhir = namaBaruHurufDepan+ namaBaruHurufBelakang;
                    nama.add(namaAkhir);
                    break;
                case "2":
                    //lakukan tampilkan data
                    System.out.println("\nData saat ini");
                    int counter = 1;
                    for(String data: nama){
                        System.out.println(Integer.toString(counter) + ". " + data);
                        counter++;
                    }
                    break;
                case "3":
                    //lakukan update data
                    System.out.println("Nama untuk diubah : ");
                    String namaUbah = inputan.nextLine();
                    System.out.println("Masukan nama terbaru : ");
                    String namaUpdate = inputan.nextLine();

                    for(int i=0;i<nama.size();i++){
                        if(nama.get(i).equalsIgnoreCase(namaUbah)){
                            String dataNama = namaUpdate.toLowerCase();
                            String hurufDepan = dataNama.substring(0,1).toUpperCase();
                            String hurufBelakang = dataNama.substring(1);
                            String namaLast = hurufDepan+ hurufBelakang;

                            nama.set(i, namaLast);
                            break;
                        }
                    }
                    break;
                default:
                    param2 = "Exit";
            }
        }
    }
}
