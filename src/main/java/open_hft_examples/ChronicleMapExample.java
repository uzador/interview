package open_hft_examples;

import net.openhft.chronicle.map.ChronicleMap;
import net.openhft.chronicle.values.Values;

interface PostalCodeRange {
    int minCode();

    void minCode(int minCode);

    int maxCode();

    void maxCode(int maxCode);
}

class FirstRange implements PostalCodeRange {

    private int min = 1;
    private int max = 10;

    @Override
    public int minCode() {
        return min;
    }

    @Override
    public void minCode(int minCode) {
        this.min = minCode;
    }

    @Override
    public int maxCode() {
        return max;
    }

    @Override
    public void maxCode(int maxCode) {
        this.max = maxCode;
    }
}

public class ChronicleMapExample {
    public static void main(String[] args) {
        final ChronicleMap<CharSequence, PostalCodeRange> cityPostalCodes = ChronicleMap
                .of(CharSequence.class, PostalCodeRange.class)
                .name("city-postal-codes-map")
                .averageKey("Amsterdam")
                .entries(50_000)
                .create();

        final PostalCodeRange amsterdam = Values.newHeapInstance(PostalCodeRange.class);
        amsterdam.minCode(5);
        amsterdam.maxCode(15);

        cityPostalCodes.put("Amsterdam", amsterdam);
        cityPostalCodes.put("Moscow", new FirstRange());
        System.out.println(cityPostalCodes);
//        cityPostalCodes.close();
    }
}
