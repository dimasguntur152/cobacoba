import java.util.ArrayList;
import java.util.Scanner;

public class NotaRestoran
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        ArrayList<MenuItem> menu = new ArrayList<>();
        menu.add(new MenuItem("Nasi Goreng", 15000));
        menu.add(new MenuItem("Rawom", 18000));
        menu.add(new MenuItem("Es Teh", 5000));
        menu.add(new MenuItem("Jus Jeruk", 8000));

        System.out.println("===== MENU RESTORAN =====");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i).getNama() + " - Rp " + menu.get(i).getHarga());
        }

        ArrayList<MenuItem> pesanan = new ArrayList<>();

        char lanjut;
        do {
            System.out.print("\nMasukkan nomor menu yang dipesan: ");
            int pilih = input.nextInt();

            if (pilih >= 1 && pilih <= menu.size()) {
                pesanan.add(menu.get(pilih - 1));
                System.out.println(menu.get(pilih - 1).getNama() + " ditambahkan.");
            } else {
                System.out.println("Pilihan tidak valid!");
            }

            System.out.print("Tambah pesanan lagi? (y/n): ");
            lanjut = input.next().charAt(0);

        } while (lanjut == 'y' || lanjut == 'Y');

        System.out.println("\n===== NOTA PEMBAYARAN PEMESANAN =====");

        //autocomplate
        double total = 0;
            for (MenuItem item : pesanan) 
            {
                System.out.println("- " + item.getNama() + " Rp " + item.getHarga());
                total += item.getHarga();
            }

        double pajak = total * 0.1;
        double grandTotal = total + pajak;

        System.out.println("\nTotal Harga : Rp " + total);
        System.out.println("Pajak (10%) : Rp " + pajak);
        System.out.println("Grand Total : Rp " + grandTotal);

        System.out.println("\nTerima kasih telah memesan!");
    }
}