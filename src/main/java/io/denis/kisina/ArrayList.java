package io.denis.kisina;

public class ArrayList implements IArrayList{

    private final int INITIAL_LENGTH = 4;
    private int size;
    int[] arrayHolder;

    public ArrayList() {
        arrayHolder = new int[INITIAL_LENGTH];
        size = 0;
    }

    public void append(int value) {
        if(size == arrayHolder.length) resize();
        arrayHolder[size++] = value;
    }

    public int get(int index) {
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException(index + " is out of bounds");
        }
        return arrayHolder[index];

    }

    public void set(int index, int value) {
        if(index > size) return;
        if(index >= arrayHolder.length||size+1 > arrayHolder.length) {
            resize();
        }
        int[] temp = new int[arrayHolder.length+1];
        System.arraycopy(arrayHolder,0,temp,0,index);
        temp[index] = value;

        System.arraycopy(arrayHolder,index,temp,index+1, arrayHolder.length - index);
        arrayHolder = temp;
        ++size;

    }

    public void delete(int index) {
        if(size == 0) throw new ArrayIndexOutOfBoundsException("Array is empty");
        int ind = -1;
        for(int i = 0; i < size; ++i ){
            if(arrayHolder[i] == index){
                ind = i;
                break;
            }
        }
        if(ind == -1) throw new ArrayIndexOutOfBoundsException("Array is empty");
        int[] temp = new int[arrayHolder.length];
        System.arraycopy(arrayHolder,0,temp,0,ind);
        System.arraycopy(arrayHolder,ind+1,temp,index,arrayHolder.length-(ind+1));
        arrayHolder = temp;
        --size;
        return;
    }

    public int size() {
        return size;
    }

    /**Helper method to resize the array ***/
    private void resize(){

        int len = arrayHolder.length;
        int newLen = 2*len;
        int[] temp = new int[newLen];
        System.arraycopy(arrayHolder,0,temp,0,len);
        arrayHolder = temp;
    }
}
