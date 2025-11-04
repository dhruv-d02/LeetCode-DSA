class Data{
    String val;
    int time;
    Data(String val, int time){
        this.val = val;
        this.time = time;
    }
}

class TimeMap {

    Map<String, List<Data>> map;
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Data(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        // Binary Search
        List<Data> list = map.get(key);
        int low = 0;
        int high = list.size() - 1;
        String result = "";
        while (low <= high){
            int mid = low + (high - low) / 2;
            if (list.get(mid).time <= timestamp){
                result = list.get(mid).val;
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }
        return result;
    }
}