package org.example.snakeLadder;

import java.util.HashMap;
import java.util.Map;

public class Board {
    //snakes and ladders with start and end;

    //map stores head and tail pos

    private Map<Integer,Integer> snakes = new HashMap<>();
    private Map<Integer,Integer> ladders = new HashMap<>();

    private Map<Integer,Integer> portal = new HashMap<>();

    public Board (){
        snakes.put(99,54);
        snakes.put(70,55);

        ladders.put(6,25);
        ladders.put(10,39);

        portal.put(21,45);
        portal.put(45,21);
    }

    public int getNextPosition(int currentPosition){
        if(snakes.containsKey(currentPosition)){
            // encountered a snake
            System.out.println("encountered a snake on " + currentPosition);
            return snakes.get(currentPosition);
        } else if(ladders.containsKey(currentPosition)){
            // encountered a ladder
            System.out.println("reached to a ladder on " + currentPosition);
            return ladders.get(currentPosition);
        } else if(portal.containsKey(currentPosition)){
            // encountered a ladder
            System.out.println("surprise, reached to a portal on " + currentPosition);
            return portal.get(currentPosition);
        }
        return currentPosition;
    }
}
