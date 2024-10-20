import java.util.ArrayList;
import java.util.List;

interface VideoLecture {
    void getInfo();
    void play();
}

class RealVideoLecture implements VideoLecture {
    private String videoName;

    public RealVideoLecture(String videoName) {
        this.videoName = videoName;
        loadVideo();
    }

    private void loadVideo() {
        System.out.println("Loading video: " + videoName);
    }

    @Override
    public void getInfo() {
        System.out.println("Video Info: " + videoName);
    }

    @Override
    public void play() {
        System.out.println("Playing video: " + videoName);
    }
}

class ProxyVideoLecture implements VideoLecture {
    private String videoName;
    private RealVideoLecture realVideoLecture;

    public ProxyVideoLecture(String videoName) {
        this.videoName = videoName;
    }

    @Override
    public void getInfo() {
        System.out.println("Proxy: Video Info: " + videoName);
    }

    @Override
    public void play() {
        if (realVideoLecture == null) {
            realVideoLecture = new RealVideoLecture(videoName);
        }
        realVideoLecture.play();
    }
}

class OnlineCourse {
    private List<VideoLecture> videoLectures = new ArrayList<>();

    public void addVideoLecture(VideoLecture videoLecture) {
        videoLectures.add(videoLecture);
    }

    public void showLecturesInfo() {
        for (VideoLecture videoLecture : videoLectures) {
            videoLecture.getInfo();
        }
    }

    public void playLecture(int index) {
        if (index >= 0 && index < videoLectures.size()) {
            videoLectures.get(index).play();
        } else {
            System.out.println("Invalid lecture index");
        }
    }
}

class LearningPlatformApp {
    public static void main(String[] args) {
        OnlineCourse course = new OnlineCourse();

        VideoLecture lecture1 = new ProxyVideoLecture("Introduction to AI");
        VideoLecture lecture2 = new ProxyVideoLecture("Deep Learning Basics");

        course.addVideoLecture(lecture1);
        course.addVideoLecture(lecture2);

        System.out.println("Course Videos Info:");
        course.showLecturesInfo();

        System.out.println("\nPlaying lectures:");
        course.playLecture(0);
        course.playLecture(1);
    }
}
