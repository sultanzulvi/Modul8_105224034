package com.rpg.main;

import com.rpg.entitas.Monster;
import com.rpg.entitas.Pahlawan;
import java.util.Scanner;

public class GameEngine { // kelas utama untuk menjalankan game, mengatur alur permainan, dan mengelola interaksi antara pahlawan dan monster dalam arena
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama pahlawan: ");
        String namaPahlawan = scanner.nextLine();

        Pahlawan pahlawan = new Pahlawan(namaPahlawan, 150, 15, 50, 1);

        Monster[] daftarMonster = new Monster[3];
        daftarMonster[0] = new Monster("Monster1", 40, 10, "Kecil");
        daftarMonster[1] = new Monster("Monster2", 70, 15, "Menengah");
        daftarMonster[2] = new Monster("Monster3", 120, 25, "Besar");

        boolean menang = true;

        for (int i = 0; i < daftarMonster.length; i++) { // loop untuk melawan setiap monster dalam daftarMonster, dengan alur pertarungan yang berulang hingga salah satu pihak kalah
            Monster monsterSaatIni = daftarMonster[i];

            while (pahlawan.getHp() > 0 && monsterSaatIni.getHp() > 0) {
                pahlawan.tampilkanStatus();
                monsterSaatIni.tampilkanStatus();

                System.out.print("Pilih aksi (1=Serang, 2=Skill, 3=Bertahan): ");
                int pilihan = scanner.nextInt();
                int damagePahlawan = 0;

                switch (pilihan) {
                    case 1: // serangan biasa
                        damagePahlawan = pahlawan.serang();
                        monsterSaatIni.terimaDamage(damagePahlawan);
                        break;
                    case 2: // serangan dengan skill khusus, yang membutuhkan mana dan memberikan damage lebih besar berdasarkan level pahlawan
                        damagePahlawan = pahlawan.serang("Skill", 20);
                        if (damagePahlawan > 0) {
                            monsterSaatIni.terimaDamage(damagePahlawan);
                        }
                        break;
                    case 3: // bertahan untuk mengurangi damage yang diterima pada giliran monster berikutnya
                        pahlawan.bertahan();
                        pahlawan.gunakanItem();
                        break;
                }

                if (monsterSaatIni.getHp() <= 0) { // jika monster kalah, lanjut ke monster berikutnya
                    break; 
                }

                int damageMonster = monsterSaatIni.serang();
                pahlawan.terimaDamage(damageMonster);

                if (pahlawan.getHp() <= 0) { // jika pahlawan kalah, keluar dari loop dan menandakan game over
                    menang = false;
                    break;
                }
            }

            if (!menang) { // jika pahlawan kalah, keluar dari loop utama dan menandakan game over
                break;
            }
        }

        if (menang && pahlawan.getHp() > 0) { // jika pahlawan berhasil mengalahkan semua monster dan masih memiliki HP, menampilkan pesan kemenangan
            System.out.println("Berhasil menamatkan Dungeon");
        } else {
            System.out.println("Game Over");
        }

        scanner.close();
    }
}
