public class Solution458 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        return (int) (Math.ceil(Math.log(buckets))/Math.log(minutesToTest/minutesToDie));
    }
}
