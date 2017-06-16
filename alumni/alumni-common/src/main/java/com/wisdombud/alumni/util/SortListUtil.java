package com.wisdombud.alumni.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 对list集合进行排序
 *
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class SortListUtil<E> {
	/**
	 *
	 * 功能: 对list集合中Integer,int,String类型属性进行排序<br/>
	 * date: 2014年12月18日 下午3:33:58 <br/>
	 *
	 * @author zlliu@wisdombudcom
	 * @param list
	 *            要排序的 list
	 * @param method
	 *            要排序属性的get方法名字 例如 getId
	 * @param asc
	 *            true asc或 false desc
	 */
	public void sort(List<E> list, final String method, final boolean asc) {
		if (list != null) {
			Collections.sort(list, new Comparator() {
				@Override
				public int compare(Object a, Object b) {
					int ret = 0;
					try {
						Method m1 = ((E) a).getClass().getMethod(method, null);
						Method m2 = ((E) b).getClass().getMethod(method, null);
						if (asc) {
							// 正序
							ret = ascSort(m1, m2, a, b);
						} else {
							// 倒序
							ret = descSort(m1, m2, a, b);
						}
					} catch (NoSuchMethodException ne) {
						System.out.println(ne);
					} catch (IllegalAccessException ie) {
						System.out.println(ie);
					} catch (InvocationTargetException it) {
						System.out.println(it);
					}
					return ret;
				}
			});
		}
	}

	private int descSort(Method m1, Method m2, Object a, Object b)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		int ret = 0;
		if (m1.getReturnType() == Integer.class) {
			ret = (Integer) m2.invoke(((E) b), null) - (Integer) m1.invoke(((E) a), null);
		} else if (m1.getReturnType() == int.class) {
			ret = (int) m2.invoke(((E) b), null) - (int) m1.invoke(((E) a), null);
		} else {
			ret = m2.invoke(((E) b), null).toString().compareTo(m1.invoke(((E) a), null).toString());
		}
		return ret;
	}

	private int ascSort(Method m1, Method m2, Object a, Object b)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		int ret = 0;
		if (m1.getReturnType() == Integer.class) {
			ret = (Integer) m1.invoke(((E) a), null) - (Integer) m2.invoke(((E) b), null);
		} else if (m1.getReturnType() == int.class) {
			ret = (int) m1.invoke(((E) a), null) - (int) m2.invoke(((E) b), null);
		} else {
			ret = m1.invoke(((E) a), null).toString().compareTo(m2.invoke(((E) b), null).toString());
		}
		return ret;
	}
}