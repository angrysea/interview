package org.interview.puzzels.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class ActivitySelection {

    static class Activity {
        private int startTime, endTime;

        Activity(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        int getStartTime() {
            return startTime;
        }

        int getEndTime() {
            return endTime;
        }
    }

    Function<Activity, String> printActivity = (activity) ->
            String.format("Activity start time: %d, end time: %d ", activity.getStartTime(), activity.getEndTime());

    private void printMaxActivities(LinkedList<Activity> activities) {
        activities.sort(new Comparator<Activity>() {
            @Override
            public int compare(Activity a1, Activity a2) {
                int ret = a1.getEndTime() - a2.getEndTime();
                if (ret == 0) {
                    ret = a2.getStartTime() - a1.getStartTime();
                }
                return ret;
            }
        });

        List<Activity> selected = new ArrayList<>();
        Activity current = activities.remove();
        selected.add(current);
        for (Activity activity : activities) {
            if (activity.getStartTime() >= current.getEndTime()) {
                selected.add(activity);
                current = activity;
            }
        }

        selected.stream()
                .map(printActivity)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        LinkedList<Activity> activities = new LinkedList<>();
        activities.add(new Activity(8, 9));
        activities.add(new Activity(3, 4));
        activities.add(new Activity(5, 9));
        activities.add(new Activity(0, 6));
        activities.add(new Activity(5, 7));
        activities.add(new Activity(1, 2));

        new ActivitySelection().printMaxActivities(activities);
    }
}
