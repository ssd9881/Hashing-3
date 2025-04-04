// TC:O(n)
//Sc:O(n)

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        if(n<10) return new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('A',1);
        map.put('C',2);
        map.put('G',3);
        map.put('T',4);
        HashSet<Long> allStrs = new HashSet<>();
        HashSet<String> result = new HashSet<>();
        long hash = 0;
        long kl = (long)Math.pow(4,9);
        for(int i=0;i<n;i++){
            // out
            if(i>=10){
                char out = s.charAt(i-10);
                hash=hash-(kl*map.get(out));
            }
            char in = s.charAt(i);
            hash=hash*4+map.get(in);
            if (i >= 9) {
                String subStr = s.substring(i-9,i+1);
            if(allStrs.contains(hash)){
                result.add(subStr);
            }else{
                allStrs.add(hash);
            }
            }
        }
        return new ArrayList<>(result);
    }
}