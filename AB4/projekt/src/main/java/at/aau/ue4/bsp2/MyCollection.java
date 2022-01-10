package at.aau.ue4.bsp2;

public class MyCollection {
    private String[] list;
    private int cursor=0;

    public MyCollection(int capacity){
        list = new String[capacity];
        cursor=0;
    }

    /**
     * Returns the size of the collection
     * @return The number of instances in the collection
     */
    public int size() {
        return cursor;
    }

    /**
     * Adds the String from to list. If the list is full it throws an IllegalArgumentException
     * @param s String to remove
     */
    public void add(String s) {
        list[cursor++]=s;
    }

    /**
     * Removes the String from the list. If the String is not in the list it throws an
     * IllegalArgumentException. If the list is empty it throws an IllegalArgumentException
     * @param s String to remove
     */
    public void remove(String s) throws IllegalArgumentException{
        for (int i = 0; i < list.length; i++) {
            if(list[i]==s){
                list[i]=null;
                cursor--;
            }
        }
    }

    /**
     * Removes all items from the list and initializes a new list
     */
    public void empty() {
        String[] newList = new String[list.length];

        while(cursor > 0){
            cursor--;
        }
        
        this.list = newList;
    }

}