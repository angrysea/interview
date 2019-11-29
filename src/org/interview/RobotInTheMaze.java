import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class RobotInTheMaze {
    private int width;
    private int height;
    private int exitX;
    private int exitY;

    static class Pair<K, V> {
        private K key;
        private V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return value;
        }
    }
    
    private RobotInTheMaze(final int width, final int height) {
        this.width = width;
        this.height = height;
    }

    private void setExitLocation(final int exitX, final int exitY) {
        this.exitX = exitX;
        this.exitY = exitY;
    }

    private List<Stack<Pair<Integer, Integer>>> findRoutes(final int x, final int y) {
        final List<Stack<Pair<Integer, Integer>>> routes = new ArrayList<>();
        final Pair<Integer, Integer> start = new Pair<>(x, y);
        final Stack<Pair<Integer, Integer>> route = new Stack<>();
        route.push(start);
        move(route, routes);
        return routes;
    }

    private boolean move(final Stack<Pair<Integer, Integer>> route, List<Stack<Pair<Integer, Integer>>> routes) {
        Pair<Integer, Integer> last = route.peek();
        if (last.getKey() == exitX && last.getValue() == exitY) {
            routes.add(route);
            return true;
        }

        if (last.getKey() + 1 == width) {
            return false;
        }

        Pair<Integer, Integer> next = new Pair<>(last.getKey() + 1, last.getValue());
        var nextRightRoute = new Stack<Pair<Integer, Integer>>();
        nextRightRoute.addAll(route);
        nextRightRoute.push(next);
        move(nextRightRoute, routes);

        if (last.getValue() > 0) {
            Pair<Integer, Integer> nextUp = new Pair<>(last.getKey() + 1, last.getValue() - 1);
            Stack<Pair<Integer, Integer>> nextUpRoute = new Stack<>();
            nextUpRoute.addAll(route);
            nextUpRoute.push(nextUp);
            move(nextUpRoute, routes);
        }

        if (last.getValue() < height - 1) {
            Pair<Integer, Integer> nextUp = new Pair<>(last.getKey() + 1, last.getValue() + 1);
            Stack<Pair<Integer, Integer>> nextDownRoute = new Stack<>();
            nextDownRoute.addAll(route);
            nextDownRoute.push(nextUp);
            move(nextDownRoute, routes);
        }
        return false;
    }

    private static void printRoute(final Stack<Pair<Integer, Integer>> route) {
        route.stream().map(p -> String.format("(%d, %d) - ", p.getValue(), p.getKey())).forEach(System.out::print);
        System.out.println();
    }

    public static void main(String[] args) {
        RobotInTheMaze maze = new RobotInTheMaze(4,3);
        maze.setExitLocation(3,2);

        List<Stack<Pair<Integer, Integer>>> routes = maze.findRoutes(0, 2);
        routes.forEach(RobotInTheMaze::printRoute);
    }
}


