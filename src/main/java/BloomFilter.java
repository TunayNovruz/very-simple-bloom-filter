import static java.lang.Math.pow;

public class BloomFilter implements IBloomFilter {

    boolean[] map;
    int size;

    public BloomFilter(int size) {
        this.size = size;
        map = new boolean[size];
    }

    /**
     * @param word - add
     */
    @Override
    public void add(String word) {

        if (word == null) {
            throw new IllegalArgumentException("Null value");
        }
        map[h1(word)] = true;
        map[h2(word)] = true;
        map[h3(word)] = true;
        map[h4(word)] = true;
    }

    /**
     * @param word -  search
     * @return false if it doesn't exist
     */
    @Override
    public boolean contains(String word) {
        return map[h1(word)] && map[h2(word)] && map[h3(word)] && map[h4(word)];
    }


    private int h1(String s) {
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = (hash + (s.charAt(i))) % size;
        }
        return hash;
    }

    int h2(String s) {
        int hash = 1;
        for (int i = 0; i < s.length(); i++) {
            hash = (hash + (int) pow(19, i) * s.charAt(i)) % size;
        }
        return hash;
    }

    int h3(String s) {
        int hash = 7;
        for (int i = 0; i < s.length(); i++) {
            hash = (hash * 31 + s.charAt(i)) % size;
        }
        return hash;
    }

    int h4(String s) {
        int hash = 3;
        for (int i = 0; i < s.length(); i++) {
            hash += hash * 7 + s.charAt(0) * pow(7, i);
            hash = hash % size;
        }
        return hash;
    }
}
