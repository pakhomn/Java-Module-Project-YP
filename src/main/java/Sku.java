public class Sku {
    String name; //название товара
    double price; // цена товара
    public static int goodsCount;

    //теперь делаем  конструктор для товара
    Sku(String nameSKU, double priceSKU){
        name = nameSKU;
        price = priceSKU;
        goodsCount++;
    }
}
