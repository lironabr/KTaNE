import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Maze implements Defuser {


    private Scanner input;
    private final int MAZE_MAX_X = 11;
    private final int MAZE_MAX_Y = 11;
    private final String O = "O";//path
    private final String C = " ";//clear
    private final String W = "#";//wall
    private final String X = "X";//stepped

    private String[][] maze_a;
    private String[][] maze_b;
    private String[][] maze_c;
    private String[][] maze_d;
    private String[][] maze_e;
    private String[][] maze_f;
    private String[][] maze_g;
    private String[][] maze_h;
    private String[][] maze_i;



    private Pair<Integer, Integer> source;
    private int source_x;
    private int source_y;
    private int target_x;
    private int target_y;
    private String[][] maze;
    private Map<CordinatesKey,String[][]> cordinates_to_maze;

    public Maze() {
        input = Bomb.input;

    }
    @Override
    public void defuse() {
        initMazes();
        initMap();
        recognizeMaze();
        getSourceAndTarget();
        solve(maze, source_x, source_y, target_x, target_y, "");
    }

    private void initMap() {
        cordinates_to_maze=new HashMap<CordinatesKey,String[][]>();
        cordinates_to_maze.clear();
        cordinates_to_maze.put(new CordinatesKey(4,3,6,3),maze_a);
        cordinates_to_maze.put(new CordinatesKey(1,3,5,5),maze_b);
        cordinates_to_maze.put(new CordinatesKey(1,5,6,4),maze_c);
        cordinates_to_maze.put(new CordinatesKey(3,2,5,6),maze_d);
        cordinates_to_maze.put(new CordinatesKey(4,1,5,4),maze_e);
        cordinates_to_maze.put(new CordinatesKey(1,3,1,6),maze_f);
        cordinates_to_maze.put(new CordinatesKey(1,2,3,5),maze_g);
        cordinates_to_maze.put(new CordinatesKey(3,3,4,6),maze_h);
        cordinates_to_maze.put(new CordinatesKey(2,1,2,6),maze_i);


    }
    private void recognizeMaze(){
        System.out.println("Enter first green circle x y");
        int x1=input.nextInt();
        int y1=input.nextInt();
        System.out.println("Enter second green circle x y");
        int x2=input.nextInt();
        int y2=input.nextInt();
        maze=cordinates_to_maze.get(new CordinatesKey(x1,y1,x2,y2));


    }

    private void getSourceAndTarget() {
        System.out.println("Enter source x y");
        source_y=(input.nextInt()-1) * 2; // start from (1,1)
        source_x=(5-input.nextInt()+1) * 2;// 5 is MAX_Y/2
        System.out.println("Enter target x y");
        target_y=(input.nextInt()-1) * 2;
        target_x=(5-input.nextInt()+1) * 2;//5 is MAX_Y/2
    }

    private boolean solve(String[][] maze, int source_x, int source_y, int target_x, int target_y, String path) {
        if (source_x==target_x && source_y==target_y){
            System.out.println(path);
            return true;
        }

        String[][] modified_maze = copyMatrix(maze);
        modified_maze[source_x][source_y] = X;
        if (canMoveRight(maze, source_x, source_y + 1)) {
            if (solve(modified_maze, source_x, source_y + 2, target_x, target_y, path + "R")) {
                return true;
            }
        }

        if(canMoveLeft(maze,source_x,source_y-1)){
            if(solve(modified_maze,source_x,source_y-2,target_x,target_y,path+"L"))
                return true;
        }
        if(canMoveUp(maze,source_x-1,source_y)){
            if(solve(modified_maze,source_x-2,source_y,target_x,target_y,path+"U"))
                return true;
        }
        if(canMoveDown(maze,source_x+1,source_y)){
            if(solve(modified_maze,source_x+2,source_y,target_x,target_y,path+"D"))
                return true;
        }
        return false;
    }

    private boolean canMoveRight(String[][] maze, int x, int y) {
        if (!canMove(maze, x, y)) return false;
        if (maze[x][y + 1].equals(X)) return false;//Already stepped
        return true;
    }

    private boolean canMoveLeft(String[][] maze, int x, int y) {
        if (!canMove(maze, x, y)) return false;
        if (maze[x][y - 1].equals(X)) return false;//Already stepped
        return true;
    }

    private boolean canMoveUp(String[][] maze, int x, int y) {
        if (!canMove(maze, x, y)) return false;
        if (maze[x - 1][y].equals(X)) return false;//Already stepped
        return true;
    }

    private boolean canMoveDown(String[][] maze, int x, int y) {
        if (!canMove(maze, x, y)) return false;
        if (maze[x + 1][y].equals(X)) return false;//Already stepped
        return true;
    }

    private boolean canMove(String[][] maze, int x, int y) {
        if (x >= MAZE_MAX_X || x < 0 || y >= MAZE_MAX_Y || y < 0)
            return false;
        if (maze[x][y].equals(W)) return false;
        return true;
    }

    private String[][] copyMatrix(String[][] old) {
        String[][] new_maze = new String[MAZE_MAX_Y][MAZE_MAX_X];
        for (int i = 0; i < old.length; i++)
            for (int j = 0; j < old[i].length; j++)
                new_maze[i][j] = old[i][j];
        return new_maze;
    }



    private void initMazes() {
        initMazeA();
        initMazeB();
        initMazeC();
        initMazeD();
        initMazeE();
        initMazeF();
        initMazeG();
        initMazeH();
        initMazeI();
    }

    private void initMazeA() {
        maze_a = new String[][]{
                {O, C, O, C, O, W, O, W, O, C, O},
                {C, W, W, W, C, W, C, W, C, C, C},
                {O, W, O, W, O, W, O, C, O, W, O},
                {W, W, C, W, C, W, W, W, W, W, C},
                {O, C, O, W, O, W, O, C, O, W, O},
                {C, W, C, W, C, W, C, W, C, W, C},
                {O, W, O, W, O, W, O, W, O, W, O},
                {C, W, C, W, C, W, C, W, C, W, C},
                {O, W, O, C, O, W, O, W, O, W, O},
                {C, W, W, W, W, W, C, W, C, W, C},
                {O, C, O, C, O, C, O, W, O, C, O}
        };
    }
    private void initMazeB(){
        maze_b = new String[][]{
                {O, C, O, C, O, W, O, C, O, C, O},
                {W, W, C, W, W, W, C, W, C, W, W},
                {O, C, O, W, O, C, O, W, O, C, O},
                {C, W, W, W, C, W, W, W, W, W, C},
                {O, W, O, C, O, W, O, C, O, C, O},
                {C, W, C, W, W, W, C, W, W, W, C},
                {O, C, O, W, O, C, O, W, O, W, O},
                {C, W, W, W, C, W, W, W, C, W, C},
                {O, W, O, W, O, W, O, C, O, W, O},
                {C, W, C, W, C, W, C, W, W, W, C},
                {O, W, O, C, O, W, O, C, O, C, O}
        };
    }
    private void initMazeC(){
        maze_c = new String[][]{
                {O, C, O, C, O, W, O, C, O, C, O},
                {C, W, W, W, C, W, C, W, W, W, W},
                {O, W, O, C, O, W, O, C, O, C, O},
                {C, W, C, W, W, W, W, W, W, W, C},
                {O, W, O, C, O, W, O, C, O, C, O},
                {C, W, W, W, C, W, C, W, W, W, C},
                {O, W, O, C, O, C, O, W, O, C, O},
                {C, W, W, W, W, W, W, W, W, W, C},
                {O, C, O, C, O, W, O, C, O, W, O},
                {C, W, W, W, C, W, C, W, W, W, C},
                {O, C, O, W, O, C, O, W, O, C, O}
        };
    }
    private void initMazeD(){
        maze_d = new String[][]{
                {O, W, O, C, O, W, O, C, O, C, O},
                {C, W, C, W, C, W, W, W, C, W, C},
                {O, W, O, W, O, W, O, C, O, W, O},
                {C, W, C, W, C, W, C, W, W, W, C},
                {O, C, O, W, O, W, O, W, O, C, O},
                {C, W, W, W, W, W, C, W, C, W, W},
                {O, C, O, W, O, C, O, W, O, W, O},
                {W, W, C, W, C, W, C, W, C, W, C},
                {O, C, O, C, O, W, O, W, O, C, O},
                {C, W, W, W, W, W, C, W, W, W, C},
                {O, C, O, C, O, C, O, W, O, C, O}
        };
    }
    private void initMazeE(){
        maze_e = new String[][]{
                {O, C, O, C, O, C, O, C, O, C, O},
                {W, W, W, W, W, W, W, W, C, W, C},
                {O, C, O, C, O, C, O, C, O, W, O},
                {C, W, W, W, W, W, C, W, W, W, W},
                {O, C, O, W, O, C, O, W, O, C, O},
                {C, W, C, W, W, W, W, W, C, W, C},
                {O, W, O, C, O, C, O, W, O, W, O},
                {C, W, W, W, W, W, C, W, W, W, C},
                {O, W, O, C, O, C, O, C, O, W, O},
                {C, W, C, W, W, W, W, W, W, W, C},
                {O, W, O, C, O, C, O, C, O, C, O}
        };
    }
    private void initMazeF(){
        maze_f = new String[][]{
                {O, C, O, W, O, C, O, C, O, C, O},
                {C, W, C, W, W, W, W, W, W, W, C},
                {O, W, O, W, O, C, O, C, O, C, O},
                {C, W, C, W, C, W, W, W, W, W, C},
                {O, W, O, C, O, W, O, C, O, W, O},
                {C, W, W, W, W, W, C, W, W, W, C},
                {O, W, O, C, O, C, O, C, O, C, O},
                {C, W, W, W, W, W, W, W, W, W, C},
                {O, C, O, C, O, C, O, C, O, W, O},
                {C, W, W, W, W, W, W, W, C, W, C},
                {O, C, O, C, O, W, O, C, O, W, O}
        };
    }
    private void initMazeG(){
        maze_g = new String[][]{
                {O, W, O, C, O, C, O, C, O, C, O},
                {C, W, C, W, W, W, W, W, C, W, C},
                {O, W, O, W, O, C, O, W, O, W, O},
                {C, W, C, W, C, W, W, W, C, W, C},
                {O, C, O, C, O, W, O, C, O, W, O},
                {C, W, W, W, W, W, C, W, W, W, C},
                {O, W, O, W, O, C, O, W, O, C, O},
                {C, W, C, W, C, W, W, W, W, W, C},
                {O, W, O, W, O, W, O, C, O, W, O},
                {C, W, C, W, C, W, C, W, C, W, W},
                {O, C, O, W, O, C, O, W, O, C, O}
        };
    }
    private void initMazeH(){
        maze_h = new String[][]{
                {O, W, O, C, O, C, O, W, O, C, O},
                {C, W, C, W, W, W, C, W, C, W, C},
                {O, C, O, C, O, W, O, C, O, W, O},
                {C, W, W, W, W, W, W, W, W, W, C},
                {O, W, O, C, O, C, O, C, O, W, O},
                {C, W, C, W, W, W, W, W, C, W, C},
                {O, W, O, C, O, W, O, C, O, C, O},
                {C, W, W, W, C, W, W, W, W, W, W},
                {O, W, O, W, O, C, O, C, O, C, O},
                {C, W, C, W, W, W, W, W, W, W, W},
                {O, C, O, C, O, C, O, C, O, C, O}
        };
    }
    private void initMazeI(){
        maze_i = new String[][]{
                {O, C, O, C, O, C, O, W, O, C, O},
                {C, W, W, W, W, W, C, W, C, W, C},
                {O, W, O, C, O, W, O, C, O, W, O},
                {C, W, C, W, W, W, W, W, W, W, C},
                {O, C, O, W, O, C, O, W, O, C, O},
                {W, W, W, W, C, W, W, W, C, W, W},
                {O, C, O, W, O, C, O, C, O, W, O},
                {C, W, C, W, C, W, W, W, W, W, C},
                {O, W, O, W, O, C, O, C, O, W, O},
                {C, W, W, W, W, W, W, W, C, W, C},
                {O, C, O, C, O, C, O, C, O, C, O}
        };
    }




    private void printMaze(String[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }
}
class CordinatesKey{
    Integer x1;
    Integer x2;
    Integer y1;
    Integer y2;
    public CordinatesKey(int x1,int y1, int x2, int y2){
        this.x1=x1;
        this.x2=x2;
        this.y1=y1;
        this.y2=y2;
        }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof CordinatesKey))
            return false;
        if (this.x1==((CordinatesKey) obj).x1 && this.x2==((CordinatesKey) obj).x2
                && this.y1==((CordinatesKey) obj).y1 && this.y2==((CordinatesKey) obj).y2)
            return true;
        if(this.x1==((CordinatesKey) obj).x2 && this.y1==((CordinatesKey) obj).y2
                &&this.x2==((CordinatesKey) obj).x1&& this.y2==((CordinatesKey) obj).y1)
            return true;
        return false;
    }
    public int hashCode(){
        return (x1.hashCode()^y1.hashCode())*(x2.hashCode()^y2.hashCode());
    }
}
