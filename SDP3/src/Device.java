interface Device {
    void powerOn();
    void powerOff();
    void setChannel(int channel);
    void setVolume(int volume);
}

class TVDevice implements Device {
    @Override
    public void powerOn() {
        System.out.println("TV is ON");
    }

    @Override
    public void powerOff() {
        System.out.println("TV is OFF");
    }

    @Override
    public void setChannel(int channel) {
        System.out.println("TV set to channel " + channel);
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("TV volume set to " + volume);
    }
}

class DVDDevice implements Device {
    @Override
    public void powerOn() {
        System.out.println("DVD Player is ON");
    }

    @Override
    public void powerOff() {
        System.out.println("DVD Player is OFF");
    }

    @Override
    public void setChannel(int channel) {
        System.out.println("DVD Player doesn't support channels");
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("DVD Player volume set to " + volume);
    }
}

abstract class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public abstract void power();
    public abstract void setChannel(int channel);
    public abstract void setVolume(int volume);
}

class BasicRemote extends RemoteControl {
    public BasicRemote(Device device) {
        super(device);
    }

    @Override
    public void power() {
        System.out.println("Basic Remote: Power toggle");
        device.powerOn();
    }

    @Override
    public void setChannel(int channel) {
        device.setChannel(channel);
    }

    @Override
    public void setVolume(int volume) {
        device.setVolume(volume);
    }
}

class AdvancedRemote extends RemoteControl {
    public AdvancedRemote(Device device) {
        super(device);
    }

    @Override
    public void power() {
        System.out.println("Advanced Remote: Power toggle with extra functions");
        device.powerOn();
    }

    @Override
    public void setChannel(int channel) {
        System.out.println("Advanced Remote: Extra feature - quick channel setup");
        device.setChannel(channel);
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("Advanced Remote: Volume control with presets");
        device.setVolume(volume);
    }
}

class HomeEntertainmentSystem {
    public static void main(String[] args) {
        Device tv = new TVDevice();
        RemoteControl basicRemote = new BasicRemote(tv);
        basicRemote.power();
        basicRemote.setChannel(5);
        basicRemote.setVolume(10);

        Device dvd = new DVDDevice();
        RemoteControl advancedRemote = new AdvancedRemote(dvd);
        advancedRemote.power();
        advancedRemote.setVolume(15);
    }
}
