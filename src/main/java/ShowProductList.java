public class ShowProductList {
    StringBuilder productList;

    ShowProductList(StringBuilder productList) {
        this.productList = productList;
    }

    void printProductList(){
        System.out.println(productList);
    }
}
