import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        int len=genres.length;
        HashMap<String,Integer>genrePlay =new HashMap<>(),count=new HashMap<>();
        for(int i=0;i<len;i++){
            genrePlay.put(genres[i],genrePlay.getOrDefault(genres[i],0)+plays[i]);
            count.put(genres[i],count.getOrDefault(genres[i],0)+1);
        }
        PriorityQueue<Genre>pq=new PriorityQueue<>();
        int c=0;
        for(String str:genrePlay.keySet()){
            pq.add(new Genre(str,genrePlay.get(str)));
            c+=count.get(str)>2?2:count.get(str);
        }
        answer=new int[c];
        // System.out.println("길이: "+c);
        int idx=0;
        while(!pq.isEmpty()){
            Genre cur=pq.poll();
            PriorityQueue<Song>spq=new PriorityQueue<>();
            int tmp=0;
            for(int i=0;i<len;i++){
                    // System.out.println("장르: "+cur.name+ " num: "+i+" genres[i]: "+genres[i]);
                if(genres[i].equals(cur.name)){
                    // System.out.println("투입 장르: "+cur.name+ " num: "+i+" genres[i]: "+genres[i]);
                    spq.add(new Song(i,plays[i]));
                }
            }
            
            int cnt=0;
            while(!spq.isEmpty()){
                Song s=spq.poll();
                if(cnt>=2) break;
                answer[idx++]=s.num;
                cnt++;
            }
        }
        
        return answer;
    }
}

class Genre implements Comparable<Genre>{
    String name;
    int plays;
    
    public Genre(String name,int plays){
        this.name=name;
        this.plays=plays;
    }
    
    @Override
    public int compareTo(Genre o){
        return o.plays-this.plays;
    }
}

class Song implements Comparable<Song>{
    int num,plays;
    public Song(int num,int plays){
        this.num=num;
        this.plays=plays;
    }
    
    @Override
    public int compareTo(Song o){
        if(o.plays==this.plays){
            return this.num-o.num;
        }
        return o.plays-this.plays;
    }
}