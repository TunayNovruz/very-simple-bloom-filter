public class BloomFilter implements IBloomFilter {

    int[] map;
    int size;

    public BloomFilter(int size) {
        this.size = size;
        map = new int[size];
    }

    /**
     * @param word - add
     */
    @Override
    public void add(String word) {
        map[getHash(word)] = 1;
    }

    /**
     * @param word -  search
     * @return false if it doesn't exist
     */
    @Override
    public boolean contains(String word) {
        return map[getHash(word)] > 0;
    }

    private int getHash(String word) {
        if (word == null){
            throw new IllegalArgumentException("Null value");
        }
        return word.hashCode() % size;
    }
}
