package demo;

/**
 * @author Prongs
 * @date 2019/11/18 21:08
 */
public class MyQueue {
    int[] elements;

    public MyQueue() {
        elements = new int[0];
    }

    public void add(int element){
        int[] newArr = new int[elements.length+1];
        System.arraycopy(elements, 0, newArr, 0, elements.length);
        newArr[elements.length]=element;
        elements = newArr;
    }

    public int poll(){
        int element = elements[0];
        int[] newArr = new int[elements.length-1];
        System.arraycopy(elements, 1, newArr, 0, newArr.length);
        elements=newArr;
        return element;
    }

    public boolean isEmpty(){
        return elements.length==0;
    }
}
