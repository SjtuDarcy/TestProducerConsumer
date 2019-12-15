package testsorting.utils;

public class Student implements Comparable<Student> {
    private String mName;
    private int mScore;

    public Student(String name, int score) {
        mName = name;
        mScore = score;
    }

    /**
     * 分数从大到小，名字从小到大
     *
     * @param o 分数
     * @return 比较结果
     */
    @Override
    public int compareTo(Student o) {
        if (o.mScore > this.mScore) {
            return 1;
        } else if (o.mScore < this.mScore) {
            return -1;
        } else {
            if (o.mName.compareTo(this.mName) < 0) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    @Override
    public String toString() {
        return "student name = " + mName + " score = " + mScore + "\n";
    }
}
