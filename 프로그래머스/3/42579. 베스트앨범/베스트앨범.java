import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        int l=genres.length;
        Map<String,List<Song>>count=new HashMap<>();
        Map<String,Integer>genrePlay=new HashMap<>();
        PriorityQueue<Genre>pq=new PriorityQueue<>((g1,g2)->g2.plays-g1.plays);
        for(int i=0;i<l;i++){
            if(!count.containsKey(genres[i])) {
                count.put(genres[i],new ArrayList<>());
                genrePlay.put(genres[i],0);
            }
            genrePlay.put(genres[i],genrePlay.get(genres[i])+plays[i]);
            count.get(genres[i]).add(new Song(i,plays[i]));
        }
        int c=0;
        for(String key:genrePlay.keySet()){
            pq.add(new Genre(key,genrePlay.get(key)));
            c+=count.get(key).size()>=2?2:count.get(key).size();
        }
        answer=new int[c];
        int idx=0;
        while(!pq.isEmpty()){
            String g=pq.poll().name;
            List<Song>sList=count.get(g);
            sList.sort((s1,s2)->s2.plays-s1.plays);
            int cnt=0;
            while(cnt<sList.size()&&cnt<2) answer[idx++]=sList.get(cnt++).num;
        }
        return answer;
    }
}

class Genre{
    String name;
    int plays;
    public Genre(String name, int plays){
        this.name=name;
        this.plays=plays;
    }
}

class Song{
    int num,plays;
    public Song(int num,int plays){
        this.num=num;
        this.plays=plays;
    }
}