/**
 * ВОЛНОВОЙ АЛГОРИТМ
 * program
 */
public class program {
    static int pos = 0;

    public static void gameStep(int[][] input_field, int[][] input_array, int[][] dir, int position) {
        int x = input_array[0][0];
        int y = input_array[0][1];
        lib.removeFirst(input_array, pos);
        pos--;
        for (int i = 0; i < dir.length; i++) {

            if (lib.isAvailable(input_field, x + dir[i][0], y + dir[i][1])) {
                input_field[x + dir[i][0]][y + dir[i][1]] = input_field[x][y] + 1;
                lib.addItem(x + dir[i][0], y + dir[i][1], pos, input_array);
                pos++;
            }
        }

    }

    public static void main(String[] args) {
        int startCoord[] = new int[2];
        int endCoord[] = { 6, 9 };
        int field[][] = new int[10][11];
        int storage[][] = new int[30][2];
        int theWay[][] = new int[30][3];
        int directions[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        startCoord = lib.getCoord("Введите корд. X точки A ", "Введите коорд. Y точки  А ");
        lib.addItem(startCoord[0], startCoord[1], pos, storage);
        pos++;
        lib.addWall(field);
        while (pos != 0) {
            gameStep(field, storage, directions, pos);
        }
        field[startCoord[0]][startCoord[1]] = 0;
        lib.printField(field);
        lib.shortWay(theWay, directions, field, endCoord[0], endCoord[1]);
        System.out.println();
        lib.printField(field);

    }
}