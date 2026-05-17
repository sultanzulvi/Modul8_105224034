package com.rpg.entitas;

import com.rpg.arena.Karakter;

public class Pahlawan extends Karakter { // kelas untuk pahlawan yang akan menjadi karakter utama dalam arena
    private int mana;
    private int level;

    public Pahlawan(String nama, int hp, int baseDamage, int mana, int level) { // konstruktor untuk inisialisasi pahlawan, dengan tambahan atribut mana dan level untuk memberikan variasi dalam gameplay
        super(nama, hp, baseDamage);
        this.mana = mana;
        this.level = level;
    }

    @Override
    public int serang() { // implementasi metode serang untuk pahlawan, dengan gaya serangan yang berbeda-beda berdasarkan level pahlawan
        int totalDamage = this.baseDamage * this.level;
        System.out.println(this.nama + " melakukan serangan biasa dan menghasilkan " + totalDamage + " damage!");
        return totalDamage;
    }

    public int serang(String namaSkill, int manaCost) { // metode serang dengan skill khusus, yang membutuhkan mana dan memberikan damage lebih besar berdasarkan level pahlawan
        if (this.mana >= manaCost) {
            this.mana -= manaCost;
            int totalDamage = this.baseDamage * this.level * 2;
            System.out.println(this.nama + " mengeluarkan skill [" + namaSkill + "] (Mana -" + manaCost + ")!");
            System.out.println("Serangan skill menghasilkan " + totalDamage + " damage luar biasa!");
            return totalDamage;
        } else {
            System.out.println("Eksekusi skill gagal! Mana tidak mencukupi (Mana saat ini: " + this.mana + ").");
            return 0;
        }
    }

    @Override
    public void bertahan() { // implementasi metode bertahan untuk pahlawan, dengan gaya bertahan yang berbeda-beda berdasarkan level pahlawan
        this.isDefending = true;
        System.out.println(this.nama + " memasang kuda-kuda bertahan dan bersiaga penuh!");
    }

    @Override
    public void gunakanItem() { // implementasi metode gunakanItem untuk pahlawan, dengan gaya penggunaan item yang berbeda-beda berdasarkan level pahlawan
        int pemulihanHP = 30;
        this.hp += pemulihanHP;
        System.out.println(this.nama + " menggunakan Potion! Memulihkan HP sebesar " + pemulihanHP + " poin.");
    }

    @Override
    public void tampilkanStatus() { // implementasi metode tampilkanStatus
        System.out.println("\n=== STATUS PAHLAWAN ===");
        System.out.println("Nama   : " + this.nama);
        System.out.println("HP     : " + this.hp);
        System.out.println("Mana   : " + this.mana);
        System.out.println("Level  : " + this.level);
        System.out.println("=======================");
    }

    public int getMana() { return mana; }
    public void setMana(int mana) { this.mana = mana; }

    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }
}
