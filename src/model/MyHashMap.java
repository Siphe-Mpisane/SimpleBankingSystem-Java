package model;

public class MyHashMap <K,V>{
    private Entry<K,V> [] buckets;
    private int size=16;

    public MyHashMap()
    {
        buckets=new Entry[size];
    }

    //Hash functions
    private int getIndex(K key){
        return Math.abs(key.hashCode());
    }

    //Insert
    public void put(K key,V value)
    {
        int index = getIndex(key);
        Entry<K,V> current = buckets[index];

        if(current==null){
            buckets[index]= new Entry<>(key,value);
            return;
        }

        //Navigate list
         while (current!=null) {
             if(current.key.equals(key)){
                 current.value=value;
                 return;
             }
             if(current.next==null){break;}
             current=current.next;
         }
         //adding new entry at the end
         current.next=new Entry<>(key,value );

    }

    //Get (search)
    public V get(K key){
        int  index = getIndex(key);
        Entry<K,V> current= buckets[index];

        while (current!=null)
        {
            if(current.key.equals(key))
            {
                return current.value;
            }
            current=current.next;
        }
        return null;
    }

    //Remove
    public void remove(K key){
        int index= getIndex(key);
        Entry<K,V> current = buckets[index];
        Entry<K,V> previous = null ;

        while(current!=null)
        {
            if(current.key.equals(key))
            {
                if (previous==null)
                {
                    buckets[index]=current.next;
                }
                else
                {
                    previous.next=current.next;
                }
                return;
            }
            previous=current;
            current=current.next;
        }
    }
    public boolean containsKey(K key){
        int index =getIndex(key);
        Entry<K,V >current =buckets[index];
        while(current!=null)
        {
            if (current.key.equals(key))
            {
                return true;
            }
            current=current.next;
        }
        return false;
    }
}
