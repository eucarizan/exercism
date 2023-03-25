import java.util.List;

public class BinarySearch {
    private List<Integer> list;

    public BinarySearch(List<Integer> list) {
        this.list = list;
    }

    public int indexOf(int target) throws ValueNotFoundException {
        int lo = 0;
        int hi = list.size();

        if (list.size() == 0) {
            throw new ValueNotFoundException("Value not in array");
        }

        do {
            int mid = (int) Math.floor(lo + (hi - lo) / 2);
            int num = list.get(mid);

            if (num == target) {
                return mid;
            } else if (num > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        } while (lo < hi);
        
        throw new ValueNotFoundException("Value not in array");
    }
}
