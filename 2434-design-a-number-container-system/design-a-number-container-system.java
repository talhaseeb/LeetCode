
public class NumberContainers {
    private Map<Integer, Integer> indexToNumber;
    private Map<Integer, TreeSet<Integer>> numberToIndices;
    
    public NumberContainers() {
        indexToNumber = new HashMap<>();
        numberToIndices = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if (indexToNumber.containsKey(index)) {
            int oldNumber = indexToNumber.get(index);
            TreeSet<Integer> indices = numberToIndices.get(oldNumber);
            if (indices != null) {
                indices.remove(index);
            }
        }
        indexToNumber.put(index, number);
        numberToIndices.putIfAbsent(number, new TreeSet<>());
        numberToIndices.get(number).add(index);
    }
    
    public int find(int number) {
        if (!numberToIndices.containsKey(number) || numberToIndices.get(number).isEmpty()) {
            return -1;
        }
        return numberToIndices.get(number).first();
    }
}
