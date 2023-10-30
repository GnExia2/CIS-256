import java.io.PrintWriter;
import java.util.*;

public class StaticSet<T> {
    private HashSet<T> set = new HashSet<T>();

    // Constructs an empty StaticSet
    public StaticSet() {
    }

    // Constructs the StaticSet by adding all ArrayList items
    public StaticSet(ArrayList<T> items) {
        for (T item : items) {
            set.add(item);
        }
    }

    // Constructs the StaticSet by copying itemsToCopy's items
    public StaticSet(HashSet<T> itemsToCopy) {
        this.set = new HashSet<T>(itemsToCopy);
    }

    public boolean contains(T item) {
        return set.contains(item);
    }

    public int getSize() {
        return set.size();
    }

    public void print(PrintWriter output, String separator, String prefix, String suffix) {
        output.write(prefix);
        boolean firstItem = true;
        for (T item : set) {
            if (firstItem) {
                output.write(item.toString());
                firstItem = false;
            } else {
                output.write(separator + item.toString());
            }
        }
        output.write(suffix);
    }

    // Returns a StaticSet<T> containing each element from this set that is not
    // in otherSet.
    public StaticSet<T> difference(StaticSet<T> otherSet) {
        HashSet<T> result = new HashSet<T>(this.set);
        result.removeAll(otherSet.set);
        return new StaticSet<T>(result);
    }

    // Returns a StaticSet<T> containing each element from this set that
    // satisfies the predicate.
    // - If predicate(item) returns true (1), item satisfies the predicate.
    // - If predicate(item) returns false (0), item does not satisfy the predicate.
    public StaticSet<T> filter(Predicate<T, Integer> predicate) {
        HashSet<T> result = new HashSet<T>();
        for (T item : this.set) {
            if (predicate.predicate(item) == 1) {
                result.add(item);
            }
        }
        return new StaticSet<T>(result);
    }

    // Calls mapMethod(item) for each item in this set and adds the returned
    // item to a StaticSet<U>. After mapMethod has been called for each item
    // in this set, the StaticSet<U> object is returned.
    public <U> StaticSet<U> map(Predicate<T, U> mapMethod) {
        HashSet<U> result = new HashSet<U>();
        for (T item : this.set) {
            result.add(mapMethod.predicate(item));
        }
        return new StaticSet<U>(result);
    }

    // Returns a StaticSet<T> containing each element from this set that is also
    // in otherSet.
    public StaticSet<T> intersection(StaticSet<T> otherSet) {
        HashSet<T> result = new HashSet<T>(this.set);
        result.retainAll(otherSet.set);
        return new StaticSet<T>(result);
    }

    // Returns a StaticSet<T> containing every element from this set and every
    // element from otherSet.
    public StaticSet<T> union(StaticSet<T> otherSet) {
        HashSet<T> result = new HashSet<T>(this.set);
        result.addAll(otherSet.set);
        return new StaticSet<T>(result);
    }
}
