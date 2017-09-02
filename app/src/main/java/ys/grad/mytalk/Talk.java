package ys.grad.mytalk;
import java.util.Calendar;

public class Talk {
    private String time;
    private String talk;
    private boolean isMe;
    public Talk(String talk, boolean isMe){
        this.time = calTime();
        this.talk = talk;
        this.isMe = isMe;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTalk() {
        return talk;
    }

    public void setTalk(String talk) {
        this.talk = talk;
    }

    public boolean isMe() {
        return isMe;
    }

    public void setMe(boolean isMe) {
        this.isMe = isMe;
    }

    private String calTime(){
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR);
        int min =  c.get(Calendar.MINUTE);
        int apm = c.get(Calendar.AM_PM);
        StringBuilder time = new StringBuilder();
        switch (apm){
            case Calendar.AM:
                time.append("오전 ");
                break;
            case Calendar.PM:
                time.append("오후 ");
                break;
        }
        if(hour <10){
            time.append("0");
        }
        time.append(hour);
        time.append(":");
        if(min <10){
            time.append("0");
        }
        time.append(min);
        return time.toString();
    }
}
