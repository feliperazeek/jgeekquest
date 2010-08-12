/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeekmod.jgeekquest.datastructures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author flipflop
 */
public class MyBlockingQueue<I> implements BlockingQueue<I> {

    private List<I> list;
    private int capacity;

    public MyBlockingQueue(int capacity) {
        this.list = new ArrayList<I>();
        this.capacity = capacity;
    }

    private boolean canAdd() {
        if (this.list.size() < this.capacity) {
            return true;
        }
        return false;
    }

    public boolean add(I o) {
        return this.add(o, true);
    }

    private synchronized boolean add(I o, boolean throwError) {
            while (!this.canAdd()) {
                System.out.println("waiting to be able to add...");
                try {
                this.wait();
                if ( this.canAdd() ) {
                    System.out.println("awake and ready to add some shit!");
                }
                } catch (Exception e) { }
            }
            if (this.canAdd()) {
                // System.out.println( "notify from add");
                this.notifyAll();
                System.out.println( "Adding object: " + o);
                this.list.add(o);
                return true;
            } else {
                if (throwError) {
                    throw new IllegalStateException();
                } else {
                    return false;
                }
            }
            // Adds the specified element to this queue if it is possible to do so immediately,
            // returning true upon success, else throwing an IllegalStateException.
    }

    public boolean offer(I o) {
        return this.add(o, false);
    }

    public boolean offer(I o, TimeUnit unit) throws InterruptedException {
        return this.add(o, true);
    }

    public synchronized I poll(long timeout, TimeUnit unit) throws InterruptedException {
        // Retrieves and removes the head of this queue, waiting if necessary up to the specified wait time if no elements are present on this queue.
            try {             
                while (this.list.size() == 0) {
                    System.out.println("sleeping fuck bored as hell i wanna poll some shit");
                    this.wait();
                    if ( this.list.size() > 0 ) {
                         System.out.println("drinks are in lets consume these puppies!");
                    }
                }
            } catch (InterruptedException e) {}
            try {
                if ( this.list.size() > 0 ) {
                    this.notifyAll();
                    I o = this.list.get(0);
                    this.list.remove(o);
                    return o;
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        return null;
    }

    public void put(I o) {
        // Adds the specified element to this queue, waiting if necessary for space to become available.
        this.offer(o);
    }

    public int remainingCapacity() {
        // Returns the number of elements that this queue can ideally (in the absence of memory or resource constraints) accept without blocking, or Integer.MAX_VALUE if there is no intrinsic limit.
        synchronized (this.list) {
            if (this.capacity < this.list.size()) {
                return 0;
            }
            return this.list.size() - this.capacity;
        }
    }

    public I take() throws InterruptedException {
        // Retrieves and removes the head of this queue, waiting if no elements are present on this queue.
        return this.poll(capacity, null);
    }

    @Override
    public boolean offer(I e, long l, TimeUnit tu) throws InterruptedException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public I remove() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public I poll() {
        try {
            return this.poll(-1, null);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public I element() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public I peek() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterator<I> iterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean containsAll(Collection<?> clctn) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean addAll(Collection<? extends I> clctn) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean removeAll(Collection<?> clctn) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean retainAll(Collection<?> clctn) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int drainTo(Collection<? super I> clctn) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int drainTo(Collection<? super I> clctn, int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    static class Producer extends Thread {

        public MyBlockingQueue<String> queue;

        public void run() {
            for (int i = 0; i < 10; i++) {
                String s = "Object " + i;
                queue.add(s, true);
            }
        }
    }

    static class Consumer extends Thread {

        public MyBlockingQueue<String> queue;

        public void run() {
            while (true) {
                long l = 0l;
                String s = this.queue.poll();
                System.out.println(this.getName() + " consumed: " + s);
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        MyBlockingQueue q = new MyBlockingQueue(8);

        Producer p1 = new Producer();
        p1.setName("Producer 1");
        p1.queue = q;

        Producer p2 = new Producer();
        p2.setName("Producer 2");
        p2.queue = q;

        Consumer c1 = new Consumer();
        c1.setName("Consumer 1");
        c1.queue = q;
        Consumer c2 = new Consumer();
        c2.setName("Consumer 2");
        c2.queue = q;

        // p1.start();
        // p2.start();
        // p1.start();
       //  c2.start();
        c1.start();

        System.out.println("ok go add shit...");
        p1.start();

        try {
        Thread.sleep(5000);
        } catch (Exception e) {}
        
        p2.start();
    }
}
