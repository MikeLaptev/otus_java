package com.mlaptev.app;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<T> implements List<T> {

  private int size = 0;
  private int capacity = 0;
  private T[] elements = (T[]) new Object[]{};

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public boolean contains(Object o) {
    return Arrays.stream(elements)
        .limit(size())
        .anyMatch(t -> t.equals(o));
  }

  @Override
  public Object[] toArray() {
    return Arrays.copyOf(elements, size());
  }

  @Override
  public <T1> T1[] toArray(T1[] a) {
    for (int i = 0; i < a.length && i < size(); i++) {
      a[i] = (T1) elements[i];
    }
    return a;
  }

  @Override
  public void clear() {
    size = 0;
    capacity = 0;
    elements = (T[]) new Object[]{};
  }

  @Override
  public T get(int index) {
    if (0 <= index && index < size) {
      return elements[index];
    }
    throw new IndexOutOfBoundsException("Invalid index provided.");
  }

  @Override
  public Iterator<T> iterator() {
    return null;
  }

  @Override
  public boolean add(T t) {
    return false;
  }

  @Override
  public boolean remove(Object o) {
    return false;
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    return false;
  }

  @Override
  public boolean addAll(Collection<? extends T> c) {
    return false;
  }

  @Override
  public boolean addAll(int index, Collection<? extends T> c) {
    return false;
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    return false;
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    return false;
  }

  @Override
  public T set(int index, T element) {
    return null;
  }

  @Override
  public void add(int index, T element) {

  }

  @Override
  public T remove(int index) {
    return null;
  }

  @Override
  public int indexOf(Object o) {
    return 0;
  }

  @Override
  public int lastIndexOf(Object o) {
    return 0;
  }

  @Override
  public ListIterator<T> listIterator() {
    return null;
  }

  @Override
  public ListIterator<T> listIterator(int index) {
    return null;
  }

  @Override
  public List<T> subList(int fromIndex, int toIndex) {
    return null;
  }
}
