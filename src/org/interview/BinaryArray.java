import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryArray {
    List<Integer> a;

    public BinaryArray(Integer[] values) {
        a = (List<Integer>) Arrays.asList(values);
    }

    private BinaryArray(int size) {
        a = new ArrayList<Integer>(size);
        for(int i=0; i<size; ++i) {
            a.add(i, 0);
        }
    }

    private BinaryArray() {
        a = new ArrayList<Integer>();
    }

    private int get(int index) {
        return a.get(index);
    }

    private void set(int index, int value) {
        a.set(index, value);
    }

    private int size() {
        return a.size();
    }

    BinaryArray add(BinaryArray rhs) {

        BinaryArray results = new BinaryArray(rhs.size() + 1);
        for (int i = a.size() - 1; i >= 0; i--) {
            int x = rhs.get(i) + get(i) + results.get(i + 1);
            if (x == 3) {
                results.set(i + 1, 1);
                results.set(i, 1);
            } else if (x == 2) {
                results.set(i + 1, 0);
                results.set(i, 1);
            } else if (x == 1) {
                results.set(i, 1);
            }
        }
        return results;
    }

    int convert() {
        int total = 0;
        int size = a.size();
        for (int i = a.size() - 1; i >= 0; i--) {
            if (a.get(i) > 0) {
                total += Math.pow(2, (size-i-1));
            }
        }
        return total;
    }

    BinaryArray(int value, boolean convert) {
        a = new ArrayList<Integer>();

        int counter = 1;
        boolean cont = true;
        do {
            if(value < Math.pow(2, counter)) {
                counter -= 1;
                cont = false;
            }
            else {
                counter++;
            }
        } while(cont);

        int work = value;
        for(int i = counter; i >= 0; --i) {
            if(work > 0) {
                double next = Math.pow(2, i);
                if(next > work) {
                    a.add(0);
                }
                else {
                    work -= next;
                    a.add(1);
                }
            }
            else {
                a.add(0);
            }
        }
    }

    void print() {
        a.forEach(System.out::print);
        System.out.println();
    }

    public static void main(String[] args) {
        BinaryArray c = new BinaryArray(20, true);
        c.print();

        Integer ar[] = {1, 1, 1, 1};
        Integer al[] = {0, 1, 0, 1};

        BinaryArray lhs = new BinaryArray(al);
        BinaryArray rhs = new BinaryArray(ar);
        BinaryArray sum = lhs.add(rhs);
        sum.print();

        System.out.println(sum.convert());

    }
}