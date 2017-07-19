package beeth0ven.tk.qrcoder.exframeworks.foundation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import beeth0ven.tk.qrcoder.exframeworks.closures.CanCanMapWithIndex;
import beeth0ven.tk.qrcoder.exframeworks.closures.CanCombine;
import beeth0ven.tk.qrcoder.exframeworks.closures.CanHandleItem;
import beeth0ven.tk.qrcoder.exframeworks.closures.CanMap;
import beeth0ven.tk.qrcoder.exframeworks.closures.CanThen;

public class Stream<T> {

    public static <T> Stream<T> from(List<T> items) {
        return new Stream<>(items);
    }

    private final List<T> items;

    private Stream(List<T> items) {
        this.items = items;
    }

    public List<T> asList() {
        return items;
    }

    // asList

    @SafeVarargs
    public static <T> List<T> asList(T... items) {
        List<T> result = new ArrayList<>();
        Collections.addAll(result, items);
        return result;
    }

    // repeat

    public static <T> Stream<T> repeat(T item, int count) {
        List<T> items = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            items.add(item);
        }
        return new Stream<>(items);
    }

    // first

    public T first() {
        return items.isEmpty() ? null : items.get(0);
    }

    // forEach

    public void forEach(CanHandleItem<T> canHandleItem) {
        for (int i = 0; i < items.size(); i++) {
            T item = items.get(i);
            canHandleItem.handleItem(item);
        }
    }

    // map

    public final <R> Stream<R> map(CanMap<T, R> canMap) {
        List<R> newItems = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            T item = items.get(i);
            R newItem = canMap.map(item);
            newItems.add(newItem);
        }
        return Stream.from(newItems);
    }

    // map with index

    public final <R> Stream<R> mapWithIndex(CanCanMapWithIndex<T, R> canCanMapWithIndex) {
        List<R> newItems = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            T item = items.get(i);
            R newItem = canCanMapWithIndex.mapWithIndex(i, item);
            newItems.add(newItem);
        }
        return Stream.from(newItems);
    }

    // filter

    public interface CanPredicate<T> {
        boolean predicate(T value);
    }

    public final Stream<T> filter(CanPredicate<T> canPredicate) {
        List<T> newItems = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            T item = items.get(i);
            if (canPredicate.predicate(item)) {
                newItems.add(item);
            }
        }
        return Stream.from(newItems);
    }

    // reduce

    public <S> S reduce(S initail, CanCombine<S, T> canCombine) {
        S total = initail;
        for (int i = 0; i < items.size(); i++) {
            T item = items.get(i);
            total = canCombine.combine(total, item);
        }
        return total;
    }

    // indexOf

    public int indexOf(CanPredicate<T> canPredicate) {
        for (int i = 0; i < items.size(); i++) {
            T item = items.get(i);
            if (canPredicate.predicate(item)) {
                return i;
            }
        }
        return -1;
    }

    // then

    public Stream<T> then(CanThen<List<T>> canThen) {
        canThen.then(this.items);
        return this;
    }
}


