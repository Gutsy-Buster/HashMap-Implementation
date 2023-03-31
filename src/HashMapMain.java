public class HashMapMain {
    public static void main(String[] args) throws Exception {
        MyHashMap<Integer,String> map = new MyHashMap<>(9);
        map.put(1, "Hi");
        map.put(2, "My");
        map.put(3, "name");
        map.put(4, "is");
        map.put(5, "Srishti");
        map.put(34, "address");

        System.out.println(map.get(2)); 
        System.out.println(map.get(34));
        System.out.println(map.get(0));
    }
}
