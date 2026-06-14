import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        ArrayList<Integer>arr=new ArrayList<>();
        int len=genres.length;
        HashMap<String,Integer> genreCount=new HashMap<>();
        for(int i=0;i<len;i++){
            genreCount.put(genres[i],genreCount.getOrDefault(genres[i],0)+plays[i]);
        }
        PriorityQueue<GenrePlay>gpq=new PriorityQueue<>((o1,o2)->Integer.compare(o2.plays,o1.plays));
        for(String k:genreCount.keySet()){
            gpq.add(new GenrePlay(k,genreCount.get(k)));
        }
        while(!gpq.isEmpty()){
            PriorityQueue<Song>spq=new PriorityQueue<>();
            String g=gpq.poll().genre;
            for(int i=0;i<len;i++){
                if(genres[i].equals(g)){
                    spq.add(new Song(i,plays[i]));
                }
            }
            int cnt=0;
            while(!spq.isEmpty()&&cnt<2) {
                arr.add(spq.poll().num);
                cnt++;
            }
        }
        answer=new int[arr.size()];
        for(int i=0;i<arr.size();i++){
            answer[i]=arr.get(i);
        }
        
        return answer;
    }
}

class GenrePlay{
    String genre;
    int plays;
    GenrePlay(String genre,int plays){
        this.genre=genre;
        this.plays=plays;
    }
}

class Song implements Comparable<Song>{
    int num;
    int plays;
    Song(int num,int plays){
        this.num=num;
        this.plays=plays;
    }
    
    @Override
    public int compareTo(Song o){
        if(this.plays==o.plays){
            return this.num-o.num;
        }
        return o.plays-this.plays;
    }
}