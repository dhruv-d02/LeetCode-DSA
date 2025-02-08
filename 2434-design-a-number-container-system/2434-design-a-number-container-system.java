import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;

class NumberContainers {
    HashMap<Integer, Integer> numbers;
    HashMap<Integer, Numbers> map;


    public NumberContainers() {
        numbers = new HashMap<>();
        map = new HashMap<>();
    }

    public void change(int index, int number) {
        if(numbers.get(index) != null){
            map.get(numbers.get(index)).removeIndex(index);
            if(map.get(numbers.get(index)).getSize() == 0){
                map.remove(numbers.get(index));
            }
            numbers.remove(index);
        }
        if(map.get(number) == null){
            map.put(number, new Numbers());
        }
        numbers.put(index, number);
        map.get(number).setNumber(number);
        map.get(number).addIndex(index);
    }

    public int find(int number) {
        if(map.get(number)== null){
            return -1;
        }
        return map.get(number).getIndex();
    }
}

class Numbers{
    private int number;
    private TreeSet<Integer> indexes;

    public Numbers() {
        indexes = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
    }

    public  void setNumber(int num){
        this.number = num;
    }

    public void addIndex(int index){
        this.indexes.add(index);
    }

    public void removeIndex(int index){
        this.indexes.remove(index);
    }

    public int getSize() {
        return this.indexes.size();
    }

    public int getIndex(){
        return this.indexes.first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */