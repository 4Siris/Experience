package com.company;

public class Main {

    public static void main(String[] args) {
        CosmeticShop cosmeticShop =new CosmeticShop();
        cosmeticShop.addCosmetics(new Bronzer());
        cosmeticShop.addCosmetics(new Highlighter("Синий", false, "Никакой", 13, 1, true, 99));
        cosmeticShop.addCosmetics(new HandCream("Секрет", 7, "А ты угадай", 0, 1, false, 1, new Sex(), new Age(12, 23)));
        cosmeticShop.addCosmetics(new FootCream("Мужыцкий", 2, "Викинг", 69, 0, true, 1000, new Sex("Женщина"), new Age()));
        cosmeticShop.addCosmetics(new Lipstick("Чёрный", "Готтты", 4, 20, false, 100000));
        cosmeticShop.showAllCosmetics();
        cosmeticShop.showOnlyCreams();
        cosmeticShop.showOnlyLipsticks();
        cosmeticShop.showOnlyFootCreams();
    }
}
