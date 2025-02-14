
public class ProductOfNumbers {
    private List<Integer> prefix;
    
    public ProductOfNumbers() {
        prefix = new ArrayList<>();
        prefix.add(1);  
    }
    
    public void add(int num) {
        if (num == 0) {
            prefix = new ArrayList<>();
            prefix.add(1);
        } else {
            int lastProduct = prefix.get(prefix.size() - 1);
            prefix.add(lastProduct * num);
        }
    }
    
    public int getProduct(int k) {
        int size = prefix.size();  
        if (k >= size) {
            
            return 0;
        }
        int totalProduct = prefix.get(size - 1);
        int divisor = prefix.get(size - 1 - k);
        return totalProduct / divisor;
    }
}
