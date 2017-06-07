package com.ebp.owat.lib.dataStructure.set;

import java.io.Serializable;
import java.util.*;

/**
 * Defines a long linked list, a linked list that inherently works using a long instead of int.
 *
 * Created by Greg Stewart on 4/1/17.
 */
public class LongLinkedList<E> implements Serializable, Cloneable, Iterable<E>, Collection<E>, Deque<E>, List<E>, Queue<E> {
	/** The capacity this list should be set to. Default capacity is {@link Long#MAX_VALUE Long.MAX_VALUE}. */
	private long capacity = Long.MAX_VALUE;
	/** The length of the list. */
	private long length = 0;
	/** The first node in this list. */
	private LongListNode<E> first;
	/** The last node in this list. */
	private LongListNode<E> last;
	
	/**
	 * Determines if this list is at capacity or not. Will always return false if no capacity specified.
	 * @return False if not at capacity, true if at capacity.
	 */
	public boolean atCapacity(){//TODO:: test
		return this.length > capacity;
	}
	
	/**
	 * Throws an IllegalStateException if the list is at capacity. Use before any operation that adds elements to the list.
	 */
	private void throwIfAtCapacity(){//TODO:: test
		if(this.atCapacity()){
			throw new IllegalStateException("List is already at capacity. Cannot add more to the list.");
		}
	}
	
	/**
	 * Throws an IllegalStateException if the list is empty. Use before any operation that removes elements from the list.
	 */
	private void throwIfEmpty(){
		if(this.isEmpty()){
			throw new IllegalStateException("List is empty. Cannot remove a node.");
		}
	}
	
	@Override
	public void addFirst(E e) {//TODO:: test
		this.throwIfAtCapacity();
		if(this.first == null){
			this.first = new LongListNode<>(e);
			this.last = this.first;
		}else{
			this.first.setPrev(new LongListNode<>(e));
			this.first = this.first.prev();
		}
	}
	
	@Override
	public void addLast(E e) {//TODO:: test
		this.throwIfAtCapacity();
		if(this.last == null){
			this.last = new LongListNode<>(e);
			this.first = this.last;
		}else{
			this.last.setNext(new LongListNode<>(e));
			this.last = this.last.next();
		}
	}
	
	@Override
	public boolean offerFirst(E e) {//TODO:: test
		try{
			this.addFirst(e);
		}catch (IllegalStateException ex){
			return false;
		}
		return true;
	}
	
	@Override
	public boolean offerLast(E e) {
		try{
			this.addLast(e);
		}catch (IllegalStateException ex){
			return false;
		}
		return true;
	}
	
	@Override
	public E removeFirst() {
		//TODO
		return null;
	}
	
	@Override
	public E removeLast() {
		//TODO
		return null;
	}
	
	@Override
	public E pollFirst() {
		//TODO
		return null;
	}
	
	@Override
	public E pollLast() {
		//TODO
		return null;
	}
	
	@Override
	public E getFirst() {
		//TODO
		return null;
	}
	
	@Override
	public E getLast() {
		//TODO
		return null;
	}
	
	@Override
	public E peekFirst() {
		//TODO
		return null;
	}
	
	@Override
	public E peekLast() {
		//TODO
		return null;
	}
	
	@Override
	public boolean removeFirstOccurrence(Object o) {
		//TODO
		return false;
	}
	
	@Override
	public boolean removeLastOccurrence(Object o) {
		//TODO
		return false;
	}
	
	@Override
	public boolean offer(E e) {
		//TODO
		return false;
	}
	
	@Override
	public E remove() {
		//TODO
		return null;
	}
	
	@Override
	public E poll() {
		//TODO
		return null;
	}
	
	@Override
	public E element() {
		//TODO
		return null;
	}
	
	@Override
	public E peek() {
		//TODO
		return null;
	}
	
	@Override
	public void push(E e) {
		//TODO
	}
	
	@Override
	public E pop() {
		//TODO
		return null;
	}
	
	@Override
	public boolean addAll(int i, Collection<? extends E> collection) {
		//TODO
		return false;
	}
	
	@Override
	public E get(int i) {
		//TODO
		return null;
	}
	
	@Override
	public E set(int i, E e) {
		//TODO
		return null;
	}
	
	@Override
	public void add(int i, E e) {
		//TODO
	}
	
	@Override
	public E remove(int i) {
		//TODO
		return null;
	}
	
	@Override
	public int indexOf(Object o) {
		//TODO
		return 0;
	}
	
	@Override
	public int lastIndexOf(Object o) {
		//TODO
		return 0;
	}
	
	@Override
	public List<E> subList(int i, int i1) {
		//TODO
		return null;
	}
	
	@Override
	public int size() {
		//TODO
		return 0;
	}
	
	@Override
	public boolean isEmpty() {
		//TODO
		return false;
	}
	
	@Override
	public boolean contains(Object o) {
		//TODO
		return false;
	}
	
	@Override
	public Object[] toArray() {
		//TODO
		return new Object[0];
	}
	
	@Override
	public <T> T[] toArray(T[] ts) {
		//TODO
		return null;
	}
	
	@Override
	public boolean add(E e) {
		//TODO
		return false;
	}
	
	@Override
	public boolean remove(Object o) {
		//TODO
		return false;
	}
	
	@Override
	public boolean containsAll(Collection<?> collection) {
		//TODO
		return false;
	}
	
	@Override
	public boolean addAll(Collection<? extends E> collection) {
		//TODO
		return false;
	}
	
	@Override
	public boolean removeAll(Collection<?> collection) {
		//TODO
		return false;
	}
	
	@Override
	public boolean retainAll(Collection<?> collection) {
		//TODO
		return false;
	}
	
	@Override
	public void clear() {
		this.first = null;
		this.last = null;
		this.length = 0;
	}
	
	@Override
	public Iterator<E> iterator() {
		return this.listIterator();
	}
	
	@Override
	public Iterator<E> descendingIterator() {
		return new Iterator<E>() {
			private LongListNode<E> curNode = last;
			private boolean startedIt = false;
			@Override
			public boolean hasNext() {
				return curNode != null ? curNode.hasPrev() : false;
			}
			@Override
			public E next() {
				if(!this.hasNext()){
					throw new NoSuchElementException("No more elements to iterate through.");
				}
				if(!startedIt){
					startedIt = true;
					return curNode.getData();
				}
				curNode = curNode.prev();
				return curNode.getData();
			}
			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
	
	@Override
	public ListIterator<E> listIterator() {//TODO:: test
		return new ListIterator<E>() {
			private LongListNode<E> curNode = first;
			private boolean startedIt = false;
			@Override
			public boolean hasNext() {
				return curNode != null ? curNode.hasNext() : false;
			}
			@Override
			public E next() {
				if(!this.hasNext()){
					throw new NoSuchElementException("No more elements to iterate through.");
				}
				if(!startedIt){
					startedIt = true;
					return curNode.getData();
				}
				curNode = curNode.next();
				return curNode.getData();
			}
			
			@Override
			public boolean hasPrevious() {
				return curNode != null ? curNode.hasPrev() : false;
			}
			
			@Override
			public E previous() {
				if(!this.hasPrevious()){
					throw new NoSuchElementException("No more elements to iterate through.");
				}
				curNode = curNode.prev();
				return curNode.getData();
			}
			
			@Override
			public int nextIndex() {
				throw new UnsupportedOperationException();
			}
			
			@Override
			public int previousIndex() {
				throw new UnsupportedOperationException();
			}
			
			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
			
			@Override
			public void set(E e) {
				throw new UnsupportedOperationException();
			}
			
			@Override
			public void add(E e) {
				throw new UnsupportedOperationException();
			}
		};
	}
	
	@Override
	public ListIterator<E> listIterator(int i) {
		return this.listIterator((long)i);
	}
	
	/**
	 * Same as {@link #listIterator(int) listIterator(int)}, except uses long, as per this class.
	 * @param i The index the ListIterator should be at.
	 * @return A ListIterator already at the element at the index given.
	 */
	public ListIterator<E> listIterator(long i) {//TODO:: test
		ListIterator<E> it = this.listIterator();
		
		for(long j = 0; j < i; j++){
			it.next();
		}
		
		return it;
	}
	
	//TODO:: private iterators that return nodes, not values
}
