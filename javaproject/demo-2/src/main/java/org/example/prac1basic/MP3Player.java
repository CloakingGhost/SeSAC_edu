package org.example.prac1basic;

public class MP3Player {
    private final String modelName;
    private byte volume;
    private boolean isOn;

    public MP3Player(String modelName) {
        this.modelName = modelName;
        this.volume = 0;
        this.isOn = false;
    }


    public boolean changeState() {
        // 실습 문제에서는 반드시 성공하지만.
        // 실제 서비스에서는 "전원 켜야지"라는 동작을 한다고 해서 켜진다는 보장이 없는 경우가 있기 때문에
        // 그런 경우에는 동작에 대해 성공하면 "성공"을 return, 실패하면 "실패"를 return하는 과정이
        // 자연스러울 수 있다.
        if (isOn) {
            return this.turnOff();
        } else {
            return this.turnOn();
        }
    }

    private boolean turnOn() {
        volume = 40;
        isOn = true;
        return true;
    }

    private boolean turnOff() {
        volume = 0;
        isOn = false;
        return false;
    }

    public byte increaseVolume() {

        if (!isOn) {
            return 0;
        }
        if (volume >= 100) {
            return 100;
        }
        return volume += 20;


    }

    public byte decreaseVolume() {
        if (!isOn) {
            return 0;
        }
        if (volume <= 0) {
            return 0;
        }
        return volume -= 20;
    }


    @Override
    public String toString() {
        return "MP3Player{" +
                "modelName='" + modelName + '\'' +
                ", volume=" + volume +
                ", isOn=" + isOn +
                '}';
    }
}
