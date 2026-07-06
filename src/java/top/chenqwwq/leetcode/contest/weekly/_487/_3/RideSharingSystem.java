package top.chenqwwq.leetcode.contest.weekly._487._3;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author chenqwwq
 * @date 2026/2/7
 **/
public class RideSharingSystem {

    Deque<Integer> riders, drivers;
    Set<Integer> existRiders;
    Set<Integer> removeRiders;

    public RideSharingSystem() {
        riders = new LinkedList<>();
        drivers = new LinkedList<>();
        existRiders = new HashSet<>();
        removeRiders = new HashSet<>();
    }

    public void addRider(int riderId) {
        riders.offer(riderId);
        existRiders.add(riderId);
    }

    public void addDriver(int driverId) {
        drivers.add(driverId);
    }

    public int[] matchDriverWithRider() {
        if (drivers.isEmpty()) return new int[]{-1, -1};
        while (!riders.isEmpty() && removeRiders.contains(riders.getFirst())) {
            removeRiders.remove(riders.getFirst());
            existRiders.remove(riders.getFirst());
            riders.pollFirst();
        }
        if (riders.isEmpty()) return new int[]{-1, -1};
        final Integer r = riders.pollFirst();
        existRiders.remove(r);
        final int[] ret = {drivers.pollFirst(), r};
        return ret;

    }

    public void cancelRider(int riderId) {
        if (existRiders.contains(riderId)) {
            removeRiders.add(riderId);
        }
    }
}