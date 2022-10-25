import java.util.Scanner;

public class lib {
    public static void printField(int[][] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                if (inputArray[i][j] > 9) {
                    System.out.print(inputArray[i][j] + " ");
                } else {
                    System.out.print(inputArray[i][j] + "  ");
                }
            }
            System.out.println();

        }
    }

    static int[] getCoord(String messageX, String messageY) {
        int[] coord = new int[2];
        Scanner iScanner = new Scanner(System.in);
        System.out.println(messageX + ": ");
        coord[0] = iScanner.nextInt();
        System.out.println(messageY + ": ");
        coord[1] = iScanner.nextInt();
        iScanner.close();
        return coord;
    }

    public static boolean isAvailable(int[][] inputArray, int x, int y) {
        boolean flag = false;
        if ((x < inputArray.length) && (x >= 0) && (y >= 0) && (y < inputArray[x].length)) {
            if (inputArray[x][y] == 0) {
                flag = true;
            }
        }
        return flag;
    }

    public static void addItem(int x, int y, int position, int[][] inputArray) {
        inputArray[position][0] = x;
        inputArray[position][1] = y;
        position++;
    }

    public static void removeFirst(int[][] inputArray, int position) {
        for (int i = 1; i < position; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                inputArray[i - 1][j] = inputArray[i][j];
            }
        }
        for (int j = 0; j < inputArray[position].length; j++) {
            inputArray[position - 1][j] = 0;
        }

    }

    public static void addWall(int[][] inputArray) {
        inputArray[3][6] = 88;
        inputArray[4][6] = 88;
        inputArray[5][6] = 88;
        inputArray[6][6] = 88;
        inputArray[7][6] = 88;
        inputArray[3][2] = 88;
        inputArray[3][3] = 88;
        inputArray[3][4] = 88;
        inputArray[3][5] = 88;
        inputArray[8][2] = 88;

    }

    public static int[] moveToA(int x, int y, int[][] inputField, int[][] inputDirection) {
        boolean flag = false;
        int index = 0;
        int newX;
        int newY;
        int[] result = new int[3];
        int temp;
        while ((flag == false) && (index < inputDirection.length)) {
            newX = x + inputDirection[index][0];
            newY = y + inputDirection[index][1];
            temp = inputField[x][y] - 1;
            if ((newX < inputField.length) && (newX >= 0) && (newY < inputField[0].length) && (newY >= 0)) {
                if (inputField[newX][newY] == temp) {
                    result[0] = newX;
                    result[1] = newY;
                    result[2] = inputField[newX][newY];
                    flag = true;
                } else {
                    index++;
                }

            } else {
                index++;
            }
        }
        return result;

    }

    public static void shortWay(int[][] wayArray, int[][] inputDirection, int[][] inputField, int xCoord, int yCoord) {
        int tempX = xCoord;
        int tempY = yCoord;
        int tempRes = inputField[tempX][tempY];
        int tempIndex = 0;
        while (tempRes != 0) {

            wayArray[tempIndex][0] = moveToA(tempX, tempY, inputField, inputDirection)[0];
            wayArray[tempIndex][1] = moveToA(tempX, tempY, inputField, inputDirection)[1];
            wayArray[tempIndex][2] = moveToA(tempX, tempY, inputField, inputDirection)[2];
            tempX = wayArray[tempIndex][0];
            tempY = wayArray[tempIndex][1];
            tempRes = wayArray[tempIndex][2];
            tempIndex++;
        }
        for (int i = 0; i < tempIndex; i++) {
            inputField[wayArray[i][0]][wayArray[i][1]] = 0;
        }
        inputField[xCoord][yCoord] = 0;
    }

    public static void main(String[] args) {

    }
}
