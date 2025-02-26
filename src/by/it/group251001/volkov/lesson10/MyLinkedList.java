package by.it.group251001.volkov.lesson10;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;

public class MyLinkedList <E> implements Deque<E> {

    private static class DequeNode<E> {
        E data;
        DequeNode<E> prev;
        DequeNode<E> next;

        private DequeNode(E data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    int size = 0;
    DequeNode<E> firstNode;
    DequeNode<E> lastNode;

    public String toString() {
        StringBuilder res = new StringBuilder("[");

        for (DequeNode<E> tempNode = firstNode; tempNode != null; tempNode = tempNode.next) {
            res.append(tempNode.data.toString()).append(", ");
        }

        if (firstNode != null) {
            res.delete(res.length() - 2, res.length());
        }

        return res.append(']').toString();
    }

    @Override
    public void addFirst(E e) {
        DequeNode<E> tempNode = new DequeNode<E>(e);
        if (firstNode == null) {
            firstNode = tempNode;
            lastNode = tempNode;
        } else {
            tempNode.next = firstNode;
            firstNode.prev = tempNode;
            firstNode = tempNode;
        }
        size++;
    }

    @Override
    public void addLast(E e) {
        DequeNode<E> tempNode = new DequeNode<E>(e);
        if (lastNode == null) {
            firstNode = tempNode;
            lastNode = tempNode;
        } else {
            tempNode.prev = lastNode;
            lastNode.next = tempNode;
            lastNode = tempNode;
        }
        size++;
    }

    @Override
    public boolean offerFirst(E e) {
        return false;
    }

    @Override
    public boolean offerLast(E e) {
        return false;
    }

    @Override
    public E removeFirst() {
        DequeNode<E> tmpNode = firstNode;
        firstNode = firstNode.next;
        firstNode.prev = null;
        size--;
        return tmpNode.data;
    }

    @Override
    public E removeLast() {
        DequeNode<E> tmpNode = lastNode;
        lastNode = lastNode.prev;
        lastNode.next = null;
        size--;
        return tmpNode.data;
    }

    @Override
    public E pollFirst() {
        return removeFirst();
    }

    @Override
    public E pollLast() {
        return removeLast();
    }

    @Override
    public E getFirst() {
        return firstNode.data;
    }

    @Override
    public E getLast() {
        return lastNode.data;
    }

    @Override
    public E peekFirst() {
        return null;
    }

    @Override
    public E peekLast() {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return pollFirst();
    }

    @Override
    public E element() {
        return getFirst();
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
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
    public void clear() {

    }

    @Override
    public void push(E e) {

    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        DequeNode<E> tempNode = firstNode;
        while (tempNode != null && !o.equals(tempNode.data))
            tempNode = tempNode.next;
        if (tempNode != null) {
            DequeNode<E> tmpP = tempNode.prev;
            DequeNode<E> tmpN = tempNode.next;
            if (tmpP != null)
                tmpP.next = tmpN;
            if (tmpN != null)
                tmpN.prev = tmpP;
            size--;
            return true;
        }
        return false;
    }

    public E remove(int index) {
        DequeNode<E> tmpNode = firstNode;
        for (int i = 0; i < index && tmpNode != null; i++)
            tmpNode = tmpNode.next;
        if (tmpNode != null) {
            DequeNode<E> tmpP = tmpNode.prev;
            DequeNode<E> tmpN = tmpNode.next;
            if (tmpP != null)
                tmpP.next = tmpN;
            if (tmpN != null)
                tmpN.prev = tmpP;
            size--;
            return tmpNode.data;
        }
        return null;
    }
    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public Iterator<E> descendingIterator() {
        return null;
    }
}
