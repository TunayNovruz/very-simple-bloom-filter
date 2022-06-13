public interface IBloomFilter {
    /**
     * @param word - add
     */
    void add(String word);

    /**
     * @param word -  search
     * @return false if it doesn't exist
     */
    boolean contains(String word);
}
