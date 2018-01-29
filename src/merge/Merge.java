package merge;
import java.util.*;

/**
 *
 * @author Zackery Lavalais
 */

public class Merge {
  public static int[] merge(int[] a,int[] b) {
    int[] result = new int[a.length+b.length];
    int na = 0, nb = 0, nr = 0;
    
    while(na < a.length && nb < b.length) {
      int diff = a[na] - b[nb];
      if(diff <= 0) {
        result[nr] = a[na];
        na++;
      } else {
        result[nr] = b[nb];
        nb++;
      }
      nr++;
    }
    
    while(na < a.length) {
      result[nr] = a[na];
      na++;
      nr++;
    }
    
    while(nb < b.length) {
      result[nr] = b[nb];
      nb++;
      nr++;
    }
    
    return result;
  }
  
  public static <T extends Comparable<T>> List<T> merge(List<T> a,List<T> b) {
    List<T> result = new ArrayList<T>();
    int na = 0, nb = 0;
    
    while(na < a.size() && nb < b.size()) {
      int diff = a.get(na).compareTo(b.get(nb));
      if(diff <= 0) {
        //result[nr] = a[na];
        result.add(a.get(na));
        na++;
      } else {
        //result[nr] = b[nb];
        result.add(b.get(nb));
        nb++;
      }
    } 
    
    while(na < a.size()) {
      //result[nr] = a[na];
      result.add(a.get(na));
      na++;
    }
    
    while(nb < b.size()) {
      //result[nr] = b[nb];
      result.add(b.get(nb));
      nb++;
    }
    
    return result;
  }
  public static <T extends Comparable<T>> List<T> mergeSort(List<T> li) {
    if(li.size() <= 1)
      return li;
    List<T> a = new ArrayList<T>();
    List<T> b = new ArrayList<T>();
    int n = li.size()/2;
    for(int i=0;i<n;i++)
      a.add(li.get(i));
    for(int i=n;i<li.size();i++)
      b.add(li.get(i));
    a = mergeSort(a);
    b = mergeSort(b);
    return merge(a,b);
  }
  
  public static void main(String[] args) {
    Random r = new Random();
    final int n = 5;
    List<Integer> a = new ArrayList<>();
    List<Integer> b = new ArrayList<>();
    for(int i=0;i<n;i++) {
      //a[i] = r.nextInt(100);
      a.add(r.nextInt(100));
      //b[i] = r.nextInt(100);
      b.add(r.nextInt(100));
    }
    //Collections.sort(a);
    //Collections.sort(b);
    a = mergeSort(a);
    b = mergeSort(b);
    System.out.println(a+" "+b);
    List<Integer> re = merge(a,b);
    System.out.println(re);
  }
  
  public static void main2(String[] args) {
    Random r = new Random();
    final int n = 5;
    int[] a = new int[n];
    int[] b = new int[n];
    for(int i=0;i<n;i++) {
      a[i] = r.nextInt(100);
      b[i] = r.nextInt(100);
    }
    Arrays.sort(a);
    Arrays.sort(b);
    System.out.println(Arrays.toString(a)+" "+Arrays.toString(b));
    int[] re = merge(a,b);
    System.out.println(Arrays.toString(re));
  }
}
