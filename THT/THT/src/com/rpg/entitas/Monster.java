package com.rpg.entitas;

import com.rpg.arena.Karakter;

public class Monster extends Karakter { // kelas untuk monster yang akan menjadi musuh dalam arena, seperti goblin, troll, dan naga
    private String jenisMonster;

    public Monster(String nama, int hp, int baseDamage, String jenisMonster) { // konstruktor untuk inisialisasi monster, dengan tambahan atribut jenisMonster untuk membedakan tipe monster
        super(nama, hp, baseDamage);
        this.jenisMonster = jenisMonster;
    }

    @Override
    public int serang() { // implementasi metode serang untuk monster, dengan gaya serangan yang berbeda-beda berdasarkan jenis monster
        System.out.println("Monster " + this.nama + " (" + this.jenisMonster + ") mencakar liar!");
        return this.baseDamage;
    }

    @Override
    public void bertahan() { // implementasi metode bertahan untuk monster, dengan gaya bertahan yang berbeda-beda berdasarkan jenis monster
        int pemulihanHpMonster = 15;
        this.hp += pemulihanHpMonster;
        System.out.println("Monster " + this.nama + " mengaum dan memulihkan HP sebesar " + pemulihanHpMonster + " poin!");
    }

    @Override
    public void gunakanItem() { // implementasi metode gunakanItem untuk monster, dengan gaya penggunaan item yang berbeda-beda berdasarkan jenis monster
        System.out.println("Monster tidak tahu cara menggunakan item manusia!");
    }

    @Override
    public void tampilkanStatus() { // implementasi metode tampilkanStatus untuk monster, menampilkan nama, jenis monster, dan HP saat ini
        System.out.println("-> " + this.nama + " [" + this.jenisMonster + "] | HP: " + this.hp);
    }

    public String getJenisMonster() { return jenisMonster; } 
    public void setJenisMonster(String jenisMonster) { this.jenisMonster = jenisMonster; } 
}
