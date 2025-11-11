// Time Complexity : O(1)
// Space Complexity : O(n) - n is the number of messages.
// Did this code successfully run on Leetcode : Yes
// Approach : I used hashmap to achieve the solutions as the search is O(1). If the same message comes again we check if it's present and
// also check the timestamp difference.


class Logger {

    HashMap<String, Integer> map;

    public Logger() {
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        int prevTimeStamp;
        if (map.containsKey(message)) { // if already present in hashmap
            prevTimeStamp = map.get(message);
            if (timestamp - prevTimeStamp < 10) { //condition check
                return false;
            }
        }
        map.put(message, timestamp);// add to hashmap
        return true;
    }
}