package com.github.martinfrank.snippets;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FriendListExercise {

    static final Location center = new Location("me", 0,0);

    private static List<Location> findClosestToMe(List<Location> aListOfFriends, int aNumberOfInterests) {
        aListOfFriends.sort(Comparator.comparingDouble(l -> l.distanceTo(center)));
        aListOfFriends.sort(Comparator.comparingDouble(Location::distanceToCenter));
        aListOfFriends.sort(Comparator.comparing(o -> o.id));
        return aListOfFriends.stream().limit(aNumberOfInterests).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int k = 9;
        List<Location> friends = new ArrayList<>();
        friends.add(new Location("A", 1, 3));
        friends.add(new Location("B", -2, 2));
        friends.add(new Location("C", 0, 10));
        friends.add(new Location("D", -2, 2));
        friends.add(new Location("E", 2, 3));
        friends.add(new Location("F", -2, 2));
        friends.add(new Location("G", 2, -2));
        friends.add(new Location("H", -2, -2));
        List<Location> result = findClosestToMe(friends, k);
        System.out.println(result);
    }



    static class Location {
        String id;
        int x;
        int y;
        public Location(String id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }
        public String toString() {
            return "Location[" + id + ": " + x + ", " + y + "]";
        }

        double distanceToCenter(){
            return Math.pow(x, center.x) + Math.pow(y, center.y);
        }

        double distanceTo(Location loc){
            return Math.pow(x, loc.x) + Math.pow(y, loc.y);
        }
    }
}
