package objects;



public class Chair {
    private String seat;
    private String feet;
    private String backrest;
    private String stabilizerBar;

    public Chair(String seat, String feet, String backrest, String stabilizerBar) {
        this.seat = seat;
        this.feet = feet;
        this.backrest = backrest;
        this.stabilizerBar = stabilizerBar;
    }

    @Override
    public String toString() {
        return "Chair{" +
                "seat='" + seat + '\'' +
                ", feet='" + feet + '\'' +
                ", backrest='" + backrest + '\'' +
                ", stabilizerBar='" + stabilizerBar + '\'' +
                '}';
    }
}
