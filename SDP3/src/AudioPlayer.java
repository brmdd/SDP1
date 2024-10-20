interface AudioPlayer {
    void play(String audioType, String fileName);
}

class MP3Player implements AudioPlayer {
    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file: " + fileName);
        } else {
            System.out.println("Invalid media format: " + audioType);
        }
    }
}

interface WAVPlayer {
    void playWAV(String fileName);
}

interface AACPlayer {
    void playAAC(String fileName);
}

class AdvancedAudioPlayer implements WAVPlayer, AACPlayer {
    @Override
    public void playWAV(String fileName) {
        System.out.println("Playing WAV file: " + fileName);
    }

    @Override
    public void playAAC(String fileName) {
        System.out.println("Playing AAC file: " + fileName);
    }
}

class AudioAdapter implements AudioPlayer {
    AdvancedAudioPlayer advancedAudioPlayer;

    public AudioAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("wav")) {
            advancedAudioPlayer = new AdvancedAudioPlayer();
        } else if (audioType.equalsIgnoreCase("aac")) {
            advancedAudioPlayer = new AdvancedAudioPlayer();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("wav")) {
            advancedAudioPlayer.playWAV(fileName);
        } else if (audioType.equalsIgnoreCase("aac")) {
            advancedAudioPlayer.playAAC(fileName);
        }
    }
}

class MusicPlayerApp {
    public static void main(String[] args) {
        AudioPlayer mp3Player = new MP3Player();
        mp3Player.play("mp3", "song.mp3");

        AudioPlayer wavPlayer = new AudioAdapter("wav");
        wavPlayer.play("wav", "song.wav");

        AudioPlayer aacPlayer = new AudioAdapter("aac");
        aacPlayer.play("aac", "song.aac");
    }
}
