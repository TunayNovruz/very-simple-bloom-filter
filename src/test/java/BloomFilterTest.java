import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BloomFilterTest {

    @Test
    void add() {
        BloomFilter bloomFilter = new BloomFilter(10);
        bloomFilter.add("Test");
        bloomFilter.add("");
        assertThrows(IllegalArgumentException.class, () -> bloomFilter.add(null));
    }

    @Test
    void contains() {
        BloomFilter bloomFilter = new BloomFilter(10);
        bloomFilter.add("Test");
        bloomFilter.add("check");
        bloomFilter.add("bloom");
        bloomFilter.add("Filter");

        assertFalse(bloomFilter.contains("test"));
        assertThrows(IllegalArgumentException.class, () -> bloomFilter.contains(null));

    }
}