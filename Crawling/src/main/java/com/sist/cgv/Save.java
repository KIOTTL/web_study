package com.sist.cgv;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.WebElement;

public class Save {
	private static List<WebElement> list=
		          new List<WebElement>() {

					@Override
					public int size() {
						// TODO Auto-generated method stub
						return 0;
					}

					@Override
					public boolean isEmpty() {
						// TODO Auto-generated method stub
						return false;
					}

					@Override
					public boolean contains(Object o) {
						// TODO Auto-generated method stub
						return false;
					}

					@Override
					public Iterator<WebElement> iterator() {
						// TODO Auto-generated method stub
						return null;
					}

					@Override
					public Object[] toArray() {
						// TODO Auto-generated method stub
						return null;
					}

					@Override
					public <T> T[] toArray(T[] a) {
						// TODO Auto-generated method stub
						return null;
					}

					@Override
					public boolean add(WebElement e) {
						// TODO Auto-generated method stub
						return false;
					}

					@Override
					public boolean remove(Object o) {
						// TODO Auto-generated method stub
						return false;
					}

					@Override
					public boolean containsAll(Collection<?> c) {
						// TODO Auto-generated method stub
						return false;
					}

					@Override
					public boolean addAll(Collection<? extends WebElement> c) {
						// TODO Auto-generated method stub
						return false;
					}

					@Override
					public boolean addAll(int index, Collection<? extends WebElement> c) {
						// TODO Auto-generated method stub
						return false;
					}

					@Override
					public boolean removeAll(Collection<?> c) {
						// TODO Auto-generated method stub
						return false;
					}

					@Override
					public boolean retainAll(Collection<?> c) {
						// TODO Auto-generated method stub
						return false;
					}

					@Override
					public void clear() {
						// TODO Auto-generated method stub
						
					}

					@Override
					public WebElement get(int index) {
						// TODO Auto-generated method stub
						return null;
					}

					@Override
					public WebElement set(int index, WebElement element) {
						// TODO Auto-generated method stub
						return null;
					}

					@Override
					public void add(int index, WebElement element) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public WebElement remove(int index) {
						// TODO Auto-generated method stub
						return null;
					}

					@Override
					public int indexOf(Object o) {
						// TODO Auto-generated method stub
						return 0;
					}

					@Override
					public int lastIndexOf(Object o) {
						// TODO Auto-generated method stub
						return 0;
					}

					@Override
					public ListIterator<WebElement> listIterator() {
						// TODO Auto-generated method stub
						return null;
					}

					@Override
					public ListIterator<WebElement> listIterator(int index) {
						// TODO Auto-generated method stub
						return null;
					}

					@Override
					public List<WebElement> subList(int fromIndex, int toIndex) {
						// TODO Auto-generated method stub
						return null;
					}
				};
	static
	   {
		   try
		   {
			   FileInputStream fis=
					   new FileInputStream("c:\\java_data\\shoes.txt");
			   ObjectInputStream ois=
					   new ObjectInputStream(fis);
			   list=(List<WebElement>)ois.readObject();
			   ois.close();
			   fis.close();
		   }catch(Exception ex){}
	   }
}
