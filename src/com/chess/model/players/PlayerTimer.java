package com.chess.model.players;

public class PlayerTimer {
    private int minutes;
    private int seconds;
    
    public PlayerTimer(int minutes, int seconds) {
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void recieveUpdate(){
        if (seconds == 0){
            seconds = 60;
            minutes--;
        }
        else{
             seconds--;
        }
    }
    
}
