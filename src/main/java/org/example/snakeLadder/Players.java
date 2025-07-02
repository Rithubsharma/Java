package org.example.snakeLadder;

public class Players {
    private String name;
    private int position;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Players(String name){
        this.name = name;
        this.position = 0;
    }
}
