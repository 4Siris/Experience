package com.company;

import java.util.ArrayList;
import java.util.List;

public class CosmeticShop {
    private List<Cosmetics> cosmetics;

    public CosmeticShop()
    {
        cosmetics =new ArrayList<>();
    }
    public CosmeticShop(List<Cosmetics> cosmetics)
    {
        this.cosmetics = cosmetics;
    }

    public void addCosmetics(Cosmetics cosmetics){
        this.cosmetics.add(cosmetics);
    }
    public void removeCosmetics(int index){
        cosmetics.remove(index);
    }
    public void removeCosmetics(Cosmetics cosmetics){
        this.cosmetics.remove(cosmetics);
    }

    public void showAllCosmetics(){
        for(Cosmetics cosmetics : this.cosmetics){
            System.out.println(""+(this.cosmetics.indexOf(cosmetics)+1)+". "+ cosmetics);
        }
    }
    public void showOnlyLipsticks(){
        for(Cosmetics cosmetics : this.cosmetics){
            if(cosmetics instanceof Lipstick) System.out.println(""+(this.cosmetics.indexOf(cosmetics)+1)+". "+ cosmetics);
        }
    }
    public void showOnlyCreams(){
        for(Cosmetics cosmetics : this.cosmetics){
            if(cosmetics instanceof Cream) System.out.println(""+(this.cosmetics.indexOf(cosmetics)+1)+". "+ cosmetics);
        }
    }
    public void showOnlyFootCreams(){
        for(Cosmetics cosmetics : this.cosmetics){
            if(cosmetics instanceof FootCream) System.out.println(""+(this.cosmetics.indexOf(cosmetics)+1)+". "+ cosmetics);
        }
    }
    public void showOnlyHandCreams(){
        for(Cosmetics cosmetics : this.cosmetics){
            if(cosmetics instanceof HandCream) System.out.println(""+(this.cosmetics.indexOf(cosmetics)+1)+". "+ cosmetics);
        }
    }
    public void showOnlyFaceCreams(){
        for(Cosmetics cosmetics : this.cosmetics){
            if(cosmetics instanceof FaceCream) System.out.println(""+(this.cosmetics.indexOf(cosmetics)+1)+". "+ cosmetics);
        }
    }
    public void showOnlyPowders(){
        for(Cosmetics cosmetics : this.cosmetics){
            if(cosmetics instanceof Powder) System.out.println(""+(this.cosmetics.indexOf(cosmetics)+1)+". "+ cosmetics);
        }
    }
    public void showOnlyHighLighters(){
        for(Cosmetics cosmetics : this.cosmetics){
            if(cosmetics instanceof Highlighter) System.out.println(""+(this.cosmetics.indexOf(cosmetics)+1)+". "+ cosmetics);
        }
    }
    public void showOnlyBronzers(){
        for(Cosmetics cosmetics : this.cosmetics){
            if(cosmetics instanceof Bronzer) System.out.println(""+(this.cosmetics.indexOf(cosmetics)+1)+". "+ cosmetics);
        }
    }

}
