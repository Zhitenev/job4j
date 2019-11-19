package ru.job4j.tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    private Node<E> root;

    private int modCount = 0;

    public Tree(E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        if (findBy(child).isEmpty()) {
            Optional<Node<E>> optionalNode = findBy(parent);
            if (optionalNode.isPresent()) {
                optionalNode.get().add(new Node<>(child));
                result = true;
                modCount++;
            }
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> result = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> element = data.poll();
            if (element.eqValue(value)) {
                result = Optional.of(element);
                break;
            }
            for (Node<E> child : element.leaves()) {
                data.offer(child);
            }
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new Tree.TreeIterator();
    }

    private class TreeIterator implements Iterator<E> {

        private int expectedModCount = modCount;

        private Queue<Node<E>> data = new LinkedList<>();

        private TreeIterator() {
            data.offer(root);
        }

        @Override
        public boolean hasNext() {
            return !data.isEmpty();
        }

        @Override
        public E next() {
            if (hasNext()) {
                if (expectedModCount <= modCount) {
                    return data.element().getValue();
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }
    }
}
