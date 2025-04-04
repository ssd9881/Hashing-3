// tc:O(g*s+u*m)
// sc:O(s*g+g*u)

// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
        
        HashMap<String,List<String>> result = new HashMap<>();
        HashMap<String,List<String>> songtoGenres = new HashMap<>();
        for(String genre:genreMap.keySet()){
            List<String> songs = genreMap.get(genre);
            for(int i=0;i<songs.size();i++){
                String song = songs.get(i);
                if(!songtoGenres.containsKey(song)){
                    songtoGenres.put(song,new ArrayList<>());
                }
                songtoGenres.get(song).add(genre);
            }
        }
        
        for(String user:userMap.keySet()){
            result.put(user,new ArrayList<>());
            HashMap<String,Integer> map = new HashMap<>();
            int max = Integer.MIN_VALUE;
            List<String> songs = userMap.get(user);
            for(String song:songs){
                if(songtoGenres.containsKey(song)){
                    List<String> genres = songtoGenres.get(song);
                    for(String genre: genres){
                        map.put(genre,map.getOrDefault(genre,0)+1);
                        max=Math.max(max,map.get(genre));
                    }
                }
            }
            for(String genre:map.keySet()){
                if(map.get(genre)==max){
                    result.get(user).add(genre);
                }
            }
        }
        
        
    return result;
}

public static void main(String[] args) {
        HashMap<String, List<String>> userSongs = new HashMap<>();

        userSongs.put("David", Arrays.asList(new String[]{"song1", "song2", "song3", "song4", "song8"}));

        userSongs.put("Emma", Arrays.asList(new String[]{"song5", "song6", "song7"}));

        HashMap<String, List<String>> songGenres = new HashMap<>();

        songGenres.put("Rock", Arrays.asList(new String[]{"song1", "song3"}));

        songGenres.put("Dubstep", Arrays.asList(new String[]{"song7"}));

        songGenres.put("Techno", Arrays.asList(new String[]{"song2", "song4"}));

        songGenres.put("Pop", Arrays.asList(new String[]{"song5", "song6"}));

        songGenres.put("Jazz", Arrays.asList(new String[]{"song8", "song9"}));

        Map<String, List<String>> res = favoritegenre(userSongs, songGenres);

        System.out.println(res);
}
}